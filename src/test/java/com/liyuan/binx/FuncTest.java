package com.liyuan.binx;

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
}
