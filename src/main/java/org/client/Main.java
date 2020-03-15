package org.client;

import org.client.App.App;
import org.client.App.Dispatcher;
import org.client.App.UI;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;

/**
 * Hello world!
 *
 */
public class Main {
    public static void main( String[] args ) throws IOException {
        App app = new App(new UI(), new Dispatcher());

        app.start();
    }
}