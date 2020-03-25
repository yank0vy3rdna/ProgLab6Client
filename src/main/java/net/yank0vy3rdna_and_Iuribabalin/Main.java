package net.yank0vy3rdna_and_Iuribabalin;

import net.yank0vy3rdna_and_Iuribabalin.App.UI;
import net.yank0vy3rdna_and_Iuribabalin.App.App;
import net.yank0vy3rdna_and_Iuribabalin.App.Dispatcher;
import net.yank0vy3rdna_and_Iuribabalin.Command.ExecuteScript;
import net.yank0vy3rdna_and_Iuribabalin.Dragon.DragonReader;
import net.yank0vy3rdna_and_Iuribabalin.Dragon.DragonSerializable;
import net.yank0vy3rdna_and_Iuribabalin.MakeObject.AddObjact;
import net.yank0vy3rdna_and_Iuribabalin.MakeObject.MakeObject;
import net.yank0vy3rdna_and_Iuribabalin.MakeObject.UpdateObject;

import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main( String[] args ) throws IOException {

        HashMap<String, MakeObject> commands = new HashMap<>();
        commands.put("add", new AddObjact());
        commands.put("add_if_max", new AddObjact());
        commands.put("update", new UpdateObject());
        commands.put("execute_script", new ExecuteScript());

        App app = new App(new UI(), new Dispatcher(commands, new DragonReader(), new DragonSerializable()));

        app.start();
    }
}