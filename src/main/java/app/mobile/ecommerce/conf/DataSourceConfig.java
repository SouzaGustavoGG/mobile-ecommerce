package app.mobile.ecommerce.conf;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfig {
     
    @Bean
    public DataSource getDataSource() {      
		    DriverManagerDataSource dataSource = new DriverManagerDataSource();
		    dataSource.setDriverClassName("spring.datasource.driver-class-name");
		    dataSource.setUrl("spring.datasource.url");
		    dataSource.setUsername("spring.datasource.username");
		    dataSource.setPassword("spring.datasource.password");
		    return dataSource;
    }
}