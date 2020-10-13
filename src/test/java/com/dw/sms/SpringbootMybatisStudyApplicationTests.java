package com.dw.sms;

import com.dw.sms.controller.UserController;
import com.dw.sms.entity.Color;
import com.dw.sms.entity.EnumTest;
import com.dw.sms.entity.JsonTest;
import com.dw.sms.entity.User;
import com.dw.sms.service.*;
import org.apache.coyote.http2.Http2OutputBuffer;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockReset;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.Mockito.when;

//让Junit测试单元运行在Spring的测试环境中，得到Spring的上下文支持
@RunWith(SpringRunner.class)
/*
是用来创建Spring的上下文ApplicationContext，保证测试在上下文环境里运行。单独使用@SpringBootTest不会启动servlet容器。
所以只是用SpringBootTest 注解，不可以使用@Resource和@Autowired等进行依赖注入（准确的说是可以使用，但被注解的bean为null

如果未指定classes 参数或者指定的classes参数不是启动main函数入口SpringBootTest(classes = SpringTestAutoConfig.class) ，则会
自动从当前测试类包一层一层向上检索，直到找到@SpringBootApplication或@SpringBootConfiguration注释类为止。以此来启动Spring Boot应用，
并装载Spring上下文。

如果未检索到Spring Boot启动主配置类，则会抛出异常：java.lang.IllegalStateException: Unable to find a @SpringBootConfiguration, you need to use
@ContextConfiguration or @SpringBootTest(classes=…) with your tes

如果制定的classes为普通config配置类，则会以此配置初始化Spring 上下文，而不会加载其他Bean到Spring 容器。可以在Junit测试单元中使用这些类
 */
@SpringBootTest(classes = {SpringbootMybatisStudyApplication.class})
//使用TestRestTemplate对象进行Controller测试
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

//@WebMvcTest
/*
 1.@WebMvcTest 与 @SpringBootTest 注解不能一起使用，会报错
 2.使用@WebMvcTest注解进行测试时，只会加载在@WebMvcTest()中配置的bean，而@SpringBootTest注解会加载所有被Spring容器管理的bean
 3. 如果使用MockMvc对象时，又希望会加载所有被Spring容器管理的bean，可以使用@AutoConfigureMockMvc注解
 */
class SpringbootMybatisStudyApplicationTests {


    @Autowired
    private UserService userService;

//    @Autowired
//    TestRestTemplate testRestTemplate;

    @Autowired
    private AccountService accountService;

    @Autowired
    private RoleService roleService;
    @Autowired
    private EnumTestService enumTestService;
    @Autowired
    private JsonTestService jsonTestService;


//    @Autowired
//    MockMvc mockMvc;

//    @Test
//    public void getUser() throws Exception {
//        System.out.println(userService.findById(1l));
//        User user = testRestTemplate.getForObject("/users/1", User.class);
//        Assert.assertEquals("'test'", user);
//        System.out.println(user);
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/users/1").param("userId", "1")).andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());
//    }

    @Test
    public void accountFindAll(){
        System.out.println(accountService.findAll());
        System.out.println();
        System.out.println(userService.findAllDetail());
        System.out.println(userService.findAllDetails());
        System.out.println(roleService.findAll());
    }

    @Test
    public void EnumTest(){
        EnumTest enumTest = new EnumTest();
        enumTest.setColor(Color.blue);
        enumTest.setBrand("林肯");
        System.out.println(enumTestService.add(enumTest));;
    }

    @Test
    public void EnumTestFindAll(){
        System.out.println(enumTestService. findAll());
    }

    @Test
    public void JsonTestAdd(){
        JsonTest jsonTest = new JsonTest();
        Map<String,String> contentMap = new HashMap<>();
        contentMap.put("1","{\"author\": \"captain&d\", \"blog\": \"https://www.cnblogs.com/captainad\"}");
        jsonTest.setContent(contentMap);
        System.out.println(jsonTestService.add(jsonTest));
    }

    @Test
    public void JsonTestFindAll(){
        System.out.println(jsonTestService.findAll());
    }
}
