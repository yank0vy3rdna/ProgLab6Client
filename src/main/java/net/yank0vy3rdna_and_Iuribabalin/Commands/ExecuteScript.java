package net.yank0vy3rdna_and_Iuribabalin.Commands;

import net.yank0vy3rdna_and_Iuribabalin.App.Dispatcher;
import net.yank0vy3rdna_and_Iuribabalin.MakeObject.ObjectExecute;

import java.io.IOException;

public class ExecuteScript implements ObjectExecute {
    public void exec(String command, Dispatcher dispatcher) throws IOException {
       // dispatcher.out.setExecute_commands(dispatcher.fileReader.serializable("resources/" + command.split(" ")[1]));
    }
}
