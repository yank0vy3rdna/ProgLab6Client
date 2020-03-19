package net.yank0vy3rdna_and_Iuribabalin.MakeObject;

import net.yank0vy3rdna_and_Iuribabalin.App.Dispatcher;
import net.yank0vy3rdna_and_Iuribabalin.Dragon.Dragon;

import java.io.IOException;

public class AddObjact implements MakeObject {

    public byte[] exec(String command, Dispatcher dispatcher) throws IOException {
        return dispatcher.serializable.serializable(dispatcher.reader.create("null"));
    }
}
