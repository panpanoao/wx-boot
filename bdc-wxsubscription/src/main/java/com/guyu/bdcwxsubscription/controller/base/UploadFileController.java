package com.guyu.bdcwxsubscription.controller.base;

import com.baomidou.mybatisplus.extension.api.R;
import com.guyu.bdcwxsubscription.utils.TimeString;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @创建人 黄盼
 * @创建时间 2020/12/5 0005 12:39
 * @描述 文件上传
 **/
@RestController
@RequestMapping("/file")
public class UploadFileController {

    static List<String> staticfile=new ArrayList<>();
    static{
        staticfile.add(".jpg");
        staticfile.add(".png");
        staticfile.add(".jpeg");
    }


    /**
     * 多文件上传
     *
     * @param file 文件对象
     * @return
     */
    @PostMapping("/uploadlist")
    @ResponseBody
    public R uploadlist(MultipartFile[] file, HttpServletRequest request) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < file.length; i++) {
            MultipartFile fileUpload = file[i];
            //获取文件名
            String fileName = fileUpload.getOriginalFilename();
            //获取文件后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            for(String a:staticfile){
                if(a.equals(suffixName)){
                    suffixName = new TimeString().getTimeString() + suffixName;
                    break;
                }
            }
            //保存路径
            String realPath = System.getProperty("user.dir") + "/src/main/resources/static/upload";
            //编译
            String classpath = System.getProperty("user.dir") + "/target/classes/static/upload";
            String urlPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/upload/" + fileName;
            try {
                this.inputStreamToFile(fileUpload.getInputStream(), new File(realPath, suffixName));
                this.inputStreamToFile(fileUpload.getInputStream(), new File(classpath, suffixName));
                list.add(urlPath);
            } catch (Exception e) {
                e.printStackTrace();
                return R.failed("在上传第" + i + "个时上传失败，错误" + e.getMessage());
            }
        }
        return R.ok(list);
    }


    /**
     * 文件上传
     *
     * @param fileTest
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/upload")
    public R upload(MultipartFile fileTest, HttpServletRequest request) throws IOException {
        //获取文件的原始名
        String filename = fileTest.getOriginalFilename();
        //获取文件后缀名
        String suffixName = filename.substring(filename.lastIndexOf("."));
        for(String a:staticfile){
            if(a.equals(suffixName)){
                suffixName = new TimeString().getTimeString() + suffixName;
                break;
            }
        }
        System.out.println(filename);
        //保存路径
        String realPath = System.getProperty("user.dir") + "/src/main/resources/static/upload";
        //编译
        String classpath = System.getProperty("user.dir") + "/target/classes/static/upload";
        //访问路径
        String urlPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/upload/" + filename;
        this.inputStreamToFile(fileTest.getInputStream(), new File(realPath, filename));
        this.inputStreamToFile(fileTest.getInputStream(), new File(classpath, filename));
        return R.ok(urlPath);
    }

    /**
     * 文件下载
     *
     * @param fileName
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/download")
    public void download(String fileName, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取文件的绝对路径
        String realPath = System.getProperty("user.dir") + "/src/main/resources/static/upload";
        //获取输入流对象（用于读文件）
        FileInputStream fis = new FileInputStream(new File(realPath, fileName));
        //获取文件后缀（.txt）
        String extendFileName = fileName.substring(fileName.lastIndexOf('.'));
        //动态设置响应类型，根据前台传递文件类型设置响应类型
        response.setContentType(request.getSession().getServletContext().getMimeType(extendFileName));
        //设置响应头,attachment表示以附件的形式下载，inline表示在线打开
        response.setHeader("content-disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
        //获取输出流对象（用于写文件）
        ServletOutputStream os = response.getOutputStream();
        //下载文件,使用spring框架中的FileCopyUtils工具
        FileCopyUtils.copy(fis, os);

    }

    /**
     * 多文件上传MultipartFile 对象重复引用问题解决
     *
     * @param ins
     * @param file
     */
    public void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
