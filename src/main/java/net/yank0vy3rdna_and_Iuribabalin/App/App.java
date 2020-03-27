package net.yank0vy3rdna_and_Iuribabalin.App;

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
                Socket socket = new Socket("127.0.0.1", 2323);
                String answ = dispatcher.dispatch(command, socket, this);
                if (answ.equals(">>")){
                    socket.close();
                    continue;
                }
                ui.print(answ);

                socket.close();

            }catch (ConnectException ex){
                ui.print("Server disconnect");
            }catch (EOFException ignored){
                System.out.println("-");
            }

        }
    }

    public void stopWork(){
        this.flag = false;
    }
}