package com.logicbig.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.logicbig.repository")
public class SimpleMongoConfig {

    @Bean
    public MongoClient mongo() {
//        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/dizertatie"); // Local DB
        ConnectionString connectionString = new ConnectionString("mongodb://db:27017/dizertatie"); // Docker DB
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongo(), "dizertatie");
    }
}