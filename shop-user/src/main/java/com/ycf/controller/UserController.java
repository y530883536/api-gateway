package com.ycf.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.ycf.model.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    private int i = 0;

    @GetMapping("/sleepTest")
    public String sleepTest() throws Exception{
        Thread.sleep(2000);
        return "sleepTest";
    }

    @GetMapping("/getById/{id}")
    @SentinelResource("userById")
    public User getById(@PathVariable Integer id) throws Exception{
        User user = new User();
        user.setId(1);
        user.setName("ycf");
        //Thread.sleep(500);
        //这个是测试异常比率的降级使用
        /*i++;
        if(i % 3 == 0) {
            throw new RuntimeException();
        }
        System.out.println("=======" + i + "========");*/
        return user;
    }

    @PostMapping("/uploadFiles")
    public String uploadFiles(@PathVariable("files") MultipartFile[] files) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String now = dateFormat.format(new Date());
        String folderPath = "D:\\" + now + "\\";
        File folder = new File(folderPath);
        //会返回trueOrFalse，如果文件夹已经存在就不会创建新的文件夹且返回false
        folder.mkdirs();
        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            System.out.println(fileName);
            FileOutputStream fos = new FileOutputStream(folderPath + fileName);
            fos.write(file.getBytes());
            fos.close();
            System.out.println("-------文件上传成功！-------------");
        }
        return "uploadFiles";
    }

}
