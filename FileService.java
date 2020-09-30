package com.progKiev;

import java.io.*;

public class FileService {

    public static void copyFile(File in, File out, int bufferSize) throws IOException {
        if (bufferSize < 1) {
            throw new IllegalArgumentException();
        }
        byte[] buffer = new byte[bufferSize];
        int readByte = 0;
        try (InputStream is = new FileInputStream(in);
             OutputStream os = new FileOutputStream(out)) {

            for (; (readByte = is.read(buffer)) > 0;) {
                os.write(buffer, 0, readByte);
            }

        } catch (IOException e) {

            throw e;
        }
    }

}
