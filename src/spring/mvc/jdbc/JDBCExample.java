package spring.mvc.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spring.mvc.bean.DBLog;
import spring.mvc.bean.User;

@Repository
public class JDBCExample {
	
	private JdbcTemplate jdbcTemplate;
	
	
	@Autowired
	public JDBCExample(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	public List<User> queryAllUsers() {
		
		
		String querySql = "SELECT * FROM USER ORDER BY IDUSER";
		
		List<User> userList =  this.jdbcTemplate.query(querySql, new RowMapper<User>() {
            public User mapRow(ResultSet resulSet, int rowNum) throws SQLException {
            	User user = new User();
            	user.setIdUser(resulSet.getInt("IDUSER"));
            	user.setUsername(resulSet.getString("USERNAME"));
            	user.setPassword(resulSet.getString("PASSWORD"));
            	user.setEnabled(resulSet.getBoolean("ENABLED"));
                return user;
            }
        });
		return userList;
	}
	
	public List<DBLog> queryAllLogs(){
		List<DBLog> dbLogList;
		String logQuery = "SELECT * FROM LOG ORDER BY IDLOG";
		
		dbLogList = this.jdbcTemplate.query(logQuery, new RowMapper<DBLog>() {
			public DBLog mapRow(ResultSet rs, int rowNum) throws SQLException {
				DBLog dbLog = new DBLog();
				dbLog.setIDLOG(rs.getInt("IDLOG"));
				dbLog.setLOGSTRING(rs.getString("LOGSTRING"));
				return dbLog;
			}
		});
		
		return dbLogList;
	}
	
	
	

}
