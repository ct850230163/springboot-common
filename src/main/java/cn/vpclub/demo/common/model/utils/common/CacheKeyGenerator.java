package cn.vpclub.demo.common.model.utils.common;



import cn.vpclub.demo.common.model.utils.web.Exceptions;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenwei on 2018/4/8.
 */
public class CacheKeyGenerator {
    /**
     * 动态生成key
     * @param requestMap
     * @return
     */
    public static String generatorKeyFromMap(Map<String, String> requestMap) {

        StringBuilder result = new StringBuilder();
        if (requestMap != null && !requestMap.isEmpty()) {
            for (Map.Entry<String, String> entry : requestMap.entrySet()) {
                if (!StringUtil.isEmpty(entry.getValue())) {
                    result.append(entry.getKey() + ":" + entry.getValue() + "-");
                }
            }
            result = new StringBuilder(result.substring(0, result.length() - 1));
        }
        return result.toString();

    }

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

    public static String generatorKey(Object bean) {
        StringBuilder result = new StringBuilder();
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
                    String value = method.invoke(bean).toString();

                    if (StringUtil.isNotEmpty(value)){
                        result.append(key + ":" + value + "-");
                    }
                }
            }
            //去掉最后一个符号
            if(StringUtil.isNotEmpty(result.toString())){
                result = new StringBuilder(result.substring(0, result.length() - 1));;
            }
        } catch (Exception e) {
            throw Exceptions.unchecked(e);
        }
        return result.toString();
    }
}
