package com.himdo.tetris;

public class varSizes {
	public static int sizeX = 10;
	public static int sizeY = 30;
	public static int currentX=sizeX/2;
	public static int currentY=0;
	public static int [][] gameBoard = new int[sizeX][sizeY];
	
	public static void setGameBoard(int[][] gameBoard) {
		varSizes.gameBoard = gameBoard;
	}
	
	public static int[][] getGameBoard() {
		return gameBoard;
	}
	
}
