package acme.entities.patronage;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Patronage extends AbstractEntity {
	
	protected static final long serialVersionUID = 1L;
	
	@NotNull
	protected StatusPatronage status;

	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	protected String code;

	@NotBlank
	@Length(max = 255)
	protected String legalStuff;

	@Positive
	@NotNull
	protected Double budget;  //NO ES MEJOR FLOAT

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date iniDate;  //no es mejor startDate
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date finishDate;
	
	@URL
	protected String link;
}