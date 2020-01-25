package com.sprhiber.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.sprhiber.model.Address;
import com.sprhiber.model.City;
import com.sprhiber.model.State;
import com.sprhiber.model.User;
import com.sprhiber.model.UserFile;
import com.sprhiber.model.UserVideo;

@Configuration
@EnableTransactionManagement
@ComponentScans(value= {@ComponentScan("com.sprhiber.dao")})
public class HibernateConfig {
	
	@Autowired
	private ApplicationContext context;
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean=new LocalSessionFactoryBean();
		factoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
//		factoryBean.setAnnotatedClasses(User.class);
	//	factoryBean.setAnnotatedClasses(UserFile.class);
		factoryBean.setAnnotatedClasses(new Class[] 
				{ User.class,UserFile.class,State.class,
						City.class,Address.class,UserVideo.class });
//		factoryBean.setPackagesToScan(new String[] { "com.shprhiber.model" });
		return factoryBean;
	}
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}

}
