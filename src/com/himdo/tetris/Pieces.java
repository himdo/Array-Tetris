package com.himdo.tetris;

public class Pieces {
	
	private static int Rotated=0;
	
	public static int getRotatedValue(){
		return Rotated;
	}
	
	public static void RotateLeft(){
		Rotated--;
		if(Rotated<0){
			Rotated=3;
		}
	}
	
	public static void RotateRight(){
		Rotated++;
		if(Rotated>3){
			Rotated=0;
		}
	}
	
	public static void RotateReset(){
		Rotated = 0;
	}
	
	public static void removeRow(){
		int [][] board = SoildTetrisPieces.getSolidPieces();
		//check rows and columns to see if they can be deleted
		//TODO optimize by only checking the rows that the piece affected
		for(int y = 0;y<VarSizes.sizeY;y++){
			for(int x = 0; x<VarSizes.sizeX;x++){
				//row is not clear
				if(board[x][y]==0){
					break;
				}else if(x==VarSizes.sizeX-1){
					//clear full row
					for(int row = 0; row< VarSizes.sizeX;row++){
						board[row][y]=0;
					}
					//pull the pieces down
					for(int rowY = y;rowY!=0;rowY--){
						for(int rowX=0;rowX<VarSizes.sizeX;rowX++){
							board[rowX][rowY]=board[rowX][rowY-1];
						}
					}
				}
			}
		}
		//fill the board back in
		SoildTetrisPieces.setSolidPieces(board);
		
	}
	
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
				if(Rotated==0||Rotated==2){
					piece[0][0]=VarSizes.currentX; 		piece[0][1]=VarSizes.currentY;
					piece[1][0]=VarSizes.currentX; 		piece[1][1]=VarSizes.currentY+1;
					piece[2][0]=VarSizes.currentX;		piece[2][1]=VarSizes.currentY+2;
					piece[3][0]=VarSizes.currentX;		piece[3][1]=VarSizes.currentY+3;
				}
				else if(Rotated==1||Rotated==3){
					piece[0][0]=VarSizes.currentX; 		piece[0][1]=VarSizes.currentY;
					piece[1][0]=VarSizes.currentX+1;	piece[1][1]=VarSizes.currentY;
					piece[2][0]=VarSizes.currentX+2;	piece[2][1]=VarSizes.currentY;
					piece[3][0]=VarSizes.currentX+3;	piece[3][1]=VarSizes.currentY;
				}
				return piece;
			case 2://"T"
				if(Rotated==0){
					piece[0][0]=VarSizes.currentX; 		piece[0][1]=VarSizes.currentY+1;
					piece[1][0]=VarSizes.currentX+1;	piece[1][1]=VarSizes.currentY;
					piece[2][0]=VarSizes.currentX+1;	piece[2][1]=VarSizes.currentY+1;
					piece[3][0]=VarSizes.currentX+1;	piece[3][1]=VarSizes.currentY+2;
				}else if(Rotated==1){
					piece[0][0]=VarSizes.currentX; 		piece[0][1]=VarSizes.currentY+1;
					piece[1][0]=VarSizes.currentX+1;	piece[1][1]=VarSizes.currentY;
					piece[2][0]=VarSizes.currentX+1;	piece[2][1]=VarSizes.currentY+1;
					piece[3][0]=VarSizes.currentX+2;	piece[3][1]=VarSizes.currentY+1;
				}else if(Rotated==2){
					piece[0][0]=VarSizes.currentX+1;	piece[0][1]=VarSizes.currentY+1;
					piece[1][0]=VarSizes.currentX;	piece[1][1]=VarSizes.currentY;
					piece[2][0]=VarSizes.currentX;	piece[2][1]=VarSizes.currentY+1;
					piece[3][0]=VarSizes.currentX;	piece[3][1]=VarSizes.currentY+2;
				}else if(Rotated==3){
					piece[0][0]=VarSizes.currentX; 		piece[0][1]=VarSizes.currentY+1;
					piece[1][0]=VarSizes.currentX+1;	piece[1][1]=VarSizes.currentY+2;
					piece[2][0]=VarSizes.currentX+1;	piece[2][1]=VarSizes.currentY+1;
					piece[3][0]=VarSizes.currentX+2;	piece[3][1]=VarSizes.currentY+1;
				}
				return piece;
			case 3://"J"
				if(Rotated==0){
					piece[0][0]=VarSizes.currentX;	piece[0][1]=VarSizes.currentY;
					piece[1][0]=VarSizes.currentX;	piece[1][1]=VarSizes.currentY+1;
					piece[2][0]=VarSizes.currentX;	piece[2][1]=VarSizes.currentY+2;
					piece[3][0]=VarSizes.currentX+1;	piece[3][1]=VarSizes.currentY+2;
				}else if(Rotated==1){
					piece[0][0]=VarSizes.currentX;		piece[0][1]=VarSizes.currentY;
					piece[1][0]=VarSizes.currentX+1;	piece[1][1]=VarSizes.currentY;
					piece[2][0]=VarSizes.currentX+2;	piece[2][1]=VarSizes.currentY;
					piece[3][0]=VarSizes.currentX;		piece[3][1]=VarSizes.currentY+1;
				}else if(Rotated==2){
					piece[0][0]=VarSizes.currentX+1;	piece[0][1]=VarSizes.currentY;
					piece[1][0]=VarSizes.currentX+1;	piece[1][1]=VarSizes.currentY+1;
					piece[2][0]=VarSizes.currentX+1;	piece[2][1]=VarSizes.currentY+2;
					piece[3][0]=VarSizes.currentX;		piece[3][1]=VarSizes.currentY;
				}else if(Rotated==3){
					piece[0][0]=VarSizes.currentX;		piece[0][1]=VarSizes.currentY+1;
					piece[1][0]=VarSizes.currentX+1;	piece[1][1]=VarSizes.currentY+1;
					piece[2][0]=VarSizes.currentX+2;	piece[2][1]=VarSizes.currentY+1;
					piece[3][0]=VarSizes.currentX+2;	piece[3][1]=VarSizes.currentY;
				}
				return piece;
			case 4://"L"
				if(Rotated==0){
					piece[0][0]=VarSizes.currentX+1;	piece[0][1]=VarSizes.currentY;
					piece[1][0]=VarSizes.currentX+1;	piece[1][1]=VarSizes.currentY+1;
					piece[2][0]=VarSizes.currentX+1;	piece[2][1]=VarSizes.currentY+2;
					piece[3][0]=VarSizes.currentX;		piece[3][1]=VarSizes.currentY+2;
				}else if(Rotated==1){
					piece[0][0]=VarSizes.currentX;		piece[0][1]=VarSizes.currentY;
					piece[1][0]=VarSizes.currentX;		piece[1][1]=VarSizes.currentY+1;
					piece[2][0]=VarSizes.currentX+1;	piece[2][1]=VarSizes.currentY+1;
					piece[3][0]=VarSizes.currentX+2;	piece[3][1]=VarSizes.currentY+1;
				}else if(Rotated==2){
					piece[0][0]=VarSizes.currentX;		piece[0][1]=VarSizes.currentY;
					piece[1][0]=VarSizes.currentX;		piece[1][1]=VarSizes.currentY+1;
					piece[2][0]=VarSizes.currentX;		piece[2][1]=VarSizes.currentY+2;
					piece[3][0]=VarSizes.currentX+1;	piece[3][1]=VarSizes.currentY;
				}else if(Rotated==3){
					piece[0][0]=VarSizes.currentX;		piece[0][1]=VarSizes.currentY;
					piece[1][0]=VarSizes.currentX+1;	piece[1][1]=VarSizes.currentY;
					piece[2][0]=VarSizes.currentX+2;	piece[2][1]=VarSizes.currentY;
					piece[3][0]=VarSizes.currentX+2;	piece[3][1]=VarSizes.currentY+1;	
				}
				
