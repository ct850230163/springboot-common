package cn.vpclub.demo.common.model.utils.validator.validators;



import cn.vpclub.demo.common.model.utils.validator.AbstractValidator;
import cn.vpclub.demo.common.model.utils.validator.annotations.Range;

import java.lang.annotation.Annotation;

/**
 * RangeOfValidator
 * Created by johnd on 2/22/17.
 */
public class RangeValidator extends AbstractValidator {
    @Override
    public String validate(Object object, Annotation annotation, Object value, String fieldName) {
        Range rangeOf = ((Range)annotation);
        String errorMessage = object.getClass().getSimpleName()  + "." + fieldName + " " + rangeOf.message() + ", " +
                rangeOf.messageExpected() + " (" + rangeOf.min() + "-" + rangeOf.max() + ") " +
                rangeOf.messageGot();
        if (null == value) {
            return errorMessage + " NULL";
        }
        Long val = new Long(value.toString());
        if ( val < rangeOf.min() || val > rangeOf.max() ) {
            return errorMessage + " " + val;
        }
        return null;
    }
}
