package cn.vpclub.demo.common.model.utils.common;

import cn.vpclub.demo.common.model.utils.constant.SystemConstant;
import cn.vpclub.demo.common.model.utils.web.Exceptions;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES {
    protected AES() {

    }

    private static String transformation = "AES/ECB/PKCS5Padding";

    /**
     * BASE64加密
     *
     * @return
     */
    public static String aesEncrypt(String str, String key) {
        try {
            if (null == str || null == key) {
                return null;
            }
            Cipher cipher = Cipher.getInstance(transformation);
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(SystemConstant.UTF8), SystemConstant.AES));
            byte[] bytes = cipher.doFinal(str.getBytes(SystemConstant.UTF8));
            return Base64Util.encode(bytes);
        } catch (Exception e) {
            throw Exceptions.unchecked(e);
        }
    }

    /**
     * BASE64解密
     *
     * @return
     */
    public static String aesDecrypt(String str, String key) {
        try {
            if (null == str || null == key) {
                return null;
            }
            Cipher cipher = Cipher.getInstance(transformation);
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(SystemConstant.UTF8), SystemConstant.AES));
            byte[] bytes = Base64Util.decode(str);
            bytes = cipher.doFinal(bytes);
            return new String(bytes, SystemConstant.UTF8);
        } catch (Exception e) {
            throw Exceptions.unchecked(e);
        }
    }

    /**
     * 16进制加密
     *
     * @return
     */
    public static String aesEncryptWith16(String str, String key) {
        try {
            if (null == str || null == key) {
                return null;
            }
            Cipher cipher = Cipher.getInstance(transformation);
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(SystemConstant.UTF8), SystemConstant.AES));
            byte[] bytes = cipher.doFinal(str.getBytes(SystemConstant.UTF8));
            return parseByte2HexStr(bytes);
        } catch (Exception e) {
            throw Exceptions.unchecked(e);
        }
    }

    /**
     * 16进制解密
     *
     * @return
     */
    public static String aesDecryptWith16(String str, String key) {
        try {
            if (null == str || null == key) {
                return null;
            }
            Cipher cipher = Cipher.getInstance(transformation);
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(SystemConstant.UTF8), SystemConstant.AES));
            byte[] bytes = parseHexStr2Byte(str);
            bytes = cipher.doFinal(bytes);
            return new String(bytes, SystemConstant.UTF8);
        } catch (Exception e) {
            throw Exceptions.unchecked(e);
        }
    }

    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte[] buf) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return new byte[0];
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

}
