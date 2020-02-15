package queue_operations;

public class Client {
	public int arrivalTime;
	public int serviceTime;
	public int waitingTime;
	public int id;
	public boolean hasReached;
	public boolean hasFinished;
	
	public Client() {
		
	}
	
	public Client(int id, int arrivalTime, int serviceTime, int waitingTime, boolean hasReached, boolean hasFinished) {
		this.id = id;
		this.arrivalTime = arrivalTime;
		this.serviceTime = serviceTime;
		this.waitingTime = waitingTime;
		this.hasReached = hasReached;
		this.hasFinished = hasFinished;
	}
}
