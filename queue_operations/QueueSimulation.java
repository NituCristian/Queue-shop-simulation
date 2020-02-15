package queue_operations;
import view.*;

import java.util.LinkedList;
import java.util.List;

public class QueueSimulation implements Runnable{
	
	public Thread thread = new Thread(this);
	
	public List<Client> clients = new LinkedList<Client>();
	public List<ManageQueue> queues = new LinkedList<>();
	public static int time = 60;
	public int numberOfClients = 12;
	
	public QueueSimulation() {
		// TODO Auto-generated constructor stub
	}
	
	
	synchronized public void generate() {
		ManageQueue queue1 = new ManageQueue();
		ManageQueue queue2 = new ManageQueue();
		ManageQueue queue3 = new ManageQueue();
	
		this.queues.add(0, queue1);
		this.queues.add(1 ,queue2);
		this.queues.add(2 ,queue3);
		
	}
	
	public void putInQueues() {
		boolean canAdd = false;
		boolean first = false;
		
		for(int i = 0; i < time; i++) {
			int index = 0, r = 0;
			for(Client c: clients) {
			//	System.out.println(c.arrivalTime);
				if(c.arrivalTime == i) {
					int min = 100;
					for(ManageQueue queue: queues) {
						if(queue.emptyQueue() == true) {
							queue.addClient(c);
							first = true;
							break;
						}
					}
					if(first == false) {
						for(ManageQueue queue: queues) {
							if(queue.getQueueTime() < min) {
								min = queue.getQueueTime();
							}
						}
						for(ManageQueue queue: queues) {
							if(queue.getQueueTime() == min) {
								canAdd = true;
								r = index;
								break;
							}
							else index++;
						}
						min = 100;
					}
					first = false;
					
					if(canAdd == true) {
						this.queues.get(r).clients.add(c);
						canAdd = false;
					}
				}
				index = 0;
			}
		}
		
		
	}
	
	public void run() {
		this.generate();
		this.putInQueues();
		
			try {
				 Thread.sleep(1000);   
			} catch (InterruptedException e) { 
				System.out.println("Thread interrupted.");  
			}
		}
}
