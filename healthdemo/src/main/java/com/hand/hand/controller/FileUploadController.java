package com.hand.hand.controller;

import com.hand.hand.util.FileUtil;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;



import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


/**
 * /将图片上传到本地/
 *
 * Created by nishuai on 2017/12/26.
 */
@CrossOrigin
@Controller
public class FileUploadController {

    private ResourceLoader resourceLoader;

    //跳转到上传文件的页面
    @RequestMapping(value="/gouploadimg", method = RequestMethod.GET)
    public String goUploadImg() {
        //跳转到 templates 目录下的 uploadimg.html
        return "uploadimg";
    }

    //处理文件上传
    @RequestMapping(value="/uploadimg", method = RequestMethod.POST)
    public @ResponseBody String uploadImg(@RequestParam("file") MultipartFile file,
                                          HttpServletRequest request) {
        System.out.println("调用文件上传方法");
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();

        System.out.println("fileName-->" + fileName);
        System.out.println("getContentType-->" + contentType);

        //文件存放路径
        //String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
        //String filePath = "F:\\Springboot\\demo\\healthdemo\\src\\main\\resources\\static\\imgupload\\";
        //写入到到服务器tomcat上的路径
        //String filePath = "C:\\Users\\Administrator\\Desktop\\apache-tomcat-7.0.72\\webapps\\images\\";
        //写入本地前端项目中的路径
        String filePath = "C:\\Users\\Administrator\\Desktop\\vue-manage-system-master\\static\\uploadimg\\";

        //写入本地Nginx服务器存放图片地址
        //String filePath = "G:\\images\\";

        System.out.println("filePath-->" + filePath);

        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }

         // 加载图片
        /*  loadImg(filePath);*/
        //String imagepath=filePath+fileName;
        //从服务器tomcat中加载图片
        //String imagepath="http://118.89.33.198:8080/images/"+fileName;

        String imagepath="./static/uploadimg/"+fileName;

        //System.out.println(imagepath);


        //将返回前端图片的存放到数据中



        return  imagepath;
    }



}
