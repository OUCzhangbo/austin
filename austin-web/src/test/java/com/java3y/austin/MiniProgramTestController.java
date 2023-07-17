package com.java3y.austin;

import com.java3y.austin.web.annotation.AustinAspect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class MiniProgramTestController extends BaseTestController {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    private static final String BASE_URL = "/miniProgram";

    /**
     * 根据账号Id获取模板列表
     *
     * @throws Exception
     */
    @Test
    public void queryList() throws Exception {
        //doRequest
        resultActions = mvc.perform(
                MockMvcRequestBuilders
                        .get(BASE_URL + "/template/list")
                        .headers(headers)
                        .param("id", "1")
        );
    }
    @Test
    public void testRedis() {
        stringRedisTemplate.opsForValue().set("test", "bobo");
        System.out.println(stringRedisTemplate.opsForValue().get("test"));
    }

}
