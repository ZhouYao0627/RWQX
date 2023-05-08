package com.yaozhou;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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


}
