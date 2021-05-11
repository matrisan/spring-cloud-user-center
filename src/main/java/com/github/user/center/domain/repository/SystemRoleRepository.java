package com.github.user.center.domain.repository;

import com.github.user.center.infrastructure.dao.ISystemRoleDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

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
public class SystemRoleRepository {

    private final ISystemRoleDao roleDao;


}
