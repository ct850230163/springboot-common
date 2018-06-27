package cn.vpclub.demo.common.model.utils.validator.validators;


import cn.vpclub.demo.common.model.utils.validator.AbstractValidator;
import cn.vpclub.demo.common.model.utils.validator.annotations.NotEmpty;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;

/**
 * NotAllowedNullValidator
 * Created by johnd on 2/22/17.
 */
@Slf4j
public class NotEmptyValidator extends AbstractValidator {
    @Override
    public String validate(Object object, Annotation annotation, Object value, String fieldName) {
        if ( null == value || value.toString().isEmpty()) {
            return object.getClass().getSimpleName()  + "." + fieldName + " " + ((NotEmpty)annotation).message();
        }
        return null;
    }
}
