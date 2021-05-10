package com.github.user.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author shishaodong
 */
@EnableJpaAuditing
@EnableTransactionManagement
@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
@SpringBootApplication
public class SpringCloudUserCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudUserCenterApplication.class, args);
    }

}
