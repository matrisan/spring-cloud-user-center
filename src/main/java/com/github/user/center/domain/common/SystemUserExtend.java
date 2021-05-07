package com.github.user.center.domain.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import static com.github.user.center.domain.common.IUserExtendInfo.USER_EXTEND_INFO;

/**
 * 用户冗余信息
 * <p>
 * create in 2021/5/7 10:38 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Getter
@Setter
@ToString
@Embeddable
public class SystemUserExtend {

//    @Column(table = USER_EXTEND_INFO, insertable = false, updatable = false, name = USER_ID)
//    Long userId;

    @Column(table = USER_EXTEND_INFO, columnDefinition = "CHAR(20) COMMENT '手机号码'")
    String mobile;

    @Column(table = USER_EXTEND_INFO, columnDefinition = "VARCHAR(50) COMMENT '邮箱'")
    String email;


}
