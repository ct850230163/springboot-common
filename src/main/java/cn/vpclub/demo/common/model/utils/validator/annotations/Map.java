package cn.vpclub.demo.common.model.utils.validator.annotations;

/**
 * Map
 * Created by johnd on 2/22/17.
 */
public @interface Map {
    enum Type {REGEX, EQUALS, GREATER, LESS, NOT_EQUALS, NOT_EMPTY, RANGE}
    String key();
    String value() default "";
    Type type() default Type.EQUALS;
    String message() default "";
}
