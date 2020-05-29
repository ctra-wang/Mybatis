package com.ctra.utils;

import org.junit.Test;

import java.util.UUID;

// 生词升级id（uuid）
@SuppressWarnings("all")
public class IDutils {
    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void test(){
        System.out.println(IDutils.getId());
    }
}
