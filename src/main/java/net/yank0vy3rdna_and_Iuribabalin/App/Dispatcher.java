package net.yank0vy3rdna_and_Iuribabalin.App;

import net.yank0vy3rdna_and_Iuribabalin.Dragon.DragonReader;
import net.yank0vy3rdna_and_Iuribabalin.Dragon.DragonSerializable;
import net.yank0vy3rdna_and_Iuribabalin.MakeObject.MakeObject;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class Dispatcher {
    HashMap<String, MakeObject> commands;
    public DragonReader reader;
    public DragonSerializable serializable;

    public Dispatcher(HashMap<String, MakeObject> commands, DragonReader reder, DragonSerializable serializable){
        this.reader = reder;
        this.commands = commands;
        this.serializable = serializable;
    }

    public String dispatch(String clientCommand, Socket socket, App app) throws IOException {
        reader.setUI(new UI());

        DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
        DataInputStream ois = new DataInputStream(socket.getInputStream());

        try {
            byte[] stringBytes = clientCommand.getBytes(StandardCharsets.UTF_8);
            byte[] sizeBytes = ByteBuffer.allocate(4).putInt(stringBytes.length).array();
            byte[] dataBytes = new byte[0]; // Этот массив байт ты заюзаешь, когда пользователь введет команду add, update или execute_script


            if(clientCommand.equals("exit")){

                oos.write(sizeBytes);
                oos.write(stringBytes);
                oos.flush();

                app.stopWork();

                return "Client off work";
            }
            if(commands.get(clientCommand.split(" ")[0].toLowerCase()) != null){

                MakeObject command = commands.get(clientCommand.split(" ")[0]);
                dataBytes = command.exec(clientCommand, this);

                oos.write(sizeBytes);
                oos.write(stringBytes);

                sizeBytes = ByteBuffer.allocate(4).putInt(dataBytes.length).array();

                oos.write(sizeBytes);
                oos.write(dataBytes);
                oos.flush();

            }else{
                oos.write(sizeBytes);
                oos.write(stringBytes);
                oos.flush();
            }

            return ois.readUTF();

        }catch (NullPointerException ex){

            oos.writeUTF("exit");
            app.stopWork();

            return "Client off work";
        }
    }
}
