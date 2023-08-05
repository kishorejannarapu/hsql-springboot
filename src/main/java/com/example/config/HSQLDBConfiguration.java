package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class HSQLDBConfiguration {

//    @Bean
//    public DataSource dataSource() {
//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.HSQL)
//                .setName("testdb")
//                .build();
//    }

    @Bean
    public DataSource test(){
        return new EmbeddedDatabaseBuilder()
                .setName("testdb")
                .setType(EmbeddedDatabaseType.H2).build();
    }
}
