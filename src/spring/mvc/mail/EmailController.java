package spring.mvc.mail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {

	@Autowired
	private EmailService service;
	
	@RequestMapping(value = "/email")
	public ModelAndView emailSender() {
		
		Map<String, Object> model  = new HashMap<String, Object>();
		model.put("from", "geet.endriya@gmail.com");
		model.put("subject", "Hello springmvc-angularjs-html5");
		model.put("to", "geet.endriya@gmail.com"); //Attention	
		model.put("ccList", new ArrayList<String>());
		model.put("bccList", new ArrayList<String>());
		model.put("urludemy", "https://www.udemy.com/spring-framework-4-course-and-core-spring-certification/"); 
		model.put("username", "Tester Tests");
		
		boolean status = service.sendEmail(model, "registered.vm" );
		
		if(status == true) {
			return new ModelAndView("success/success", "model", model);
		}else {
			return new ModelAndView("error/error", "model", model);
		}
		
	}
}
