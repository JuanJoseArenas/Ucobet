package co.edu.uco.ucobet.generales.init;

import java.io.IOException;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

public class SendGridExample {
    public static void main(String[] args) {
        Email from = new Email("juanjoseaq99@gmail.com");
        String subject = "Ucobet";
        Email to = new Email("juanjoseaq99@gmail.com");
        Content content = new Content("text/html", "<strong>Su Plan de estacionamiento, en la sede Principal esta proxima a vencer, por favor ingresa al siguiente link para renovar su plan</strong>");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}