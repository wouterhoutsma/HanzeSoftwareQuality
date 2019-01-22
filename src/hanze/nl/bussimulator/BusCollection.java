package hanze.nl.bussimulator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BusCollection {

    private HashMap<Integer,ArrayList<Bus>> busStart = new HashMap<>();

    BusCollection() {
        initializeBusses();
    }

    private void addBus(int starttijd, Bus bus){
        ArrayList<Bus> bussen = new ArrayList<>();
        if (busStart.containsKey(starttijd)) {
            bussen = busStart.get(starttijd);
        }
        bussen.add(bus);
        busStart.put(starttijd,bussen);
    }

    public boolean isEmpty() {
        return busStart.isEmpty();
    }

    public ArrayList<Bus> get(Integer key) {
        return busStart.get(key);
    }

    public void remove(Integer key) {
        busStart.remove(key);
    }

    public int getLowestStartTime() {
        return (busStart.isEmpty()) ? -1 : Collections.min(busStart.keySet());
    }
    public void initializeBusses() {
        Object[][] bussesAndStarttimes = {
            { 3, new Bus(Lijnen.LIJN1, Bedrijven.ARRIVA, 1) },
            { 5, new Bus(Lijnen.LIJN2, Bedrijven.ARRIVA, 1) },
            { 4, new Bus(Lijnen.LIJN3, Bedrijven.ARRIVA, 1) },
            { 6, new Bus(Lijnen.LIJN4, Bedrijven.ARRIVA, 1) },
            { 3, new Bus(Lijnen.LIJN5, Bedrijven.FLIXBUS, 1) },
            { 5, new Bus(Lijnen.LIJN6, Bedrijven.QBUZZ, 1) },
            { 4, new Bus(Lijnen.LIJN7, Bedrijven.QBUZZ, 1) },
            { 6, new Bus(Lijnen.LIJN1, Bedrijven.ARRIVA, 1) },
            { 12, new Bus(Lijnen.LIJN4, Bedrijven.ARRIVA, 1) },
            { 10, new Bus(Lijnen.LIJN5, Bedrijven.FLIXBUS, 1) },
            { 3, new Bus(Lijnen.LIJN1, Bedrijven.ARRIVA, -1) },
            { 5, new Bus(Lijnen.LIJN2, Bedrijven.ARRIVA, -1) },
            { 4, new Bus(Lijnen.LIJN3, Bedrijven.ARRIVA, -1) },
            { 6, new Bus(Lijnen.LIJN4, Bedrijven.ARRIVA, -1) },
            { 3, new Bus(Lijnen.LIJN5, Bedrijven.FLIXBUS, -1) },
            { 5, new Bus(Lijnen.LIJN6, Bedrijven.QBUZZ, -1) },
            { 4, new Bus(Lijnen.LIJN7, Bedrijven.QBUZZ, -1) },
            { 6, new Bus(Lijnen.LIJN1, Bedrijven.ARRIVA, -1) },
            { 12, new Bus(Lijnen.LIJN4, Bedrijven.ARRIVA, -1) },
            { 10, new Bus(Lijnen.LIJN5, Bedrijven.FLIXBUS, -1) },
        };
        for (Object[] busAndStartTime: bussesAndStarttimes) {
            addBus((int) busAndStartTime[0], (Bus) busAndStartTime[1]);
            ((Bus) busAndStartTime[1]).setbusID((int) busAndStartTime[0]);
        }
    }
}
