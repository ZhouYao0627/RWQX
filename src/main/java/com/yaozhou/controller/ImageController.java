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

    /**
     * 观测站(GCZ)的轮播图
     */
    @GetMapping("/GCZ")
    public List<String> getGCZImages() throws IOException {
        return imageService.getGCZImages();
    }

    /**
     * 雷达(LD)的轮播图
     */
    @GetMapping("/LD")
    public List<String> getLDImages() throws IOException {
        return imageService.getLDImages();
    }


    /**
     * 雕塑馆(DSG)的轮播图
     */
    @GetMapping("/DSG")
    public List<String> getDSGImages() throws IOException {
        return imageService.getDSGImages();
    }


    /**
     * 相风台(XFT)的轮播图
     */
    @GetMapping("/XFT")
    public List<String> getXFTImages() throws IOException {
        return imageService.getXFTImages();
    }


}
