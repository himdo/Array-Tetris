package com.himdo.tetris;

public class VarSizes {
	public static int sizeX = 50;
	public static int sizeY = 50;
	public static int currentX=sizeX/2;
	public static int currentY=0;
	public static int [][] gameBoard = new int[sizeX][sizeY];
	
	public static void setGameBoard(int[][] gameBoard) {
		VarSizes.gameBoard = gameBoard;
	}
	
	public static int[][] getGameBoard() {
		return gameBoard;
	}
	
}
