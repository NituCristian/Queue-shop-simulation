package view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

import queue_operations.QueueSimulation;

public class Interface extends JFrame{
	

	private JTextField minArrivalTime = new JTextField(20);
	private JTextField maxArrivalTime = new JTextField(20);
	private JTextField minServiceTime = new JTextField(20);
	private JTextField maxServiceTime = new JTextField(20);

	public JButton button = new JButton("Start simulation");
		
	public JTextField Q1T1 = new JTextField(20);
	public JTextField Q1T2 = new JTextField(20);
	public JTextField Q1T3 = new JTextField(20);
	public JTextField Q1T4 = new JTextField(20);
	public JTextField Q1T5 = new JTextField(20);
	
	public JTextField Q2T1 = new JTextField(20);
	public JTextField Q2T2 = new JTextField(20);
	public JTextField Q2T3 = new JTextField(20);
	public JTextField Q2T4 = new JTextField(20);
	public JTextField Q2T5 = new JTextField(20);

	public JTextField Q3T1 = new JTextField(20);
	public JTextField Q3T2 = new JTextField(20);
	public JTextField Q3T3 = new JTextField(20);
	public JTextField Q3T4 = new JTextField(20);
	public JTextField Q3T5 = new JTextField(20);

	private JTextField waitingTime1 = new JTextField(20);
	private JTextField serviceTime1 = new JTextField(20);
	private JTextField emptyQueue1 = new JTextField(20);
	private JTextField peakHour1 = new JTextField(20);

	private JTextField waitingTime2 = new JTextField(20);
	private JTextField serviceTime2 = new JTextField(20);
	private JTextField emptyQueue2 = new JTextField(20);
	private JTextField peakHour2 = new JTextField(20);
	
	private JTextField waitingTime3 = new JTextField(20);
	private JTextField serviceTime3 = new JTextField(20);
	private JTextField emptyQueue3 = new JTextField(20);
	private JTextField peakHour3 = new JTextField(20);

	public JTextField simulationQueue1Servicetime = new JTextField(20);
	public JTextField simulationQueue2Servicetime = new JTextField(20);
	public JTextField simulationQueue3Servicetime = new JTextField(20);
	
	public JTextField simulationQueue1Waitingtime = new JTextField(20);
	public JTextField simulationQueue2Waitingtime = new JTextField(20);
	public JTextField simulationQueue3Waitingtime = new JTextField(20);
	
	JLabel queue1 = new JLabel("Queue 1 evolution");
	JLabel queue2 = new JLabel("Queue 2 evolution");
	JLabel queue3 = new JLabel("Queue 3 evolution");
	JLabel giveMinArrivalTime = new JLabel("Type the minimum arrival time");
	JLabel giveMaxArrivalTime = new JLabel("Type the maximum arrival time");
	JLabel giveMinServiceTime = new JLabel("Type the minimum service time");
	JLabel giveMaxServiceTime = new JLabel("Type the maximum service time");
		
	JLabel waitingTime1Is = new JLabel("Queue 1 waiting time");
	JLabel serviceTime1Is = new JLabel("Queue 1 service time");
	JLabel emptyQueue1Is = new JLabel("Queue 1 empty time");
	JLabel peakHour1Is = new JLabel("Queue 1 peak hour");
	
	JLabel waitingTime2Is = new JLabel("Queue 2 waiting time");
	JLabel serviceTime2Is = new JLabel("Queue 2 service time");
	JLabel emptyQueue2Is = new JLabel("Queue 2 empty time");
	JLabel peakHour2Is = new JLabel("Queue 2 peak hour");
	
	JLabel waitingTime3Is = new JLabel("Queue 3 waiting time");
	JLabel serviceTime3Is = new JLabel("Queue 3 service time");
	JLabel emptyQueue3Is = new JLabel("Queue 3 empty time");
	JLabel peakHour3Is = new JLabel("Queue 3 peak hour");
	
	public JLabel simulationAverageServiceTime = new JLabel("Simulation average service time");
	public JLabel simulationServiceTime1 = new JLabel("Queue 1 simulation service time");
	public JLabel simulationServiceTime2 = new JLabel("Queue 2 simulation service time");
	public JLabel simulationServiceTime3 = new JLabel("Queue 3 simulation service time");
	
	public JLabel simulationAverageWaitingTime = new JLabel("Simulation average waiting time");
	public JLabel simulationWaitingTime1 = new JLabel("Queue 1 simulation waiting time");
	public JLabel simulationWaitingTime2 = new JLabel("Queue 2 simulation waiting time");
	public JLabel simulationWaitingTime3 = new JLabel("Queue 3 simulation waiting time");
	
