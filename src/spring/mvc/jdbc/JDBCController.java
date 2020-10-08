package spring.mvc.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.bean.DBLog;
import spring.mvc.bean.User;

@Controller
public class JDBCController {
	
	@Autowired
	private JDBCExample jdbcExample;
	
	@RequestMapping(value="/jdbcSelectLogs", method=RequestMethod.GET)
	public ModelAndView jdbcSelectLogs() {
		System.out.println("**** **** **** ****");
		System.out.println("The jdbcSelectLogs method inside the JDBCController is invoked.");
		List<DBLog> dbLogs = this.jdbcExample.queryAllLogs();
		return new ModelAndView("jdbc/jdbc", "dbLogs", dbLogs);
	}
	
	@RequestMapping(value="/jdbcSelectAllUsers", method=RequestMethod.GET)
	public ModelAndView jdbcSelectAllUsers() {
		System.out.println("**** **** **** ****");
		System.out.println("The jdbcSelectAllUsers method inside the JDBCController is invoked.");
		List<User> users = this.jdbcExample.queryAllUsers();
		return new ModelAndView("jdbc/jdbc", "users", users);
	}

}
