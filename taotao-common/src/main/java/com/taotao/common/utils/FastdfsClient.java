package com.taotao.common.utils;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

import java.io.IOException;

/**
 * Created by liuhang on 2017/2/28.
 * Fastdfs工具类
 */
public class FastdfsClient {
    private TrackerClient trackerClient = null;
    private TrackerServer trackerServer = null;
    private StorageServer storageServer = null;
    private StorageClient1 storageClient1 = null;

    public FastdfsClient(String conf) throws IOException, MyException {
        conf = this.getClass().getClassLoader().getResource(conf).getFile();
        ClientGlobal.init(conf);
        trackerClient = new TrackerClient();
        trackerServer = trackerClient.getConnection();
        storageServer = trackerClient.getStoreStorage(trackerServer);
        storageClient1 = new StorageClient1(trackerServer, storageServer);
    }

    // 指定文件名上传
    public String uploadFile(String fileName) throws IOException, MyException {
        return storageClient1.upload_file1(fileName, null, null);
    }

    public String uploadFile(byte[] fileContent) throws IOException, MyException {
        return storageClient1.upload_file1(fileContent, null, null);
    }

}
