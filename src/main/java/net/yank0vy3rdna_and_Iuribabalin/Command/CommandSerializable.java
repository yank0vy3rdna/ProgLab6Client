package net.yank0vy3rdna_and_Iuribabalin.Command;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CommandSerializable {

    public byte[] serializable(String obj){

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;

        try {
            objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);

            objectOutputStream2.writeObject(obj);
            objectOutputStream2.flush();

        } catch (IOException e) {

            e.printStackTrace();
        }

        return byteArrayOutputStream.toByteArray();
    }
}
