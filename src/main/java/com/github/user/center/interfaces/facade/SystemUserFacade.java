package com.github.user.center.interfaces.facade;

import com.github.user.center.application.service.SystemUserService;
import com.github.user.center.interfaces.dto.ISystemQueryResult;
import com.github.user.center.interfaces.dto.UserQueryRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 * <p>
 * create in 2021/5/8 11:00 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@RestController
@RequiredArgsConstructor
public class SystemUserFacade {

    private final SystemUserService service;

    @GetMapping("/users")
    public Page<ISystemQueryResult> findAllUser(UserQueryRequest request, Pageable pageable) {
        return service.findAllUser(request, pageable);
    }


}
