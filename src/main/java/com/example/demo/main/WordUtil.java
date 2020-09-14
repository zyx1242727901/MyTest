package com.example.demo.main;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.ByteArrayInputStream;

import java.io.FileOutputStream;

import java.io.IOException;


public class WordUtil {

    public static void htmlToWord (String htmlContent, String charsetName, String filePath) throws IOException, InterruptedException {
        POIFSFileSystem poifs = null;
        FileOutputStream ostream = null;
        ByteArrayInputStream bais = null;

        try {
            htmlContent = "<html><body>" + htmlContent + "</body></html>";
            byte[] b = htmlContent.getBytes(charsetName);
            bais = new ByteArrayInputStream(b);
            poifs = new POIFSFileSystem();
            DirectoryEntry directory = poifs.getRoot();
            //WordDocument名称不允许修改
//            directory.createDocument("WordDocument", bais);
            poifs.createDocument(bais,"WordDocument");
            ostream = new FileOutputStream(filePath);
            poifs.writeFilesystem(ostream);
//            Thread.sleep(5000);
        } catch (Exception e) {
            throw e;
        } finally {
            IOUtils.closeQuietly(poifs);
            IOUtils.closeQuietly(ostream);
            IOUtils.closeQuietly(bais);
        }

    }

    public static void main(String[] args) throws Exception {

        String html = returnHtml2();
        String a = "\\";
        html = html.replace("\\n", "");
        System.out.println(html);
        html = html.replace(a, "");
        System.out.println(html);
        htmlToWord(html, "GBK", "测试GBK"+ System.currentTimeMillis() +".doc");
        htmlToWord(html, "UTF-8", "测试UTF"+ System.currentTimeMillis() +".doc");
        System.out.println("end");
    }

    public static String returnHtml(){
        String html = "<p>1111111111sdf是打发斯蒂芬水电费第三方对方的说法第三方第三方的是非得失发的所发生的发的发的顺丰神鼎飞丹砂发送到发打发斯蒂芬第三方的说法第三方到沙发地方的" +
                "<img src=\\\"https://srt-read-dev.3ren.cn/basebusiness/material/20200902/1599029973525X4NK4aJDjD002.jpg?x-oss-process=image/resize,w_780\\\" />" +
                "</p>\\n" +
                "<p>是法撒旦借款方数据开发看十多份沙发上反倒是说法第三方水电费阿斯顿发生反倒是发达都是</p>\\n" +
                "<p>&nbsp;</p>\\n" +
                "<ol>\\n" +
                "<li>是打发斯蒂芬第三方到沙发地方</li>\\n" +
                "<li>是打发的温柔访问防</li>\\n" +
                "<li>发送到文认为啊</li>\\n" +
                "<li>二维若群二群热无群若</li>\\n" +
                "<li>韦尔奇无</li>\\n" +
                "</ol>\\n" +
                "<p>&nbsp;</p>\\n" +
                "<p>" +
                "<span style=\\\"color: #ff9900;\\\">二维若翁翁二维若群翁热无若</span>" +
                "</p>\\n<p>&nbsp;</p>\\n" +
                "<p style=\\\"text-align: center;\\\">" +
                "<span style=\\\"color: #ff9900; font-size: 18px;\\\">" +
                "<span style=\\\"text-decoration: underline;\\\"><em><strong>无人区二无群二额外热无若而我却人</strong></em></span>" +
                "<span style=\\\"text-decoration: underline;\\\"><em><strong>无人区二无群二额外热无若而我却人</strong></em></span>" +
                "<span style=\\\"text-decoration: underline;\\\"><em><strong>无人区二无群二额外热无若而我却人</strong></em></span>" +
                "<span style=\\\"text-decoration: underline;\\\"><em><strong>无人区二无群二额外热无若而我却人</strong></em></span>" +
                "</span>" +
                "</p>" +
                "<p>" +
                "<span style=\\\"color: #ff9900;\\\">二维若翁翁二维若群翁热无若</span>" +
                "</p>\\n<p>&nbsp;</p>\\n" +
                "<p style=\\\"text-align: center;\\\">" +
                "<span style=\\\"color: #ff9900; font-size: 18px;\\\">" +
                "<span style=\\\"text-decoration: underline;\\\"><em><strong>无人区二无群二额外热无若而我却人</strong></em></span>" +
                "<span style=\\\"text-decoration: underline;\\\"><em><strong>无人区二无群二额外热无若而我却人</strong></em></span>" +
                "<span style=\\\"text-decoration: underline;\\\"><em><strong>无人区二无群二额外热无若而我却人</strong></em></span>" +
                "<span style=\\\"text-decoration: underline;\\\"><em><strong>无人区二无群二额外热无若而我却人</strong></em></span>" +
                "</span>" +
                "</p>" +
                "<p>" +
                "<span style=\\\"color: #ff9900;\\\">二维若翁翁二维若群翁热无若</span>" +
                "</p>\\n<p>&nbsp;</p>\\n" +
                "<p style=\\\"text-align: center;\\\">" +
                "<span style=\\\"color: #ff9900; font-size: 18px;\\\">" +
                "<span style=\\\"text-decoration: underline;\\\"><em><strong>无人区二无群二额外热无若而我却人</strong></em></span>" +
                "<span style=\\\"text-decoration: underline;\\\"><em><strong>无人区二无群二额外热无若而我却人</strong></em></span>" +
                "<span style=\\\"text-decoration: underline;\\\"><em><strong>无人区二无群二额外热无若而我却人</strong></em></span>" +
                "<span style=\\\"text-decoration: underline;\\\"><em><strong>无人区二无群二额外热无若而我却人</strong></em></span>" +
                "</span>" +
                "</p>" +
                ""
                ;
        return html;
    }

    public static String returnHtml2(){
        String html = "<p>在批改作文时，我发现学生此次习作最大的问题是：一旦涉及到人物的语言、动作、神态等就一笔划过。" +
                "而语言是心灵的&ldquo;门户&rdquo;，语言描写是直接表现人物精神风貌、把人物写&ldquo;活&rdquo;的重要手段。" +
                "语言描写具体了，人物的神态、动作才描画得出来。因此，本节课的方法引路我就落在了&ldquo;" +
                "指导学生把人物的对话写具体&rdquo;上。</p>\\n"

                ;
        return html;
    }

}
