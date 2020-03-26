package net.yank0vy3rdna_and_Iuribabalin.Commands;

import net.yank0vy3rdna_and_Iuribabalin.App.Dispatcher;

import java.io.IOException;

public class CheckExecuts {
    public String check(String execute, Dispatcher dispatcher) throws IOException {
        if(execute!= null) {
            for (String el : execute.split("\n")) {
                if (el.split(" ")[0].equals("execute_script")) {
                    execute.replace(el,dispatcher.fileReader.inputCommandFile("resources/" + el.split(" ")[1]));
                }
            }
        }
        return execute;
    }
}
