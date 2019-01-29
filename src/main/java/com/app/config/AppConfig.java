package com.app.config;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc; 
import org.springframework.web.servlet.view.InternalResourceViewResolver; 
import com.app.model.Product;
import com.app.model.User;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@PropertySource("classpath:app.properties")
@ComponentScan(basePackages = "com.app")
@Import(SecurityConfig.class)
public class AppConfig {

	@Autowired
	private Environment env;

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public BasicDataSource dsObj() {
		BasicDataSource d = new BasicDataSource();
		d.setDriverClassName(env.getProperty("driverClassName"));
		d.setUsername(env.getProperty("username"));
		d.setPassword(env.getProperty("password"));
		d.setUrl(env.getProperty("url"));
		d.setInitialSize(1);
		d.setMaxIdle(10);
		d.setMinIdle(5);
		d.setMaxTotal(10);
		return d;
	}

	@Bean
	public LocalSessionFactoryBean sfObj() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setAnnotatedClasses(Product.class, User.class);
		sf.setDataSource(dsObj());
		sf.setHibernateProperties(hibernateProperties());
		return sf;
	}

	private Properties hibernateProperties() {
		Properties p = new Properties();
		p.put("hibernate.dialect", env.getProperty("dialect"));
		p.put("hibernate.show_sql", env.getProperty("showsql"));
		p.put("hibernate.format_sql", env.getProperty("fmtsql"));
		p.put("hibernate.hbm2ddl.auto", env.getProperty("ddlauto"));
		return p;
	}

	@Bean
	public HibernateTemplate htObj() {
		HibernateTemplate ht = new HibernateTemplate();
		ht.setSessionFactory(sfObj().getObject());
		return ht;

	}

	@Bean
	public HibernateTransactionManager httx() {
		HibernateTransactionManager htm = new HibernateTransactionManager();
		htm.setSessionFactory(sfObj().getObject());
		return htm;
	}

	@Bean
	public InternalResourceViewResolver ivr() {
		InternalResourceViewResolver i = new InternalResourceViewResolver();
		i.setPrefix("/WEB-INF/views/");
		i.setSuffix(".jsp");
		return i;
	}

	 
}
