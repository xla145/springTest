package com.yuelinghui.design.order;

public class GarageDoorOpenCommand implements Command{

    GarageDoor garageDoor;


    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() throws InterruptedException {

        garageDoor.down();
        garageDoor.lightOn();

        System.out.println("行驶中......");
        Thread.sleep(800);

        garageDoor.stop();
        garageDoor.lightOff();
        garageDoor.up();
    }
}
