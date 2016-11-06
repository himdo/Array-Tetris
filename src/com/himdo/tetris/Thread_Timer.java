package com.himdo.tetris;

import javax.swing.JLabel;

public class Thread_Timer extends Thread{

	JLabel timerText;
	
	int seconds = 0;
	int minutes = 0;
	int hours = 0;
	
	public Thread_Timer(JLabel lblTimer) {
		// TODO Auto-generated constructor stub
		timerText = lblTimer;
	}
	
	public void run(){
		while(true){
			try {
				Thread.sleep(1000);
				seconds++;
				if(seconds>=60){
					seconds = 0;
					minutes++;
				}
				if(minutes>=60){
					minutes = 0;
					hours++;
				}
				
				//String text = timerText.getText();
				StringBuilder newText = new StringBuilder();
				if(minutes<10)
					newText.append("0"+minutes+":");
				else
					newText.append(minutes+":");
				
				if(seconds <10)
					newText.append("0"+seconds);
				else
					newText.append(seconds);
					
				timerText.setText(newText.toString());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
