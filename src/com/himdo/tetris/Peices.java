package com.himdo.tetris;

public class Peices {
	//int [] peiceNumber = new int [7];
	
	public static int[] getPeiceSize(int number){
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
	public static int[][] summonPeice(int number,int setter){
		
		//square = 0
		//line = 1
		//"t" = 2
		//"j" = 3
		//"L" = 4
		//"S" = 5
		//"Z" = 6
		int [][] peice = new int[varSizes.sizeX][varSizes.sizeY];
		switch(number){
			case 0://O
				peice[varSizes.currentX][varSizes.currentY]=peice[varSizes.currentX][varSizes.currentY+1]=peice[varSizes.currentX+1][varSizes.currentY]=peice[varSizes.currentX+1][varSizes.currentY+1]=setter;
				return peice;
			case 1://I
				peice[varSizes.currentX][varSizes.currentY]=peice[varSizes.currentX][varSizes.currentY+1]=peice[varSizes.currentX][varSizes.currentY+2]=peice[varSizes.currentX][varSizes.currentY+3]=setter;
				return peice;
			case 2://"T"
				peice[varSizes.currentX][varSizes.currentY+1]=peice[varSizes.currentX+1][varSizes.currentY]=peice[varSizes.currentX+1][varSizes.currentY+1]=peice[varSizes.currentX+1][varSizes.currentY+2]=setter;
				return peice;
			case 3://"J"
				peice[varSizes.currentX][varSizes.currentY]=peice[varSizes.currentX][varSizes.currentY+1]=peice[varSizes.currentX][varSizes.currentY+2]=peice[varSizes.currentX+1][varSizes.currentY+2]=setter;
				return peice;
			case 4://"L"
				peice[varSizes.currentX][varSizes.currentY]=peice[varSizes.currentX][varSizes.currentY+1]=peice[varSizes.currentX][varSizes.currentY+2]=peice[varSizes.currentX+1][varSizes.currentY]=setter;
				return peice;
			
			case 5://"S"
				peice[varSizes.currentX][varSizes.currentY+1]=peice[varSizes.currentX][varSizes.currentY+2]=peice[varSizes.currentX+1][varSizes.currentY]=peice[varSizes.currentX+1][varSizes.currentY+1]=setter;
				return peice;
				
			case 6://"Z"
				peice[varSizes.currentX+1][varSizes.currentY+1]=peice[varSizes.currentX+1][varSizes.currentY+2]=peice[varSizes.currentX][varSizes.currentY]=peice[varSizes.currentX][varSizes.currentY+1]=setter;
				return peice;
				
			}
		return null;
	}
}
