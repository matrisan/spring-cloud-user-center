package com.github.user.center.application.service;

import com.github.user.center.application.CreateUserCommand;
import com.github.user.center.application.UserSaveResult;
import com.github.user.center.application.common.UserCreateFactory;
import com.github.user.center.domain.aggregate.SystemUserAgg;
import com.github.user.center.domain.entity.SystemRoleEntity;
import com.github.user.center.domain.repository.ISystemRoleRepository;
import com.github.user.center.domain.repository.ISystemUserRepository;
import com.github.user.center.interfaces.dto.ISystemQueryResult;
import com.github.user.center.interfaces.dto.UserQueryRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<ISystemQueryResult> findAllUser(@Validated UserQueryRequest request, Pageable pageable) {
        return null;
    }

    @Transactional(rollbackFor = Throwable.class)
    public UserSaveResult createUser(@Validated CreateUserCommand command) {
        List<SystemRoleEntity> roles = roleRepository.findAllById(command.getRoleIds());
        SystemUserAgg user = UserCreateFactory.createUser(command, roles);
        SystemUserAgg save = userRepository.save(user);
        return null;
    }

    @Transactional(rollbackFor = Throwable.class)
    public UserSaveResult updateUserRoles(@NotNull SystemUserAgg user, List<SystemRoleEntity> roles) {
        user.replaceAllRoles(roles);
        return null;
    }

    public UserSaveResult deleteUser(SystemUserAgg user) {
        userRepository.delete(user);
        return null;
    }


}

