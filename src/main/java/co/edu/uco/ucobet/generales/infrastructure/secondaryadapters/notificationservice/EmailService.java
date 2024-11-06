package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.notificationservice;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.MessageService;
@Service
public class EmailService {
	
	@Value("${sendgrid.api.key}")
	private String apiKey;

	@Value("${sendgrid.from}")
	private String correofrom;
	
	private final MessageService messageService;
	
	public EmailService(MessageService messageService) {
		super();
		this.messageService = messageService;
	}

	public void sendEmailNotification(String cityName) {
		Email from = new Email(correofrom);
		
		String subject = String.format(messageService.getMessageContent("M010"));
		Email to = new Email("juanjoseaq99@gmail.com");

		String mensajeFormateado = String.format(messageService.getMessageContent("M009"));

		Content content = new Content("text/html", mensajeFormateado + "<strong>" + cityName + "</strong>");
		Mail mail = new Mail(from, subject, to, content);

		SendGrid sg = new SendGrid(apiKey);
		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			System.out.println("Email enviado - Status Code: " + response.getStatusCode());
		} catch (IOException ex) {
			System.err.println("Error al enviar email: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

}
