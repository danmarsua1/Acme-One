package acme.features.inventor.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorComponentShowService implements AbstractShowService<Inventor, Item> {
	
	@Autowired
	protected InventorItemRepository repository;

	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;
		
		Integer id;
		Item item;
		boolean result;
		id = request.getModel().getInteger("id");
		item = this.repository.findOneItemById(id);
		result = request.getPrincipal().getActiveRoleId() == item.getInventor().getId();
		
		return result;
	}

	@Override
	public Item findOne(final Request<Item> request) {
		assert request != null;
		
		Integer id;
		Item item;
		id = request.getModel().getInteger("id");
		item = this.repository.findOneItemById(id);
		
		return item;
	}

	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		model.setAttribute("item", entity.getType());
		
		request.unbind(entity, model, "type", "name", "code", "technology", "description", "retailPrice", "link", "published");
	}
}