package com.yaozhou.controller;

import com.yaozhou.service.ImageService;
import com.yaozhou.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/images")
public class ImageController {
    @Autowired
    private ImageService imageService;

    /**
     * 科普基地默认情况的轮播图
     */
    @GetMapping("/MoRen")
    public List<String> getImages() throws IOException {
        return imageService.getMoRenImages();
    }

    // 科普基地总体介绍文字
    //@GetMapping("/MoRen/word")
    //public ResponseResult getWord() {
    //    return kpjdService.getWord();
    //}

    // 科普基地默认宣传视频
    //@GetMapping("/MoRen/video")
    //public ResponseEntity<InputStreamResource> getVideo() throws Exception {
    //    return kpjdService.getVideo();
    //}

    /**
     * 观测站(GCZ)的轮播图
     */
    @GetMapping("/GCZ")
    public List<String> getGCZImages() throws IOException {
        return imageService.getGCZImages();
    }
    //
    //// 观测站活动
    //@GetMapping("/GCZ/activity")
    //public ResponseResult getGCZActivity() {
    //    return kpjdService.getGCZActivity();
    //}
    //
    //// 观测站宣传视频
    //@GetMapping("/GCZ/video")
    //public ResponseEntity<InputStreamResource> getGCZVideo() throws Exception {
    //    return kpjdService.getGCZVideo();
    //}

    /**
     * 雷达(LD)的轮播图
     */
    @GetMapping("/LD")
    public List<String> getLDImages() throws IOException {
        return imageService.getLDImages();
    }
    //
    //// 雷达活动
    //@GetMapping("/LD/activity")
    //public ResponseResult getGCZActivity() {
    //    return kpjdService.getLDActivity();
    //}
    //
    //// 雷达宣传视频
    //@GetMapping("/LD/video")
    //public ResponseEntity<InputStreamResource> getGCZVideo() throws Exception {
    //    return kpjdService.getLDVideo();
    //}
    //

    /**
     * 雕塑馆(DSG)的轮播图
     */
    @GetMapping("/DSG")
    public List<String> getDSGImages() throws IOException {
        return imageService.getDSGImages();
    }
    //
    //// 雕塑馆活动
    //@GetMapping("/DSG/activity")
    //public ResponseResult getGCZActivity() {
    //    return kpjdService.getGCZActivity();
    //}
    //
    //// 雕塑馆宣传视频
    //@GetMapping("/DSG/video")
    //public ResponseEntity<InputStreamResource> getDSGVideo() throws Exception {
    //    return kpjdService.getDSGVideo();
    //}
    //

    /**
     * 相风台(XFT)的轮播图
     */
    @GetMapping("/XFT")
    public List<String> getXFTImages() throws IOException {
        return imageService.getXFTImages();
    }
    //
    //// 相风台活动
    //@GetMapping("/XFT/activity")
    //public ResponseResult getXFTActivity() {
    //    return kpjdService.getXFTActivity();
    //}
    //
    //// 相风台宣传视频
    //@GetMapping("/XFT/video")
    //public ResponseEntity<InputStreamResource> getXFTVideo() throws Exception {
    //    return kpjdService.getXFTVideo();
    //}


    // 获取单个图片的接口
    //@GetMapping("/image/{filename:.+}")
    //public ResponseEntity<Resource> getImage(@PathVariable String filename) {
    //    Resource resource = new ClassPathResource("images/" + filename);
    //
    //    try {
    //        return ResponseEntity.ok()
    //                .contentType(MediaType.IMAGE_JPEG)
    //                .body(new InputStreamResource(resource.getInputStream()));
    //    } catch (IOException e) {
    //        return ResponseEntity.notFound().build();
    //    }
    //}

}
