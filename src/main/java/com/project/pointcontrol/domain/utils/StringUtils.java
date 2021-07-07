package com.project.pointcontrol.domain.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StringUtils {

    public static String uuid() {
        return UUID.randomUUID().toString();
    }
}
