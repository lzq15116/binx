package com.liyuan.binx;

import com.liyuan.binx.service.biz.RedisSearchServiceBiz;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.UnifiedJedis;
import redis.clients.jedis.search.Document;
import redis.clients.jedis.search.Query;
import redis.clients.jedis.search.SearchResult;

import java.util.HashMap;
import java.util.List;


public class RedisSearch extends BinxApplicationTests {

    @Autowired
    private RedisSearchServiceBiz redisSearchServiceBiz;
    @Autowired
    private UnifiedJedis jedis;

    @Test
    void create() {
        redisSearchServiceBiz.createIndex();
    }

    @Test
    void List() {
        List<String> list = jedis.ftList();
        list.forEach(System.out::println);
    }

    @Test
    void add() {
        String productId = "product:1";
        HashMap<String, String> map = new HashMap<>();
        map.put("title", "RedisSearch Guide");
        map.put("description", "Learn how to use RedisSearch with UnifiedJedis");
        map.put("price", "199");

        // 使用 HSet 添加哈希数据
        jedis.hset(productId, map);

        System.out.println("Product added successfully!");
    }

    @Test
    void search() {
        Query query = new Query("RedisSearch")
                .returnFields("title", "description", "price")
                .limit(0, 10);

        SearchResult result = jedis.ftSearch("product_index", query);

        // 输出查询结果
        System.out.println("Total Results: " + result.getTotalResults());
        for (Document doc : result.getDocuments()) {
            System.out.println("Document ID: " + doc.getId());
            System.out.println("Title: " + doc.getString("title"));
            System.out.println("Description: " + doc.getString("description"));
            System.out.println("Price: " + doc.getString("price"));
            System.out.println("-----------------------");
        }

    }
}
