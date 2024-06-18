//package com.liyuan.binx.s3;
//
//import com.alibaba.fastjson.JSONObject;
//import software.amazon.awssdk.services.s3.S3AsyncClient;
//import software.amazon.awssdk.services.s3.model.CreateMultipartUploadRequest;
//import software.amazon.awssdk.services.s3.model.CreateMultipartUploadResponse;
//
//import java.util.concurrent.CompletableFuture;
//
//public class UploadTest {
//
//    public static void main(String[] args) {
//
//        S3AsyncClient client = S3AsyncClient.builder().build();
////        client.createMultipartUpload()
////        CreateMultipartUploadRequest
////                .builder()
////                .bucket("m1-gamedata")
//
////                .
//
//        String getTokenData = "{'appId': 30165, 'appType': 'AndroidGame', 'platformType': 'android', 'installDir': 'apName1112', 'configDir': 'apName1112', 'pkgVersion': 1, 'steamID': '', 'bucketName': 'm1-gamedata', 'regionName': 'ap-southeast-1', 'awsAccessKeyId': 'ASIASXTLYB32TBVFQGWH', 'awsSecretAccessKey': 'WpNyQobowb0Y6pySUpuEPloWNWIDAy9aol21O88b', 'awsSessionToken': 'FwoGZXIvYXdzECwaDG5SD3k6C8ycBuobnCKBAYXiRzYd7/EdNWC+7sUADQ9mw8UCpMXxOpssm4q7AIgTH1HPJ3pEky6LbyMfwxO6Y8Wh3k8DaPtr01gXG145X2GtSfcs7qOzC1pLkcPQ2nFVbLdSIHH0vHyU+aYHitIJ003FRzkaOqp35CyPyWIwvfUCy3WTW6Ygn2WIvbMZxm/VfCj+4vuyBjIo0Ui7MC8dzxPHEz+ndNDJqnJb7ZRV9p/2UPbvtDrAcOvXmZz/xqJf1g==', 'uploadUrl': '/AndroidGame/30165/1/'}";
//
//        JSONObject getTokenDataObject = JSONObject.parseObject(getTokenData);
//        CreateMultipartUploadRequest
//                 .builder()
//                 .bucket(getTokenDataObject.get("bucketName").toString())
//                .
//
//        CompletableFuture<CreateMultipartUploadResponse> multipartUpload = client.createMultipartUpload(new CreateMultipartUploadRequest());
//
//
//
//    }
//}