				return piece;
			
			case 5://"S"
				if(Rotated==0||Rotated==2){
					piece[0][0]=VarSizes.currentX; 		piece[0][1]=VarSizes.currentY+1;
					piece[1][0]=VarSizes.currentX; 		piece[1][1]=VarSizes.currentY+2;
					piece[2][0]=VarSizes.currentX+1;	piece[2][1]=VarSizes.currentY;
					piece[3][0]=VarSizes.currentX+1;	piece[3][1]=VarSizes.currentY+1;
				}else if(Rotated==1||Rotated==3){
					piece[0][0]=VarSizes.currentX; 		piece[0][1]=VarSizes.currentY;
					piece[1][0]=VarSizes.currentX+1;	piece[1][1]=VarSizes.currentY;
					piece[2][0]=VarSizes.currentX+1;	piece[2][1]=VarSizes.currentY+1;
					piece[3][0]=VarSizes.currentX+2;	piece[3][1]=VarSizes.currentY+1;
				}
				
				return piece;
				
			case 6://"Z"
				if(Rotated==0||Rotated==2){
					piece[0][0]=VarSizes.currentX+1; 	piece[0][1]=VarSizes.currentY+1;
					piece[1][0]=VarSizes.currentX+1;	piece[1][1]=VarSizes.currentY+2;
					piece[2][0]=VarSizes.currentX;		piece[2][1]=VarSizes.currentY;
					piece[3][0]=VarSizes.currentX;		piece[3][1]=VarSizes.currentY+1;
				}else if(Rotated==1||Rotated==3){
					piece[0][0]=VarSizes.currentX;	 	piece[0][1]=VarSizes.currentY+1;
					piece[1][0]=VarSizes.currentX+1;	piece[1][1]=VarSizes.currentY+1;
					piece[2][0]=VarSizes.currentX+1;	piece[2][1]=VarSizes.currentY;
					piece[3][0]=VarSizes.currentX+2;	piece[3][1]=VarSizes.currentY;
				}
				
