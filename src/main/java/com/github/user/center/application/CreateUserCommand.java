package com.github.user.center.application;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

/**
 * TODO
 * <p>
 * create in 2021/5/6 2:11 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Getter
@Setter
public class CreateUserCommand {

    private Set<Long> roleIds;

}
