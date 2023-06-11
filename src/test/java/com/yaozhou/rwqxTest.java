package com.yaozhou;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

}
