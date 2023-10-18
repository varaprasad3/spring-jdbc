package springjdbc.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@ComponentScan(basePackages = "springjdbc")
@Configuration
public class Config {
    
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource() ;
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring_jdbc");
		dataSource.setUsername("root") ;
		dataSource.setPassword("root") ;
		return dataSource ;
	}
	
	@Bean("jdbc")
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(getDataSource()) ;
	}
}
