package queue_operations;

import java.util.Random;

public class ClientGenerator {
	public int minimumArrivalTime;
	public int maximumArrivalTime;
	public int minimumServiceTime;
	public int maximumServiceTime;
	
	
	public ClientGenerator() {
		// TODO Auto-generated constructor stub
	}
	
	public ClientGenerator(int minimumArrivalTime, int maximumArrivalTime, int minimumServiceTime, int maximumServiceTime) {
		this.minimumArrivalTime = minimumArrivalTime;
		this.maximumArrivalTime = maximumArrivalTime;
		this.minimumServiceTime = minimumServiceTime;
		this.maximumServiceTime = maximumServiceTime;
	}
	
	public Client generateClient(int id) {
		Random rand1 = new Random();
		Random rand2 = new Random();
		int arrivalTime = rand1.nextInt((maximumArrivalTime - minimumArrivalTime) + 1) + minimumArrivalTime;
		int serviceTime = rand2.nextInt((maximumServiceTime - minimumServiceTime) + 1) + minimumServiceTime;
		return new Client(id, arrivalTime, serviceTime, 0, false, false);
	}
	
}
