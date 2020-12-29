package guru.springframework.sfgdi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import guru.springframework.sfgdi.examplebeans.FakeDataSource;
import guru.springframework.sfgdi.examplebeans.FakeJMSBroker;

@Configuration
//@PropertySource({"classpath:datasource.properties", "classpath:fakejms.properties"})
@PropertySources({
	@PropertySource("classpath:datasource.properties"),
	@PropertySource("classpath:fakejms.properties")
})
public class PropertyConfig {
	
	@Autowired
	Environment env;

	@Value("${guru.username}")
	String username;
	
	@Value("${guru.password}")
	String password;
	
	@Value("${guru.dburl}")
	String dburl;
	
	@Value("${guru.jms.username}")
	String jmsusername;
	
	@Value("${guru.jms.password}")
	String jmspassword;
	
	@Value("${guru.jms.dburl}")
	String jmsdburl;

	@Bean
	public FakeDataSource fakeDataSource() {
		FakeDataSource fakedatasource = new FakeDataSource();
//		fakedatasource.setUsername(username);
		fakedatasource.setUsername(env.getProperty("USERNAME"));
		fakedatasource.setPassword(password);
		fakedatasource.setDburl(dburl);
		return fakedatasource;
	}
	
	@Bean
	public FakeJMSBroker fakeJMSBroker() {
		FakeJMSBroker fakejmsbroker = new FakeJMSBroker();
		fakejmsbroker.setUsername(jmsusername);
		fakejmsbroker.setPassword(jmspassword);
		fakejmsbroker.setDburl(jmsdburl);
		return fakejmsbroker;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		return propertySourcesPlaceholderConfigurer;
	}

}
