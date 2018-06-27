package cn.vpclub.demo.common.model.utils.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

/**
 * CommonBeanUtils
 * Created by johnd on 17/02/2017.
 */
@Slf4j
public class CommonBeanUtils {
    /**
     * Retrieves the type of the property with the given name of the given
     * Class.<br>
     * Supports nested properties following bean naming convention.
     *
     * "foo.bar.name"
     *
     * @see PropertyUtils#getPropertyDescriptors(Class)
     *
     * @param clazz
     * @param propertyName
     *
     * @return Null if no property exists.
     */
    public static PropertyDescriptor getPropertyType(Object object, Class<?> stopClazz, String propertyName)
    {
        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo((Class<?>) object, stopClazz);
        } catch (IntrospectionException e) {
            log.info("{}", e);
        }
        PropertyDescriptor descriptors[] = beanInfo.getPropertyDescriptors();
        int stop = descriptors.length;
        for (int i = 0; i < stop; ++i) {
            PropertyDescriptor descriptor = descriptors[i];
            log.debug(descriptor.getName() + " : " + descriptor.getPropertyType().getName() + ", writemethod :" + descriptor.getWriteMethod());
            if (descriptor.getName().equals(propertyName))
            {
                return descriptor;
            }
        }
        log.debug("\n");

        return null;
    }

    public static Map<String, PropertyDescriptor> getPropertyDescriptors(Object object, Class<?> stopClazz)
    {
        Map<String, PropertyDescriptor> propertyDescriptors = new HashMap<>();
        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo((Class<?>) object, stopClazz);
        } catch (IntrospectionException e) {
            log.info("{}", e);
        }
        PropertyDescriptor descriptors[] = beanInfo.getPropertyDescriptors();
        int stop = descriptors.length;
        for (int i = 0; i < stop; ++i) {
            PropertyDescriptor descriptor = descriptors[i];
            log.debug(descriptor.getName() + " : " + descriptor.getPropertyType().getName() + ", writemethod :" + descriptor.getWriteMethod());
            propertyDescriptors.put(descriptor.getName(), descriptor);
        }
        log.debug("\n");

        return propertyDescriptors;
    }
}

