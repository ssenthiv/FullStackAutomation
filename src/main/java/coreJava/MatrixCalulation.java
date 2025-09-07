package coreJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MatrixCalulation {

	
	public static void main(String args[]){
		
		MatrixCalulation mc=new MatrixCalulation();
		List<Integer> rowColList2=new ArrayList<>();
		
		rowColList2=mc.readInput();
		mc.calculate(rowColList2);
		
		//System.exit(0);
	}
	public List readInput(){
		
		
		
		
		InputStreamReader isr =new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int row=0, col=0;
		List<Integer> rowColList=new ArrayList<>();
		String str=null;
		System.out.println("Enter row size");
		try {
			
			str=br.readLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		
		row=Integer.parseInt(str);
		
		rowColList.add(row);
		System.out.println("row :"+ row);
		
		
		
		// read input suing InputStreamReader
		
		System.out.println("Enter Column Size");
		try {
			col=isr.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		str = ""+(char)col;
		col=Integer.parseInt(str);
		rowColList.add(col);
		System.out.println("Column :"+ col);
		
		return rowColList;
		
		
		
		
		
	}
	public void calculate( List rowColList){
		
		int row = (int) rowColList.get(0);
		int col = (int) rowColList.get(1);
		
		System.out.println("Row :"+ row);
		System.out.println("Col :"+ col);
		
		int[][] m1 = new int[row][col];
		int[][] m2 = new int[col][row];
		int[][] r = new int[row][col];
		
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//Read first matrix
		System.out.println("Enter the elements for 1st Matrix");
		for (int i=0; i<row; i++){
			
			for (int j=0;j<col; j++){
				
				try {
					m1[i][j]= Integer.parseInt(br.readLine());
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
			}
		}
		
		//Read second matrix
		System.out.println("Enter the elements for 2nd Matrix");
				for (int i=0; i<col; i++){
					
					for (int j=0;j<row; j++){
						
						try {
							m2[i][j]= Integer.parseInt(br.readLine());
						} catch (IOException e) {
							
							e.printStackTrace();
						}
						
					}
				}
		
		// Print 1st matrix
		
		System.out.println("Matrix 1");
		for (int i=0; i<row; i++){
			
			for (int j=0;j<col; j++){
				
				System.out.print(m1[i][j]+ " ");
				
			}
			System.out.println();
		}
		// print 2nd matrix
		System.out.println("Matrix 2");
		for (int i=0; i<col; i++){
			
			for (int j=0;j<row; j++){
				
				System.out.print(m2[i][j]+ " ");
				
			}
			System.out.println();
		}
		
		
		System.out.println("Result ");
		for (int i=0;i<row;i++){
			
			for(int j=0;j<col;j++){
				
				r[i][j] = m1[i][j] + m2[j][i];
				
				System.out.print(r[i][j] + " ");
			}
			System.out.println("");
		}
		
}
	public void dummy(){

		int[][] m1 ={{1,2,3},
				     {3,4,3}};
		int[][] m2 = {{11,12},
				     {13,14},
				     {15,16}
				     };
		
		int row =2, col =3;
		int[][] r = new int[row][col];
		
		System.out.println("Row len :" + m1.length);
		System.out.println("Col len :" + m1[0].length);
		
		for (int i=0;i<2;i++){
			
			for(int j=0;j<3;j++){
				
				r[i][j] = m1[i][j] + m2[j][i];
				
				System.out.print(r[i][j] + " ");
			}
			System.out.println("");
		}
		
	}
	
}
