package hanze.nl.bussimulator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class BusController {

    private final BusCollection startBusses;
    private final ArrayList<Bus> activeBusses = new ArrayList<>();
    private int iterations = 0;

    BusController(BusCollection startBusses) {
        this.startBusses = startBusses;
    }

    private int startBussen(int time){
        activeBusses.addAll(startBusses.get(time));
        startBusses.remove(time);
        return (!startBusses.isEmpty()) ? startBusses.getLowestStartTime() : -1;
    }

    public boolean canRun() {
        return !activeBusses.isEmpty() || startBusses.getLowestStartTime() >= 0;
    }

    public void run() {
        System.out.println("De tijd is:" + iterations);
        if (iterations == startBusses.getLowestStartTime()) {
            startBussen(iterations);
        }
        moveBussen(iterations);
        sendETAs(iterations);
        iterations++;
    }

    public void moveBussen(int nu){
        Iterator<Bus> itr = activeBusses.iterator();
        while (itr.hasNext()) {
            Bus bus = itr.next();
            boolean eindpuntBereikt = bus.move();
            if (eindpuntBereikt) {
                bus.sendLastETA(nu);
                itr.remove();
            }
        }
    }

    private void sendETAs(int now){
        Iterator<Bus> itr = activeBusses.iterator();
        while (itr.hasNext()) {
            Bus bus = itr.next();
            bus.sendETAs(now);
        }
    }
}
