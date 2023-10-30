package com.example.m3u8;

import java.io.*;

/**
 * @description:
 * @package: com.example.m3u8
 * @author: zheng
 * @date: 2023/10/31
 */
public class VideoToM3u8AndTSUtil {

    public static String getRealname(String filename) {
        int lastDotIndex = filename.lastIndexOf(".");
        if (lastDotIndex > 0) {
            return filename.substring(0, lastDotIndex);
        } else {
            return null;
        }
    }

    /**
     * @param filename 文件名称
     */
    public static String convert(String filename) {
        try {
            String src = "E:/Type Files/Videos/Captures/videos/" + filename;
            String realname = getRealname(filename);
            String dest = "E:/Type Files/Videos/Captures/m3u8s/" + realname + ".m3u8";

            ProcessBuilder processBuilder = new ProcessBuilder("ffmpeg", "-i", src, "-c:v", "libx264", "-hls_time", "60",
                    "-hls_list_size", "0", "-c:a", "aac", "-strict", "-2", "-f", "hls", dest);
            processBuilder.redirectErrorStream(true);

            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("FFmpeg process exited with code: " + exitCode);
            return "http://localhost:8080/video/m3u8?filepath=" + "E:/Type Files/Videos/Captures/m3u8s" + "&filename=" + realname + ".m3u8";
        } catch (IOException | InterruptedException e) {
            e.fillInStackTrace();
            return null;
        }
    }

    public static boolean write(InputStream inputStream, String filepath, String filename) throws IOException {
        File file = new File(filepath, filename);

        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            return false;
        }

        OutputStream outputStream = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        outputStream.close();
        inputStream.close();
        return true;
    }

}
