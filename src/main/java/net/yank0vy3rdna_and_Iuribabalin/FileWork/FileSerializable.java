package net.yank0vy3rdna_and_Iuribabalin.FileWork;

import java.io.*;

public class FileSerializable {

    public byte[] serializable(String filename) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;

        try {
            BufferedReader reader = new BufferedReader((new InputStreamReader(new FileInputStream(filename))));
            char[] charBuffer = new char[8 * 1024];
            StringBuilder builder = new StringBuilder();

            int numCharsRead;
            while ((numCharsRead = reader.read(charBuffer, 0, charBuffer.length)) != -1) {
                builder.append(charBuffer, 0, numCharsRead);
            }

            objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);

            objectOutputStream2.writeObject(builder);
            objectOutputStream2.flush();

        } catch (IOException e) {
            System.out.println("Не существующий файл");
        }

        return byteArrayOutputStream.toByteArray();
    }
}
