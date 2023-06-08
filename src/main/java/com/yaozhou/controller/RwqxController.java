package com.yaozhou.controller;

import com.yaozhou.service.RwqxService;
import com.yaozhou.domain.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rwqx")
public class RwqxController {
    //@GetMapping
    //public ResponseResult getRwqx(@RequestParam("cityName") String cityName) {
    //    if ("anyang".equals(cityName)) {
    //        String rw = null, qx = null, dl = null, ls = null;
    //        int i = 0;
    //        String[] parts1 = new String[4];
    //        HashMap<String, String> map = null;
    //        BufferedReader reader;
    //        try {
    //            reader = new BufferedReader(new FileReader("src/main/resources/anyang.txt"));
    //            String line = reader.readLine();
    //            while (line != null) {
    //                String[] parts = line.split("&");
    //                for (String part : parts) {
    //                    parts1[i++] = part;
    //                }
    //                line = reader.readLine();
    //            }
    //            qx = parts1[0];
    //            ls = parts1[3];
    //            dl = parts1[2];
    //            rw = parts1[1];
    //
    //            map = new HashMap<>();
    //            map.put("qx", qx);
    //            map.put("ls", ls);
    //            map.put("dl", dl);
    //            map.put("rw", rw);
    //            reader.close();
    //        } catch (IOException e) {
    //            e.printStackTrace();
    //        }
    //        return ResponseResult.okResult(map);
    //    } else {
    //        return ResponseResult.errorResult(400, "获取失败");
    //    }
    //}

    @Autowired
    private RwqxService rwqxService;

    @GetMapping
    public ResponseResult getRwqx(@RequestParam("cityName") String cityName) {
        return rwqxService.getRwqx(cityName);
    }


}

