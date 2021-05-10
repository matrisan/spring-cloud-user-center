package com.github.user.center.application.service;

import com.github.user.center.application.UserCreateCommand;
import com.github.user.center.application.UserPasswordUpdateCommand;
import com.github.user.center.application.UserSaveResult;
import com.github.user.center.application.UserUpdateCommand;
import com.github.user.center.application.common.ISystemUserMapper;
import com.github.user.center.application.common.UserCreateFactory;
import com.github.user.center.application.exception.UserIdNotFoundException;
import com.github.user.center.domain.aggregate.SystemUserAgg;
import com.github.user.center.domain.entity.SystemRoleEntity;
import com.github.user.center.domain.repository.ISystemRoleRepository;
import com.github.user.center.domain.repository.ISystemUserRepository;
import com.github.user.center.interfaces.dto.ISystemQueryResult;
import com.github.user.center.interfaces.dto.UserQueryRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

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

    /**
     * 创建用户信息
     *
     * @param command 用户信息
     * @return UserSaveResult
     */
    @Transactional(rollbackFor = Throwable.class)
    public UserSaveResult createUser(@Validated UserCreateCommand command) {
        log.info("创建用户:{}", command);
        List<SystemRoleEntity> roles = roleRepository.findAllById(command.getRoleIds());
        SystemUserAgg user = UserCreateFactory.createUser(command, roles);
        SystemUserAgg save = userRepository.save(user);
        return ISystemUserMapper.INSTANCE.from(save);
    }

    /**
     * 更新用户密码
     *
     * @param command 更新用户密码
     * @return bool
     */
    public boolean updatePassword(@Validated UserPasswordUpdateCommand command) {
        SystemUserAgg agg = userRepository.findSystemUserAggById(command.getUserId());
        log.info("用户更新了密码:{}", agg);
        return agg.updatePassword((command.getPassword()));
    }

    /**
     * 更新用户信息
     *
     * @param command 更新命令
     * @return 用户信息
     */
    @Transactional(rollbackFor = Throwable.class)
    public UserSaveResult updateUser(@Validated UserUpdateCommand command) {
        log.info("更新用户角色");
        Optional<SystemUserAgg> optional = userRepository.findById(command.getUserId());
        if (optional.isEmpty()) {
            throw new UserIdNotFoundException("找不到用户的 ID");
        }
        List<SystemRoleEntity> roles = roleRepository.findAllById(command.getRoleIds());
        SystemUserAgg userAgg = optional.get();
        userAgg.replaceAllRoles(roles);
        return ISystemUserMapper.INSTANCE.from(userAgg);
    }

    /**
     * 删除用户
     *
     * @param userId 用户的 ID
     * @return boolean
     */
    public boolean deleteUser(long userId) {
        Optional<SystemUserAgg> user = userRepository.findById(userId);
        user.ifPresent(systemUserAgg -> {
            log.info("删除用户:{}", systemUserAgg);
            userRepository.delete(systemUserAgg);
        });
        return true;
    }

}

