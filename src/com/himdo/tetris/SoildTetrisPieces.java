package com.himdo.tetris;

public class SoildTetrisPieces {
	public static int[][] solidPieces = new int [VarSizes.sizeX][VarSizes.sizeY];
	public static int[][] getSolidPieces() {
		return solidPieces;
	}
	public static void setSolidPieces(int[][] solidPieces) {
		SoildTetrisPieces.solidPieces = solidPieces;
	}
}
