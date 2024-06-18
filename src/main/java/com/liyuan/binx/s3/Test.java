package com.liyuan.binx.s3;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 胡超雄
 * @date 2024/06/04 19:23
 * @desc
 */
public class Test {
    public static void main(String[] args) {
        String bucketName = "m1-gamedata";
        String keyName = "dtpkpjb3262.apk";
        String filePath = "/Users/bbummb/Downloads/dtpkpjb3262.apk";
        String region = "ap-southeast-1"; // 替换为你的区域

        // 使用提供的 AWS 凭证
        String awsAccessKeyId = "ASIASXTLYB32373YMOOS";
        String awsSecretAccessKey = "Zp9lkKggOBi5l3kYojWvzFMP8aMxNlpCrHK96k3i";
        String awsSessionToken = "FwoGZXIvYXdzEEIaDN6UeOB0Tqo+6cFtZyKBAYYc7vZn4aUFxcVCZ6El7InDFEEli1r9R6JQgxNAG5yBlmVtdn+GhR7go0FM3XlCIKp5dXoFFlk3bxe/hUWsS6wPw4KK58GoB2aL+v8zQBa/n/v+8aVNzt2Q2AtQw2aMFCCWebtuqiC5+OCbpzKR+MLO7Y6kbMuPPTqRHw75hZKAISjQ0ICzBjIo8v/Dz/aznGEcuEV/aiSdIy9A2lw+dHG16GDaG7VO0MxzkNypHkZbdw==";

        BasicSessionCredentials sessionCredentials = new BasicSessionCredentials(
                awsAccessKeyId, awsSecretAccessKey, awsSessionToken);

        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(sessionCredentials))
                .withRegion(region)
                .build();

        // 初始化分片上传
        InitiateMultipartUploadRequest initRequest = new InitiateMultipartUploadRequest(bucketName, keyName);
        InitiateMultipartUploadResult initResponse = s3Client.initiateMultipartUpload(initRequest);
        String uploadId = initResponse.getUploadId();
        System.out.println("UploadId: " + uploadId);

        // 上传分片
        File file = new File(filePath);
        long contentLength = file.length();
        long partSize = 50 * 1024 * 1024; // 每个分片5MB

        List<PartETag> partETags = new ArrayList<>();
        try {
            InputStream inputStream = new FileInputStream(file);
            byte[] buffer = new byte[(int) partSize];
            int bytesRead;
            int partNumber = 1;

            while ((bytesRead = inputStream.read(buffer)) > 0) {
                UploadPartRequest uploadRequest = new UploadPartRequest()
                        .withBucketName(bucketName)
                        .withKey(keyName)
                        .withUploadId(uploadId)
                        .withPartNumber(partNumber++)
                        .withInputStream(new ByteArrayInputStream(buffer, 0, bytesRead))
                        .withPartSize(bytesRead);

                UploadPartResult uploadResult = s3Client.uploadPart(uploadRequest);
                partETags.add(uploadResult.getPartETag());
                System.out.println("Uploaded part " + (partNumber - 1));
            }

            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            // 如果上传过程中出现异常，可以选择中止上传
            s3Client.abortMultipartUpload(new AbortMultipartUploadRequest(bucketName, keyName, uploadId));
            return;
        }

        // 完成分片上传
        CompleteMultipartUploadRequest compRequest = new CompleteMultipartUploadRequest(bucketName, keyName, uploadId, partETags);
        CompleteMultipartUploadResult compResult = s3Client.completeMultipartUpload(compRequest);
        System.out.println("Complete Multipart Upload Result: " + compResult.getLocation());
    }
}
