import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Utility {
private Scanner scanner;
private String fileName;
public Utility() {
this.scanner = new Scanner(System.in);
this.fileName = "";
}

public void createFile() {
	System.out.print("enter a file name: ");
	this.fileName = this.scanner.nextLine();
	try {
		File Todo = new File(this.fileName+".txt");
	    if (Todo.createNewFile()) {
			System.out.println("File created: " + Todo.getName());
			writeFile();
		} else {
			System.out.println("File already exists.");
		}
	} catch (IOException e) {
		System.out.println("An error occurred.");
		e.printStackTrace();

	}
}

public void writeFile() {
	TodoList todoList = new TodoList();
	try {
		FileWriter output = new FileWriter(this.fileName+".txt");
		output.write(" ");
		output.close();
	} catch (IOException e) {
		System.out.println("it's fucked");
		e.printStackTrace();
	}
}

public static String applyStrikethrough(String text) {
	return "\u001B[9m" + text + "\u001B[29m";
}

public static String applyBold(String text) {
	return "\u001B[1m" + text + "\u001B[22m";
}

public static String applyItalics(String text) {
	return "\u001B[3m" + text + "\u001B[23m";
}
}