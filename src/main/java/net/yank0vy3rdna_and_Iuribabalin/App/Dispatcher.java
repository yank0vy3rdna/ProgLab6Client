package net.yank0vy3rdna_and_Iuribabalin.App;

import net.yank0vy3rdna_and_Iuribabalin.Commands.CommandSerializable;
import net.yank0vy3rdna_and_Iuribabalin.Commands.OutputCommand;
import net.yank0vy3rdna_and_Iuribabalin.Dragon.DragonReader;
import net.yank0vy3rdna_and_Iuribabalin.FileWork.FileReader;
import net.yank0vy3rdna_and_Iuribabalin.MakeObject.ObjectExecute;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class Dispatcher {
    HashMap<String, ObjectExecute> commands;
    public DragonReader reader;
    public CommandSerializable serialCommand;
    public FileReader fileReader;
    public OutputCommand out;


    public Dispatcher(HashMap<String, ObjectExecute> commands, DragonReader reder, CommandSerializable serialCommand,
                      FileReader fileReader, OutputCommand out){
        this.reader = reder;
        this.commands = commands;
        this.serialCommand = serialCommand;
        this.out = out;
        this.fileReader = fileReader;
    }

    public String dispatch(String clientCommand, Socket socket, App app) throws IOException {
        reader.setUI(new UI());

        DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
        DataInputStream ois = new DataInputStream(socket.getInputStream());

        out.setCommand(clientCommand);

        try {
            byte[] outBytes;
            byte[] sizeBytes;

            if (commands.get(clientCommand.split(" ")[0].toLowerCase()) != null) {

                ObjectExecute doComm =  commands.get(clientCommand.split(" ")[0]);
                doComm.exec(clientCommand,this);

                outBytes = serialCommand.serializable(out);
                sizeBytes = ByteBuffer.allocate(4).putInt(outBytes.length).array();

                oos.write(sizeBytes);
                oos.write(outBytes);
                oos.flush();

            }else if(clientCommand.equals("exit")){
                outBytes = serialCommand.serializable(out);
                sizeBytes = ByteBuffer.allocate(4).putInt(outBytes.length).array();

                oos.write(sizeBytes);
                oos.write(outBytes);
                oos.flush();

                app.stopWork();

                return ois.readUTF();
            }
            else{
                outBytes = serialCommand.serializable(out);
                sizeBytes = ByteBuffer.allocate(4).putInt(outBytes.length).array();

                oos.write(sizeBytes);
                oos.write(outBytes);
                oos.flush();
            }
        }catch (NullPointerException ex){
            app.stopWork();

            return "Client off work";
        }


        return ois.readUTF();
    }
}
