package com.liyuan.binx;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 胡超雄
 * @date 2024/05/17 10:21
 * @desc
 */
public class XTokenGenerator {

    private static String ak = "lay83dabziuppuzfy36t";

    private static String sk = "g5st3es2g4x6mvqphxlr6a0vxdgbak3zzwkzr8m5569j4oojtb57sbpua386duhq";

    public static String generateXToken(String ak, String sk, int appId, long expireTime) {
        Map<String, Object> header = new HashMap<>();
        header.put("alg", "HS256");
        header.put("ver", "20240517");
        header.put("typ", "JWT");
//eyJ2ZXIiOiIyMDIzMTExMSIsInR5cCI6IkpXVCIsImFsZyI6IkhTMjU2In0.eyJhayI6ImxheTgzZGFieml1cHB1emZ5MzZ0IiwiYXBwSWQiOjExMTEsImV4cCI6MTcxNTkxNjMxNH0.4usESmPnbM1WDNPfOkeOYzXruCqU-SWXRf0lqzDwA1Q
        // 很久过期的
        //eyJ2ZXIiOiIyMDIzMTExMSIsInR5cCI6IkpXVCIsImFsZyI6IkhTMjU2In0.eyJhayI6ImxheTgzZGFieml1cHB1emZ5MzZ0IiwiYXBwSWQiOjExMTEsImV4cCI6MTcxNjI3MjgyMn0._YIe5huPBhfY43YMgY2IpVaZMN3TKRmzkqCHwAIS2pc
        return JWT.create()
                .withHeader(header)
                .withClaim("ak", ak)
                .withClaim("appId", appId)
                .withClaim("exp", expireTime)
                .sign(Algorithm.HMAC256(sk));
    }

    public static void main(String[] args) {
        int tid = 0;
        //String ak = ak;
        //String sk = sk;
        int appId = 1292321312;
        long expireTime = System.currentTimeMillis() + 3600000;
        String xToken = generateXToken(ak, sk, appId, expireTime);
        System.out.println("Generated x-token: " + xToken);
    }


}


