package com.multitenant;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.multitenant.config.DataSourceConfig;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.multitenant")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.multitenant")
public class MulittenantWithSpringbootJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MulittenantWithSpringbootJpaApplication.class, args);
		
	}
	
	@Bean
    public DataSource dataSource(){
        CustomRoutingDataSource customDataSource=new CustomRoutingDataSource();
        customDataSource.setTargetDataSources(DataSourceConfig.getDataSourceHashMap());
        return customDataSource;
    }

}
