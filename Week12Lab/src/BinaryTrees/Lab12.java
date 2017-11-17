/**
 * 
 */
package BinaryTrees;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author jgsha
 *
 */
public class Lab12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String inputLine;
		File input = new File("C:\\Users\\jgsha\\Desktop\\students.in");
		Scanner inputFile = null;
		int index = 0;
		int ID = 0;
		String name;
		double GPA = 0.0;
		String advisor = null;
		BinarySearchTree tree = new BinarySearchTree();
		String[] tokens = new String[4];

		try {
			inputFile = new Scanner(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (inputFile.hasNext()) {
			index = 0;
			inputLine = inputFile.nextLine();
			tokens = inputLine.split(" ");
			ID = Integer.parseInt(tokens[index++]);
			name = tokens[index++];
			GPA = Double.parseDouble(tokens[index++]);

			if ((index + 1) < tokens.length) {
				advisor = tokens[index];
				GraduateStudentGPA newGrad = new GraduateStudentGPA(ID, name, GPA, advisor);
				tree.insert(newGrad.GPA);
				index++;
			} else {
				StudentGPA newStudent = new StudentGPA(ID, name, GPA);
				tree.insert(newStudent.GPA);
				index++;
			}
		}
		
		TreeIterator iter = new TreeIterator(tree, 1);
		
		iter.printInorder();
	}
}