package com.github.user.center.application.service;

import com.github.user.center.application.CreateUserCommand;
import com.github.user.center.application.UserSaveResult;
import com.github.user.center.application.common.UserCreateFactory;
import com.github.user.center.domain.entity.SystemRoleEntity;
import com.github.user.center.domain.aggregate.SystemUser;
import com.github.user.center.domain.repository.ISystemRoleRepository;
import com.github.user.center.domain.repository.ISystemUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * TODO
 * <p>
 * create in 2021/5/6 2:10 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class SystemUserService {

    private final ISystemUserRepository userRepository;

    private final ISystemRoleRepository roleRepository;

    @Transactional(rollbackFor = Throwable.class)
    public UserSaveResult createUser(@Validated @NotNull CreateUserCommand command) {
        List<SystemRoleEntity> roles = roleRepository.findAllById(command.getRoleIds());
        SystemUser user = UserCreateFactory.createUser(command, roles);
        SystemUser save = userRepository.save(user);
        return null;
    }

    @Transactional(rollbackFor = Throwable.class)
    public UserSaveResult updateUserRoles(SystemUser user, List<SystemRoleEntity> roles) {
        user.replaceAllRoles(roles);
        return null;
    }

    public UserSaveResult deleteUser(SystemUser user) {
        userRepository.delete(user);
        return null;
    }


}

