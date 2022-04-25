package acme.features.any;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Configuration;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Any;

@Controller
public class AnyConfigurationController extends AbstractController<Any,Configuration>{
	@Autowired
	protected AnyConfigurationShowService showService;
	
	@PostConstruct
	protected void initialise(){
		super.addCommand("show",this.showService);
	}
}
