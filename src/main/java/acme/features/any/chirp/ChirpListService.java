/*
 * AnyDutyListService.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.any.chirp;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Chirp;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractListService;

@Service
public class ChirpListService implements AbstractListService<Any, Chirp> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected ChirpRepository repository;

	@Override
	public boolean authorise(final Request<Chirp> request) {
		assert request!=null;
		
		return true;
	}

	@Override
	public Collection<Chirp> findMany(final Request<Chirp> request) {
		assert request!=null;
		
		Collection<Chirp> result;
		
		final Date currentDate = new java.util.Date();
		result = this.repository.findAllChirps();
		List<Chirp> r;
		r = this.repository.findAllChirps();
//		for(int i = 0; i<r.size();i++) {
//			final Chirp c = r.get(i);
//			
//			if(c.getCreationMoment()<) {
//				result.add(null);
//			}
//		}
		
		return result;
	}

	@Override
	public void unbind(final Request<Chirp> request, final Chirp entity, final Model model) {
		assert request!=null;
		assert entity!=null;
		assert model!=null;
		
		request.unbind(entity, model, "creationMoment","title","author","body","email");
	}

	// AbstractListService<Employer, Duty> interface ---------------------------


//	@Override
//	public boolean authorise(final Request<Duty> request) {
//		assert request != null;
//
//		boolean result;
//		int masterId;
//		Job job;
//
//		masterId = request.getModel().getInteger("masterId");
//		job = this.repository.findOneJobById(masterId);
//		result = !job.isDraftMode();
//
//		return result;
//	}
//
//	@Override
//	public Collection<Duty> findMany(final Request<Duty> request) {
//		assert request != null;
//
//		Collection<Duty> result;
//		int masterId;
//
//		masterId = request.getModel().getInteger("masterId");
//		result = this.repository.findManyDutiesByMasterId(masterId);
//
//		return result;
//	}
//	
//	@Override
//	public void unbind(final Request<Duty> request, final Duty entity, final Model model) {
//		assert request != null;
//		assert entity != null;
//		assert model != null;
//
//		request.unbind(entity, model, "title", "description", "workLoad", "moreInfo");
//	}

}