				return piece;
				
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
				if(Rotated==0||Rotated==2){
					piece[VarSizes.currentX][VarSizes.currentY]=piece[VarSizes.currentX][VarSizes.currentY+1]=piece[VarSizes.currentX][VarSizes.currentY+2]=piece[VarSizes.currentX][VarSizes.currentY+3]=setter;					
				}else if(Rotated==1||Rotated==3){
					piece[VarSizes.currentX][VarSizes.currentY]=piece[VarSizes.currentX+1][VarSizes.currentY]=piece[VarSizes.currentX+2][VarSizes.currentY]=piece[VarSizes.currentX+3][VarSizes.currentY]=setter;						
				}
				return piece;
			case 2://"T"
				if(Rotated==0){
					piece[VarSizes.currentX][VarSizes.currentY+1]=piece[VarSizes.currentX+1][VarSizes.currentY]=piece[VarSizes.currentX+1][VarSizes.currentY+1]=piece[VarSizes.currentX+1][VarSizes.currentY+2]=setter;
				}else if(Rotated==1){
					piece[VarSizes.currentX][VarSizes.currentY+1]=piece[VarSizes.currentX+1][VarSizes.currentY]=piece[VarSizes.currentX+1][VarSizes.currentY+1]=piece[VarSizes.currentX+2][VarSizes.currentY+1]=setter;
				}else if(Rotated==2){
					piece[VarSizes.currentX+1][VarSizes.currentY+1]=piece[VarSizes.currentX][VarSizes.currentY]=piece[VarSizes.currentX][VarSizes.currentY+1]=piece[VarSizes.currentX][VarSizes.currentY+2]=setter;
				}else if(Rotated==3){
					piece[VarSizes.currentX][VarSizes.currentY+1]=piece[VarSizes.currentX+1][VarSizes.currentY+2]=piece[VarSizes.currentX+1][VarSizes.currentY+1]=piece[VarSizes.currentX+2][VarSizes.currentY+1]=setter;
				}
				return piece;
			case 3://"J"
				if(Rotated==0){
					piece[VarSizes.currentX][VarSizes.currentY]=piece[VarSizes.currentX][VarSizes.currentY+1]=piece[VarSizes.currentX][VarSizes.currentY+2]=piece[VarSizes.currentX+1][VarSizes.currentY+2]=setter;
				}else if(Rotated==1){
					piece[VarSizes.currentX][VarSizes.currentY]=piece[VarSizes.currentX+1][VarSizes.currentY]=piece[VarSizes.currentX+2][VarSizes.currentY]=piece[VarSizes.currentX][VarSizes.currentY+1]=setter;
				}else if(Rotated==2){
					piece[VarSizes.currentX+1][VarSizes.currentY]=piece[VarSizes.currentX+1][VarSizes.currentY+1]=piece[VarSizes.currentX+1][VarSizes.currentY+2]=piece[VarSizes.currentX][VarSizes.currentY]=setter;
				}else if(Rotated==3){
					piece[VarSizes.currentX][VarSizes.currentY+1]=piece[VarSizes.currentX+1][VarSizes.currentY+1]=piece[VarSizes.currentX+2][VarSizes.currentY+1]=piece[VarSizes.currentX+2][VarSizes.currentY]=setter;					
				}
				
