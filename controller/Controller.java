package controller;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import queue_operations.*;
import sun.awt.www.content.image.gif;
import sun.nio.cs.Surrogate.Generator;

public class Controller implements Runnable{

	Thread thread = new Thread(this);
	private Interface queueInterface = new Interface();
	public QueueSimulation queueSimulation = new QueueSimulation();
	
	public Controller() {
		
	}
	
	public Controller(Interface queueInterface, QueueSimulation queueSimulation) {
		this.queueInterface = queueInterface;
		this.queueSimulation = queueSimulation;
			
		queueInterface.addStartListener(new StartListener());
	}
	
	public void run() {
		for(ManageQueue queue: queueSimulation.queues) {
			synchronized(queue)  {
				queue.thread.start();
			}	
		}
		int q1 = 0;
		int q2 = 0;
		int q3 = 0;
		int empty1 = 0;
		int empty2 = 0;
		int empty3 = 0;
		String string1 = "";
		String string2 = "";
		String string3 = "";
		double waiting1 = 0.0;
		double waiting2 = 0.0;
		double waiting3 = 0.0;
		int size1 = queueSimulation.queues.get(0).clients.size();
		int size2 = queueSimulation.queues.get(1).clients.size();
		int size3 = queueSimulation.queues.get(2).clients.size();
		
		queueInterface.simulationAverageServiceTime.setVisible(false);
		queueInterface.simulationServiceTime1.setVisible(false);
		queueInterface.simulationServiceTime2.setVisible(false);
		queueInterface.simulationServiceTime3.setVisible(false);
		
		queueInterface.simulationAverageWaitingTime.setVisible(false);
		queueInterface.simulationWaitingTime1.setVisible(false);
		queueInterface.simulationWaitingTime2.setVisible(false);
		queueInterface.simulationWaitingTime3.setVisible(false);
		
		queueInterface.simulationQueue1Servicetime.setVisible(false);
		queueInterface.simulationQueue2Servicetime.setVisible(false);
		queueInterface.simulationQueue3Servicetime.setVisible(false);
		
		queueInterface.simulationQueue1Waitingtime.setVisible(false);
		queueInterface.simulationQueue2Waitingtime.setVisible(false);
		queueInterface.simulationQueue3Waitingtime.setVisible(false);
		
		queueInterface.setSimulationService1(Double.toString(queueSimulation.queues.get(0).getSimulationAverageServiceTime()));
		queueInterface.setSimulationService2(Double.toString(queueSimulation.queues.get(1).getSimulationAverageServiceTime()));
		queueInterface.setSimulationService3(Double.toString(queueSimulation.queues.get(2).getSimulationAverageServiceTime()));	
		
		
		for(int i = 0; i < QueueSimulation.time; i++) {
			
			for(Client client: queueSimulation.queues.get(0).clients) {
				if(client != null && client.arrivalTime == i && q1 == 0) {
					queueInterface.Q1T1.setText(String.valueOf(client.id));
					q1++;
				}
				else if(client != null && client.arrivalTime == i && q1 == 1) {
					queueInterface.Q1T2.setText(String.valueOf(client.id));
					q1++;
				}
				
				else if(client != null && client.arrivalTime == i && q1 == 2) {
					queueInterface.Q1T3.setText(String.valueOf(client.id));
					q1++;
				} 
				
				else if(client != null && client.arrivalTime == i && q1 == 3) {
					queueInterface.Q1T4.setText(String.valueOf(client.id));
					q1++;
				} 
		
				else if(client != null && client.arrivalTime == i && q1 == 4) {
					queueInterface.Q1T5.setText(String.valueOf(client.id));
					q1++;
				} 
				
				else if(client.hasFinished == true && q1 == 1) {
					queueInterface.Q1T1.setText("");
					q1--;
				} 
				else if(client.hasFinished == true && q1 == 2) {
					queueInterface.Q1T1.setText(queueInterface.Q1T2.getText());
					queueInterface.Q1T2.setText("");
					q1--;
				} 
				else if(client.hasFinished == true && q1 == 3) {
					queueInterface.Q1T1.setText(queueInterface.Q1T2.getText());
					queueInterface.Q1T2.setText(queueInterface.Q1T3.getText());
					queueInterface.Q1T3.setText("");
					q1--;
				} 
				else if(client.hasFinished == true && q1 == 4) {
					queueInterface.Q1T1.setText(queueInterface.Q1T2.getText());
					queueInterface.Q1T2.setText(queueInterface.Q1T3.getText());
					queueInterface.Q1T3.setText(queueInterface.Q1T4.getText());
					queueInterface.Q1T4.setText("");
					q1--;
				} 
				else if(client.hasFinished == true && q1 == 5) {
					queueInterface.Q1T1.setText(queueInterface.Q1T2.getText());
					queueInterface.Q1T2.setText(queueInterface.Q1T3.getText());
					queueInterface.Q1T3.setText(queueInterface.Q1T4.getText());
					queueInterface.Q1T4.setText(queueInterface.Q1T5.getText());
					queueInterface.Q1T5.setText("");
					q1--;
				} 
			}
			
			waiting1 += queueSimulation.queues.get(0).getSimulationAverageWaitingTime();
			//System.out.println("give: " + waiting1);
			
			for(Client client: queueSimulation.queues.get(1).clients) {
				
				if(client != null && client.arrivalTime == i && q2 == 0) {
					queueInterface.Q2T1.setText(String.valueOf(client.id));
					q2++;
				}
				else if(client != null && client.arrivalTime == i && q2 == 1) {
					queueInterface.Q2T2.setText(String.valueOf(client.id));
					q2++;
				}
				
				else if(client != null && client.arrivalTime == i && q2 == 2) {
					queueInterface.Q2T3.setText(String.valueOf(client.id));
					q2++;
				} 
				
				else if(client != null && client.arrivalTime == i && q2 == 3) {
					queueInterface.Q2T4.setText(String.valueOf(client.id));
					q2++;
				} 
		
				else if(client != null && client.arrivalTime == i && q2 == 4) {
					queueInterface.Q2T5.setText(String.valueOf(client.id));
					q2++;
				} 
				
				else if(client.hasFinished == true && q2 == 1 ) {
					queueInterface.Q2T1.setText("");
					q2--;
				} 
				else if(client.hasFinished == true && q2 == 2) {
					queueInterface.Q2T1.setText(queueInterface.Q2T2.getText());
					queueInterface.Q2T2.setText("");
					q2--;
				} 
				else if(client.hasFinished == true && q2 == 3) {
					queueInterface.Q2T1.setText(queueInterface.Q2T2.getText());
					queueInterface.Q2T2.setText(queueInterface.Q2T3.getText());
					queueInterface.Q2T3.setText("");
					q2--;
				} 
				else if(client.hasFinished == true && q2 == 4) {
					queueInterface.Q2T1.setText(queueInterface.Q2T2.getText());
					queueInterface.Q2T2.setText(queueInterface.Q2T3.getText());
					queueInterface.Q2T3.setText(queueInterface.Q2T4.getText());
					queueInterface.Q2T4.setText("");
					q2--;
				} 
				else if(client.hasFinished == true && q2 == 5) {
					queueInterface.Q2T1.setText(queueInterface.Q2T2.getText());
					queueInterface.Q2T2.setText(queueInterface.Q2T3.getText());
					queueInterface.Q2T3.setText(queueInterface.Q2T4.getText());
					queueInterface.Q2T4.setText(queueInterface.Q2T5.getText());
					queueInterface.Q2T5.setText("");
					q2--;
				} 
			}

			waiting2 += queueSimulation.queues.get(1).getSimulationAverageWaitingTime();
			
			for(Client client: queueSimulation.queues.get(2).clients) {
	
				if(client != null && client.arrivalTime == i && q3 == 0) {
					queueInterface.Q3T1.setText(String.valueOf(client.id));
					q3++;
				}
				else if(client != null && client.arrivalTime == i && q3 == 1) {
					queueInterface.Q3T2.setText(String.valueOf(client.id));
					q3++;
				}
	
				else if(client != null && client.arrivalTime == i && q3 == 2) {
					queueInterface.Q3T3.setText(String.valueOf(client.id));
					q3++;
				} 
	
				else if(client != null && client.arrivalTime == i && q3 == 3) {
					queueInterface.Q3T4.setText(String.valueOf(client.id));
					q3++;
				} 

				else if(client != null && client.arrivalTime == i && q3 == 4) {
					queueInterface.Q3T5.setText(String.valueOf(client.id));
					q3++;
				} 
	
				else if(client.hasFinished == true && q3 == 1) {
					queueInterface.Q3T1.setText("");
					q3--;
				} 
				else if(client.hasFinished == true && q3 == 2) {
					queueInterface.Q3T1.setText(queueInterface.Q3T2.getText());
					queueInterface.Q3T2.setText("");
					q3--;
				} 
				else if(client.hasFinished == true && q3 == 3) {
					queueInterface.Q3T1.setText(queueInterface.Q3T2.getText());
					queueInterface.Q3T2.setText(queueInterface.Q3T3.getText());
					queueInterface.Q3T3.setText("");	
					q3--;
				} 
				else if(client.hasFinished == true && q3 == 4) {
					queueInterface.Q3T1.setText(queueInterface.Q3T2.getText());
					queueInterface.Q3T2.setText(queueInterface.Q3T3.getText());
					queueInterface.Q3T3.setText(queueInterface.Q3T4.getText());
					queueInterface.Q3T4.setText("");
					q3--;	
				} 
				else if(client.hasFinished == true && q3 == 5) {
					queueInterface.Q3T1.setText(queueInterface.Q3T2.getText());
					queueInterface.Q3T2.setText(queueInterface.Q3T3.getText());
					queueInterface.Q3T3.setText(queueInterface.Q3T4.getText());
					queueInterface.Q3T4.setText(queueInterface.Q3T5.getText());
					queueInterface.Q3T5.setText("");
					q3--;
				} 
			}
				
			waiting3 += queueSimulation.queues.get(2).getSimulationAverageWaitingTime();
			
			queueInterface.setServiceTime1(String.valueOf(queueSimulation.queues.get(0).getAverageServiceTime()));
			double s1 = Double.parseDouble(String.valueOf(queueSimulation.queues.get(0).getAverageServiceTime()));
			if(Double.isNaN(s1)){
				queueInterface.setServiceTime1("0.0");
			}
			
			queueInterface.setServiceTime2(String.valueOf(queueSimulation.queues.get(1).getAverageServiceTime()));
			double s2 = Double.parseDouble(String.valueOf(queueSimulation.queues.get(1).getAverageServiceTime()));
			if(Double.isNaN(s2)){
				queueInterface.setServiceTime2("0.0");
			}
			
			queueInterface.setServiceTime3(String.valueOf(queueSimulation.queues.get(2).getAverageServiceTime()));
			double s3 = Double.parseDouble(String.valueOf(queueSimulation.queues.get(2).getAverageServiceTime()));
			if(Double.isNaN(s3)){
				queueInterface.setServiceTime3("0.0");
			}

			queueInterface.setWaitingTime1(String.valueOf(queueSimulation.queues.get(0).getAverageWaitingTime()));
			double w1 = Double.parseDouble(String.valueOf(queueSimulation.queues.get(0).getAverageWaitingTime()));
			if(Double.isNaN(w1)){
				queueInterface.setWaitingTime1("0.0");
			}
			
			queueInterface.setWaitingTime2(String.valueOf(queueSimulation.queues.get(1).getAverageWaitingTime()));
			double w2 = Double.parseDouble(String.valueOf(queueSimulation.queues.get(1).getAverageWaitingTime()));
			if(Double.isNaN(w2)){
				queueInterface.setWaitingTime2("0.0");
			}
			
			queueInterface.setWaitingTime3(String.valueOf(queueSimulation.queues.get(2).getAverageWaitingTime()));
			double w3 = Double.parseDouble(String.valueOf(queueSimulation.queues.get(2).getAverageWaitingTime()));
			if(Double.isNaN(w3)){
				queueInterface.setWaitingTime3("0.0");
			}
			
			if(queueSimulation.queues.get(0).emptyQueue() == true || queueSimulation.queues.get(0).clients.element().hasReached == false) {
				empty1++;
			}
			
			queueInterface.setEmptyTime1(String.valueOf(empty1));
			
			if(queueSimulation.queues.get(1).emptyQueue() == true || queueSimulation.queues.get(1).clients.element().hasReached == false) {
				empty2++;
			}
			
			queueInterface.setEmptyTime2(String.valueOf(empty2));
			
			if(queueSimulation.queues.get(2).emptyQueue() == true || queueSimulation.queues.get(2).clients.element().hasReached == false) {
				empty3++;
			}
			
			queueInterface.setEmptyTime3(String.valueOf(empty3));
			
			
			try {
				 Thread.sleep(1000);   
			} catch (InterruptedException e) { 
				System.out.println("Thread interrupted.");  
			}
		}
//		System.out.println("WAW " + waiting1);
		queueInterface.setSimulationWaiting1(Double.toString(waiting1 / size1));
		queueInterface.setSimulationWaiting2(Double.toString(waiting2 / size2));
		queueInterface.setSimulationWaiting3(Double.toString(waiting3 / size3));
		
	//	queueInterface.setSimulationWaiting1(Double.toString(queueSimulation.queues.get(0).getSimulationAverageWaitingTime()));
	//	queueInterface.setSimulationWaiting2(Double.toString(queueSimulation.queues.get(1).getSimulationAverageWaitingTime()));
	//	queueInterface.setSimulationWaiting3(Double.toString(queueSimulation.queues.get(2).getSimulationAverageWaitingTime()));
		
	//	System.out.println(("ESTE: " + queueSimulation.queues.get(0).getSimulationAverageWaitingTime()));
		
		for(int i = 0; i < QueueSimulation.time; i++) {
			if(queueSimulation.queues.get(0).numberOfClients[i] == queueSimulation.queues.get(0).maxNoOfClients) {
				string1 += i + " ";
			}
			
			if(queueSimulation.queues.get(1).numberOfClients[i] == queueSimulation.queues.get(1).maxNoOfClients) {
				string2 += i + " ";
			}
			
			if(queueSimulation.queues.get(2).numberOfClients[i] == queueSimulation.queues.get(2).maxNoOfClients) {
				string3 += i + " ";
			}
		}
		
			queueInterface.setPeakHour1(string1);
			queueInterface.setPeakHour2(string2);
			queueInterface.setPeakHour3(string3);
			
			queueInterface.simulationAverageServiceTime.setVisible(true);
			queueInterface.simulationServiceTime1.setVisible(true);
			queueInterface.simulationServiceTime2.setVisible(true);
			queueInterface.simulationServiceTime3.setVisible(true);
			
			queueInterface.simulationAverageWaitingTime.setVisible(true);
			queueInterface.simulationWaitingTime1.setVisible(true);
			queueInterface.simulationWaitingTime2.setVisible(true);
			queueInterface.simulationWaitingTime3.setVisible(true);
			
			queueInterface.simulationQueue1Servicetime.setVisible(true);
			queueInterface.simulationQueue2Servicetime.setVisible(true);
			queueInterface.simulationQueue3Servicetime.setVisible(true);
			
			queueInterface.simulationQueue1Waitingtime.setVisible(true);
			queueInterface.simulationQueue2Waitingtime.setVisible(true);
			queueInterface.simulationQueue3Waitingtime.setVisible(true);
			
		
		}
	
	
	class StartListener implements ActionListener{

		public void generateClients() {
			int minArrTime = Integer.parseInt(queueInterface.getMinArrivalTime());
			int maxArrTime = Integer.parseInt(queueInterface.getMaxArrivalTime());
			int minServTime = Integer.parseInt(queueInterface.getMinServiceTime());
			int maxServTime = Integer.parseInt(queueInterface.getMaxServiceTime());
			ClientGenerator clientGenerator = new ClientGenerator(minArrTime, maxArrTime, minServTime, maxServTime);
			for(int i = 0; i < queueSimulation.numberOfClients; i++) {
				Client client = clientGenerator.generateClient(i + 1);
				queueSimulation.clients.add(client);
			}
		
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			generateClients();
			
			queueSimulation.generate();
			queueSimulation.putInQueues();
			thread.start();
			
		}
	}

}

