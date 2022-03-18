package acme.entities.patronage;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.datatypes.Money;
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
	@Length(min = 0, max = 255)
	protected String legalStuff;

	@NotNull
	@Valid
	protected Money budget; 
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date creationDate;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date startDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date endDate;
	
	@URL
	protected String link;
}