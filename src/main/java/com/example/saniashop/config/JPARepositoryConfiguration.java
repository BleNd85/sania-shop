package com.example.saniashop.config;

import com.example.saniashop.repository.naturalRepository.NaturalIdRepositoryImplementation;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(value = "com.example.saniashop",
        repositoryBaseClass = NaturalIdRepositoryImplementation.class)
public class JPARepositoryConfiguration {

}
