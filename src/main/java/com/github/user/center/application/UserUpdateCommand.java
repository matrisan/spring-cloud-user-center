package com.github.user.center.application;

import com.github.user.center.domain.common.SystemUserExtend;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

/**
 * TODO
 * <p>
 * create in 2021/5/10 7:46 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateCommand {

    Long userId;

    String phone;

    Set<Long> roleIds;

    SystemUserExtend userInfo;

}
