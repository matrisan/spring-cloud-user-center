package com.github.user.center.domain.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

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
public class SystemUserExtend implements Serializable {

    private static final long serialVersionUID = 5624943535398579636L;

    @Column(table = USER_EXTEND_INFO, columnDefinition = "VARCHAR(50) COMMENT '邮箱'")
    String email;


}
