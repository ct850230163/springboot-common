package cn.vpclub.demo.common.model.utils.web;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Dispatcher
 * Created by johnd on 7/21/16.
 */
@Deprecated
@Slf4j
public class Dispatcher<T> {

    private Class<T> serviceClass;
    private T service;

    public Dispatcher(Class<T> serviceClass, T service) {
        this.serviceClass = serviceClass;
        this.service = service;
    }

    public void process(HttpServletRequest request, HttpServletResponse response, String methodName) {
        try {
            if (null != request) {
                String sRequest = IOUtils.toString(request.getInputStream());
                for (Method method : serviceClass.getMethods()) {
                    if (!method.isBridge() && method.getName().equals(methodName)) {
                        String sResponse = (String) method.invoke(service, new Object[]{sRequest});
                        HttpResponseUtil.setResponseJsonBody(response, sResponse);
                        log.info("Calling " + serviceClass.getName() + "." + methodName + "()");
                        log.info("Request: " + sRequest);
                        log.info("Response: " + sResponse);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            throw Exceptions.unchecked(e);
        } catch (IllegalAccessException e) {
            throw Exceptions.unchecked(e);
        } catch (InvocationTargetException e) {
            throw Exceptions.unchecked(e);
        }
    }

    public <O, I> O process(I request, String methodName) {
        try {
            if (null != request) {
                for (Method method : serviceClass.getMethods()) {
                    if (!method.isBridge() && method.getName().equals(methodName)) {

                        O response = (O) method.invoke(service, new Object[]{request});

                        log.info("Calling " + serviceClass.getName() + "." + methodName + "()");

                        return response;
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw Exceptions.unchecked(e);
        } catch (InvocationTargetException e) {
            throw Exceptions.unchecked(e);
        }

        return null;
    }
}
