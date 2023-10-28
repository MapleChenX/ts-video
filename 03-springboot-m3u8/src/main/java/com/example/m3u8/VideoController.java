package com.example.m3u8;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @description:
 * @package: com.example.m3u8
 * @author: zheng
 * @date: 2023/10/28
 */
@RestController
@RequestMapping("/video")
public class VideoController {

    @GetMapping("/m3u8")
    public ResponseEntity<byte[]> getM3U8Content(@RequestParam String filepath, @RequestParam String filename) {
        try {
            // 从classpath中读取M3U8文件内容
            File file = new File(filepath, filename);
            if (file.exists()) {
                // 读取M3U8文件内容
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] data = new byte[(int) file.length()];
                fileInputStream.read(data);
                fileInputStream.close();

                // 设置响应头为M3U8类型
                return ResponseEntity.ok()
                        .contentType(MediaType.valueOf("application/vnd.apple.mpegurl"))
                        .body(data);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            // 处理文件读取异常
            e.fillInStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{filename}")
    public ResponseEntity<byte[]> getTSContent(@PathVariable String filename) {
        try {
            File file = new File("E:\\Type Files\\Videos\\Captures", filename);
            if (file.exists()) {
                // 读取TS文件内容
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] data = new byte[(int) file.length()];
                fileInputStream.read(data);
                fileInputStream.close();

                // 设置响应头为TS文件类型
                return ResponseEntity.ok()
                        .contentType(MediaType.valueOf("video/mp2t"))
                        .body(data);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            // 处理文件读取异常
            e.fillInStackTrace();
            return null;
        }
    }
}