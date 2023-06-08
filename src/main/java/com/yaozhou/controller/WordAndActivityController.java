package com.yaozhou.controller;

import com.yaozhou.service.WordAndActivityService;
import com.yaozhou.domain.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/WordAndActivity")
public class WordAndActivityController {
    @Autowired
    private WordAndActivityService wordAndActivityService;

    // 科普基地总体介绍文字
    @GetMapping("/MoRenWord")
    public ResponseResult getWord() {
        return wordAndActivityService.getMoRenWord();
    }

    /**
     * 观测站(GCZ)
     */
    // 活动列表
    @GetMapping("/GCZList")
    public ResponseResult getGCZActivityList() {
        return wordAndActivityService.getGCZActivityList();
    }

    // 活动列表内图片等详细信息
    @GetMapping("/GCZMsg")
    public ResponseResult getGCZActivityMsg(@RequestParam String activityId) throws IOException {
        return wordAndActivityService.getGCZActivityMsg(activityId);
    }

    /**
     * 雕塑馆(DSG)
     */
    // 活动列表
    @GetMapping("/DSGList")
    public ResponseResult getDSGActivityList() {
        return wordAndActivityService.getDSGActivityList();
    }

    // 活动列表内图片等详细信息
    @GetMapping("/DSGMsg")
    public ResponseResult getDSGActivityMsg(@RequestParam String activityId) throws IOException {
        return wordAndActivityService.getDSGActivityMsg(activityId);
    }

    /**
     * 雷达(LD)
     */
    // 活动列表
    @GetMapping("/LDList")
    public ResponseResult getLDActivityList() {
        return wordAndActivityService.getLDActivityList();
    }

    // 活动列表内图片等详细信息
    @GetMapping("/LDMsg")
    public ResponseResult getLDActivityMsg(@RequestParam String activityId) throws IOException {
        return wordAndActivityService.getLDActivityMsg(activityId);
    }

    /**
     * 相风台(XFT)
     */
    // 活动列表
    @GetMapping("/XFTList")
    public ResponseResult getXFTActivityList() {
        return wordAndActivityService.getXFTActivityList();
    }

    // 活动列表内图片等详细信息
    @GetMapping("/XFTMsg")
    public ResponseResult getXFTActivityMsg(@RequestParam String activityId) throws IOException {
        return wordAndActivityService.getXFTActivityMsg(activityId);
    }



}