	public Interface(){
	
	JPanel panel1 = new JPanel();   
	JPanel panel2 = new JPanel();   
	JPanel panel3 = new JPanel();   
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	JPanel panel6 = new JPanel();   
	JPanel panel7 = new JPanel();   
	JPanel panel8 = new JPanel();
	JPanel panel9 = new JPanel();
	JPanel panel10 = new JPanel();
	JPanel panel11 = new JPanel();
	
	panel1.setLayout(new FlowLayout());   
	panel2.setLayout(new FlowLayout());   
	panel3.setLayout(new FlowLayout());   
	panel4.setLayout(new FlowLayout());   
	panel5.setLayout(new FlowLayout());
	panel6.setLayout(new FlowLayout());   
	panel7.setLayout(new FlowLayout());   
	panel8.setLayout(new FlowLayout());
	panel9.setLayout(new FlowLayout());
	panel10.setLayout(new FlowLayout());
	panel11.setLayout(new FlowLayout());
	
	panel1.add(giveMinArrivalTime);
	panel1.add(minArrivalTime);
	panel1.add(giveMaxArrivalTime);
	panel1.add(maxArrivalTime);
	
	panel2.add(giveMinServiceTime);
	panel2.add(minServiceTime);
	panel2.add(giveMaxServiceTime);
	panel2.add(maxServiceTime);
	
	panel3.add(button);
	
	panel4.add(queue1);
	panel4.add(Q1T1);
	panel4.add(Q1T2);
	panel4.add(Q1T3);
	panel4.add(Q1T4);
	panel4.add(Q1T5);
	
	panel5.add(queue2);
	panel5.add(Q2T1);
	panel5.add(Q2T2);
	panel5.add(Q2T3);
	panel5.add(Q2T4);
	panel5.add(Q2T5);
	
	panel6.add(queue3);
	panel6.add(Q3T1);
	panel6.add(Q3T2);
	panel6.add(Q3T3);
	panel6.add(Q3T4);
	panel6.add(Q3T5);
	
	panel7.add(waitingTime1Is);
	panel7.add(waitingTime1);
	panel7.add(serviceTime1Is);
	panel7.add(serviceTime1);
	panel7.add(emptyQueue1Is);
	panel7.add(emptyQueue1);
	panel7.add(peakHour1Is);
	panel7.add(peakHour1);
	
	panel8.add(waitingTime2Is);
	panel8.add(waitingTime2);
	panel8.add(serviceTime2Is);
	panel8.add(serviceTime2);
	panel8.add(emptyQueue2Is);
	panel8.add(emptyQueue2);
	panel8.add(peakHour2Is);
	panel8.add(peakHour2);
	
	panel9.add(waitingTime3Is);
	panel9.add(waitingTime3);
	panel9.add(serviceTime3Is);
	panel9.add(serviceTime3);
	panel9.add(emptyQueue3Is);
	panel9.add(emptyQueue3);
	panel9.add(peakHour3Is);
	panel9.add(peakHour3);
	
	panel10.add(simulationAverageServiceTime);
	panel10.add(simulationServiceTime1);
	panel10.add(simulationQueue1Servicetime);
	panel10.add(simulationServiceTime2);
	panel10.add(simulationQueue2Servicetime);
	panel10.add(simulationServiceTime3);
	panel10.add(simulationQueue3Servicetime);
	
	panel11.add(simulationAverageWaitingTime);
	panel11.add(simulationWaitingTime1);
	panel11.add(simulationQueue1Waitingtime);
	panel11.add(simulationWaitingTime2);
	panel11.add(simulationQueue2Waitingtime);
	panel11.add(simulationWaitingTime3);
	panel11.add(simulationQueue3Waitingtime);
	
	JPanel p = new JPanel();  
	p.add(panel1);   
	p.add(panel2); 
	p.add(panel3);
	p.add(panel4);
	p.add(panel5);
	p.add(panel6);
	p.add(panel7);
	p.add(panel8);
	p.add(panel9);
	p.add(panel10);
	p.add(panel11);
	
	p.setLayout(new BoxLayout(p, BoxLayout. Y_AXIS ));  
	this.setContentPane(p);
	
	this.pack();               
	this.setTitle("Queue simulation");  
	  
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public String getMinArrivalTime() {
		return minArrivalTime.getText();
	}
	
	public String getMaxArrivalTime() {
		return maxArrivalTime.getText();
	}
	
	public String getMinServiceTime() {
		return minServiceTime.getText();
	}
	
	public String getMaxServiceTime() {
		return maxServiceTime.getText();
	}
	
	public void setWaitingTime1(String waiting1) {
		waitingTime1.setText(waiting1);
	}
	
	public void setServiceTime1(String service1) {
		serviceTime1.setText(service1);
	}
	
	public void setEmptyTime1(String empty1) {
		emptyQueue1.setText(empty1);
	}
	
	public void setPeakHour1(String hour1) {
		peakHour1.setText(hour1);
	}
	
	public void setWaitingTime2(String waiting2) {
		waitingTime2.setText(waiting2);
	}
	
	public void setServiceTime2(String service2) {
		serviceTime2.setText(service2);
	}
	
	public void setEmptyTime2(String empty2) {
		emptyQueue2.setText(empty2);
	}
	
	public void setPeakHour2(String hour2) {
		peakHour2.setText(hour2);
	}
	
	public void setWaitingTime3(String waiting3) {
		waitingTime3.setText(waiting3);
	}
	
	public void setServiceTime3(String service3) {
		serviceTime3.setText(service3);
	}
	
	public void setEmptyTime3(String empty3) {
		emptyQueue3.setText(empty3);
	}
	
	public void setPeakHour3(String hour3) {
		peakHour3.setText(hour3);
	}

	public void setSimulationService1(String service1) {
		simulationQueue1Servicetime.setText(service1);
	}
	
	public void setSimulationService2(String service2) {
		simulationQueue2Servicetime.setText(service2);
	}
	
	public void setSimulationService3(String service3) {
		simulationQueue3Servicetime.setText(service3);
	}
	
	public void setSimulationWaiting1(String waiting1) {
		simulationQueue1Waitingtime.setText(waiting1);
	}
	
	public void setSimulationWaiting2(String waiting2) {
		simulationQueue2Waitingtime.setText(waiting2);
	}
	
	public void setSimulationWaiting3(String waiting3) {
		simulationQueue3Waitingtime.setText(waiting3);
	}
	
	public void addStartListener(ActionListener listener) {
		button.addActionListener(listener);
	}
	
}

