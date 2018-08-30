package com.yjytke.api;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;


/**
 * 
 * @ClassName: QcloudDemo
 * @Description: 测试云储存
 * @author chengrui
 * @date 2017年7月25日 下午2:59:17
 */
public class TenCentCloudService {

	private static final String bucketName = "keblog-1252041665";
	private static final String secretId = "AKID3eBaHu2cfXDmbMdVpxtqd0FKE2jGHqtP";
	private static final String secretKey = "e7PVSEoDRq5B7sQmyzoTxFNL7h5IJ8mb";
	private static final String url = "https://keblog-1252041665.cos.ap-beijing.myqcloud.com";
    /**
     * 
     * @Title: getCOSClient
     * @Description: 生成客户端对象
     * @return
     */
    public static COSClient getCOSClient() {
        
     // 1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region("ap-beijing"));
        // 3 生成cos客户端
        COSClient cosclient = new COSClient(cred, clientConfig);
        return cosclient;
    }

    /**
     * 
     * @param fileName 
     * @param file 
     * @throws IOException 
     * @Title: uploadFile
     * @Description:上传文件
     */
    public static String uploadFile(MultipartFile file, String fileName) throws IOException {
        // 设置要操作的bucket
    	ObjectMetadata objectMetadata = new ObjectMetadata();
    	// 设置输入流长度为 500
    	objectMetadata.setContentLength(500);  
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileName, file.getInputStream(), objectMetadata);
        PutObjectResult putObjectResult = getCOSClient().putObject(putObjectRequest);
        return url+fileName;
    }

}