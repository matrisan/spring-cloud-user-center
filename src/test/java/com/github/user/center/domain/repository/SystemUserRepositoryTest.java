package com.github.user.center.domain.repository;

import com.github.user.center.domain.entity.SystemUserEntity;
import com.github.user.center.interfaces.dto.ISystemQueryResult;
import com.github.user.center.interfaces.dto.UserQueryRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/5/11 12:35 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@ActiveProfiles("junit")
@SpringBootTest
@DisplayName("用户仓储测试")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SystemUserRepositoryTest {

    private static final String USERNAME1 = "test_name1";

    private static final String PHONE1 = "18888888888";

    private static final String USERNAME2 = "test_name2";

    private static final String PHONE2 = "19999999999";

    @Resource
    private SystemUserRepository repository;

    private SystemUserEntity savedEntity;

    @DisplayName("测试开始前准备数据")
    @BeforeAll
    void setUp() {
        SystemUserEntity entity = new SystemUserEntity(USERNAME1, PHONE1, "1234");
        savedEntity = repository.save(entity);
    }

    @Nested
    @DisplayName("根据用户名查找用户")
    class FindUserByUsername {

        @DisplayName("用户已存在,正常查出用户")
        @Test
        void findUserByUsername1() {
            UserDetails details = repository.findUserByUsername(USERNAME1);
            Assertions.assertEquals(USERNAME1, details.getUsername());
        }

        @DisplayName("用户不存在,抛出异常")
        @Test
        void findUserByUsername2() {
            Assertions.assertThrows(UsernameNotFoundException.class,
                    () -> repository.findUserByUsername(USERNAME2));
        }
    }

    @Nested
    @DisplayName("根据号码查找用户")
    class FindUserByPhone {

        @DisplayName("号码已存在,正常查出用户")
        @Test
        void findUserByPhone1() {
            UserDetails details = repository.findUserByPhone(PHONE1);
            Assertions.assertEquals(USERNAME1, details.getUsername());
        }

        @DisplayName("号码不存在,抛出异常")
        @Test
        void findUserByPhone2() {
            Assertions.assertThrows(UsernameNotFoundException.class,
                    () -> repository.findUserByPhone(PHONE2));
        }
    }


    @Nested
    @DisplayName("根据ID查找用户")
    class FindByUserId {

        @DisplayName("ID已存在,正常查出用户")
        @Test
        void findUserByPhone1() {
            SystemUserEntity details = repository.findByUserId(savedEntity.getId());
            Assertions.assertEquals(USERNAME1, details.getUsername());
        }

        @DisplayName("ID不存在, 断言为空")
        @Test
        void findUserByPhone2() {
            SystemUserEntity entity = repository.findByUserId(100L);
            Assertions.assertNull(entity);
        }
    }

    @Nested
    @DisplayName("查找所有的用户")
    class FindAll {

        @DisplayName("查找所有的用户")
        @Test
        void findAll() {
            Page<ISystemQueryResult> page = repository.findAll(new UserQueryRequest(), PageRequest.of(0, 1));
            Assertions.assertEquals(1L, page.getTotalElements());
        }
    }

}