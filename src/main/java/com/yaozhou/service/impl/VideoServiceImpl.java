package com.yaozhou.service.impl;

import com.yaozhou.service.VideoService;
import org.springframework.core.io.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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

    // 通用方法
    public ResponseEntity<InputStreamResource> getVideo(String dir, String idOrName) throws FileNotFoundException {
        // 读取视频文件
        File videoFile = new File("src/main/resources/video/" + dir + "/" + idOrName + ".mp4");
        if (!videoFile.exists()) {
            return ResponseEntity.notFound().build();
        }

        // 设置Header头，使浏览器可以识别视频文件类型
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + idOrName);
        headers.add("Accept-Ranges", "bytes");
        //headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename*=UTF-8''" + URLEncoder.
        //        encode(fileName, "UTF-8").replaceAll("\\+", "\\ ") + ".mp4");

        // 将视频文件转换成InputStreamResource
        InputStreamResource inputStreamResource = new InputStreamResource(new FileInputStream(videoFile));

        // 返回ResponseEntity对象，包含InputStreamResource和Header头信息
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(videoFile.length())
                .contentType(MediaType.parseMediaType("video/mp4"))
                .body(inputStreamResource);
    }


}
