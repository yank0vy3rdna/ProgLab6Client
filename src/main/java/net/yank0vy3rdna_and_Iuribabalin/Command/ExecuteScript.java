package net.yank0vy3rdna_and_Iuribabalin.Command;

import net.yank0vy3rdna_and_Iuribabalin.App.Dispatcher;
import net.yank0vy3rdna_and_Iuribabalin.MakeObject.MakeObject;

import java.io.IOException;

public class ExecuteScript implements MakeObject {
    public byte[] exec(String command, Dispatcher dispatcher) throws IOException {
        return dispatcher.fileSerializable.serializable(command.split(" ")[1]);
    }
}
