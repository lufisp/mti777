package org.etsmtl.mti777;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableJpaRepositories
public class Main {

	/*As configurações estão no arquivo application.properties
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mti777Bd");
		dataSource.setUsername("mti777");
		dataSource.setPassword("mti777");

		return dataSource;
	}
	*/

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Main.class, args);
	}

}