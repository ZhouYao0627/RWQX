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
        // 读取视频文件
        File videoFile = new File("src/main/resources/video/fx/" + FxId + ".mp4");
        if (!videoFile.exists()) {
            return ResponseEntity.notFound().build();
        }

        // 设置Header头，使浏览器可以识别视频文件类型
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + FxId);
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

    @Override
    public ResponseEntity<InputStreamResource> getDsVideo(String DsId) throws Exception {
        // 读取视频文件
        File videoFile = new File("src/main/resources/video/ds/" + DsId + ".mp4");
        if (!videoFile.exists()) {
            return ResponseEntity.notFound().build();
        }

        // 设置Header头，使浏览器可以识别视频文件类型
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + DsId);
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

    @Override
    public ResponseEntity<InputStreamResource> getKpVideo(String kpId) throws Exception {
        // 读取视频文件
        File videoFile = new File("src/main/resources/video/kp/" + kpId + ".mp4");
        if (!videoFile.exists()) {
            return ResponseEntity.notFound().build();
        }

        // 设置Header头，使浏览器可以识别视频文件类型
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + kpId);
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

    @Override
    public ResponseEntity<InputStreamResource> getCloudVideo(String CloudName) throws Exception {
        // 读取视频文件
        File videoFile = new File("src/main/resources/video/cloud/" + CloudName + ".mp4");
        if (!videoFile.exists()) {
            return ResponseEntity.notFound().build();
        }

        // 设置Header头，使浏览器可以识别视频文件类型
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + CloudName);
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
