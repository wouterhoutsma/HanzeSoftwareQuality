package hanze.nl.bussimulator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import hanze.nl.tijdtools.TijdFuncties;

public class Runner {

	private static int interval=100;
	private static int syncInterval=5;

	public static void main(String[] args){
		BusCollection busses = new BusCollection();
		BusController busController = new BusController(busses);
		try {
			while (busController.canRun()) {
				busController.run();
				Thread.sleep(interval);
			}
		} catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	/* Om de tijdsynchronisatie te gebruiken moet de onderstaande main gebruikt worden
	 * 
	public static void main(String[] args) throws InterruptedException {
		int tijd=0;
		int counter=0;
		TijdFuncties tijdFuncties = new TijdFuncties();
		tijdFuncties.initSimulatorTijden(interval,syncInterval);
		int volgende = initBussen();
		while ((volgende>=0) || !actieveBussen.isEmpty()) {
			counter=tijdFuncties.getCounter();
			tijd=tijdFuncties.getTijdCounter();
			System.out.println("De tijd is:" + tijdFuncties.getSimulatorWeergaveTijd());
			volgende = (counter==volgende) ? startBussen(counter) : volgende;
			moveBussen(tijd);
			sendETAs(tijd);
			tijdFuncties.simulatorStep();
		}
	}
		 */

}
