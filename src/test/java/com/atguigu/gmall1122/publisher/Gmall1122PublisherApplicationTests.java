package com.atguigu.gmall1122.publisher;

import com.atguigu.gmall1122.publisher.service.EsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Gmall1122PublisherApplicationTests {


    @Autowired
    EsService esService;

    @Test
    public void testDauTotal() {
        Long dauTotal = esService.getDauTotal("2020-05-14");
        System.out.println(dauTotal);
    }

}
