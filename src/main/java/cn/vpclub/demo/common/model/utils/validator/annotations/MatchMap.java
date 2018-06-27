package cn.vpclub.demo.common.model.utils.validator.annotations;



import cn.vpclub.demo.common.model.utils.constant.ValidatorMessageCodeConstant;
import cn.vpclub.demo.common.model.utils.validator.AbstractValidator;
import cn.vpclub.demo.common.model.utils.validator.validators.MatchMapValidator;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * NotAllowedNullList
 * Created by johnd on 2/22/17.
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { })
public @interface MatchMap {
    String message() default ValidatorMessageCodeConstant.MESSAGE_VALIDATOR_NOTMATCH;

    String messageExpected() default ValidatorMessageCodeConstant.MESSAGE_VALIDATOR_EXPECTED;

    String messageGot() default ValidatorMessageCodeConstant.MESSAGE_VALIDATOR_GOT;

    Map[] map();

    String validateField() default "";

    String[] when() default {}; // only validate when the expression is true

    Class<? extends AbstractValidator> validator() default MatchMapValidator.class;
}

