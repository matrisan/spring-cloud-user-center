package com.github.user.center.domain.repository;

import com.github.user.center.application.UserSaveResult;
import com.github.user.center.domain.converter.SystemUserConverter;
import com.github.user.center.domain.entity.SystemUserEntity;
import com.github.user.center.infrastructure.dao.ISystemUserDao;
import com.github.user.center.interfaces.dto.ISystemQueryResult;
import com.github.user.center.interfaces.dto.UserQueryRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 用户接口
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

    public SystemUserEntity findByUserId(long userId) {
        return userDao.findSystemEntityById(userId);
    }

    public UserSaveResult save(SystemUserEntity entity) {
        SystemUserEntity save = userDao.save(entity);
        log.info("保存用户:{}", save);
        return SystemUserConverter.from(entity);
    }

    public Page<ISystemQueryResult> findAll(UserQueryRequest request, Pageable pageable) {
        return userDao.findAll(specification(request), pageable).map(SystemUserConverter::fromEntity);
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
                Collections.emptyList()
        );
    }

    private Specification<SystemUserEntity> specification(UserQueryRequest request) {
        return (root, query, builder) -> {
            List<Predicate> list = new ArrayList<>();
            if (StringUtils.isNotBlank(request.getUsername())) {
                Predicate predicateParent = builder.equal(root.get("username").as(Long.class), request.getUsername());
                list.add(predicateParent);
            }
            Predicate[] predicates = list.toArray(new Predicate[0]);
            return query.where(predicates).getRestriction();
        };
    }

    public Optional<SystemUserEntity> findById(long userId) {
        return null;

    }

    public void delete(SystemUserEntity systemUserAgg) {

    }
}
