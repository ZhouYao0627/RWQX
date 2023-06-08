package com.yaozhou.service.impl;

import com.alibaba.fastjson.JSON;
import com.yaozhou.service.RwqxService;
import com.yaozhou.domain.ResponseResult;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

@Service
public class RwqxServiceImpl implements RwqxService {
    @Override
    public ResponseResult getRwqx(String cityName) {
        Object json = null;
        if (cityName != null) {
            String rw, qx, dl, ls;
            int i = 0;
            String[] parts1 = new String[4];
            HashMap<String, String> map = null;
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader("src/main/resources/人文/" + cityName + ".txt"));
                String line = reader.readLine();
                while (line != null) {
                    String[] parts = line.split("&");
                    for (String part : parts) {
                        parts1[i++] = part;
                    }
                    line = reader.readLine();
                }
                qx = parts1[0];
                ls = parts1[3];
                dl = parts1[2];
                rw = parts1[1];

                map = new HashMap<>();
                map.put("qx", qx);
                map.put("ls", ls);
                map.put("dl", dl);
                map.put("rw", rw);

                json = JSON.toJSON(map);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return ResponseResult.okResult(json);
        } else {
            return ResponseResult.errorResult(400, "该城市名有误");
        }


    }
}
