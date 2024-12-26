package com.liyuan.binx.service.biz;

import com.liyuan.binx.func.MyFunctionalInterface;
import org.springframework.stereotype.Service;

@Service
public class FuncServiceBiz {

    public void sout(MyFunctionalInterface myFunctionalInterface, String mes) {
        myFunctionalInterface.myMethod(mes);
    }
}
