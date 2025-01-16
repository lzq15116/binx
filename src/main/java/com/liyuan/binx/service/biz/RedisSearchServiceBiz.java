package com.liyuan.binx.service.biz;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.UnifiedJedis;
import redis.clients.jedis.JedisPooled;
import redis.clients.jedis.search.IndexDefinition;
import redis.clients.jedis.search.Schema;
import redis.clients.jedis.search.IndexOptions;


@Service
@RequiredArgsConstructor
public class RedisSearchServiceBiz {

    private final UnifiedJedis jedis;


    public void createIndex() {

        // 定义 Schema
        Schema schema = new Schema()
                .addTextField("title", 1.0)         // 文本字段
                .addTextField("description", 1.0)   // 文本字段
                .addNumericField("price");          // 数值字段

        // 定义索引规则
        IndexDefinition definition = new IndexDefinition(IndexDefinition.Type.HASH)
                .setPrefixes("product:");

        // 创建索引
        jedis.ftCreate("product_index", IndexOptions.defaultOptions().setDefinition(definition), schema);

        System.out.println("Index created successfully!");

    }

}
