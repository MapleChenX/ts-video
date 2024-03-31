package com.example.m3u8.controller;

import com.example.m3u8.utils.VideoToM3u8AndTSUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * @description:
 * @package: com.example.m3u8
 * @author: zheng
 * @date: 2023/10/28
 */
@RestController
@RequestMapping("/video")
public class VideoController {

    @PostMapping("/upload")
    public ResponseEntity<String> upload(MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        if (file == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        try {

            boolean written = VideoToM3u8AndTSUtil.write(file.getInputStream(), "X:/Type Files/Videos/Captures/videos/", file.getOriginalFilename());
            if (!written) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }

            String srcPathname = "X:/Type Files/Videos/Captures/videos/" + file.getOriginalFilename();
            String filename = VideoToM3u8AndTSUtil.getFilenameWithoutSuffix(Objects.requireNonNull(file.getOriginalFilename()));
            String destPathname = "X:/Type Files/Videos/Captures/m3u8s/" + filename + ".m3u8";
            Path path = Paths.get("X:/Type Files/Videos/Captures/m3u8s");
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
            boolean converted = VideoToM3u8AndTSUtil.convert(srcPathname, destPathname);
            if (!converted) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok("http://localhost:8080/video/m3u8?filepath=X:/Type Files/Videos/Captures/m3u8s&filename=" + filename + ".m3u8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/m3u8")
    public ResponseEntity<byte[]> getM3U8Content(@RequestParam String filepath, @RequestParam String filename) {
        System.out.println("/m3u8接口");
        try {
            File file = new File(filepath, filename);
            Path path = Paths.get(filepath, filename);
            System.out.println(path);
            if (Files.exists(path)) {
                System.out.println("文件存在");
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
                System.out.println("文件不存在");
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            e.fillInStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{filename}")
    public ResponseEntity<byte[]> getTSContent(@PathVariable String filename) {
        try {
            File file = new File("X:/Type Files/Videos/Captures/m3u8s/", filename);

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
            e.fillInStackTrace();
            return null;
        }
    }
}