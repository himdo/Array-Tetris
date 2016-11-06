package com.himdo.tetris;

@SuppressWarnings("unused")
public class Thread_GamePlaying extends Thread {
	
	private Thread t;
	private String threadName;
	private MyPanel board;
	
	public static int piece;
	public Thread_GamePlaying(String name, MyPanel gameBoardPanel) {
		threadName = name;
		board = gameBoardPanel;
	}
	public void run() {
		while(true){
			
			piece = (int) (Math.random()*7);
			VarSizes.currentY=0;
			VarSizes.currentX=VarSizes.sizeX/2-1;
			int[][] tempBoard = SoildTetrisPieces.getSolidPieces();
			while(true){
				try {
					if(VarSizes.currentY+Pieces.getPieceSize(piece)[1]!=VarSizes.sizeY){
						//check if below the piece is solid
						
						if((SoildTetrisPieces.solidPieces[Pieces.getPieceBounds(piece)[0][0]] [Pieces.getPieceBounds(piece)[0][1]+1]==0))
							if(SoildTetrisPieces.solidPieces[Pieces.getPieceBounds(piece)[1][0]] [Pieces.getPieceBounds(piece)[1][1]+1]==0)
								if(SoildTetrisPieces.solidPieces[Pieces.getPieceBounds(piece)[2][0]] [Pieces.getPieceBounds(piece)[2][1]+1]==0)
									if(SoildTetrisPieces.solidPieces[Pieces.getPieceBounds(piece)[3][0]] [Pieces.getPieceBounds(piece)[3][1]+1]==0){
										VarSizes.currentY+=1;
										VarSizes.setGameBoard(Pieces.summonPiece(piece,1));
									}else break;
								else break;
							else break;
						else break;
					}else break;
					//board.repaint();
					Thread.sleep(250);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tempBoard[Pieces.getPieceBounds(piece)[0][0]] [Pieces.getPieceBounds(piece)[0][1]]=2;
			tempBoard[Pieces.getPieceBounds(piece)[1][0]] [Pieces.getPieceBounds(piece)[1][1]]=2;
			tempBoard[Pieces.getPieceBounds(piece)[2][0]] [Pieces.getPieceBounds(piece)[2][1]]=2;
			tempBoard[Pieces.getPieceBounds(piece)[3][0]] [Pieces.getPieceBounds(piece)[3][1]]=2;
			
		
			SoildTetrisPieces.setSolidPieces(tempBoard);
			
			Pieces.removeRow();
			
			Pieces.RotateReset();
			
			//board.repaint();
		}
	}
}
