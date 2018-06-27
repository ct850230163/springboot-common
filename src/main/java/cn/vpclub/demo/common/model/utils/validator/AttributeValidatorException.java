package cn.vpclub.demo.common.model.utils.validator;

/**
 * The exception which is thrown by the Validator package
 *
 * @author johnd
 */

public class AttributeValidatorException extends Exception
{
    /**
     * Creates a new AttributeValidatorException object.
     *
     * @param msg The error message of the thrown AttributeValidatorException
     */
    public AttributeValidatorException( String msg )
    {
        super( msg );
    }
}
