package challenge;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "scripts")
public class Quote implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@NotBlank
	private String actor;

	@NotNull
	@NotBlank
	@Column(name = "detail")
	private String quote;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Quote)) return false;
		Quote quote1 = (Quote) o;
		return getId().equals(quote1.getId()) &&
				getActor().equals(quote1.getActor()) &&
				getQuote().equals(quote1.getQuote());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getActor(), getQuote());
	}
}
