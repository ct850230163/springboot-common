package cn.vpclub.demo.common.model.utils.common;


import cn.vpclub.demo.common.model.utils.web.Exceptions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * MAP解析器
 * <p>
 * User: HJ
 * Date: 2016/1/22
 */
@Slf4j
public class MapParserUtil {

    protected MapParserUtil() {

    }

    /**
     * 把bean直接转换成map
     *
     * @param bean
     * @return Map<String, Object>
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static Map<String, Object> convertBeanToMap(Object bean) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Class c = bean.getClass();
            // 获取类所有方法
            Method[] methodArr = c.getMethods();
            for (Method method : methodArr) {
                String methodName = method.getName();
                if (methodName.startsWith("get") && !"getClass".equals(methodName)
                        && null != method.invoke(bean)) {
                    String key = methodName.substring(3);
                    key = key.toLowerCase().charAt(0) + key.substring(1);
                    map.put(key, method.invoke(bean));
                }
            }
        } catch (Exception e) {
            throw Exceptions.unchecked(e);
        }
        return map;
    }

    /**
     * 把bean直接转换成map
     *
     * @param bean
     * @return Map<String, Object>
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static Map<String, String> convertBeanToStringMap(Object bean) {
        Map<String, String> map = new HashMap<String, String>();
        try {
            Class c = bean.getClass();
            // 获取类所有方法
            Method[] methodArr = c.getMethods();
            for (Method method : methodArr) {
                String methodName = method.getName();
                if (methodName.startsWith("get") && !"getClass".equals(methodName)
                        && null != method.invoke(bean)) {
                    String key = methodName.substring(3);
                    key = key.toLowerCase().charAt(0) + key.substring(1);
                    map.put(key, method.invoke(bean).toString());
                }
            }
        } catch (Exception e) {
            throw Exceptions.unchecked(e);
        }
        return map;
    }

    /**
     * 获取请求参数中所有的信息
     *
     * @param request
     * @return
     */
    public static Map<String, String> getAllRequestParam(final HttpServletRequest request) {
        Map<String, String> res = new HashMap<String, String>();
        Enumeration<?> temp = request.getParameterNames();
        if (null != temp) {
            while (temp.hasMoreElements()) {
                String en = (String) temp.nextElement();
                String value = request.getParameter(en);
                res.put(en, value);
                //在报文上送时，如果字段的值为空，则不上送<下面的处理为在获取所有参数数据时，判断若值为空，则删除这个字段>
                if (null == res.get(en) || "".equals(res.get(en))) {
                    res.remove(en);
                }
            }
        }
        return res;
    }

    /**
     * 获取请求内容信息
     *
     * @param request HttpServletRequest
     * @return Map<String, Object>
     */
    public static Map<String, Object> getInputStreamToMap(final HttpServletRequest request) {
        Map<String, Object> resultMap = null;
        try {
            String json = IOUtils.toString(request.getInputStream());
            log.info("requestInputStreamToJson: " + json);
            resultMap = JsonUtil.jsonToMap(json);
        } catch (IOException e) {
            throw Exceptions.unchecked(e);
        }
        return resultMap;
    }

    /**
     * 将map转换成Javabean
     * 利用org.apache.commons.beanutils.BeanUtils工具类实现
     *
     * @param cls  javaBean
     * @param data map数据
     */
    public static <T> T getObjectFromMap(Class<T> cls, Map<String, ? extends Object> data) {
        T object = null;
        try {
            // 实例化对象
            object = cls.newInstance();
            // map转换成Javabean操作
            BeanUtils.populate(object, data);
        } catch (InstantiationException e) {
            throw Exceptions.unchecked(e);
        } catch (IllegalAccessException e) {
            throw Exceptions.unchecked(e);
        } catch (InvocationTargetException e) {
            throw Exceptions.unchecked(e);
        }
        return object;
    }

    /**
     * 从MAP获取字符串值
     *
     * @param map
     * @param key
     * @return
     */
    public static String getStringFromMap(Map<String, ? extends Object> map, String key) {
        return getStringFromMap(map, key, null);
    }

    /**
     * 从MAP获取字符串值
     *
     * @param map
     * @param key
     * @param defaultValue 默认值
     * @return
     */
    public static String getStringFromMap(Map<String, ? extends Object> map, String key, String defaultValue) {
        if (StringUtil.isEmpty(key)) {
            return defaultValue;
        }
        Object result = map.get(key);
        if (result == null) {
            return defaultValue;
        } else {
            return result.toString();
        }
    }

    /**
     * 从MAP获取Integer值
     *
     * @param map
     * @param key
     * @return
     */
    public static Integer getIntFromMap(Map<String, ? extends Object> map, String key) {
        if (StringUtil.isEmpty(key)) {
            return null;
        }
        Object result = map.get(key);
        if (result == null) {
            return null;
        } else {
            return Integer.parseInt(result.toString());
        }
    }

    /**
     * 从MAP获取Long值
     *
     * @param map
     * @param key
     * @return
     */
    public static Long getLongFromMap(Map<String, ? extends Object> map, String key) {
        if (StringUtil.isEmpty(key)) {
            return null;
        }
        Object result = map.get(key);
        if (result == null) {
            return null;
        } else {
            return Long.parseLong(result.toString());
        }
    }

    /**
     * 从MAP获取BigDecimal值
     *
     * @param map
     * @param key
     * @return
     */
    public static BigDecimal getBigDecimalFromMap(Map<String, ? extends Object> map, String key) {
        if (StringUtil.isEmpty(key)) {
            return null;
        }
        Object result = map.get(key);
        if (result == null) {
            return null;
        } else {
            return new BigDecimal(result.toString());
        }
    }
}
