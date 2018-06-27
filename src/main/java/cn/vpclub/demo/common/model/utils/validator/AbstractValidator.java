package cn.vpclub.demo.common.model.utils.validator;

import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;

/**
 * Validator
 * Created by johnd on 2/22/17.
 */
@Slf4j
public abstract class AbstractValidator implements IValidator {
    public String validate(Object object, Annotation annotation, Object value, String fieldName) {
        log.warn("method validate is not implemented");
        return null;
    }
}
