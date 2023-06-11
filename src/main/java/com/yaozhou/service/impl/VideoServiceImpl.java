package com.yaozhou.service.impl;

import com.yaozhou.service.VideoService;
import org.springframework.core.io.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;

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

    public ResponseEntity<InputStreamResource> getVideoNew(String path) throws FileNotFoundException {
        // 读取视频文件
        File videoFile = new File(path);
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
        return ResponseEntity.ok().headers(headers).contentLength(videoFile.length()).contentType(MediaType.parseMediaType("video/mp4")).body(inputStreamResource);
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
        return ResponseEntity.ok().headers(headers).contentLength(videoFile.length()).contentType(MediaType.parseMediaType("video/mp4")).body(inputStreamResource);
    }


}
