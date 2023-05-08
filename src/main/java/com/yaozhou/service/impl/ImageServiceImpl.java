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


    //@Override
    //public ResponseResult getWord() {
    //    String line = null;
    //    BufferedReader reader;
    //    try {
    //        reader = new BufferedReader(new FileReader("src/main/resources/kp/MoRen/word/word.txt"));
    //        line = reader.readLine();
    //        reader.close();
    //    } catch (IOException e) {
    //        e.printStackTrace();
    //    }
    //    return ResponseResult.okResult(line);
    //}
    //
    //@Override
    //public ResponseEntity<InputStreamResource> getVideo() throws FileNotFoundException {
    //    // 读取视频文件
    //    File videoFile = new File("src/main/resources/kp/MoRen/video/video.mp4");
    //    if (!videoFile.exists()) {
    //        return ResponseEntity.notFound().build();
    //    }
    //
    //    // 设置Header头，使浏览器可以识别视频文件类型
    //    HttpHeaders headers = new HttpHeaders();
    //    headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
    //    headers.add("Pragma", "no-cache");
    //    headers.add("Expires", "0");
    //    headers.add("Accept-Ranges", "bytes");
    //    headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "video");
    //
    //
    //    // 将视频文件转换成InputStreamResource
    //    InputStreamResource inputStreamResource = new InputStreamResource(new FileInputStream(videoFile));
    //
    //    // 返回ResponseEntity对象，包含InputStreamResource和Header头信息
    //    return ResponseEntity.ok()
    //            .headers(headers)
    //            .contentLength(videoFile.length())
    //            .contentType(MediaType.parseMediaType("video/mp4"))
    //            .body(inputStreamResource);
    //}
}
