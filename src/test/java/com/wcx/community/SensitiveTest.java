package com.wcx.community;

import com.wcx.community.util.SensitiveFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenxin
 * @create 2022-03-13 15:38
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class SensitiveTest {

    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Test
    public void testSensitiveFilter() {
        String text = "这里可以吸⭐⭐⭐毒，可以⭐⭐⭐嫖⭐⭐娼，可以吸⭐⭐毒⭐⭐，可以开票⭐⭐⭐，哈⭐⭐⭐哈哈";
        String filter = sensitiveFilter.filter(text);
        System.out.println(filter);

    }

}
