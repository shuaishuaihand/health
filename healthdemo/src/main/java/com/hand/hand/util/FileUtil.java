package com.hand.hand.util;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by nishuai on 2017/12/26.
 */
public class FileUtil{

    //文件上传工具类服务方法

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception{

        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
