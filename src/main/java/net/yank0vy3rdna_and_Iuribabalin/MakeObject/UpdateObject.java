package net.yank0vy3rdna_and_Iuribabalin.MakeObject;

import net.yank0vy3rdna_and_Iuribabalin.App.Dispatcher;

import java.io.IOException;

public class UpdateObject implements MakeObject {
    @Override
    public byte[] exec(String command, Dispatcher dispatcher) throws IOException {
        return dispatcher.serializable.serializable(dispatcher.reader.create(command.split(" ")[1]));
    }
}
