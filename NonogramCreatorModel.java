import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NonogramCreatorModel {
	
	private int numRows;
	private int numCols;
	private boolean [][] grid;
	
	public static void main (String [] args) {
		boolean [] cells = {true, false, false, false, true, true, false, false, true};
//		cells[1] = true;
//		cells[4] = true;
		List<Integer> list = project(cells);
		System.out.println(list);
		
	}
	
	public NonogramCreatorModel(int numRows, int numCols) {
		if (numRows <= 0 || numCols <= 0) {
			throw new IllegalArgumentException();
		}
		grid = new boolean [numRows] [numCols];
		this.numRows = numRows;
		this.numCols = numCols;
		
	}
	
	public int getNumRows() {
		return numRows;
	}
	
	public int getNumCols() {
		return numCols;
	}
	
	public void setCell(int rowIdx, int colIdx, boolean state) throws IllegalArgumentException {
		grid[rowIdx][colIdx] = state;
		
		
		
		
//		if (rowIdx >= 0 && rowIdx < numRows || colIdx >= 0 || colIdx < numCols) {
//			state = true;
//		}
//		else {
//			state = false;
//		}
	}
	
	public boolean getCell(int rowIdx, int colIdx) {
		return grid [rowIdx] [colIdx];
	}
	
	public static List<Integer> project (boolean[] cells){
		List<Integer> list = new ArrayList<>();
		int trueCounter = 0;
		boolean[] checkFalse = new boolean [cells.length];
		
		Arrays.fill(checkFalse, false);
		
//		if (Arrays.equals(checkFalse, cells)) {
//			list.add(0);
//			return list;
//		}
		
		boolean[] checkT = new boolean[cells.length];
		Arrays.fill(checkT, true);
		
		if (Arrays.equals(checkT, cells)) {
			list.add(cells.length);
			return list;
		}
		
		else if ((Arrays.equals(checkFalse, cells))) {
			list.add(0);
			return list;
		}
		else {
			
			for (int i = 0; i < cells.length; ++i) { 
				if (cells[i] == true) {
					trueCounter++; 
					if (i == cells.length-1) {
						list.add(trueCounter);
					}
				}
				 
				else if (cells[i] == false) {
					if (i > 0 && cells[i-1] == true) {
						list.add(trueCounter);
						trueCounter = 0;
					}
					trueCounter = 0;
				}
				
			}
		
//		for (int i = 0; i < cells.length; i++) {
//			 if (cells[i] == true) {
//				 trueCounter++;
//				 if (cells[i] == true && i == cells.length-1) {
//					list.add(trueCounter);
//					}
//			 }
//			 if (i > 0 && cells[i] == false && cells[i-1] == true) {
//				 if (trueCounter != 0) {
//				 list.add(trueCounter);
//				 }
//				 trueCounter = 0;
//			 }
//		 
//		}
	}
		
	
		
	
//		
		
		
		
		
	
	


//		for (int i = 0; i < cells.length; i++) {
//			 if (cells[i] == true) {
//				 trueCounter++;
//				 if (cells[i] == true && i == cells.length-1) {
//					list.add(trueCounter);
//					}
//			 }
//			 if (i>0 && cells[i] == false && cells[i-1] == true) {
//				 if (trueCounter != 0) {
//				 list.add(trueCounter);
//				 }
//				 trueCounter = 0;
//			 }
//		 
//		}
		
		return list;
	}
	
	public List<Integer> projectRow (int rowIdx){
		
		return project(grid[rowIdx]);
		
	}

	
	public List<Integer> projectCol (int colIdx){
		boolean[] column = getColumn(grid, colIdx);
		return project(column);
	}
	
	public boolean[] getColumn(boolean[][] array, int index){
	    boolean[] column = new boolean[getNumRows()]; 
	    for(int i=0; i<column.length ; i++){
	       column[i] = array[i][index];
	    }
	    return column;
	}
	
	public void savePuzzle (String filename) throws IOException, NullPointerException {
	File f1 = new File(filename);
		
		FileWriter write = new FileWriter (f1, false);
		
		write.write(toString());
		write.close();
		
		
	}
	
	public String toString() {
		StringBuilder sbRow = new StringBuilder();
		StringBuilder sbCol = new StringBuilder();
		String delim = "\n";
		int i = 0;
        while (i < numRows)
        {
            sbRow.append(projectRow(i));
            sbRow.append(delim);
            i++;
        }
        int b = 0;
        while (b < numCols)
        {
            sbCol.append(projectCol(b));
            
            if (b != numRows - 1) {
            sbCol.append(delim);
            }
            b++;
        }

		String res = sbRow.toString();
		String res2 = sbCol.toString();
		
		for (int k = 0; k < res.length(); k++) {
			if (res.charAt(k) == '[' || res.charAt(k) == ']' || res.charAt(k) == ',') {
				res = res.replace("[", "");
				res = res.replace("]", "");
				res = res.replace(",", "");
			}
		}
		
		for (int j = 0; j < res2.length(); j++) {
			if (res2.charAt(j) == '[' || res2.charAt(j) == ']' || res2.charAt(j) == ',') {
				res2 = res2.replace("[", "");
				res2 = res2.replace("]", "");
				res2 = res2.replace(",", "");
			}
		}

		String s = String.valueOf(numRows) + " " +
			String.valueOf(numCols) + 
				System.lineSeparator() +
				res  + 
				res2;
		
		
		return s;
	}

}
	
		
		
		
		
		
		
	
	


