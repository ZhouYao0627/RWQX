package com.yaozhou;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootTest
public class rwqxTest {
    @Test
    public void testR() {
        String rw = null, qx = null, dl = null, ls = null;
        int i = 0;
        int j = 0;
        String[] parts1 = new String[4];
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/main/resources/anyang.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split("&");
                for (String part : parts) {
                    //System.out.println(part);
                    parts1[i++] = part;
                    //System.out.println(parts[j++]);
                }
                line = reader.readLine();
            }
            qx = parts1[0];
            ls = parts1[3];
            dl = parts1[2];
            rw = parts1[1];
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(parts1);
        //System.out.println("qx:" + qx);
        //System.out.println("ls:" + ls);
        //System.out.println("dl:" + dl);
        //System.out.println("rw:" + rw);

    }

    @Test
    public void testPassword() {
        // 用户密码
        //String password = "admin@cspd123";
        String password = "test001";
        // 创建密码加密的对象
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // 密码加密
        String newPassword = passwordEncoder.encode(password);
        System.out.println("加密后的密码为：" + newPassword);

        // 校验这两个密码是否是同一个密码
        // matches方法第一个参数是原密码，第二个参数是加密后的密码
        boolean matches = passwordEncoder.matches(password, newPassword);
        System.out.println("两个密码一致:" + matches);
    }

    private static final String API_URL = "https://api.bilibili.com/";

    @Test
    public void testBilibiliVideoDownloader() {
        //https://www.bilibili.com/video/BV16s411E7UE/?share_source=copy_web&vd_source=ad10dc54f8ec866ebe04c4e521a0c143

        String videoId = "BV16s411E7UE"; // 替换为要下载的视频ID

        try {
            // 构建API请求URL
            String apiUrl = String.format(API_URL, videoId);

            // 发送API请求，获取视频信息
            String videoInfoJson = sendGetRequest(apiUrl);

            // 解析视频信息，提取视频URL
            String videoUrl = extractVideoUrl(videoInfoJson);

            // 下载视频文件
            downloadVideo(videoUrl, "video.mp4"); // 下载的视频文件名为video.mp4

            System.out.println("视频下载成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String sendGetRequest(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // 添加其他必要的请求头或身份验证信息

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            return response.toString();
        } else {
            throw new IOException("API请求失败，响应代码：" + responseCode);
        }
    }

    private static String extractVideoUrl(String videoInfoJson) {
        // 解析视频信息JSON，提取视频URL
        // 这里需要根据Bilibili API返回的数据结构进行解析，提取视频URL
        // 例如，如果视频URL嵌在JSON的"url"字段中，可以使用JSON解析库（例如Jackson或Gson）来提取
        return "https://example.com/video.mp4"; // 替换为实际的视频URL
    }

    private static void downloadVideo(String videoUrl, String fileName) throws IOException {
        URL url = new URL(videoUrl);
        File destination = new File(fileName);
        FileUtils.copyURLToFile(url, destination);
    }

}
