package net.yank0vy3rdna_and_Iuribabalin;

import net.yank0vy3rdna_and_Iuribabalin.App.UI;
import net.yank0vy3rdna_and_Iuribabalin.App.App;
import net.yank0vy3rdna_and_Iuribabalin.App.Dispatcher;
import net.yank0vy3rdna_and_Iuribabalin.Dragon.DragonReader;
import net.yank0vy3rdna_and_Iuribabalin.Dragon.DragonSerializable;
import net.yank0vy3rdna_and_Iuribabalin.MakeObject.AddObjact;
import net.yank0vy3rdna_and_Iuribabalin.MakeObject.MakeObject;

import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main( String[] args ) throws IOException {

        HashMap<String, MakeObject> commands = new HashMap<>();
        commands.put("add", new AddObjact());

        App app = new App(new UI(), new Dispatcher(commands, new DragonReader(), new DragonSerializable()));

        app.start();
    }
}