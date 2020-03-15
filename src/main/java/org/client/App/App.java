package org.client.App;

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
                Socket socket = new Socket("localhost", 8888);
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                ui.print(dispatcher.dispatch(ui.getNextCommand(br), socket, this));
            }catch (ConnectException ex){
                ui.print("Server disconnect");
                break;
            }

        }
    }

    public void stopWork(){
        this.flag = false;
    }
}