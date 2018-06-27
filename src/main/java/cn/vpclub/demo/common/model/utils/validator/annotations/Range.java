package cn.vpclub.demo.common.model.utils.validator.annotations;



import cn.vpclub.demo.common.model.utils.constant.ValidatorMessageCodeConstant;
import cn.vpclub.demo.common.model.utils.validator.AbstractValidator;
import cn.vpclub.demo.common.model.utils.validator.validators.RangeValidator;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = {}
)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Min(0L)
@Max(9223372036854775807L)
@ReportAsSingleViolation
public @interface Range {
    @OverridesAttribute(
            constraint = Min.class,
            name = "value"
    )
    long min() default 0L;

    @OverridesAttribute(
            constraint = Max.class,
            name = "value"
    )
    long max() default 9223372036854775807L;

    String message() default ValidatorMessageCodeConstant.MESSAGE_VALIDATOR_OUTOFRANGE;

    String messageExpected() default ValidatorMessageCodeConstant.MESSAGE_VALIDATOR_EXPECTED;

    String messageGot() default ValidatorMessageCodeConstant.MESSAGE_VALIDATOR_GOT;

    String[] when() default {}; // only validate when the expression is true

    Class<? extends AbstractValidator> validator() default RangeValidator.class;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface List {
        org.hibernate.validator.constraints.Range[] value();
    }
}


