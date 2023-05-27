package com.yaozhou.service.impl;

import com.yaozhou.service.ImageService;
import com.yaozhou.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ResourcePatternResolver resourcePatternResolver;

    @Override
    public List<String> getMoRenImages() throws IOException {
        List<String> images = new ArrayList<>();

        Resource[] resources = resourcePatternResolver.getResources("classpath:/images/MoRen/*");
        for (Resource resource : resources) {
            String imageUrl = "/image/" + resource.getFilename();
            images.add(imageUrl);
        }
        return images;
    }

    @Override
    public List<String> getGCZImages() {
        List<String> base64Images = new ArrayList<>();
        File folder = new File("src/main/resources/images/GCZ/"); // 指定包含多张图片的文件夹路径

        for (File file : folder.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".png")) {
                FileInputStream inputStream = null;
                byte[] bytes;
                try {
                    inputStream = new FileInputStream(file);
                    bytes = new byte[(int) file.length()];
                    inputStream.read(bytes);
                    inputStream.close();

                    // 将每一张图片转换成base64编码
                    String base64Image = Base64.getEncoder().encodeToString(bytes);
                    base64Images.add(base64Image);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return base64Images;
    }

    @Override
    public List<String> getLDImages() {
        return null;
    }

    @Override
    public List<String> getDSGImages() {
        return null;
    }

    @Override
    public List<String> getXFTImages() {
        return null;
    }

}
