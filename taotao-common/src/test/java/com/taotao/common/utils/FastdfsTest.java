package com.taotao.common.utils;

import org.csource.common.MyException;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by liuhang on 2017/2/28.
 */
public class FastdfsTest {
    @Test
    public void testFastfsClient() throws IOException, MyException {
        FastdfsClient client = new FastdfsClient("properties/fastdfs.conf");
        String uploadFile=client.uploadFile("/Users/liuhang/Pictures/weichatPay.png");
        System.out.println(uploadFile);
    }
}
