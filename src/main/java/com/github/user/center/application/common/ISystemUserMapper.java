package com.github.user.center.application.common;

import com.github.user.center.application.UserCreateCommand;
import com.github.user.center.application.UserSaveResult;
import com.github.user.center.domain.entity.SystemUserEntity;
import com.github.user.center.interfaces.dto.ISystemQueryResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * TODO
 * <p>
 * create in 2021/5/10 7:03 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Mapper
public interface ISystemUserMapper {

    /**
     * 对外提供服务类
     */
    ISystemUserMapper INSTANCE = Mappers.getMapper(ISystemUserMapper.class);

    /**
     * {@link SystemUserEntity} 转换成 {@link UserSaveResult}
     *
     * @param user 用户实体类
     * @return 用户保存结果
     */
    UserSaveResult from(SystemUserEntity user);


    /**
     * 创建用户
     *
     * @param command 创建用户命令
     * @return 用户实体类
     */
    SystemUserEntity from(UserCreateCommand command);

    ISystemQueryResult fromEntity(SystemUserEntity entity);

}
