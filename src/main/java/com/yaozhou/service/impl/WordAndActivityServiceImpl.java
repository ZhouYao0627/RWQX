package com.yaozhou.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.yaozhou.service.WordAndActivityService;
import com.yaozhou.domain.ResponseResult;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

@Service
public class WordAndActivityServiceImpl implements WordAndActivityService {
    @Override
    public ResponseResult getMoRenWord() {
        String line = null;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/main/resources/word/moren.txt"));
            line = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseResult.okResult(line);
    }

    /**
     * 观测站
     */
    @Override
    public ResponseResult getGCZActivityList() {
        Object json = null;
        String activity1, activity2, activity3, activity4;
        int i = 0;
        String[] parts1 = new String[4];
        HashMap<String, String> map;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/main/resources/activity/GCZ/GczActivityList.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split("&");
                for (String part : parts) {
                    parts1[i++] = part;
                }
                line = reader.readLine();
            }

            activity1 = parts1[0];
            activity2 = parts1[3];
            activity3 = parts1[2];
            activity4 = parts1[1];

            map = new HashMap<>();
            map.put("activity1", activity1);
            map.put("activity2", activity2);
            map.put("activity3", activity3);
            map.put("activity4", activity4);

            json = JSON.toJSON(map);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseResult.okResult(json);
    }

    // 返回文本数据
    String getTextData(String activityName, String activityId) {
        //String line = null;
        //BufferedReader reader;
        //try {
        //    reader = new BufferedReader(new FileReader("src/main/resources/activity/word/" + activityId + ".txt"));
        //    line = reader.readLine();
        //    reader.close();
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
        //return line;
        String filePath = "src/main/resources/activity/" + activityName + "/word/" + activityId + ".txt";
        String textData = "";
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                textData += line;
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            // 处理IOException异常
        }
        return textData;
    }

    // 返回图片文件路径列表
    List<String> getImagePathList(String activityName, String activityId) {
        // 返回一个包含图片路径的列表
        List<String> imagePaths = new ArrayList<>();
        imagePaths.add("src/main/resources/activity/" + activityName + "/image/" + activityId + "/1.jpg");
        imagePaths.add("src/main/resources/activity/" + activityName + "/image/" + activityId + "/2.jpg");
        imagePaths.add("src/main/resources/activity/" + activityName + "/image/" + activityId + "/3.jpg");
        return imagePaths;
    }

    // 读取图片数据到缓存
    public List<BufferedImage> getImageDataList(String activityName, String activityId) throws IOException {
        List<String> imagePaths = getImagePathList(activityName, activityId);
        List<BufferedImage> images = new ArrayList<>();
        for (String imagePath : imagePaths) {
            BufferedImage image = ImageIO.read(new File(imagePath));
            images.add(image);
        }
        return images;
    }

    @Override
    public ResponseResult getGCZActivityMsg(String activityId) throws IOException {
        //String activityName = "GCZ";
        //// 读取文本数据
        //String textData = getTextData(activityName, activityId);
        //// 读取图片文件列表
        //List<BufferedImage> images = getImageDataList(activityName, activityId);
        //// 将图片转换为Base64编码
        //List<String> imageDataList = new ArrayList<>();
        //for (BufferedImage image : images) {
        //    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //    ImageIO.write(image, "jpg", outputStream);
        //    String imageData = Base64.getEncoder().encodeToString(outputStream.toByteArray());
        //    imageDataList.add(imageData);
        //}
        //
        //HashMap<String, Object> map = new HashMap<>();
        //map.put("word", textData);
        //JSONArray imageDataArray = new JSONArray(imageDataList);
        //map.put("image", imageDataArray);
        //Object json = JSON.toJSON(map);
        //// 返回JSON字符串
        //return ResponseResult.okResult(json);
        return null;
    }

    /**
     * 雕塑馆
     */
    @Override
    public ResponseResult getDSGActivityList() {
        Object json = null;
        String activity1, activity2, activity3, activity4;
        int i = 0;
        String[] parts1 = new String[4];
        HashMap<String, String> map;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/main/resources/activity/DSG/DsgActivityList.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split("&");
                for (String part : parts) {
                    parts1[i++] = part;
                }
                line = reader.readLine();
            }

            activity1 = parts1[0];
            activity2 = parts1[3];
            activity3 = parts1[2];
            activity4 = parts1[1];

            map = new HashMap<>();
            map.put("activity1", activity1);
            map.put("activity2", activity2);
            map.put("activity3", activity3);
            map.put("activity4", activity4);

            json = JSON.toJSON(map);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseResult.okResult(json);
    }

    @Override
    public ResponseResult getDSGActivityMsg(String activityId) throws IOException {
        //String activityName = "DSG";
        //// 读取文本数据
        //String textData = getTextData(activityName, activityId);
        //// 读取图片文件列表
        //List<BufferedImage> images = getImageDataList(activityName, activityId);
        //// 将图片转换为Base64编码
        //List<String> imageDataList = new ArrayList<>();
        //for (BufferedImage image : images) {
        //    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //    ImageIO.write(image, "jpg", outputStream);
        //    String imageData = Base64.getEncoder().encodeToString(outputStream.toByteArray());
        //    imageDataList.add(imageData);
        //}
        //
        //HashMap<String, Object> map = new HashMap<>();
        //map.put("word", textData);
        //JSONArray imageDataArray = new JSONArray(imageDataList);
        //map.put("image", imageDataArray);
        //Object json = JSON.toJSON(map);
        //// 返回JSON字符串
        //return ResponseResult.okResult(json);
        return null;
    }

    /**
     * 雷达
     */
    @Override
    public ResponseResult getLDActivityList() {
        Object json = null;
        String activity1, activity2, activity3, activity4;
        int i = 0;
        String[] parts1 = new String[4];
        HashMap<String, String> map;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/main/resources/activity/LD/LdActivityList.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split("&");
                for (String part : parts) {
                    parts1[i++] = part;
                }
                line = reader.readLine();
            }

            activity1 = parts1[0];
            activity2 = parts1[3];
            activity3 = parts1[2];
            activity4 = parts1[1];

            map = new HashMap<>();
            map.put("activity1", activity1);
            map.put("activity2", activity2);
            map.put("activity3", activity3);
            map.put("activity4", activity4);

            json = JSON.toJSON(map);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseResult.okResult(json);
    }

    @Override
    public ResponseResult getLDActivityMsg(String activityId) throws IOException {
        //String activityName = "LD";
        //// 读取文本数据
        //String textData = getTextData(activityName, activityId);
        //// 读取图片文件列表
        //List<BufferedImage> images = getImageDataList(activityName, activityId);
        //// 将图片转换为Base64编码
        //List<String> imageDataList = new ArrayList<>();
        //for (BufferedImage image : images) {
        //    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //    ImageIO.write(image, "jpg", outputStream);
        //    String imageData = Base64.getEncoder().encodeToString(outputStream.toByteArray());
        //    imageDataList.add(imageData);
        //}
        //
        //HashMap<String, Object> map = new HashMap<>();
        //map.put("word", textData);
        //JSONArray imageDataArray = new JSONArray(imageDataList);
        //map.put("image", imageDataArray);
        //Object json = JSON.toJSON(map);
        //// 返回JSON字符串
        //return ResponseResult.okResult(json);
        return null;
    }

    /**
     * 相风台
     */
    @Override
    public ResponseResult getXFTActivityList() {
        Object json = null;
        String activity1, activity2, activity3, activity4;
        int i = 0;
        String[] parts1 = new String[4];
        HashMap<String, String> map;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/main/resources/activity/XFT/XftActivityList.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split("&");
                for (String part : parts) {
                    parts1[i++] = part;
                }
                line = reader.readLine();
            }

            activity1 = parts1[0];
            activity2 = parts1[3];
            activity3 = parts1[2];
            activity4 = parts1[1];

            map = new HashMap<>();
            map.put("activity1", activity1);
            map.put("activity2", activity2);
            map.put("activity3", activity3);
            map.put("activity4", activity4);

            json = JSON.toJSON(map);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseResult.okResult(json);
    }

    @Override
    public ResponseResult getXFTActivityMsg(String activityId) throws IOException {
        //String activityName = "XFT";
        //// 读取文本数据
        //String textData = getTextData(activityName, activityId);
        //// 读取图片文件列表
        //List<BufferedImage> images = getImageDataList(activityName, activityId);
        //// 将图片转换为Base64编码
        //List<String> imageDataList = new ArrayList<>();
        //for (BufferedImage image : images) {
        //    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //    ImageIO.write(image, "jpg", outputStream);
        //    String imageData = Base64.getEncoder().encodeToString(outputStream.toByteArray());
        //    imageDataList.add(imageData);
        //}
        //
        //HashMap<String, Object> map = new HashMap<>();
        //map.put("word", textData);
        //JSONArray imageDataArray = new JSONArray(imageDataList);
        //map.put("image", imageDataArray);
        //Object json = JSON.toJSON(map);
        //// 返回JSON字符串
        //return ResponseResult.okResult(json);
        return null;
    }
}