package com.github.user.center.application.common;

import com.github.user.center.application.UserCreateCommand;
import com.github.user.center.domain.entity.SystemRoleEntity;
import com.github.user.center.domain.entity.SystemUserEntity;
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

    public static SystemUserEntity createUser(UserCreateCommand command, List<SystemRoleEntity> roles) {
        SystemUserEntity userAgg = ISystemUserMapper.INSTANCE.from(command);
        userAgg.addRoles(roles);
        return userAgg;
    }

}
