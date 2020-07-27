package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService {

	private final QuoteRepository repository;

	@Autowired
	public QuoteServiceImpl(QuoteRepository repository) {
		this.repository = repository;
	}

	@Override
	public Quote getQuote() {
		List<Quote> quotes = repository.findAll();
		Collections.shuffle(quotes);
		return quotes.get(0);
	}

	@Override
	public Quote getQuoteByActor(String actor) {
		List<Quote> quotes = repository.findByActor(actor);
		Collections.shuffle(quotes);
		return quotes.get(0);
	}

}
