package com.github.user.center.domain.repository;

import com.github.user.center.domain.aggregate.SystemUserAgg;
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

public interface ISystemUserRepository extends JpaRepository<SystemUserAgg, Long>, JpaSpecificationExecutor<SystemUserAgg>, RevisionRepository<SystemUserAgg, Long, Integer> {

    SystemUserAgg findSystemUserAggById(long id);

    Optional<SystemUserAgg> findByUsername(String username);

    Optional<SystemUserAgg> findByPhone(String mobile);

    Revisions<Integer, SystemUserAgg> findRevisionsByIdAndLastModifiedDateAfter(long id, LocalDateTime dateTime);

}
