package com.example.m3u8;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("ffmpeg", "-i", "E:\\Type Files\\Videos\\Captures\\香子兰 .mp4", "-c:v", "libx264", "-hls_time", "60", "-hls_list_size", "0", "-c:a", "aac", "-strict", "-2", "-f", "hls", "E:\\Type Files\\Videos\\Captures\\香子兰 .m3u8");
            processBuilder.redirectErrorStream(true); // Merge error and output streams

            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("FFmpeg process exited with code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}
