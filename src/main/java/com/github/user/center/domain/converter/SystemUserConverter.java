package com.github.user.center.domain.converter;

import com.github.user.center.application.UserCreateCommand;
import com.github.user.center.application.UserSaveResult;
import com.github.user.center.domain.entity.SystemUserEntity;
import com.github.user.center.interfaces.dto.ISystemQueryResult;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

/**
 * TODO
 * <p>
 * create in 2021/5/12 7:40 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SystemUserConverter {

    public static UserSaveResult from(SystemUserEntity user) {
        UserSaveResult result = new UserSaveResult();
        BeanUtils.copyProperties(user, result);
        return result;
    }

    public static SystemUserEntity fromCreateCommand(UserCreateCommand command) {
        SystemUserEntity entity = new SystemUserEntity();
        BeanUtils.copyProperties(command, entity);
        return entity;
    }


    public static ISystemQueryResult fromEntity(SystemUserEntity entity) {
        ISystemQueryResult.SystemQueryResult result = new ISystemQueryResult.SystemQueryResult();
        BeanUtils.copyProperties(entity, result);
        return result;
    }


}
