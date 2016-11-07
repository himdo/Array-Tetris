package com.himdo.tetris;

import javax.swing.JPanel;

public class Thread_Repaint extends Thread {
	private MyPanel PlayingBoard;
	private FuturePiecePanel NextBoard;
	
	public Thread_Repaint(MyPanel gameBoardPanel, FuturePiecePanel futurePiece) {
		PlayingBoard = gameBoardPanel;
		NextBoard = futurePiece;
	}
	
	public void run() {
		while(true){
			try {
				PlayingBoard.repaint();
				//int nextPiece = Thread_GamePlaying.nextPiece;
				NextBoard.repaint();
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}