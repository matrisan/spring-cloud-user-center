package com.github.user.center.application.annotation.constraints.validator;

import com.github.user.center.application.UserPasswordUpdateCommand;
import com.github.user.center.application.annotation.constraints.Password;
import com.github.user.center.domain.entity.SystemUserEntity;
import com.github.user.center.infrastructure.dao.ISystemUserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.history.Revisions;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

/**
 * 校验密码
 * <p>
 * create in 2021/5/10 8:48 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
public class PasswordValidator implements ConstraintValidator<Password, UserPasswordUpdateCommand> {

    @Resource
    private ISystemUserDao repository;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean isValid(UserPasswordUpdateCommand value, ConstraintValidatorContext context) {
        Revisions<Integer, SystemUserEntity> revisions = repository.findRevisionsByIdAndLastModifiedDateAfter(value.getUserId(), LocalDateTime.now().minusMonths(6));
        return revisions.stream().noneMatch(one -> passwordEncoder.matches(value.getPassword(), one.getEntity().getPassword()));
    }
}
