/**
 * Copyright (c) 2005-2012 springside.org.cn
 */
package cn.vpclub.demo.common.model.utils.common;



import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import cn.vpclub.demo.common.model.utils.constant.SystemConstant;
import cn.vpclub.demo.common.model.utils.web.Exceptions;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 * 封装各种格式的编码解码工具类.
 * 1.Commons-Codec的 hex/base64 编码
 * 2.自制的base62 编码
 * 3.Commons-Lang的xml/html escape
 * 4.JDK提供的URLEncoder
 *
 * @author calvin
 * @version 2013-01-15
 */
public class Encodes extends Base64Util {

  private static final String DEFAULT_URL_ENCODING = "UTF-8";
  private static final char[] BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
      .toCharArray();

  /**
   * Hex编码.
   */
  public static String encodeHex(byte[] input) {
    return new String(Hex.encodeHex(input));
  }

  /**
   * Hex解码.
   */
  public static byte[] decodeHex(String input) {
    try {
      return Hex.decodeHex(input.toCharArray());
    } catch (DecoderException e) {
      throw Exceptions.unchecked(e);
    }
  }

  /**
   * Base62编码。
   */
  public static String encodeBase62(byte[] input) {
    char[] chars = new char[input.length];
    for (int i = 0; i < input.length; i++) {
      chars[i] = BASE62[((input[i] & 0xFF) % BASE62.length)];
    }
    return new String(chars);
  }

  /**
   * Html 转码.
   */
  public static String escapeHtml(String html) {
    return StringEscapeUtils.escapeHtml4(html);
  }

  /**
   * Html 解码.
   */
  public static String unescapeHtml(String htmlEscaped) {
    return StringEscapeUtils.unescapeHtml4(htmlEscaped);
  }

  /**
   * Xml 转码.
   */
  public static String escapeXml(String xml) {
    return StringEscapeUtils.escapeXml10(xml);
  }

  /**
   * Xml 解码.
   */
  public static String unescapeXml(String xmlEscaped) {
    return StringEscapeUtils.unescapeXml(xmlEscaped);
  }

  /**
   * URL 编码, Encode默认为UTF-8.
   */
  public static String urlEncode(String part) {
    try {
      return URLEncoder.encode(part, DEFAULT_URL_ENCODING);
    } catch (UnsupportedEncodingException e) {
      throw Exceptions.unchecked(e);
    }
  }

  /**
   * URL 解码, Encode默认为UTF-8.
   */
  public static String urlDecode(String part) {

    try {
      return URLDecoder.decode(part, DEFAULT_URL_ENCODING);
    } catch (UnsupportedEncodingException e) {
      throw Exceptions.unchecked(e);
    }
  }

  /**
   * 对字符串进行MD5加密
   *
   * @param str 需要加密的字符串
   * @return MD5加密后的字符串
   */
  public static String encodeToMD5(String str) {
    return encodeToAlgorithm(str, SystemConstant.MD5);
  }

  /**
   * 根据运算法测对字符串进行相应的法则加密
   *
   * @param str 加密字符串
   * @param algorithm 运算法测
   * @return String
   */
  public static String encodeToAlgorithm(String str, String algorithm) {
    if (StringUtil.isEmpty(str)) {
      return null;
    } else {
      try {
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        byte[] digest = messageDigest.digest(str.getBytes("utf-8"));
        return new String(Hex.encodeHex(digest));
      } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
        throw Exceptions.unchecked(e);
      }
    }
  }

  /**
   * 根据Ascall码升序对字符串进行排序并用“&”连接拼接成url参数
   *
   * @param map 需要排序的参数键值对
   * @return String
   */
  public static String sortParam(Map<String, ? extends Object> map) {
    ArrayList<String> list = new ArrayList<String>();
    for (Map.Entry<String, ?> entry : map.entrySet()) {
      if (!StringUtil.isEmpty(entry.getValue())) {
        list.add(entry.getKey() + "=" + entry.getValue() + "&");
      }
    }
    if (!list.isEmpty()) {
      int size = list.size();
      String[] arrayToSort = list.toArray(new String[size]);
      Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
      StringBuilder stringSignTemp = new StringBuilder();
      for (int i = 0; i < size; i++) {
        stringSignTemp.append(arrayToSort[i]);
      }
      return stringSignTemp.toString();
    } else {
      return null;
    }
  }
}
