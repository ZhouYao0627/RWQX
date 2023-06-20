package com.yaozhou.service.impl;

import com.yaozhou.enums.AppHttpCodeEnum;
import com.yaozhou.exception.SystemException;
import com.yaozhou.service.VideoService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

@Service
public class VideoServiceImpl implements VideoService {
    @Override
    public ResponseEntity<InputStreamResource> getFxVideo(String FxId) throws Exception {
        String dir = "fx";
        return getVideo(dir, FxId);
    }

    @Override
    public ResponseEntity<InputStreamResource> getDsVideo(String DsId) throws Exception {
        String dir = "ds";
        return getVideo(dir, DsId);
    }

    @Override
    public ResponseEntity<InputStreamResource> getKpVideo(String kpId) throws Exception {
        String dir = "kp";
        return getVideo(dir, kpId);
    }

    @Override
    public ResponseEntity<InputStreamResource> getCloudVideo(String CloudName) throws Exception {
        String dir = "cloud";
        return getVideo(dir, CloudName);
    }

    @Override
    public ResponseEntity<InputStreamResource> getVRVideo(String VrId) throws FileNotFoundException {
        String dir = "vr";
        return getVideo(dir, VrId);
    }

    @Override
    public ResponseEntity<InputStreamResource> getDnVideo(String dnId) throws FileNotFoundException {
        String dir = "dn";
        return getVideo(dir, dnId);
    }

    @Override
    public ResponseEntity<InputStreamResource> getWkVideo(String wkId) throws FileNotFoundException {
        String dir = "wk";
        return getVideo(dir, wkId);
    }

    @Override
    public ResponseEntity<InputStreamResource> getYyVideo(String yyId) throws FileNotFoundException {
        String dir = "yy";
        return getVideo(dir, yyId);
    }

    @Override
    public ResponseEntity<InputStreamResource> getGyVideo(String gyId) throws FileNotFoundException {
        String dir = "gy";
        return getVideo(dir, gyId);
    }

    @Override
    public ResponseEntity<InputStreamResource> getFyVideo(String fyName) throws Exception {
        //if (fyName.equals("r2")) {
        //    return getVideoNew("D:\\software\\IDEA\\Project\\RWQX\\src\\main\\resources\\video\\fy\\r2.mp4");
        //} else if (fyName.equals("sp")) {
        //    return getVideoNew("D:\\software\\IDEA\\Project\\RWQX\\src\\main\\resources\\video\\fy\\sp.mp4");
        //} else if (fyName.equals("t2m")) {
        //    return getVideoNew("D:\\software\\IDEA\\Project\\RWQX\\src\\main\\resources\\video\\fy\\t2m.mp4");
        //} else if (fyName.equals("tp")) {
        //    return getVideoNew("D:\\software\\IDEA\\Project\\RWQX\\src\\main\\resources\\video\\fy\\tp.mp4");
        //}
        String dir = "fy";
        return getVideo(dir, fyName);
    }

    @Override
    public void getVideoByNet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //String url = "https://www.bilibili.com/video/BV16s411E7UE/?share_source=copy_web&vd_source=ad10dc54f8ec866ebe04c4e521a0c143";
        //https://v.youku.com/v_show/id_XNDI0MTA0MDE2OA==.html?s=63efbfbd202befbfbd47&spm=a2hje.13141534.1_3.d_1_1&scm=20140719.apircmd.239064.video_XNDI0MTA0MDE2OA==
        //https://v.youku.com/v_show/id_XNDI0MTAzODQwNA==.html?s=63efbfbd202befbfbd47&spm=a2hje.13141534.1_3.d_1_2&scm=20140719.apircmd.239064.video_XNDI0MTAzODQwNA==
        //...
        //https://v.youku.com/v_show/id_XNDI4NjQ1NDc4MA==.html?s=63efbfbd202befbfbd47&spm=a2hje.13141534.1_3.d_1_8&scm=20140719.apircmd.239064.video_XNDI4NjQ1NDc4MA==
        //String urlId = "id_XNDI0MTA0MDE2OA";
        //String urlNum = "1";
        //getVideoNew(request, response, urlId, urlNum);

        //https://v.youku.com/v_show/id_XNTIwMzQxNzkxNg==.html?spm=a2hja.14919748_WEBFUN_JINGXUAN.drawer6.d_zj1_2&playMode=pugv&scm=20140719.manual.5653.video_XNTIwMzQxNzkxNg==

        String videoUrl = "https://v.youku.com/v_show/id_XNTIwMzQxNzkxNg==.html"; // 视频播放地址

        // 调用优酷API获取视频信息
        // 根据视频URL和API密钥构建请求
        // 发送HTTP请求并解析返回的JSON数据，获取视频信息和播放地址

        // 下载视频文件
        try {
            URL url = new URL(videoUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();

            FileOutputStream fileOutputStream = new FileOutputStream("videoTest.mp4"); // 视频保存路径
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }

            fileOutputStream.close();
            inputStream.close();

            System.out.println("视频下载完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getVideoNew(HttpServletRequest request, HttpServletResponse response, String urlId, String urlNum) throws Exception {
        String path = "https://v.youku.com/v_show/id_" + urlId + "==.html?s=63efbfbd202befbfbd47&spm=a2hje.13141534.1_3.d_1_" + urlNum;
        //创建连接对象
        URL url = new URL(path);
        URLConnection conn = url.openConnection();
        //设置超时
        conn.setConnectTimeout(1000);
        conn.setReadTimeout(5000);
        //发起连接
        conn.connect();
        //获取流
        InputStream inputStream = conn.getInputStream();

        //流转换
        IOUtils.copy(inputStream, response.getOutputStream());
        //设置返回类型
        response.addHeader("Content-Type", "video/mp4;charset=utf-8");

        response.flushBuffer();
    }

    // 通用方法
    public ResponseEntity<InputStreamResource> getVideo(String dir, String idOrName) throws FileNotFoundException {
        // 读取视频文件
        File videoFile = new File("src/main/resources/video/" + dir + "/" + idOrName + ".mp4");
        //File videoFile = new File("D:\\software\\IDEA\\Project\\RWQX\\src\\main\\resources\\video\\dn\\1.mp4");
        if (!videoFile.exists()) {
            return ResponseEntity.notFound().build();
        }

        // 设置Header头，使浏览器可以识别视频文件类型
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=");
        headers.add("Accept-Ranges", "bytes");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "video.mp4");

        // 将视频文件转换成InputStreamResource
        InputStreamResource inputStreamResource = new InputStreamResource(new FileInputStream(videoFile));

        // 返回ResponseEntity对象，包含InputStreamResource和Header头信息
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(videoFile.length())
                .contentType(MediaType.parseMediaType("video/mp4"))
                .body(inputStreamResource);
    }


}
