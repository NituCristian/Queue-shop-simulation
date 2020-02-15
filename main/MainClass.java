package main;

import controller.Controller;
import queue_operations.QueueSimulation;
import view.Interface;

public class MainClass {

public static void main(String args[]) {
		
		Interface queueInterface = new Interface();
		QueueSimulation queueSimulation = new QueueSimulation();
		Controller controller = new Controller(queueInterface, queueSimulation);
				
		queueInterface.setVisible(true);
		
	}
}