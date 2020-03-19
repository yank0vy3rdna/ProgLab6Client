package net.yank0vy3rdna_and_Iuribabalin.MakeObject;

import net.yank0vy3rdna_and_Iuribabalin.App.Dispatcher;

import java.io.IOException;

public interface MakeObject {
    public byte[] exec(String command, Dispatcher dispatcher) throws IOException;
}
