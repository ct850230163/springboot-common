package cn.vpclub.demo.common.model.utils.common;


import cn.vpclub.demo.common.model.utils.constant.SystemConstant;
import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * Created by admin on 2016/10/26.
 */
public class Base64Util {
    protected Base64Util() {

    }

    /**
     * Base64加密
     *
     * @param binaryData
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String encode(byte[] binaryData) throws UnsupportedEncodingException {
        if (null != binaryData && binaryData.length > 0) {
            return new String(Base64.encodeBase64(binaryData), SystemConstant.UTF8);
        } else {
            return null;
        }
    }

    /**
     * Base64加密
     *
     * @param data
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String encryptBASE64(String data) throws UnsupportedEncodingException {
        if (StringUtil.isNotEmpty(data)) {
            return Base64Util.encode(data.getBytes());
        } else {
            return null;
        }
    }

    /**
     * Base64解密
     *
     * @param base64String
     * @return
     * @throws UnsupportedEncodingException
     */
    public static byte[] decode(String base64String) throws UnsupportedEncodingException {
        if (StringUtil.isNotEmpty(base64String)) {
            return Base64.decodeBase64(base64String.getBytes(SystemConstant.UTF8));
        } else {
            return new byte[0];
        }
    }

    /**
     * Base64解密
     *
     * @param base64String
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String decryptBASE64(String base64String) throws UnsupportedEncodingException {
        byte[] byteArray = Base64Util.decode(base64String);
        if (null != byteArray && byteArray.length > 0) {
            return new String(byteArray);
        } else {
            return null;
        }
    }
}
