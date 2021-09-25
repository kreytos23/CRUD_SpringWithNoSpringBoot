package org.academia;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;
import java.io.FileNotFoundException;

@Configuration
@ComponentScan(basePackages = "org.academia")
public class AppConfiguration {
    @Bean
    public DataSource dataSource() throws FileNotFoundException {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.h2.Driver");
        driverManagerDataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        driverManagerDataSource.setUsername("sa");
        driverManagerDataSource.setPassword("");

        Resource initSchema = new ClassPathResource("sqlScripts/books.sql");
        Resource dataSchema = new ClassPathResource("sqlScripts/data.sql");
        DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema,dataSchema);
        DatabasePopulatorUtils.execute(databasePopulator,driverManagerDataSource);
        return driverManagerDataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() throws FileNotFoundException {
        return new JdbcTemplate(dataSource());
    }
}
