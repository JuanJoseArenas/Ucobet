
package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import co.edu.uco.ucobet.generales.aplication.primaryports.dto.CityDTO;
import co.edu.uco.ucobet.generales.aplication.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.aplication.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.aplication.primaryports.interactor.city.RetrieveCityInteractor;
import co.edu.uco.ucobet.generales.crosscuting.exception.UcobetException;
import co.edu.uco.ucobet.generales.crosscuting.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.ucobet.generales.crosscuting.messageCatalog.data.CodigoMensaje;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.CityResponse;

@RestController
@RequestMapping("/general/api/v1/cities")
@CrossOrigin(origins = "http://localhost:4200")
public class RegisterNewCityController {
	
	@Value("${sendgrid.api.key}")
	private String apiKey;

	@Value("${sendgrid.from}")
	private String correofrom;

	private final RegisterNewCityInteractor registerNewCityInteractor;
	private final RetrieveCityInteractor retrieveCityInteractor;

	public RegisterNewCityController(final RegisterNewCityInteractor registerNewCityInteractor,
			final RetrieveCityInteractor retrieveCityInteractor) {
		this.registerNewCityInteractor = registerNewCityInteractor;
		this.retrieveCityInteractor = retrieveCityInteractor;
	}

	@PostMapping
	public ResponseEntity<CityResponse> crear(@RequestBody RegisterNewCityDTO dto) {
		var httpStatusCode = HttpStatus.CREATED;
		var ciudadResponse = new CityResponse();

		try {
			registerNewCityInteractor.execute(dto);
			ciudadResponse.getMensajes().add(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00008));

			sendEmailNotification(dto.getCityName());

		} catch (final UcobetException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			ciudadResponse.getMensajes().add(excepcion.getUserMessage());

		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00009);
			ciudadResponse.getMensajes().add(mensajeUsuario);
		}

		return new ResponseEntity<>(ciudadResponse, httpStatusCode);
	}

	@GetMapping
	public ResponseEntity<CityResponse> consultar() {
		var httpStatusCode = HttpStatus.ACCEPTED;
		var cityResponse = new CityResponse();
		try {
			var cityDto = CityDTO.create();
			cityResponse.setDatos(retrieveCityInteractor.execute(cityDto));
			cityResponse.getMensajes().add(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00013));
		} catch (final UcobetException exception) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			cityResponse.getMensajes().add(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00014));
			exception.printStackTrace();

		} catch (final Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var mensajeUsusario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00015);
			cityResponse.getMensajes().add(mensajeUsusario);
			exception.printStackTrace();
		}
		return new ResponseEntity<>(cityResponse, httpStatusCode);
	}

	private void sendEmailNotification(String cityName) {
		Email from = new Email(correofrom);
		
		String subject = String.format(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00017));
		Email to = new Email("juanjoseaq99@gmail.com");

		String mensajeFormateado = String.format(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00016),
				cityName);

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
