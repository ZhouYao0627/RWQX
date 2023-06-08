package com.yaozhou.service;

import java.io.IOException;
import java.util.List;

public interface ImageService {
    List<String> getMoRenImages() throws IOException;

    List<String> getGCZImages();

    List<String> getLDImages();

    List<String> getDSGImages();

    List<String> getXFTImages();


}
