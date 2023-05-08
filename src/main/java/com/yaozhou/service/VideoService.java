package com.yaozhou.service;

import com.yaozhou.utils.ResponseResult;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public interface VideoService {
    ResponseEntity<InputStreamResource> getFxVideo(String FxId) throws Exception;

    ResponseEntity<InputStreamResource> getDsVideo(String DsId) throws Exception;

    ResponseEntity<InputStreamResource> getKpVideo(String kpId) throws Exception;

    ResponseEntity<InputStreamResource> getCloudVideo(String CloudName) throws Exception;

    ResponseEntity<InputStreamResource> getVRVideo(String VrId) throws Exception;

    ResponseEntity<InputStreamResource> getDnVideo(String dnId) throws FileNotFoundException;

    ResponseEntity<InputStreamResource> getWkVideo(String wkId) throws FileNotFoundException;

    ResponseEntity<InputStreamResource> getYyVideo(String yyId) throws FileNotFoundException;

    ResponseEntity<InputStreamResource> getGyVideo(String gyId) throws FileNotFoundException;
}
