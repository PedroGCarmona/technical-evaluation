package br.com.pedrocarmona.testbackend.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

public class GzipDeserializer {
    
    public static String gzipToJson(byte[] bytes) throws IOException {

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        GZIPInputStream GzipInputStream = new GZIPInputStream(byteArrayInputStream);
        
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;

        while ((length = GzipInputStream.read(buffer)) > 0) {
            byteArrayOutputStream.write(buffer, 0, length);
        }

        String output = new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);

        return new String(output);
    }

}
