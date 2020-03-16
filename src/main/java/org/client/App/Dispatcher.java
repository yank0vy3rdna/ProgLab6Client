package org.client.App;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class Dispatcher {

    public String dispatch(String clientCommand, Socket socket, App app) throws IOException {
        DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
        DataInputStream ois = new DataInputStream(socket.getInputStream());
        byte[] stringBytes = clientCommand.getBytes(StandardCharsets.UTF_8);
        byte[] sizeBytes = ByteBuffer.allocate(4).putInt(stringBytes.length).array();
        byte[] dataBytes = new byte[0]; // Этот массив байт ты заюзаешь, когда пользователь введет команду add, update или execute_script
        try {
            oos.write(sizeBytes);
            oos.write(stringBytes);
            oos.flush();
            while(ois.available()==0);
            return ois.readUTF();
        }catch (NullPointerException ex){
            oos.writeUTF("exit");
            app.stopWork();
            return "Client off work";
        }
    }
}
