package com.himdo.tetris;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class FuturePiecePanel extends JComponent{
	@Override
	public void paint(Graphics g) {
		
		int next = Thread_GamePlaying.nextPiece;

		int width = (int) getSize().getWidth()-1;
		int height = (int) getSize().getHeight()-1;
		int size = height/6;
		
		g.setColor(Color.RED);
	
		int [] bounds = Pieces.getPieceSize(next);
		int [][]piece = Pieces.getPieceShadow(next, 0, false);
		for(int x=0; x<4;x++){//bounds[0]-1;x++){
			int xspot= (piece[x][0]*size);
			int yspot=(piece[x][1]*size);
			g.drawRect(xspot+(width/2-size), yspot, size, size);
			
		}
		
		g.drawString("Next Piece: "+next+"", 5, height/2);
		
		g.setColor(Color.BLACK);
		
		super.paint(g);
	}

}
