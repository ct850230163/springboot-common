package cn.vpclub.demo.common.model.utils.constant;

import java.io.Serializable;

/**
 * Created by johnd on 2017/6/21.
 * 国际化message基础常量
 *
 */
public class ValidatorMessageCodeConstant implements Serializable {

  /**
   * 不允许为空字符
   */
  public static final String MESSAGE_VALIDATOR_NOTEMPTY = "message.validator.NotEmpty";

  /**
   * 超出范围
   */
  public static final String MESSAGE_VALIDATOR_OUTOFRANGE = "message.validator.OutOfRange";

  /**
   * 不允许为空对象
   */
  public static final String MESSAGE_VALIDATOR_NOTNULL = "message.validator.NotNull";

  /**
   * 不匹配
   */
  public static final String MESSAGE_VALIDATOR_NOTMATCH = "message.validator.NotMatch";

  /**
   * 期望
   */
  public static final String MESSAGE_VALIDATOR_EXPECTED= "message.validator.Expected";

  /**
   * 实际获得
   */
  public static final String MESSAGE_VALIDATOR_GOT = "message.validator.Got";

}
