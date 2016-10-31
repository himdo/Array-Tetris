package com.himdo.tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;

public class MyPanel extends Panel {
	
	int width = 0;
	int height = 0;
	public void paintSpot(Graphics g){
		g.setColor(Color.RED);
		for(int x=0;x<VarSizes.sizeX;x++){
			for(int y = 0; y<VarSizes.sizeY;y++){
				if(VarSizes.gameBoard[x][y]==1){
					g.fillRect((x*width)/VarSizes.sizeX, (y*height)/VarSizes.sizeY, width/VarSizes.sizeX, height/VarSizes.sizeY);
				}
			}
		}
		g.setColor(Color.BLACK);
	}
	
	private void drawOutline(Graphics g){
		g.drawLine(0, 0, width, 0);
		g.drawLine(0, 0, 0, height);
		g.drawLine(width, 0, width, height);
		g.drawLine(0, height, width, height);
		
	}
	private void paintBoard(Graphics g){
		//draw the game board
		drawOutline(g);
		
		//draws the x line
		for(int i = 0; i<VarSizes.sizeX; i++){
			g.drawLine((width*(i+1))/VarSizes.sizeX, 0, (width*(i+1))/VarSizes.sizeX, height);
		}
		
		//draw the y line
		for(int i = 0; i<VarSizes.sizeY; i++){
			g.drawLine(0, (height*(i+1))/VarSizes.sizeY, width, (height*(i+1))/VarSizes.sizeY);
		}
		
	}
	
	private void paintPieces(Graphics g) {
		g.setColor(Color.GREEN);
		for(int x=0;x<VarSizes.sizeX;x++){
			for(int y = 0; y<VarSizes.sizeY;y++){
				if(SoildTetrisPieces.solidPieces[x][y]==2){
					g.fillRect((x*width)/VarSizes.sizeX, (y*height)/VarSizes.sizeY, width/VarSizes.sizeX, height/VarSizes.sizeY);
				}
			}
		}
		g.setColor(Color.BLACK);
	}
	
	@Override
	public void paint(Graphics g) {
		width = (int) getSize().getWidth()-1;
		height = (int) getSize().getHeight()-1;
		paintBoard(g);
		paintSpot(g);
		paintPieces(g);
		super.paint(g);
	}
	
}
