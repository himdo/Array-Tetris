package com.himdo.tetris;


public class updateThread extends Thread {
	
	private Thread t;
	private String threadName;
	private myPanel board;
	
	public static int piece;
	public updateThread(String name, myPanel gameBoardPanel) {
		threadName = name;
		board = gameBoardPanel;
	}
	public void run() {
		while(true){
			piece = (int) (Math.random()*7);
			varSizes.currentY=0;
			varSizes.currentX=varSizes.sizeX/2;
			while(true){
				try {
					
					if(varSizes.currentY+Peices.getPeiceSize(piece)[1]!=varSizes.sizeY){
						varSizes.currentY+=1;
						//varSizes.getGameBoard()+=Peices.summonPeice(piece);
						varSizes.setGameBoard(Peices.summonPeice(piece,1));
					}else break;
					board.repaint();
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			int[][] tempBoard = soildTetrisPeices.getSolidPieces();
			tempBoard[varSizes.currentX][varSizes.currentY]=2;
			soildTetrisPeices.setSolidPieces(Peices.summonPeice(piece,2));
			board.repaint();
		}
	}
}
