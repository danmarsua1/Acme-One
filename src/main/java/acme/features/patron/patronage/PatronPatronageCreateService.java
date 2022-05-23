package acme.features.patron.patronage;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronage.Patronage;
import acme.entities.patronage.StatusPatronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Patron;

@Service
public class PatronPatronageCreateService implements AbstractCreateService<Patron, Patronage>{

	@Autowired
	protected PatronPatronageRepository repository;
	
	@Override
	public boolean authorise(final Request<Patronage> request) {
		assert request != null;
		
		boolean result;
		int patronageId;
		Patronage patronage;
		
		patronageId = request.getModel().getInteger("id");
		patronage = this.repository.findOnePatronageById(patronageId);
		result = request.getPrincipal().getActiveRoleId() == patronage.getPatron().getId();
		
		return result;
	}

	@Override
	public void bind(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "code", "creationMoment", "initDate", "finishDate",
			"budget" , "status", "legalStuff", "link");
		
	}

	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "code", "creationMoment", "initDate", "finishDate",
			"budget" , "status", "legalStuff", "link");		
	}

	@Override
	public Patronage instantiate(final Request<Patronage> request) {
		assert request != null;
		
		Patronage result;
		result = new Patronage();


		result.setPatron(this.repository.findPatronByUserId(request.getPrincipal().getAccountId()));
		result.setStatus(StatusPatronage.PROPOSED);
		
		return result;
	}

	@Override
	public void validate(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		if(!errors.hasErrors("code")) {
			Patronage existing;
			
			existing = this.repository.findOnePatronageByCode(entity.getCode());
			if(existing!=null) {
			errors.state(request, existing.getId()==entity.getId(), "code", "patron.patronage.form.error.duplicated");
			}
		}
		if (!errors.hasErrors("initDate")) {
			Calendar calendar;

			calendar = new GregorianCalendar();
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			errors.state(request, entity.getInitDate().after(calendar.getTime()), "initDate", "patron.patonage.form.error.too-close-init-date");
		}
		if (!errors.hasErrors("finishDate")) {
			Calendar calendar;
			Date finish;
			calendar = new GregorianCalendar();
			calendar.setTime(entity.getInitDate());
			calendar.add(Calendar.MONTH, 1);
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			finish = calendar.getTime();
			errors.state(request, entity.getFinishDate().after(finish), "finishDate", "patron.patonage.form.error.one-month");
		}
		if(!errors.hasErrors("budget")) {
			final String [] currencies = this.repository.findConfiguration().getAcceptedCurrencies().split(",");
			Boolean acceptedCurrencies = false;
			for(int i = 0; i<currencies.length;i++) {
				if(entity.getBudget().getCurrency().equals(currencies[i].trim())) {
					acceptedCurrencies=true;
				}
			}
			
			errors.state(request, entity.getBudget().getAmount() > 0, "budget", "patron.patronage.form.error.negative-budget");
			errors.state(request, acceptedCurrencies, "budget", "patron.patronage.form.error.non-accepted-currency");
		}
	}


	@Override
	public void create(final Request<Patronage> request, final Patronage entity) {
		assert request != null;
		assert entity !=null;
		
		this.repository.save(entity);
		
	}

}
