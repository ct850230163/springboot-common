package cn.vpclub.demo.common.model.utils.validator.annotations;



import cn.vpclub.demo.common.model.utils.constant.ValidatorMessageCodeConstant;
import cn.vpclub.demo.common.model.utils.validator.AbstractValidator;
import cn.vpclub.demo.common.model.utils.validator.validators.NotEmptyValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * NotNull
 * Created by johnd on 2/22/17.
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { })
public @interface NotEmpty {

    String message() default ValidatorMessageCodeConstant.MESSAGE_VALIDATOR_NOTEMPTY;

    String[] when() default {}; // only validate when the expression is true

    Class<? extends AbstractValidator> validator() default NotEmptyValidator.class;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface List {
        org.hibernate.validator.constraints.Range[] value();
    }
}
