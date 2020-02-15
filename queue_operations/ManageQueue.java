package queue_operations;
import java.util.LinkedList;
import java.util.Queue;
public class ManageQueue implements Runnable{
	
	public Thread thread = new Thread(this);
	int emptyQueue = 0;
	public int[] numberOfClients = new int[QueueSimulation.time];
	public int maxNoOfClients = 0;
	public Queue<Client> clients = new LinkedList<Client>();
	
	public ManageQueue() {
		// TODO Auto-generated constructor stub
	}
	
	public ManageQueue(Queue<Client> clients) {
		this.clients = clients;
	}
	
	public void addClient(Client client) {
		this.clients.add(client);
	}
	
	public void removeClient() {
		this.clients.poll();
	}
	
	public boolean emptyQueue() {
		if (this.clients.isEmpty()){
			return true;
		}
		
		return false;
	}
	
	public int getQueueSize() {
		int numberOfClients = 0;
	
		for(Client client: this.clients) {
			numberOfClients++;
		}
		
		return numberOfClients;
	}	

	public void reached(Client client, int time) {
		if(client.arrivalTime == time) {
			System.out.println("Client " + client.id + " reached at time " + time + " ;service time is: " + client.serviceTime);
			client.hasReached = true;
		}
	}
	
	synchronized public void makeRun() {
		int time = 0;
		int id = 1;
		int val = 0;	
		boolean first = true; //se refera la primul client care a ajuns la coada de cand s-a format
		boolean remove = false;
		
		while(time < QueueSimulation.time) {
			
			for(Client client: this.clients) {
				reached(client, time);		
				if(client.hasReached == true && client != this.clients.element() 
					&& client.arrivalTime < this.clients.element().arrivalTime + this.clients.element().serviceTime 
					&& first == true && client.arrivalTime < time) {
					client.waitingTime++;
					System.out.println("Waiting time for " + client.id + " is " + client.waitingTime);
				}
				else if(client.hasReached == true && client != this.clients.element() 
					&& client.arrivalTime < val + this.clients.element().serviceTime 
					&& first == false && client.arrivalTime < time) {
					client.waitingTime++;
					System.out.println("Waiting time for " + client.id + " is " + client.waitingTime);
				}
				
				if(this.clients.element().serviceTime + this.clients.element().arrivalTime == time && first == true) {
					System.out.println("Client " + client.id + " has finished at " + time);
					client.hasFinished = true;
					val = time;
					first = false; 
					remove = true;
				}
				else if(this.clients.element().serviceTime + val == time && first == false) {
					System.out.println("Client " + client.id + " has finished at " + time);
					client.hasFinished = true;
					val = time;
					remove = true; 
				}
			}
			
			int nr = 0;
			for(Client client: this.clients) {
				if(client.hasReached == true && client.hasFinished == false) {
					nr++;
				}
			}
			numberOfClients[time] = nr;
			if(nr > maxNoOfClients) {
				maxNoOfClients = nr;
			}
			if(this.emptyQueue() == true) {
				emptyQueue++;
			}	
			time++;
			try {
				 Thread.sleep(1000);   
			} catch (InterruptedException e) { 
				System.out.println("Thread interrupted.");  
			}   
		
			if(remove == true) {
				this.removeClient();
				remove = false;
			}
			
		}
	}
	
	public void run() {
		this.makeRun();
	}
	
	public int getQueueTime() {
		int time = 0;
		time = this.clients.element().arrivalTime;
		
		for(Client client: this.clients) {
			time += client.serviceTime;
		}
		
		return time;
	}
	
	public double getAverageServiceTime() {
		double avgServiceTime = 0.0;
		int size = 0;
		
		for(Client client: this.clients) {
			if(client.hasReached == true && client.hasFinished == false) {
				avgServiceTime += client.serviceTime;
				size++;
			}	
		}		
		avgServiceTime /= size;
		return avgServiceTime;
	}
	
	public double getSimulationAverageServiceTime() {
		double avgServiceTime = 0.0;
	
		for(Client client: this.clients) {
			avgServiceTime += client.serviceTime;
		}
			avgServiceTime /= this.clients.size();
		return avgServiceTime;
	}
	
	public int getEmptyQueue() {
		int time = 0;
		
		if(this.emptyQueue() == true) {
			time++;
		}
		
		return time;
	}
	
	public double getAverageWaitingTime() {
		double avgWaitingTime = 0.0;
		int size = 0;
		
		for(Client client: this.clients) {
			if(client.hasReached == true && client.hasFinished == false && client != this.clients.element()) {
				avgWaitingTime += client.waitingTime;
				size++;
			}
		}
		avgWaitingTime /= size;	
		return avgWaitingTime;
	}
	
	public double getSimulationAverageWaitingTime() {
		double avgWaitingTime = 0.0;
	
		for(Client client: this.clients) {
			if(client.waitingTime != 0 && client != this.clients.element()) {
				avgWaitingTime += 1;
			}
		}	
		return avgWaitingTime; 
	}
}
