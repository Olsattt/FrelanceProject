package ru.kuvaev.freelance.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "ru.kuvaev.freelance.repositories")
@EnableTransactionManagement
public class H2DatabaseConfig {

    @Bean
    @Profile("h2") // Этот профиль будет активирован при запуске с профилем H2
    @ConfigurationProperties(prefix = "spring.datasource.h2") // Префикс для свойств в application.properties
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
}
