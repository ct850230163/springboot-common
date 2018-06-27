package cn.vpclub.demo.common.model.utils.web;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 通讯返回工具类
 * <p>
 * Created by admin on 2016/2/24.
 */
@Slf4j
public class HttpResponseUtil {

    protected HttpResponseUtil() {

    }

    /**
     * 设置通讯返回信息
     *
     * @param resp
     * @param respBodyStr
     */
    public static void setResponseHtmlBody(HttpServletResponse resp, String respBodyStr) {
        setResponseBody(resp, respBodyStr, "text/html;charset=UTF-8", "UTF-8");
    }

    /**
     * 设置通讯返回信息（application/json）
     *
     * @param resp
     * @param respBodyStr
     */
    public static void setResponseJsonBody(HttpServletResponse resp, String respBodyStr) {
        setResponseBody(resp, respBodyStr, "application/json;charset=UTF-8", "UTF-8");
    }

    /**
     * 设置通讯返回信息
     *
     * @param resp
     * @param respBodyStr
     * @param contentType  媒体类型
     * @param encodingType 字符编码类型
     */
    public static void setResponseBody(HttpServletResponse resp,
                                       String respBodyStr,
                                       String contentType,
                                       String encodingType) {
        resp.setCharacterEncoding(encodingType);
        resp.setContentType(contentType);
        PrintWriter printWriter = null;
        try {
            printWriter = resp.getWriter();
            printWriter.write(respBodyStr);
            printWriter.flush();
        } catch (IOException e) {
            log.error("HttpServletResponse写入异常" + e.getMessage(), e);
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }
}
