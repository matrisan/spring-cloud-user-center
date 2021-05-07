package com.github.user.center.domain.repository;

import com.github.user.center.domain.aggregate.SystemUserAggregateRoot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * TODO
 * <p>
 * create in 2021/5/6 2:12 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface ISystemUserRepository extends JpaRepository<SystemUserAggregateRoot, Long>, JpaSpecificationExecutor<SystemUserAggregateRoot> {
}
