package com.yaozhou.service;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
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

    ResponseEntity<InputStreamResource> getFyVideo(String fyName)throws Exception;

    void getVideoByNet(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
