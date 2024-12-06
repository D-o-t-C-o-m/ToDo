import java.util.Scanner;

public class UserInterface {
private Scanner scanner;
private TodoList todoList;
public UserInterface(TodoList todoList, Scanner scan){
	this.scanner = scan;
	this.todoList = todoList;
}
public void start(){
	System.out.println("Two Deux: Add to Add a Task, List to show a List of Tasks, Remove to remove a task, Stop to exit.");
	while (true) {
		System.out.print("Command: ");
		String command = scanner.nextLine();
		if (command.equals("stop")) {
			break;
		} else if (command.equals("add")) {
			System.out.print("To add: ");
			String task = scanner.nextLine();
			this.todoList.add(task);
		}else if(command.equals("list")) {
			todoList.print();
		} else if (command.equals("remove")) {
			System.out.print("Which one is removed: ");
			int number = Integer.valueOf(scanner.nextLine());
			todoList.remove(number);
			//TODO: Add a mark complete method that strikes out the text but doesn't remvove an item.
		}
	}
}
}