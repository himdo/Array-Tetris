package com.himdo.tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;

public class myPanel extends Panel {
	
	int width = 0;
	int height = 0;
	public void paintSpot(Graphics g){
		g.setColor(Color.RED);
		for(int x=0;x<varSizes.sizeX;x++){
			for(int y = 0; y<varSizes.sizeY;y++){
				if(varSizes.gameBoard[x][y]==1){
					g.fillRect((x*width)/varSizes.sizeX, (y*height)/varSizes.sizeY, width/varSizes.sizeX, height/varSizes.sizeY);
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
		for(int i = 0; i<varSizes.sizeX; i++){
			g.drawLine((width*(i+1))/varSizes.sizeX, 0, (width*(i+1))/varSizes.sizeX, height);
		}
		
		//draw the y line
		for(int i = 0; i<varSizes.sizeY; i++){
			g.drawLine(0, (height*(i+1))/varSizes.sizeY, width, (height*(i+1))/varSizes.sizeY);
		}
		
	}
	
	private void paintPeices(Graphics g) {
		g.setColor(Color.GREEN);
		for(int x=0;x<varSizes.sizeX;x++){
			for(int y = 0; y<varSizes.sizeY;y++){
				if(soildTetrisPeices.solidPieces[x][y]==2){
					System.out.println("found");
					g.fillRect((x*width)/varSizes.sizeX, (y*height)/varSizes.sizeY, width/varSizes.sizeX, height/varSizes.sizeY);
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
		paintPeices(g);
		super.paint(g);
	}
	
}
