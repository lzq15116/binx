package com.liyuan.binx;

import cn.hutool.core.util.StrUtil;
import com.liyuan.binx.service.biz.FuncServiceBiz;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FuncTest extends BinxApplicationTests{

    @Autowired
    private FuncServiceBiz funcServiceBiz;

    @Test
    void name() {

        funcServiceBiz.sout((s) -> System.out.println(s),"ewqeqwewqeqweqweqw");
    }

    @Test
    void s() {
        Optional<String> s = Optional.of("s");
        System.out.println(s);

    }

    @Test
    void sda() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 300; i++) {
            sb.append(i);
        }
        System.out.println(sb.toString());
    }
}
