/**
 * 
 */
package sEdwardsExercise6;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;




/**
 * @author Shane Edwards 
 * 
 *         Due Date: 11/06/2022
 *         
 *         This program reads from a txt file and creates a 2-dimensional character array that is m * n.
 *         The encrypted output string abides by the following rules: a)On even numbered rows, 
 *         fill the row from the leftmost column to the rightmost, b) On odd numbered rows, 
 *         fill the row from the rightmost column to the leftmost. c) Fill any unused spaces in the 2D array with the ‘*’ character. 
 *         If you have more characters than space, ignore the excess characters.
 *         
 *         This is completely my own work with the following exceptions: NONE
 *         
 *         
 *
 */
public class SEdwardsExercise6 {


	public static String readFile(String fileName) throws IOException {
		Scanner scanner = new Scanner(new File(fileName));
		String content = "";
		while(scanner.hasNextLine()) {
			content += scanner.nextLine();
		}
		return content;
		}
	public static void initializeGrid(char [][] grid, int m, int n) {
		for(int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = '*';
	}
	public static void fillGrid(char [][] grid, int m, int n, String fileName) throws IOException {
		String text = readFile(fileName);
		initializeGrid(grid, m, n);
		int i = 0;
		int j = 0;
		for(int k = 0; k < text.length(); k++) {
			char c = text.charAt(k);
			if(i % 2 == 0) {
				grid[i][j] = c;
				j++;
			}
			else {
				grid[i][n-j-1] = c;
				j++;
			}
			if(j == n) {
				i++;
				j = 0;
			}
			if(i == m) {
				break;
			}
		}
	}
	public static void displayGrid(char [][] grid, int m, int n) {
		for(int j = 0; j < n; j++) {
			for(int i = 0; i < m; i++)
				System.out.print(grid[i][j]);
		}
	}

	
	
	public static void main(String[] args) throws IOException {
		
		String fileName = "input.in";
		int m = 4; int n = 8;
		char grid[][] = new char[m][n];
		fillGrid(grid, m, n, fileName);
		displayGrid(grid, m, n);
	}
}
		

	
		

		

