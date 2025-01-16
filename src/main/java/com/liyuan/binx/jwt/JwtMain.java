package com.liyuan.binx.jwt;

import cn.hutool.json.JSONUtil;
import io.jsonwebtoken.Claims;

public class JwtMain {
    public static void main(String[] args) {
        String token = JwtUtil.generateToken("lzqqwert");
        System.out.println(token);

        Claims claims = JwtUtil.parseToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsenFxd2VydCIsImlhdCI6MTczNjgzNDUyMywiZXhwIjoxNzM2ODM0NTIzfQ.i_farF1s-ETrpxow8_YI5Y4FzzbKt956UkajdF3XvIk");
        System.out.println(claims.getSubject());
    }


}
