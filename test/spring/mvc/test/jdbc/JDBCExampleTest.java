package spring.mvc.test.jdbc;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.mvc.bean.DBLog;
import spring.mvc.bean.User;
import spring.mvc.jdbc.JDBCExample;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:mvc-config.xml", "classpath:application-context.xml"})
public class JDBCExampleTest {
	
	@Autowired
	private JDBCExample jdbcExample = null;


	@Test
	public void testUserQuery() {
		List<User> usersList = this.jdbcExample.queryAllUsers();
		Assert.assertNotNull(usersList);
		
		for (User user :usersList) {
			System.out.println(user.getIdUser() + " is the User's Id.");
			System.out.println(user.getUsername() + " is the Username.");
			System.out.println(user.getPassword() + " is the password");
			System.out.println("Enabled : " + user.isEnabled() );
			
		}
		System.out.println();
	}
	
	@Test
	public void testDbLogQuery() {
		List<DBLog> queryAllLogs = this.jdbcExample.queryAllLogs();
		Assert.assertNotNull(queryAllLogs);
		
		for(DBLog dbLog: queryAllLogs) {
			System.out.println(dbLog.getIDLOG() + " is the Log Id" );
			System.out.println(dbLog.getLOGSTRING() + " is the Log String");
		}
		System.out.println();
	}

}
