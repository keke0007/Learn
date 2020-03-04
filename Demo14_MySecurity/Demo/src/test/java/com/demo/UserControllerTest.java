//package com.demo;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockMultipartFile;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.util.Date;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class UserControllerTest {
//    @Autowired
//    private WebApplicationContext wac;
//    private MockMvc mockMvc;
//
//    @Before
//    public void setup() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//    }
//
//    @Test
//    public void whenQuerySuccess() throws Exception {
//        String result = mockMvc.perform(MockMvcRequestBuilders.get("/user")
//                .param("username", "jojo")
//                .param("age", "18")
//                .param("ageTo", "60")
//                .param("xxx", "yyy")
//                .param("page", "1")
//                .param("size", "11")
//                .param("sort", "username,desc")
//                .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
//                .andReturn().getResponse().getContentAsString();
//        System.out.println(result);
//    }
//
//    @Test
//    public void whenGetInfoSuccess() throws Exception {
//        String result = mockMvc.perform(MockMvcRequestBuilders.get("/user/1")
//                .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("tom"))
//                .andReturn().getResponse().getContentAsString();
//        System.out.println(result);
//    }
//
////    @Test
////    public void whenGetInfoFail() throws Exception {
////        //TODO id有限制只能是数字
////        mockMvc.perform(MockMvcRequestBuilders.get("/user/a")
////                .contentType(MediaType.APPLICATION_JSON_UTF8))
////                .andExpect(MockMvcResultMatchers.status().isOk())
////                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("tom"));
////    }
//
//    @Test
//    public void whenInsertSuccess() throws Exception {
//        Date date = new Date();
//        System.out.println(date.getTime());
//        String content = "{\"username\":\"tom\",\"password\":null,\"birthday\":"+date.getTime()+"}";
//        String result = mockMvc.perform(MockMvcRequestBuilders.post("/user")
//                .content(content)
//                .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
//                .andReturn().getResponse().getContentAsString();
//        System.out.println(result);
//    }
//
//    @Test
//    public void whenUpdateSuccess() throws Exception {
//
//        Date date = new Date(LocalDateTime.now().plusYears(1).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
//        System.out.println(date.getTime());
//        String content = "{\"id\":\"1\", \"username\":\"tom\",\"password\":null,\"birthday\":"+date.getTime()+"}";
//        String reuslt = mockMvc.perform(put("/user/1").contentType(MediaType.APPLICATION_JSON_UTF8)
//                .content(content))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value("1"))
//                .andReturn().getResponse().getContentAsString();
//
//        System.out.println(reuslt);
//    }
//
//    @Test
//    public void whenDeleteSuccess() throws Exception {
//        mockMvc.perform(delete("/user/1")
//                .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void whenUploadSuccess() throws Exception {
//        String result = mockMvc.perform(fileUpload("/file")
//                .file(new MockMultipartFile("file", "test.txt", "multipart/form-data", "hello upload".getBytes("UTF-8"))))
//                .andExpect(status().isOk())
//                .andReturn().getResponse().getContentAsString();
//        System.out.println(result);
//    }
//}
