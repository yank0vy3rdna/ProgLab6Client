package org.client.App;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Dispatcher {

    public String dispatch(String clientCommand, Socket socket, App app) throws IOException {
        DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
        DataInputStream ois = new DataInputStream(socket.getInputStream());

        try {
            oos.writeUTF(clientCommand);
            oos.flush();
        }catch (NullPointerException ex){
            oos.writeUTF("exit");
            app.stopWork();
            return "Client off work";
        }
        return "";
    }
}
