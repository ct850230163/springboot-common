package cn.vpclub.demo.common.model.utils.web;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by WeiPin on 2016/3/19.
 */
@Slf4j
public class FTPUtils {
    protected FTPUtils() {

    }

    private static FTPClient ftp;

    /**
     * 获取ftp连接
     *
     * @param f
     * @return
     * @throws Exception
     */
    public static boolean connectFtp(Ftp f) {
        try {
            ftp = new FTPClient();
            boolean flag = false;
            int reply;
            if (f.getPort() == null) {
                ftp.connect(f.getIpAddr(), 21);
            } else {
                ftp.connect(f.getIpAddr(), f.getPort());
            }
            ftp.login(f.getUserName(), f.getPwd());
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return flag;
            }
            ftp.changeWorkingDirectory(f.getPath());
            flag = true;
            return flag;
        } catch (Exception e) {
            throw Exceptions.unchecked(e);
        }
    }

    /**
     * 关闭ftp连接
     */
    public static void closeFtp() {
        if (ftp != null && ftp.isConnected()) {
            try {
                ftp.logout();
                ftp.disconnect();
            } catch (IOException e) {
                throw Exceptions.unchecked(e);
            }
        }
    }

    /**
     * ftp上传文件
     *
     * @param
     * @throws Exception
     */
    public static void upload(Ftp f, byte[] byteData, String fileName) {
        try {
            InputStream input = byte2Input(byteData);
            if (null != f.getPath() && !"".equals(f.getPath())) {
                ftp.makeDirectory(f.getPath());
                ftp.changeWorkingDirectory(f.getPath());
            } else {
                ftp.changeToParentDirectory();

            }
            ftp.storeFile(fileName, input);
            input.close();
        } catch (Exception e) {
            throw Exceptions.unchecked(e);
        }
    }

    public static InputStream byte2Input(byte[] buf) {
        return new ByteArrayInputStream(buf);
    }

    public static byte[] input2byte(InputStream inStream)
            throws IOException {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc;
        while ((rc = inStream.read(buff, 0, 100)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        byte[] in2b = swapStream.toByteArray();
        return in2b;
    }

    /**
     * 下载链接配置
     *
     * @param f
     * @param remoteBaseDir 远程目录
     * @throws Exception
     */
    public static byte[] startDown(Ftp f, String remoteBaseDir) {
        try {
            if (FTPUtils.connectFtp(f)) {
                InputStream inputStream = ftp.retrieveFileStream(remoteBaseDir);
                return input2byte(inputStream);
            } else {
                log.error("链接失败！");
            }
            return new byte[0];
        } catch (Exception e) {
            throw Exceptions.unchecked(e);
        }
    }


}
