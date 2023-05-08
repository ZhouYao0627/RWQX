package com.yaozhou.controller;

import com.yaozhou.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
@RequestMapping(value = "/video")
@Slf4j
@Api(tags = "视频相关接口")
public class VideoController {

    @Autowired
    private VideoService fxService;

    // 飞翔在Nuist
    @GetMapping("/FxVideo")
    @ApiOperation(value = "飞翔在Nuist")
    @ApiImplicitParams(@ApiImplicitParam(name = "FxId", value = "视频id，共有3个视频，视频id分别为1，2，3"))
    public ResponseEntity<InputStreamResource> getFxVideo(@RequestParam("FxId") String FxId) throws Exception {
        return fxService.getFxVideo(FxId);
    }

    // 大师云集
    @GetMapping("/DsVideo")
    @ApiOperation(value = "大师云集")
    @ApiImplicitParams(@ApiImplicitParam(name = "DsId", value = "视频id，共有3个视频，视频id分别为1，2，3"))
    public ResponseEntity<InputStreamResource> getDsVideo(@RequestParam("DsId") String DsId) throws Exception {
        return fxService.getDsVideo(DsId);
    }

    // 科普基地
    @GetMapping("/KpVideo")
    @ApiOperation(value = "科普基地")
    @ApiImplicitParams(@ApiImplicitParam(name = "KpId", value = "视频id，共有4个视频，视频id分别为0，1，2，3，其中视频id为0代表科普基地总体介绍视频"))
    public ResponseEntity<InputStreamResource> getKpVideo(@RequestParam("KpId") String KpId) throws Exception {
        return fxService.getKpVideo(KpId);
    }

    // 看云识天
    @GetMapping("/CloudVideo")
    @ApiOperation(value = "看云识天")
    @ApiImplicitParams(@ApiImplicitParam(name = "CloudName", value = "视频id，共有8个视频，视频id分别为1，2，...，8"))
    public ResponseEntity<InputStreamResource> getCoudVideo(@RequestParam("CloudName") String CloudName) throws Exception {
        return fxService.getCloudVideo(CloudName);
    }

    // VR气象站
    @GetMapping("/VR")
    @ApiOperation(value = "VR气象站")
    @ApiImplicitParams(@ApiImplicitParam(name = "VrId", value = "视频id，共有1个视频，视频id为0，1，2，...，15，其中视频id为0代表气象站介绍视频"))
    public ResponseEntity<InputStreamResource> getVRVideo(@RequestParam("VrId") String VrId) throws Exception {
        return fxService.getVRVideo(VrId);
    }

}