				return piece;
			case 4://"L"
				if(Rotated==0){
					piece[VarSizes.currentX+1][VarSizes.currentY]=piece[VarSizes.currentX+1][VarSizes.currentY+1]=piece[VarSizes.currentX+1][VarSizes.currentY+2]=piece[VarSizes.currentX][VarSizes.currentY+2]=setter;
				}else if(Rotated==1){
					piece[VarSizes.currentX][VarSizes.currentY]=piece[VarSizes.currentX][VarSizes.currentY+1]=piece[VarSizes.currentX+1][VarSizes.currentY+1]=piece[VarSizes.currentX+2][VarSizes.currentY+1]=setter;
				}else if(Rotated==2){
					piece[VarSizes.currentX][VarSizes.currentY]=piece[VarSizes.currentX][VarSizes.currentY+1]=piece[VarSizes.currentX][VarSizes.currentY+2]=piece[VarSizes.currentX+1][VarSizes.currentY]=setter;	
				}else if(Rotated==3){
					piece[VarSizes.currentX][VarSizes.currentY]=piece[VarSizes.currentX+1][VarSizes.currentY]=piece[VarSizes.currentX+2][VarSizes.currentY]=piece[VarSizes.currentX+2][VarSizes.currentY+1]=setter;			
				}
				
				return piece;
			
			case 5://"S"
				if(Rotated==0||Rotated==2){
					piece[VarSizes.currentX][VarSizes.currentY+1]=piece[VarSizes.currentX][VarSizes.currentY+2]=piece[VarSizes.currentX+1][VarSizes.currentY]=piece[VarSizes.currentX+1][VarSizes.currentY+1]=setter;
				}else if(Rotated==1||Rotated==3){
					piece[VarSizes.currentX][VarSizes.currentY]=piece[VarSizes.currentX+1][VarSizes.currentY]=piece[VarSizes.currentX+1][VarSizes.currentY+1]=piece[VarSizes.currentX+2][VarSizes.currentY+1]=setter;
				}
				
				return piece;
				
			case 6://"Z"
				if(Rotated==0||Rotated==2){
					piece[VarSizes.currentX+1][VarSizes.currentY+1]=piece[VarSizes.currentX+1][VarSizes.currentY+2]=piece[VarSizes.currentX][VarSizes.currentY]=piece[VarSizes.currentX][VarSizes.currentY+1]=setter;
				}else if(Rotated==1||Rotated==3){
					piece[VarSizes.currentX][VarSizes.currentY+1]=piece[VarSizes.currentX+1][VarSizes.currentY+1]=piece[VarSizes.currentX+1][VarSizes.currentY]=piece[VarSizes.currentX+2][VarSizes.currentY]=setter;
						
				}
				
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
				if(Rotated==0||Rotated==2){
					size[0]=1; 
					size[1]=4;
				}else if(Rotated==1||Rotated==3){
					size[0]=4; 
					size[1]=1;
				}
				return size;
			case 2:
				if(Rotated==0||Rotated==2){
					size[0]=2;
					size[1]=3;
				}else if(Rotated==1||Rotated==3){
					size[0]=3;
					size[1]=2;
				}
				return size;
			case 3:
				if(Rotated==0||Rotated==2){
				size[0]=2;
				size[1]=3;
				}else if(Rotated==1||Rotated==3){
					size[0]=3;
					size[1]=2;
				}
				return size;
			case 4:
				if(Rotated==0||Rotated==2){
				size[0]=2;
				size[1]=3;
				}else if(Rotated==1||Rotated==3){
					size[0]=3;
					size[1]=2;
				}
				return size;
			case 5:
				if(Rotated==0||Rotated==2){
				size[0]=2;
				size[1]=3;
				}else if(Rotated==1||Rotated==3){
					size[0]=3;
					size[1]=2;
				}
				return size;
			case 6:
				if(Rotated==0||Rotated==2){
					size[0]=2;
					size[1]=3;
				}else if(Rotated==1||Rotated==3){
					size[0]=3;
					size[1]=2;	
				}
				return size;
				
		}
		return null;
		
	}
	
}
