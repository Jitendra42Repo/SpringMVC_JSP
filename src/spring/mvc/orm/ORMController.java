package spring.mvc.orm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.bean.User;

@Controller
public class ORMController {
	
	@Autowired
	private ORMExample ormExample;
	
	@RequestMapping(value = "/ormFindAllUsers", 
			method=RequestMethod.GET)
	public ModelAndView findAllUsers() {
		System.out.println("Inside the ormUpdateUsr method of ORMController.");
		List<User> users = ormExample.findAllUsers();
		return new ModelAndView("orm/orm", "users", users);
	}
	
	
	@RequestMapping(value="/ormUpdateUser/iduser/{iduser}/enabled/{enabled}", 
			method=RequestMethod.GET)
	public ModelAndView ormUpdateUsr(
			@PathVariable(value = "iduser") int iduser,
			@PathVariable(value="enabled")boolean enabled) {
		System.out.println("ORMController's ormUpdateUsr method is invoked.");
		boolean result = ormExample.ormUpdateUsr(iduser, enabled);
		return new ModelAndView("orm/orm", "result" , result );
		
	}
	
	@RequestMapping(value="/ormDeleteUser/iduser/{id}", 
			method=RequestMethod.GET)
	public void ormDeleteUsr() {
		System.out.println("Inside the ormDeleteUsr method of ORMController.");
		
		
	}
	
	@RequestMapping(value="/ormInsertUser/username/testuser/password/testpassword/enabled/true", 
			method=RequestMethod.POST)
	public void ormInsertUsr() {
		
		
	}

}
