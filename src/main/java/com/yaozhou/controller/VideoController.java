package com.yaozhou.controller;

import com.yaozhou.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
@RequestMapping(value = "/video")
@Slf4j
@Api(tags = "视频相关接口")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/FyVideo")
    public ResponseEntity<InputStreamResource> getFyVideo(@RequestParam("FyName") String FyName) throws Exception {
        return videoService.getFyVideo(FyName);
    }

    // 飞翔在Nuist
    @GetMapping("/FxVideo")
    @ApiOperation(value = "飞翔在Nuist")
    @ApiImplicitParams(@ApiImplicitParam(name = "FxId", value = "视频id，共有3个视频，视频id分别为1，2，3"))
    public ResponseEntity<InputStreamResource> getFxVideo(@RequestParam("FxId") String FxId) throws Exception {
        return videoService.getFxVideo(FxId);
    }

    // 大师云集
    @GetMapping("/DsVideo")
    @ApiOperation(value = "大师云集")
    @ApiImplicitParams(@ApiImplicitParam(name = "DsId", value = "视频id，共有4个视频，视频id分别为1，2，3，4"))
    public ResponseEntity<InputStreamResource> getDsVideo(@RequestParam("DsId") String DsId) throws Exception {
        return videoService.getDsVideo(DsId);
    }

    // 科普基地
    @GetMapping("/KpVideo")
    @ApiOperation(value = "科普基地")
    @ApiImplicitParams(@ApiImplicitParam(name = "KpId", value = "视频id，共有5个视频，视频id分别为0，1，2，3，4，其中视频id为0代表科普基地总体介绍视频"))
    public ResponseEntity<InputStreamResource> getKpVideo(@RequestParam("KpId") String KpId) throws Exception {
        return videoService.getKpVideo(KpId);
    }

    // 看云识天
    @GetMapping("/CloudVideo")
    @ApiOperation(value = "看云识天")
    @ApiImplicitParams(@ApiImplicitParam(name = "CloudName", value = "视频名称，共有8个视频，视频名称分别为云的名字"))
    public ResponseEntity<InputStreamResource> getCoudVideo(@RequestParam("CloudName") String CloudName) throws Exception {
        return videoService.getCloudVideo(CloudName);
    }

    // VR气象站
    @GetMapping("/VrVideo")
    @ApiOperation(value = "VR气象站")
    @ApiImplicitParams(@ApiImplicitParam(name = "VrId", value = "视频id，共有16个视频，视频id为0，1，2，...，15，其中视频id为0代表气象站总体介绍视频，1-3代表温度传感器，以此类推"))
    public ResponseEntity<InputStreamResource> getVRVideo(@RequestParam("VrId") String VrId) throws Exception {
        return videoService.getVRVideo(VrId);
    }

    // 大牛说课
    @GetMapping("/DnVideo")
    @ApiOperation(value = "大牛说课")
    @ApiImplicitParams(@ApiImplicitParam(name = "DnId", value = "视频id，共有5个视频，视频id为1，2，3，...，5"))
    public ResponseEntity<InputStreamResource> getDnVideo(@RequestParam("DnId") String DnId) throws Exception {
        return videoService.getDnVideo(DnId);
    }

    // 气象微课
    @GetMapping("/WkVideo")
    @ApiOperation(value = "气象微课")
    @ApiImplicitParams(@ApiImplicitParam(name = "WkId", value = "视频id，共有5个视频，视频id为1，2，3，...，5"))
    public ResponseEntity<InputStreamResource> getWkVideo(@RequestParam("WkId") String WkId) throws Exception {
        return videoService.getWkVideo(WkId);
    }

    // 云游世界

    @GetMapping("/YyVideo")
    @ApiOperation(value = "云游世界")
    @ApiImplicitParams(@ApiImplicitParam(name = "YyId", value = "视频id，共有5个视频，视频id为1-5"))
    public ResponseEntity<InputStreamResource> getYyVideo(@RequestParam("YyId") String YyId) throws Exception {
        return videoService.getYyVideo(YyId);
    }

    // 公益气象+
    @GetMapping("/GyVideo")
    @ApiOperation(value = "公益气象+")
    @ApiImplicitParams(@ApiImplicitParam(name = "GyId", value = "视频id，共有5个视频，视频id为1，2，3，...，5"))
    public ResponseEntity<InputStreamResource> getGyVideo(@RequestParam("GyId") String GyId) throws Exception {
        return videoService.getGyVideo(GyId);
    }

    @GetMapping("/getVideoByNet")
    public void getVideoByNet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        videoService.getVideoByNet(request, response);
    }

}














