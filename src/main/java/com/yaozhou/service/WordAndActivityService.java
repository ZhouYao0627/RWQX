package com.yaozhou.service;

import com.yaozhou.domain.ResponseResult;

import java.io.IOException;

public interface WordAndActivityService {
    ResponseResult getMoRenWord();

    ResponseResult getGCZActivityList();

    ResponseResult getGCZActivityMsg(String activityId) throws IOException;

    ResponseResult getDSGActivityList();

    ResponseResult getDSGActivityMsg(String activityId) throws IOException;

    ResponseResult getLDActivityList();

    ResponseResult getLDActivityMsg(String activityId) throws IOException;

    ResponseResult getXFTActivityList();

    ResponseResult getXFTActivityMsg(String activityId) throws IOException;
}
