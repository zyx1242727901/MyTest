package com.example.demo.weixin;

import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Iterator;

public class FileUtil {

    /**
     * 获取网络上的图片
     *
     * @param fileUrl 地址
     * @throws Exception
     */
    public static byte[] getStreamBytesOfUrlFileByUrl(String fileUrl) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        int HttpResult = 0; //服务器返回的状态
        URL url = new URL(fileUrl); //创建URL
        URLConnection urlconn = url.openConnection(); // 试图连接并取得返回状态码urlconn.connect();
        HttpURLConnection httpconn = (HttpURLConnection) urlconn;
        HttpResult = httpconn.getResponseCode();
        byte[] osbytes = null;
        if (HttpResult != HttpURLConnection.HTTP_OK){  //不等于HTTP_OK说明连接不成功
//            logger.error("file url: " + fileUrl + "连接失败！status:" + HttpResult);
        } else {
            int filesize = urlconn.getContentLength();  //取数据长度
//            logger.info("文件大小:" + filesize);
            BufferedInputStream bis = new BufferedInputStream(urlconn.getInputStream());
            BufferedOutputStream bos = new BufferedOutputStream(os);
            byte[] buffer = new byte[1024]; //创建存放输入流的缓冲
            int num = -1; //读入的字节数
            while (true) {
                num = bis.read(buffer); // 读入到缓冲区
                if (num ==-1){
                    bos.flush();
                    break; //已经读完
                }
                bos.flush();
                bos.write(buffer,0,num);
            }
            osbytes = os.toByteArray();
            bos.close();
            bis.close();
            os.close();
        }
        return osbytes;
    }

}
