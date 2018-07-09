package com.yuelinghui.design.order;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        LightOnCommand lightOnCommand = new LightOnCommand(new Light());

        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();

        GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(new GarageDoor());

        simpleRemoteControl.setCommand(lightOnCommand);

        simpleRemoteControl.buttonWasPressed();

        simpleRemoteControl.setCommand(garageDoorOpenCommand);

        simpleRemoteControl.buttonWasPressed();



    }
}
