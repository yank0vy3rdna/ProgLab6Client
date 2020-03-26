package net.yank0vy3rdna_and_Iuribabalin.App;

import net.yank0vy3rdna_and_Iuribabalin.Dragon.DragonReader;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;

public class App {

    private final UI ui;
    private final Dispatcher dispatcher;
    private boolean flag = true;

    public App(UI ui, Dispatcher dispatcher){
        this.ui = ui;
        this.dispatcher = dispatcher;
    }

    public void start() throws IOException {
        while(flag) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String command = ui.getNextCommand(br);
                Socket socket = new Socket("localhost", 9000);
                String answ = dispatcher.dispatch(command, socket, this);
                if (answ.equals(">>")){
                    socket.close();
                    continue;
                }
                ui.print(answ);

                socket.close();

            }catch (ConnectException ex){

                ui.print("Server disconnect");
                break;
            }catch (EOFException ignored){

            }

        }
    }

    public void stopWork(){
        this.flag = false;
    }
}