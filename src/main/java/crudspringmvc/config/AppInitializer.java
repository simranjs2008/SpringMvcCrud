package crudspringmvc.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource({"classpath:database.properties"})
public class AppInitializer {
	@Autowired
	Environment environment;
	
	  @Bean
	  public DataSource dataSource() {
	      DriverManagerDataSource dataSource = new DriverManagerDataSource();
	      dataSource.setDriverClassName(environment.getProperty("jdbc.driverClass"));
	      dataSource.setUrl(environment.getProperty("jdbc.url"));
	      dataSource.setUsername(environment.getProperty("jdbc.username"));
	      dataSource.setPassword(environment.getProperty("jdbc.password"));
	      return dataSource;
	  }
	  
	  @Bean
	  public LocalSessionFactoryBean sessionFactory() {
	      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	      sessionFactory.setDataSource(dataSource());
	      sessionFactory.setPackagesToScan(new String[] {
	          "crudspringmvc.model"
	      });
	      sessionFactory.setHibernateProperties(hibernateProperties());
	      return sessionFactory;
	  }
	  
		private Properties hibernateProperties() {
			Properties properties = new Properties();
			properties.put("hibernate.dialect",environment.getProperty("hibernate.dialect"));
			properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
			properties.put("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
			properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
			return properties;
		}
		
	    @Bean
	    public HibernateTransactionManager getTransactionManager() {
	        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	        transactionManager.setSessionFactory(sessionFactory().getObject());
	        return transactionManager;
	    }
}
