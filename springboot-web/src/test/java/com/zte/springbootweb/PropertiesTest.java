package com.zte.springbootweb;

import com.zte.springbootweb.comm.EricProperties;
import com.zte.springbootweb.comm.OtherProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTest {
    @Resource
    private EricProperties properties;
    
    @Resource
    private OtherProperties otherProperties;

    @Value("${eric.title}")
    private String title ;

    @Test
    public void testSingle() {
//        System.out.println(title);
        //此处注意项目和配置文件的字符集，选择UTF-8
        Assert.assertEquals(title, "飞奔的小野猪");
    }

    @Test
    public void testMore() throws Exception {
        System.out.println("title:" + properties.getTitle());
        System.out.println("description:" + properties.getDescription());
    }

    @Test
    public void testOther() throws Exception {
        System.out.println("title:" + otherProperties.getTitle());
        System.out.println("blog:" + otherProperties.getBlog());
    }
}
