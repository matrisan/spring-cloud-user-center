package com.github.user.center.application.common;

import com.github.user.center.application.CreateUserCommand;
import com.github.user.center.domain.entity.SystemRoleEntity;
import com.github.user.center.domain.aggregate.SystemUser;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * TODO
 * <p>
 * create in 2021/5/6 2:24 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
public class UserCreateFactory {

    private UserCreateFactory() {
    }

    public static SystemUser createUser(CreateUserCommand command, List<SystemRoleEntity> roles) {
        return new SystemUser();
    }

}
