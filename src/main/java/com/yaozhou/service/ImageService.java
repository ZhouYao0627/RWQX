package com.yaozhou.service;

import com.yaozhou.utils.ResponseResult;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ImageService {
    List<String> getMoRenImages() throws IOException;

    List<String> getGCZImages();

    List<String> getLDImages();

    List<String> getDSGImages();

    List<String> getXFTImages();


}
