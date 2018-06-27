package cn.vpclub.demo.common.model.utils.validator;

/**
 * The Validateable interface should be implemented by all classes which
 * are used as paramter objects and where any kind of tests with the class 
 * should be done.
 * @author johnd
 */
public interface Validateable
{
    /**
     * Send the validator which is used to validate the class into the class
     *
     * @param validator The validator which will be used
     *
     * @throws Exception Thrown if the validation is unsuccsessful
     */
    public void validateWith(IClassAttributeValidator validator) throws Exception;
    public void validate(String condition) throws Exception;
    public void validate() throws Exception;
}
