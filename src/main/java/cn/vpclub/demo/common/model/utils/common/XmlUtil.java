package cn.vpclub.demo.common.model.utils.common;


import cn.vpclub.demo.common.model.utils.web.Exceptions;
import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Xml序列化与反序列化
 * 实体注解
 *
 * @XmlRootElement：根节点
 * @XmlElement：实体属性映射到节点
 * @XmlAttribute：实体属性映射到节点属性
 * @XmlTransient：忽略映射 其他属性自行百度
 * Created by Fred on 2016/8/26.
 */
@Slf4j
public class XmlUtil {

    protected XmlUtil() {

    }

    /**
     * 序列化实体
     * 编码方式为UTF-8
     *
     * @param data 实体
     * @return xml文本
     */
    public static <T> String serialize(T data) {
        return serialize(data, "UTF-8");
    }

    /**
     * 序列化实体
     * 指定编码方式
     *
     * @param data     实体
     * @param encoding 编码方式
     * @return xml文本
     */
    public static <T> String serialize(T data, String encoding) {
        try {
            JAXBContext context = JAXBContext.newInstance(data.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);// //编码格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// 是否格式化生成的xml串
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xm头声明信息
            StringWriter writer = new StringWriter();
            marshaller.marshal(data, writer);
            return writer.toString();
        } catch (JAXBException e) {
            log.error("XmlSerializeJAXBError", e);
            throw Exceptions.unchecked(e);
        } catch (Exception e) {
            log.error("XmlSerializeError", e);
            throw Exceptions.unchecked(e);
        }
    }

    /**
     * 反序列化实体
     *
     * @param xml xml文本
     * @param cls 实体类型
     * @param <T> 实体类型
     * @return 实体
     */
    @SuppressWarnings("unchecked")
    public static <T> T deserialize(String xml, Class<T> cls) {
        try {
            JAXBContext context = JAXBContext.newInstance(cls);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new StringReader(xml));
        } catch (JAXBException e) {
            log.error("XmlDeserializeJAXBError", e);
            throw Exceptions.unchecked(e);
        } catch (Exception e) {
            log.error("XmlDeserializeError", e);
            throw Exceptions.unchecked(e);
        }
    }
}
