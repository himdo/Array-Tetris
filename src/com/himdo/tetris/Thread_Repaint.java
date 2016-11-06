package com.himdo.tetris;

public class Thread_Repaint extends Thread {
	private MyPanel board;
	
	public Thread_Repaint(MyPanel gameBoardPanel) {
		board = gameBoardPanel;
	}
	
	public void run() {
		while(true){
			try {
				board.repaint();
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}