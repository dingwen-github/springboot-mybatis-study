package com.dw.sms.controller;

import com.dw.sms.result.Result;
import com.dw.sms.result.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @program:
 * @description: 文件上传
 * @author: dingwen
 * @create: 2020/9/24 14:33
 **/
@Api("文件上传下载接口")
@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {
    private static final String FILEPATH = "E:/study/springboot-mybatis-study/files/";

    /*
     *单个文件上传
     * @param [file]
     * @return com.dw.sms.result.Result
     */
    @ApiOperation(value = "实现单个文件的上传")
    @ApiParam(value = "上传的文件", name = "file", type = "MultipartFile")
    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                log.error("FileController:upload():上传的文件不存在");
                return ResultGenerator.genFailureResult("上传的文件不存在");
            }
            //获取文件名
            String fileName = file.getOriginalFilename();
            //获取文件名后缀
            String suffixName = fileName.substring(fileName.lastIndexOf('.'));
            log.info("上传文件名称：" + fileName + "," + "上传文件后缀" + suffixName);
            //设置文件的存储路径
            String fullPath = FILEPATH + fileName;
            log.info("文件上传路径：" + fullPath);
            File dest = new File(fullPath);
            //检测是否存在目录
            if (!dest.getParentFile().exists()) {
                //新建文件夹
                dest.getParentFile().mkdirs();
                log.info("FileController:upload():目录不存在已经创建");
            }
            //文件写入
            file.transferTo(dest);
            return ResultGenerator.genOkResult();

        } catch (IOException e) {
            log.error("FileController:upload():文件上传失败:" + e);
            ResultGenerator.genFailureResult("上传失败");
        }
        return ResultGenerator.genOkResult();
    }

    /*
     *多文件上传
     * @param [request]
     * @return com.dw.sms.result.Result
     */
    @ApiOperation("多文件上传")
    @PostMapping("/batch")
    public Result batch(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); i++) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream((new FileOutputStream(new File(FILEPATH + file.getOriginalFilename()))));
                    //写入文件
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    stream = null;
                    log.error("第" + i + "个文件上传失败" + e);
                    return ResultGenerator.genFailureResult("第" + i + "个文件上传失败" + e);
                }
            } else {
                log.error("第" + i + "个文件为空，上传失败");
                return ResultGenerator.genFailureResult("第" + i + "个文件为空上传失败");
            }
        }
        return ResultGenerator.genOkResult("上传成功");
    }

    /*
     *文件下载
     * @param [request, response]
     * @return com.dw.sms.result.Result
     */
    @ApiOperation("文件下载")
    @GetMapping("/download")
    public Result download(HttpServletRequest request, HttpServletResponse response) {
        //文件名称
        String fileName = "wechat-tx.jpg";
        if (fileName != null) {
            //设置文件路径
            File file = new File(FILEPATH + fileName);
            if (file.exists()) {
                //设置强制下载不打开
                response.setContentType("application/force-download");
                //设置文件名
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
                byte[] buffer = new byte[2048];
                FileInputStream fileInputStream = null;
                BufferedInputStream bufferedInputStream = null;
                try {
                    fileInputStream = new FileInputStream(file);
                    bufferedInputStream = new BufferedInputStream(fileInputStream);
                    OutputStream outputStream = response.getOutputStream();
                    int i = bufferedInputStream.read(buffer);
                    while (i != -1) {
                        outputStream.write(buffer, 0, i);
                        i = bufferedInputStream.read(buffer);
                    }
                    log.info("FileController:download():下载成功");
                    return ResultGenerator.genOkResult("下载成功");
                } catch (IOException e) {
                    log.error("FileController:download():下载失败" + e);
                    return ResultGenerator.genFailureResult("下载失败");
                } finally {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                            log.info("FileController:downLoad():bufferedInputStream已关闭");
                        } catch (IOException e) {
                            log.error("FileController:downLoad():bufferedInputStream关闭出错" + e);
                            e.printStackTrace();
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            log.info("FileController:downLoad():fileInputStream已关闭");
                        } catch (IOException e) {
                            log.error("FileController:downLoad():fileInputStream关闭出错" + e);
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return ResultGenerator.genOkResult("下载成功");
    }
}
