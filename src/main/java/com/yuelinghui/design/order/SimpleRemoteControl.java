package com.yuelinghui.design.order;

public class SimpleRemoteControl {

    Command command;


    public SimpleRemoteControl() {

    }


    public void buttonWasPressed() throws InterruptedException {
        command.execute();
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
