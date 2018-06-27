package cn.vpclub.demo.common.model.utils.validator.validators;


import cn.vpclub.demo.common.model.utils.common.PropertyUtils;
import cn.vpclub.demo.common.model.utils.validator.AbstractValidator;
import cn.vpclub.demo.common.model.utils.validator.annotations.Map;
import cn.vpclub.demo.common.model.utils.validator.annotations.MatchMap;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * NotAllowedNullValidator
 * Created by johnd on 2/22/17.
 */
@Slf4j
public class MatchMapValidator extends AbstractValidator {
    @Override
    public String validate(Object object, Annotation annotation, Object value, String fieldName) {
        MatchMap multipleMatches = (MatchMap)annotation;
        Map[] keyValues = multipleMatches.map();
        Object fieldValue = PropertyUtils.invokeGetter(object, multipleMatches.validateField());
        Boolean isValid = false;
        for (Map kv: keyValues) {
            if (value.equals(kv.key())) {
                switch (kv.type()) {
                    case NOT_EMPTY:
                        isValid = notEmpty(fieldValue);
                        break;
                    case EQUALS:
                        isValid = equals(kv.value(), fieldValue);
                        break;
                    case NOT_EQUALS:
                        isValid = !equals(kv.value(), fieldValue);
                        break;
                    case REGEX:
                        isValid = matches(kv.value(), fieldValue);
                        break;
                    case GREATER:
                        isValid = greater(kv.value(), fieldValue);
                        break;
                    case LESS:
                        isValid = less(kv.value(), fieldValue);
                        break;
                }
                if ( !isValid ) {
                    String prefix = kv.key() + ", " + multipleMatches.validateField() + multipleMatches.messageGot() + " '" + fieldValue + "', " + multipleMatches.messageExpected() + " ";
                    if ("".equals(kv.message())) {
                        return prefix + multipleMatches.message();
                    }
                    return prefix + kv.message();
                }
            }
        }

        if ( !isValid ) {
            return multipleMatches.message();
        }
        return null;
    }

    private Boolean less(String expected, Object fieldValue) {
        if (null == fieldValue) {
            return false;
        }
        return Long.parseLong(fieldValue.toString()) < Long.parseLong(expected);
    }

    private Boolean greater(String expected, Object fieldValue) {
        if (null == fieldValue) {
            return false;
        }
        return Long.parseLong(fieldValue.toString()) > Long.parseLong(expected);
    }

    private Boolean matches(String value, Object fieldValue) {
        Pattern p = Pattern.compile(value);
        Matcher m = p.matcher(fieldValue.toString());
        if (m.matches()) {
            return true;
        }
        return false;
    }

    private Boolean equals(String expected, Object fieldValue) {
        if (null == fieldValue) {
            return false;
        }
        return expected.equals(fieldValue.toString());
    }

    private Boolean notEmpty(Object fieldValue) {
        return null != fieldValue && !"".equals(fieldValue.toString());
    }
}
