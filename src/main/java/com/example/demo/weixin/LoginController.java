package com.example.demo.weixin;

import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.logging.Logger;

@Controller
@RequestMapping("/o2o")
public class LoginController {
    Log log = LogFactory.getLog(this.getClass());
    /**
     * 微信授权登录
     */
    @RequestMapping("/wxLogin")
    public void doGet(HttpServletResponse response) throws Exception {
        String backUrl = URLEncoder.encode("http://39.105.95.181/o2o/callBack?name=zyx", "UTF-8");
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + AuthUtil.APPID + "&redirect_uri="
                + backUrl + "&response_type=code" + "&scope=snsapi_userinfo"
                + "&state=STATE#wechat_redirect";
        response.sendRedirect(url);
    }

    /**
     * 微信授权登录
     */
    @RequestMapping("/wxLoginbase")
    public void wxLoginbase(HttpServletResponse response) throws Exception {
        String backUrl = URLEncoder.encode("http://39.105.95.181/o2o/callBack?oper=111", "UTF-8");
        String url = "https://open.weixin.qq.c" +
                "" +
                "" +
                "om/connect/oauth2/authorize?appid=" + AuthUtil.APPID + "&redirect_uri="
                + backUrl + "&response_type=code" + "&scope=snsapi_base"
                + "&state=STATE#wechat_redirect";
        response.sendRedirect(url);
    }

    /**
     * 登录成功的回调函数
     *
     */
    @RequestMapping("/callBack")
    @ResponseBody
    public void callBack(HttpServletRequest request) throws Exception {
        log.info("enter    callBack"+JSONObject.fromObject(request.getParameterMap()));

        String code = request.getParameter("code");
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + AuthUtil.APPID + "&secret="
                + AuthUtil.APPSECRET + "&code=" + code + "&grant_type=authorization_code";
        JSONObject jsonObject = AuthUtil.doGetJson(url);
        log.info("access_token   "+jsonObject);
        String openid = jsonObject.optString("openid");
        String token = jsonObject.optString("access_token");
        String infoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=" + token + "&openid=" + openid
                + "&lang=zh_CN";
        JSONObject userInfo = AuthUtil.doGetJson(infoUrl);
        log.info("userInfo   "+userInfo);

        //此处需返回openId，授权成功后页面根据不同的
    }

    /**
     * 微信验证
     */
    @RequestMapping(value = "/echo")
    @ResponseBody
    public String echo(
            @RequestParam(required = false) String echostr,
            @RequestParam(required = false) String signature,
            @RequestParam(required = false) String timestamp,
            @RequestParam(required =false) String nonce
    ){
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(echostr+"="+signature+"="+timestamp+"="+nonce);

        throw new RuntimeException("1111");
//        return echostr;
    }

    @Description("远程图片读取保存")
    @RequestMapping("/fileFormNet")
    @ResponseBody
    public void fileFormNet(){
        try {

            try {
                byte[] streamBytesOfUrlFileByUrl = FileUtil.getStreamBytesOfUrlFileByUrl("http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTI1bkicrqwLoyDW4WTJ3CvBW8FaUeJsVqYMxwosCO9aAicY1B4f0v7oxffN6qWRBhlNP6vE2ztuTkdA/132");

                File localFile = new File("/Users/zhangyuxiao/Desktop/touxiang");
                if (!localFile.exists()) {
                    localFile.mkdirs();
                }
                localFile = new File("/Users/zhangyuxiao/Desktop/touxiang/111.png");
                FileUtils.writeByteArrayToFile(localFile, streamBytesOfUrlFileByUrl);

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Description("绑定开放平台账号")
    @RequestMapping("/bind")
    @ResponseBody
    public void bind(){

        try {
//            String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+AuthUtil.APPID+"&secret="+ AuthUtil.APPSECRET;
//
//            JSONObject jsonObject = AuthUtil.doGetJson(url);
//            log.info("token=" + jsonObject);
//            String access_token = jsonObject.optString("access_token");
            String access_token = "34_lVZTBKrWAAJHq77FbB3Pl0EFhsZ0yDAisvLCFgyOgVQJBeKNKlmzO9-32rmUCIANw82TcQaH7VGwSXCGqpcZqUUstKY-hbnSWepxk7jvzQIYFHz557Mj-AF7yHu6w7-UFry_Y8WoOIuHddgCBQNbAIAETQ";
            String bindUrl =  "https://api.weixin.qq.com/cgi-bin/open/create?access_token="+access_token;
            JSONObject jsonObject = AuthUtil.post(bindUrl,"{'appid':'"+AuthUtil.APPID+"'}");

            log.info("bindUrl=" + jsonObject);
            String open_appid = jsonObject.optString("open_appid");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
