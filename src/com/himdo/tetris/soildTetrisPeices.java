package com.himdo.tetris;

public class soildTetrisPeices {
	public static int[][] solidPieces = new int [varSizes.sizeX][varSizes.sizeY];
	public static int[][] getSolidPieces() {
		return solidPieces;
	}
	public static void setSolidPieces(int[][] solidPieces) {
		soildTetrisPeices.solidPieces = solidPieces;
	}
}
