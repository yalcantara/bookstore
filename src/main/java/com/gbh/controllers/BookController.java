package com.gbh.controllers;

import com.gbh.entities.Book;
import com.gbh.entities.BookPage;
import com.gbh.entities.PageFormat;
import com.gbh.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {


	@Autowired
	private BookService srv;


	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List> list() {
		List<Book> list = srv.list();

		return ResponseEntity.ok(list);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces =
			MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> get(@PathVariable("id") long id) {

		Book book = srv.find(id);

		if (book == null) {
			//The HTTP standard states that when a resource could not be found, 404
			//as the status header must be returned with an optional body message.

			//El estandard HTTP declara que cuando un recurso no pudo ser encontrado,
			//el codigo 404 debe ser retornado en el header del response con un mensaje
			//en el body opcional.
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.ok(book);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}/page/{page}")
	public ResponseEntity get(@PathVariable("id") long id,
							  @PathVariable("page") int page,
							  @RequestParam(value = "format", required = false) String format) {

		// Dada esta asignación, es mi responsabilidad como Ingeriero de Software hacer saber cuando
		// sugiero una manera diferente de implementar una specificación tecnica, para prevenir
		// futuros errores/problemas:
		// -----------------------------------------------------------------------------------------
		// For selecting the appropriate Mime Type or content format, the HTTP standard defines the
		// proper mechanism for "Content Negotiation", in which the client and the server agreeds
		// on the best supported format.
		//
		// Para seleccionar el formato del contenido, el estandard HTTP define los mecanismos
		// adecuados para hacer "Content Negotiation", en donde el cliente y el servidor se ponen
		// de acuerdos en cual es el mejor formato soportado.
		//
		//
		// Hypertext Transfer Protocol -- HTTP/1.1
		// Section: 12 Content Negotiation
		// https://tools.ietf.org/html/rfc2616
		//
		// How RESTful Is Your REST?
		// Video at 27:33
		// https://www.youtube.com/watch?v=GQMfR0_t4H8&t=2361s
		//
		// -----------------------------------------------------------------------------------------


		PageFormat fmt;

		if (format == null) {
			//The default format is TEXT.
			fmt = PageFormat.TEXT;
		} else {
			fmt = PageFormat.parse(format);
			if (fmt == null) {
				String supported = PageFormat.labelText();
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid format '" + format +
						"'. Supported formats: " + supported + ".");
			}
		}

		BookPage ent = srv.findPage(id, page);

		if (ent == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Could not find page " + page +" for book with id " + id +".");
		}

		switch (fmt) {
			case TEXT:
				String text = ent.getTextFormat();
				return ResponseEntity.status(HttpStatus.OK).header("ContentType",
						MediaType.TEXT_PLAIN_VALUE).body(text);
			case HTML:
				String html = ent.getHtmlFormat();
				return ResponseEntity.status(HttpStatus.OK).header("ContentType",
						MediaType.TEXT_HTML_VALUE).body(html);
			default:
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
						"Unsupported format '" + fmt + "'.");
		}
	}
}
