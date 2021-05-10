package com.github.user.center.application.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/5/10 7:44 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@DataJpaTest
@ActiveProfiles("junit")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SystemUserServiceTest {

    @Resource
    private SystemUserService service;

    @Test
    void findAllUser() {
    }

    @Test
    void createUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}