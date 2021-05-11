package com.github.user.center.interfaces.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 用户查询请求
 * <p>
 * create in 2021/5/8 11:01 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SuppressWarnings("unused")
@JsonDeserialize(as = ISystemQueryResult.SystemQueryResult.class)
public interface ISystemQueryResult extends Serializable {

    /**
     * ID
     *
     * @return ID
     */
    String getId();

    /**
     * NAME
     *
     * @return NAME
     */
    String getUsername();

    /**
     * PHONE
     *
     * @return PHONE
     */
    String getPhone();

    @Getter
    @Setter
    @Builder
    @ToString
    class SystemQueryResult implements ISystemQueryResult {

        private static final long serialVersionUID = -8929477193624059903L;

        Long id;

        String username;

        String phone;
    }

}
