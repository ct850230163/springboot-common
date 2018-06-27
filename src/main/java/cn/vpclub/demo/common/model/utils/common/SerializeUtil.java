package cn.vpclub.demo.common.model.utils.common;



import cn.vpclub.demo.common.model.utils.web.Exceptions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化工具
 * <p>
 * Created by HJ on 2016/7/5.
 */
public class SerializeUtil {
    protected SerializeUtil() {

    }

    /**
     * 序列化
     *
     * @param object
     */
    public static byte[] serialize(Object object) {
        try {
            // 序列化
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            return baos.toByteArray();
        } catch (Exception e) {
            throw Exceptions.unchecked(e);
        }
    }

    /**
     * 反序列化
     *
     * @param bytes
     */
    public static Object unSerialize(byte[] bytes) {
        try {
            // 反序列化
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            throw Exceptions.unchecked(e);
        }
    }
}
