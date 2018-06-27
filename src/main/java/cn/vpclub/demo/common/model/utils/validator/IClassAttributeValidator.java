package cn.vpclub.demo.common.model.utils.validator;

/**
 * This is the interface for any kind of validator implementations
 *
 * @author johnd
 */
public interface IClassAttributeValidator
{
    /**
     * The validate  method has to implement the validate algorithm for the
     * parameter class which has to be validated
     *
     * @param param The AbstractParameter which has to be validated
     *
     * @throws AttributeValidatorException Thrown if the validation fails
     */
    public void validate(BaseAbstractParameter param, String condition) throws AttributeValidatorException;
}
