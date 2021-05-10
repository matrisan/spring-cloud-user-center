package com.github.user.center.domain.repository;

import com.github.user.center.domain.aggregate.SystemUserAgg;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * TODO
 * <p>
 * create in 2021/5/8 11:37 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@DataJpaTest
@ActiveProfiles("junit")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ISystemUserRepositoryTest {

    private static final String USERNAME = RandomStringUtils.randomAlphabetic(10);
    private static final String PHONE = RandomStringUtils.randomAlphanumeric(11);
    private static final String PASSWORD = RandomStringUtils.randomAlphabetic(10);

    @Resource
    private ISystemUserRepository repository;


    @DisplayName("先存入一个用户的信息")
    @BeforeAll
    void saveOne() {
        SystemUserAgg userAgg = new SystemUserAgg(
                USERNAME,
                PHONE,
                PASSWORD
        );
        SystemUserAgg save = repository.save(userAgg);
        log.info("存入用户数据:{}", save);
    }

    @DisplayName("根据用户名,查询刚刚存入的用户")
    @Test
    void findByUsername() {
        Optional<SystemUserAgg> optional = repository.findByUsername(USERNAME);
        Assertions.assertTrue(optional.isPresent());
        SystemUserAgg userAgg = optional.get();
        log.info("查询到用户信息!{}", userAgg);
        Assertions.assertEquals(USERNAME, userAgg.getUsername());
    }

    @DisplayName("根据用户名,查询刚刚存入的用户")
    @Test
    void findByPhone() {
        Optional<SystemUserAgg> optional = repository.findByPhone(PHONE);
        Assertions.assertTrue(optional.isPresent());
        SystemUserAgg userAgg = optional.get();
        log.info("查询到用户信息!{}", userAgg);
        Assertions.assertEquals(USERNAME, userAgg.getUsername());
    }
}