package com.hand.hand.controller;
import com.hand.hand.util.FtpFileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;


/**
 * /将图片上传到服务器/
 *
 * Created by nishuai on 2017/12/26.
 */
@CrossOrigin
@Controller
public class FtpFileUploadController {

    //ftp处理文件上传
    @RequestMapping(value="/ftpuploadimg", method = RequestMethod.POST)
    public @ResponseBody String uploadImg(@RequestParam("file") MultipartFile file,
                                          HttpServletRequest request) throws IOException {
        System.out.print("ftp图片上传接口");
        String fileName = file.getOriginalFilename();
        InputStream inputStream=file.getInputStream();
        String filePath=null;



        Boolean flag=FtpFileUtil.uploadFile(fileName,inputStream);
        if(flag==true){
            System.out.println("ftp上传成功！");
            filePath=fileName;
        }


        return  filePath;
    }


}
