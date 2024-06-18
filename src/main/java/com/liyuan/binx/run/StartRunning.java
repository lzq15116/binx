package com.liyuan.binx.run;

import com.liyuan.binx.service.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class StartRunning implements CommandLineRunner {

    @Autowired
    private List<Processor> processors;

//    private ApplicationContext applicationContext;



    @Override
    public void run(String... args) throws Exception {
        for (Processor processor : processors) {
            processor.processor();
        }
//        Map<String, Processor> beansOfType = applicationContext.getBeansOfType(Processor.class);
//        beansOfType.forEach((key, value) -> {
//            System.out.println("key:" + key + " value:" + value);
//            value.processor();
//        });
//        processors.processor();

//        processors.processor();

    }

//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext = applicationContext;
//    }
}
