package com.github.user.center.domain.repository;

import com.github.user.center.application.common.ISystemUserMapper;
import com.github.user.center.domain.entity.SystemUserEntity;
import com.github.user.center.infrastructure.dao.ISystemUserDao;
import com.github.user.center.interfaces.dto.ISystemQueryResult;
import com.github.user.center.interfaces.dto.UserQueryRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * TODO
 * <p>
 * create in 2021/5/11 12:55 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Repository
@RequiredArgsConstructor
public class SystemUserRepository {

    private final ISystemUserDao userDao;

    public UserDetails findUserByUsername(String username) {
        Optional<SystemUserEntity> optional = userDao.findByUsername(username);
        return getUser(optional);
    }

    public UserDetails findUserByPhone(String phone) {
        Optional<SystemUserEntity> optional = userDao.findByPhone(phone);
        return getUser(optional);
    }

    public Page<ISystemQueryResult> findAll(UserQueryRequest request, Pageable pageable) {
        return userDao.findAll(request.specification(), pageable).map(ISystemUserMapper.INSTANCE::fromEntity);
    }

    private UserDetails getUser(Optional<SystemUserEntity> optional) {
        if (optional.isEmpty()) {
            throw new UsernameNotFoundException("UsernameNotFoundException");
        }
        SystemUserEntity entity = optional.get();
        return new User(
                entity.getUsername(),
                entity.getPassword(),
                entity.isEnabled(),
                entity.getAccountNonExpired(),
                entity.getCredentialsNonExpired(),
                entity.getAccountNonLocked(),
                null
        );
    }

}
