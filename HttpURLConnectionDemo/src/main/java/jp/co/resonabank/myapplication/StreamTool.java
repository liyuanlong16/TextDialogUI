package jp.co.resonabank.myapplication;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by smyhvae on 2015/5/7.
 */
public class StreamTool {
    //从流中读取数据
    public static byte[] read(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }
}
