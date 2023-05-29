import os
import smtplib
import ssl
from email.mime.multipart import MIMEMultipart
from email.mime.base import MIMEBase
from email import encoders
import json
from fpdf import FPDF
from flask import Flask, request

app = Flask(__name__)

class PDF(FPDF):
    def __init__(self):
        super().__init__('P', 'mm', 'A4')

    def header(self):
        self.set_font('Arial', 'B', 18)
        self.set_text_color(138, 43, 226)  # Color lila
        self.cell(0, 10, 'Informe Médico', 0, 1, 'C')

    def chapter_title(self, title):
        self.set_font('Arial', 'B', 16)
        self.set_text_color(138, 43, 226)  # Color lila
        self.cell(0, 10, title, 0, 1, 'L')

    def chapter_content(self, content):
        self.set_font('Arial', '', 12)
        self.set_text_color(0)  # Color negro
        self.multi_cell(0, 8, content)
        self.ln(5)  # Agrega un espacio adicional después del contenido del capítulo

@app.route('/generar-pdf', methods=['POST'])
def generar_pdf():
    try:
        registros = request.get_json()

        if not registros:
            return 'No se encontraron registros en la solicitud.', 400

        correo = registros.get('correo')
        if not correo:
            return 'No se proporcionó una dirección de correo.', 400

        registros = registros.get('registros')
        if not registros:
            return 'No se encontraron registros de datos en la solicitud.', 400

        # Lógica para generar el PDF utilizando los datos de los registros
        pdf = PDF()

        for registro in registros:
            fecha = registro.get('fechaRegistro')
            nombre = registro.get('id_Usuario', {}).get('nombreUsuario')
            apellido = registro.get('id_Usuario', {}).get('apellidosUsuario')
            duracion = registro.get('duracionCrisis')
            medicamento = registro.get('id_Medicacion', {}).get('tipoMedicacion')
            intensidad = registro.get('intensidad')
            causa = registro.get('id_Desencadenante', {}).get('tipo')
            dolor = registro.get('id_Dolor', {}).get('tipo')

            # Formatear la fecha al formato dd/mm/yyyy
            fecha_formateada = '-'.join(fecha.split('-')[::-1])

            # Agregar contenido al PDF según los datos del registro
            pdf.add_page()
            pdf.chapter_title(f"Nombre: {nombre} {apellido}")
            pdf.chapter_title(f"Fecha: {fecha_formateada}")
            pdf.chapter_content(f"Duración: {duracion}")
            pdf.chapter_content(f"Medicamento consumido: {medicamento}")
            pdf.chapter_content(f"Intensidad: {intensidad}")
            pdf.chapter_content(f"Causa: {causa}")
            pdf.chapter_content(f"Dolor experimentado: {dolor}")

        # Guardar el PDF en un archivo
        pdf_filename = 'ruta_del_archivo.pdf'
        pdf.output(pdf_filename)

        # Crear el objeto MIMEMultipart
        message = MIMEMultipart()
        message['From'] = 'brainhelp@outlook.es'  # Reemplaza con la dirección de correo electrónico de Brain Help
        message['To'] = correo
        message['Subject'] = 'Registros de datos de crisis'
        body = 'Adjunto encontrarás el PDF generado sobre tus crisis.'

        # Adjuntar el archivo PDF al correo
        with open(pdf_filename, 'rb') as attachment:
            part = MIMEBase('application', 'octet-stream')
            part.set_payload(attachment.read())
            encoders.encode_base64(part)
            part.add_header('Content-Disposition', f'attachment; filename={pdf_filename}')
            message.attach(part)

        # Enviar el correo electrónico utilizando el servidor SMTP
        smtp_server = 'smtp.office365.com'
        smtp_port = 587
        username = 'brainhelp@outlook.es'  # Reemplaza con tu dirección de correo electrónico de Brain Help
        password = 'zxocfrqcavzothjz'  # Reemplaza con tu contraseña de Brain Help

        context = ssl.create_default_context()
        with smtplib.SMTP(smtp_server, smtp_port) as server:
            server.starttls(context=context)
            server.login(username, password)
            server.sendmail(username, correo, message.as_string())

        # Eliminar el archivo PDF después de enviarlo por correo
        os.remove(pdf_filename)

        return 'PDF generado y enviado por correo correctamente.'
    except Exception as e:
        return f'Error al generar el PDF: {str(e)}', 500

if __name__ == '__main__':
    app.run(host='192.168.1.50', port=8000)
