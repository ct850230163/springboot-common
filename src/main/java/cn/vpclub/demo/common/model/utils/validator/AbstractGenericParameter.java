package cn.vpclub.demo.common.model.utils.validator;

import lombok.extern.slf4j.Slf4j;

/**
 * This is the abstract implementation of an ProSa Parameter object.  This abstract object
 * implements an generic toString method which  generates an output for all private attributes of
 * the class where an corresponding getter exists. This getters have to start with
 * <code>get</code>. Subattributes (in a Collection) are also printed!<br>
 * Also it is posible to check if an attribute is optional. This could be  done by the method
 * isOptionalMethod. This method delivers <code>true</code> if the name of the method is added to
 * the included HashMap via the method  addOptionalMethod. This is needed for the validating process!<br>
 * Also there is the method validatWith where you can send a Validator object  into the parameter
 * and let him do his work. Normally this will be the  GenericClassAttributeValidator. Which
 * validates all attributes including  Collections!
 *
 * @author johnd
 */

@Slf4j
public abstract class AbstractGenericParameter extends BaseAbstractParameter {
    /**
     * This is the implementation from the Validateable interface and just calls validate on the
     * validator which is given to the method.
     *
     * @param validator The validator which should be used
     * @throws AttributeValidatorException Is thrown when an non optinal attribute  is null. And if
     *                                     a refelction call does not work! (Look to message!)
     */
    @Override
    public void validateWith(IClassAttributeValidator validator)
            throws AttributeValidatorException {
        validator.validate(this, null);
    }

    /**
     * This is the implementation from the Validateable interface and just calls validate on the
     * validator which is given to the method.
     *
     * @param condition The validate condition which should be used
     * @throws AttributeValidatorException Is thrown when an non optinal attribute  is null. And if
     *                                     a refelction call does not work! (Look to message!)
     */
    @Override
    public void validate(String condition) throws AttributeValidatorException {
        IClassAttributeValidator validator = GenericClassAttributeValidator.getInstance();
        validator.validate(this, condition);
    }

    /**
     * This is the implementation from the Validateable interface and just calls validate on the
     * validator which is given to the method.
     *
     * @throws AttributeValidatorException Is thrown when an non optinal attribute  is null. And if
     *                                     a refelction call does not work! (Look to message!)
     */
    @Override
    public void validate() throws AttributeValidatorException {
        validate(null);
    }
}
