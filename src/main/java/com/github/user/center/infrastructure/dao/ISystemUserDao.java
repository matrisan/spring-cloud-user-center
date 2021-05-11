package com.github.user.center.infrastructure.dao;

import com.github.user.center.domain.entity.SystemUserEntity;
import org.springframework.data.history.Revisions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.history.RevisionRepository;

import java.time.LocalDateTime;
import java.util.Optional;


/**
 * TODO
 * <p>
 * create in 2021/5/6 2:12 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface ISystemUserDao extends JpaRepository<SystemUserEntity, Long>, JpaSpecificationExecutor<SystemUserEntity>, RevisionRepository<SystemUserEntity, Long, Integer> {

    SystemUserEntity findSystemUserAggById(long id);

    Optional<SystemUserEntity> findByUsername(String username);

    Optional<SystemUserEntity> findByPhone(String mobile);

    Revisions<Integer, SystemUserEntity> findRevisionsByIdAndLastModifiedDateAfter(long id, LocalDateTime dateTime);

}
