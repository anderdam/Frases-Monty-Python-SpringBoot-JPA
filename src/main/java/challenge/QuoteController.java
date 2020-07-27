package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/quote")
public class QuoteController {

	private final QuoteService service;

	@Autowired
	public QuoteController(QuoteService service) {
		this.service = service;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Quote> getQuote() {
		Quote quote = service.getQuote();
		return new ResponseEntity<>(quote, HttpStatus.OK);
	}

	@GetMapping(value = "/{actor}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Quote> getQuoteByActor(@PathVariable("actor") String actor) {
		Quote quote = service.getQuoteByActor(actor);
		return new ResponseEntity<>(quote, HttpStatus.OK);
	}
}
