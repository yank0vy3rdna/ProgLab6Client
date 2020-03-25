package net.yank0vy3rdna_and_Iuribabalin.Commands;

import net.yank0vy3rdna_and_Iuribabalin.Dragon.Dragon;

import java.io.Serializable;

public class OutputCommand implements Serializable {
    public String command = null;

    public Dragon dragon = null;

    public String execute_commands = null;

    public void setCommand(String command) {
        this.command = command;
    }

   public void setDragon(Dragon dragon) {
        this.dragon = dragon;
    }

    public void setExecute_commands(String execute_commands) {
        this.execute_commands = execute_commands;
    }

    public Dragon getDragon() {
        return dragon;
    }

    public String getExecute_commands() {
        return execute_commands;
    }

    public String getCommand() {
        return command;
    }

}