package com.pekam;

import com.pekam.app.MyAppSettings;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import com.google.appengine.api.utils.SystemProperty;


@Configuration
@ComponentScan("com.pekam")
@EnableAutoConfiguration
@EnableJpaRepositories



public class AppConfig {
	@Resource
	Environment env;

 
@Bean
public DataSource MyDataSource() {
	
	//String str = com.pekam.Settings.this.dbUser;
	DriverManagerDataSource H2DataSource = new DriverManagerDataSource();
	H2DataSource.setDriverClassName("org.h2.Driver");
	H2DataSource.setUrl("jdbc:h2:file:h2\\db");
	H2DataSource.setUsername("sa");
	H2DataSource.setPassword("");

//	DriverManagerDataSource MsSqlDataSource = new DriverManagerDataSource();
//	MsSqlDataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//	MsSqlDataSource.setUrl("jdbc:sqlserver://WIN-IQ0VJPLIUSK:1433/pk");
//	MsSqlDataSource.setUsername("pk2");
//	MsSqlDataSource.setPassword("f7ka1");
	
//	DriverManagerDataSource SqlLiteDataSource = new DriverManagerDataSource();
//	SqlLiteDataSource.setDriverClassName("org.sqlite.JDBC");
//	SqlLiteDataSource.setUrl("jdbc:sqlite:sample.db");
//	SqlLiteDataSource.setUsername("pk2");
//	SqlLiteDataSource.setPassword("f7ka1");
	
	
	
	DriverManagerDataSource MySqlDataSource = new DriverManagerDataSource();
	MySqlDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		//MySqlDataSource.setUrl("jdbc:mysql://localhost:3306/test");
		
		
		String url = null;
		if (SystemProperty.environment.value() ==
		    SystemProperty.Environment.Value.Production) {
//		  // Connecting from App Engine.
//		  // Load the class that provides the "jdbc:google:mysql://"
//		  // prefix.
	//Class.forName("com.mysql.jdbc.GoogleDriver");
		  	url ="jdbc:google:mysql://gps-trackman:mysql55";
		 		 MySqlDataSource.setDriverClassName("com.mysql.jdbc.GoogleDriver");
		 		 MySqlDataSource.setUsername(MyAppSettings.dbUserNameProduction);
				MySqlDataSource.setPassword(MyAppSettings.dbUserPwdProduction);
				MySqlDataSource.setUrl(url);
			
		} else {  // is Development DB
//		  // page and use it to connect from an external network.
//Class.forName("com.mysql.jdbc.Driver");
			MySqlDataSource.setDriverClassName("com.mysql.jdbc.Driver");
			 url = "jdbc:mysql://localhost:3306/test";
			  MySqlDataSource.setUsername(MyAppSettings.dbUserNameDevelopment);
				MySqlDataSource.setPassword(MyAppSettings.dbUserPwdDevelopment);
				MySqlDataSource.setUrl(url);
		}
		
	
		
		return MySqlDataSource;
				
	
	
	

	 

	
	
}

@Bean
public EntityManagerFactory entityManagerFactory() {

  HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
  vendorAdapter.setGenerateDdl(true);
  vendorAdapter.setShowSql(true);
  vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");

  
  LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

  factory.setJpaVendorAdapter(vendorAdapter);
  factory.setJpaDialect(new HibernateJpaDialect());
  factory.setPackagesToScan("com.pekam");
  factory.setDataSource(MyDataSource());
  factory.afterPropertiesSet();
  

  return factory.getObject();
}

@Bean
public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
	final JpaTransactionManager transactionManager = new JpaTransactionManager();
	transactionManager.setEntityManagerFactory(emf);
//	transactionManager.setDataSource(dataSource());
//	transactionManager.setJpaDialect(jpaDialect());
	return transactionManager;

}


}

/*import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.orm.jpa.JpaDialect;
import java.util.List;
import org.hibernate.dialect.Oracle8iDialect;
*
*
*/

//@Bean  
//public LocalContainerEntityManagerFactoryBean entityManagerFactory() {  
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();  
//        entityManagerFactoryBean.setDataSource(dataSource());  
//        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);  
//       String persistenceUnitName="MyJPA";
//		// entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));  
//        entityManagerFactoryBean.setPersistenceUnitName(persistenceUnitName); 
//      //  entityManagerFactoryBean.setJpaProperties(hibProperties());  
//          
//        return entityManagerFactoryBean;  
//}  
  
//private Properties hibProperties() {  
//        Properties properties = new Properties();  
//        properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));  
//        properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));  
//        return properties;          
//}  
  
//@Bean  
//public JpaTransactionManager transactionManager() {  
//        JpaTransactionManager transactionManager = new JpaTransactionManager();  
//        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());  
//        return transactionManager;  
//}  
