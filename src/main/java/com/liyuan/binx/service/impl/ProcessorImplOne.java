package com.liyuan.binx.service.impl;

import com.liyuan.binx.service.Processor;
import org.springframework.stereotype.Component;

@Component
public class ProcessorImplOne implements Processor {
    @Override
    public void processor() {
        System.out.println(1);
    }
}
