package com.himdo.tetris;

public class Pieces {
	
	public static int[][] getPieceBounds(int number){
		int[][] piece = new int[4][2];
		switch(number){
			case 0://O
				piece[0][0]=VarSizes.currentX; 		piece[0][1]=VarSizes.currentY;
				piece[1][0]=VarSizes.currentX; 		piece[1][1]=VarSizes.currentY+1;
				piece[2][0]=VarSizes.currentX+1;	piece[2][1]=VarSizes.currentY;
				piece[3][0]=VarSizes.currentX+1;	piece[3][1]=VarSizes.currentY+1;
				
				return piece;
			case 1://I
				piece[0][0]=VarSizes.currentX; 		piece[0][1]=VarSizes.currentY;
				piece[1][0]=VarSizes.currentX; 		piece[1][1]=VarSizes.currentY+1;
				piece[2][0]=VarSizes.currentX;		piece[2][1]=VarSizes.currentY+2;
				piece[3][0]=VarSizes.currentX;		piece[3][1]=VarSizes.currentY+3;
				
				return piece;
			case 2://"T"
				piece[0][0]=VarSizes.currentX; 		piece[0][1]=VarSizes.currentY+1;
				piece[1][0]=VarSizes.currentX+1;	piece[1][1]=VarSizes.currentY;
				piece[2][0]=VarSizes.currentX+1;	piece[2][1]=VarSizes.currentY+1;
				piece[3][0]=VarSizes.currentX+1;	piece[3][1]=VarSizes.currentY+2;
				
				return piece;
			case 3://"J"
				piece[0][0]=VarSizes.currentX; 		piece[0][1]=VarSizes.currentY;
				piece[1][0]=VarSizes.currentX; 		piece[1][1]=VarSizes.currentY+1;
				piece[2][0]=VarSizes.currentX;		piece[2][1]=VarSizes.currentY+2;
				piece[3][0]=VarSizes.currentX+1;	piece[3][1]=VarSizes.currentY+2;
				
				return piece;
			case 4://"L"
				piece[0][0]=VarSizes.currentX; 		piece[0][1]=VarSizes.currentY;
				piece[1][0]=VarSizes.currentX; 		piece[1][1]=VarSizes.currentY+1;
				piece[2][0]=VarSizes.currentX;		piece[2][1]=VarSizes.currentY+2;
				piece[3][0]=VarSizes.currentX+1;	piece[3][1]=VarSizes.currentY;
				
				return piece;
			
			case 5://"S"
				piece[0][0]=VarSizes.currentX; 		piece[0][1]=VarSizes.currentY+1;
				piece[1][0]=VarSizes.currentX; 		piece[1][1]=VarSizes.currentY+2;
				piece[2][0]=VarSizes.currentX+1;	piece[2][1]=VarSizes.currentY;
				piece[3][0]=VarSizes.currentX+1;	piece[3][1]=VarSizes.currentY+1;
				
				return piece;
				
			case 6://"Z"
				piece[0][0]=VarSizes.currentX+1; 	piece[0][1]=VarSizes.currentY+1;
				piece[1][0]=VarSizes.currentX+1;	piece[1][1]=VarSizes.currentY+2;
				piece[2][0]=VarSizes.currentX;		piece[2][1]=VarSizes.currentY;
				piece[3][0]=VarSizes.currentX;		piece[3][1]=VarSizes.currentY+1;
				
				return piece;
				
			}
		return null;
	}
	
	public static int[] getPieceSize(int number){
		int[] size = new int[2];
		//[0]=width [1]=hieght
		
		switch(number){
			case 0:
				size[0]=size[1]=2;
				return size;
			case 1:
				size[0]=1; 
				size[1]=4;
				return size;
			case 2:
				size[0]=2;
				size[1]=3;
				return size;
			case 3:
				size[0]=2;
				size[1]=3;
				return size;
			case 4:
				size[0]=2;
				size[1]=3;
				return size;
			case 5:
				size[0]=2;
				size[1]=3;
				
				return size;
			case 6:
				size[0]=2;
				size[1]=3;
				
				return size;
				
		}
		return null;
		
	}
	public static int[][] summonPiece(int number,int setter){
		
		//square = 0
		//line = 1
		//"t" = 2
		//"j" = 3
		//"L" = 4
		//"S" = 5
		//"Z" = 6
		int [][] piece = new int[VarSizes.sizeX][VarSizes.sizeY];
		switch(number){
			case 0://O
				piece[VarSizes.currentX][VarSizes.currentY]=piece[VarSizes.currentX][VarSizes.currentY+1]=piece[VarSizes.currentX+1][VarSizes.currentY]=piece[VarSizes.currentX+1][VarSizes.currentY+1]=setter;
				return piece;
			case 1://I
				piece[VarSizes.currentX][VarSizes.currentY]=piece[VarSizes.currentX][VarSizes.currentY+1]=piece[VarSizes.currentX][VarSizes.currentY+2]=piece[VarSizes.currentX][VarSizes.currentY+3]=setter;
				return piece;
			case 2://"T"
				piece[VarSizes.currentX][VarSizes.currentY+1]=piece[VarSizes.currentX+1][VarSizes.currentY]=piece[VarSizes.currentX+1][VarSizes.currentY+1]=piece[VarSizes.currentX+1][VarSizes.currentY+2]=setter;
				return piece;
			case 3://"J"
				piece[VarSizes.currentX][VarSizes.currentY]=piece[VarSizes.currentX][VarSizes.currentY+1]=piece[VarSizes.currentX][VarSizes.currentY+2]=piece[VarSizes.currentX+1][VarSizes.currentY+2]=setter;
				return piece;
			case 4://"L"
				piece[VarSizes.currentX][VarSizes.currentY]=piece[VarSizes.currentX][VarSizes.currentY+1]=piece[VarSizes.currentX][VarSizes.currentY+2]=piece[VarSizes.currentX+1][VarSizes.currentY]=setter;
				return piece;
			
			case 5://"S"
				piece[VarSizes.currentX][VarSizes.currentY+1]=piece[VarSizes.currentX][VarSizes.currentY+2]=piece[VarSizes.currentX+1][VarSizes.currentY]=piece[VarSizes.currentX+1][VarSizes.currentY+1]=setter;
				return piece;
				
			case 6://"Z"
				piece[VarSizes.currentX+1][VarSizes.currentY+1]=piece[VarSizes.currentX+1][VarSizes.currentY+2]=piece[VarSizes.currentX][VarSizes.currentY]=piece[VarSizes.currentX][VarSizes.currentY+1]=setter;
				return piece;
				
			}
		return null;
	}
}
