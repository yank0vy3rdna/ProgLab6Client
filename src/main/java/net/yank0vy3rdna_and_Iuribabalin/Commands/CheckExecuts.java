package net.yank0vy3rdna_and_Iuribabalin.Commands;

import net.yank0vy3rdna_and_Iuribabalin.App.Dispatcher;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CheckExecuts {

    static List<String> files = new ArrayList<>();


    public String check(String execute, Dispatcher dispatcher) throws IOException {
        StringBuilder builder = new StringBuilder();
        if(execute!= null) {
            for (String el : execute.split("\n")) {
                String[] element = el.split(" ");
                if (element[0].equals("execute_script")) {
                    if(checkName(element[1]))
                        try {
                            builder.append(dispatcher.fileReader.inputCommandFile("resources/" + element[1])).append("\n");
                        }catch (FileNotFoundException ex){
                            try {
                                builder.append(dispatcher.fileReader.inputCommandFile("resources/" + element[1] + ".txt")).append("\n");
                            }catch (FileNotFoundException e) {
                                System.out.println("Такого файла не уществует");
                            }
                        }
                }else{
                    builder.append(el).append("\n");
                }
            }
        }
        return String.valueOf(builder);
    }

    private boolean checkName(String nameFile) {
        for (String name : files) {
            if (nameFile.equals(name))
                return false;
        }
        files.add(nameFile);
        return true;
    }

}
