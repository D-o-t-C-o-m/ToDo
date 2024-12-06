import java.util.Scanner;

public class UserInterface {
private Scanner scanner;
private TodoList todoList;

public UserInterface(TodoList todoList, Scanner scan) {
	this.scanner = scan;
	this.todoList = todoList;
}

public void start() {
	System.out.println("===To Deux===");
	System.out.println("(H)elp for commands");

	while (true) {

		System.out.print("Command: ");
		String command = scanner.nextLine().toLowerCase();

		if (command.equals("stop") || command.equals("quit") || command.equals("q") || command.equals("exit")) {
			break;

		} else if (command.equals("add") || command.equals("a")) {
			System.out.print("Task to add (!B to go cancel): ");
			String task = scanner.nextLine();
			if (task.equals("!B") || task.equals("!b")) {
				System.out.println();
			} else {
				this.todoList.add(task);
			}

		} else if (command.equals("export") || command.equals("e")) {
			Utility utility = new Utility();
			utility.createFile();

	}

	else if (command.equals("list") || command.equals("l")) {
			if(todoList.size() == 0){
				System.out.println("There are no tasks! (A)dd one now?");
			} else {
				todoList.print();
			}

		} else if (command.equals("mark") || command.equals("m")) {
				todoList.print();
			int number = 0;
			if(scanner.hasNextInt()) {
				number = scanner.nextInt();
			} else {
				System.out.println("Please enter a number");
				scanner.nextLine();
				System.out.println();
				continue;
			}
			if (number < 0){
				System.out.println("Invalid number!");
			} else {
			todoList.markComplete(number);
		}

		} else if (command.equals("remove") || command.equals("r")) {
			todoList.print();
			System.out.print("Item # to remove: ");
			int number = 0;
			if(scanner.hasNextInt()) {
				 number = scanner.nextInt();
			} else {
				System.out.println("Please enter a number");
				scanner.nextLine();
				System.out.println();
				continue;
			}
			if (number < 0){
				System.out.println("Invalid number!");
			} else {
				todoList.remove(number);
			}

		} else if (command.equals("clear") || command.equals("c")) {
			System.out.print("Are you sure you want to clear all items? Y/N? ");
			String confirm = scanner.nextLine().toLowerCase();
			if (confirm.equals("yes") || confirm.equals("y")) {
				while (todoList.size() > 0) {
					todoList.remove(1);
				}
			}

		} else if (command.equals("help") || command.equals("h")) {
			System.out.println("Commands:");
			System.out.println("(A)dd a task");
			System.out.println("(M)ark a tasked completed");
			System.out.println("(R)emove a task from the list");
			System.out.println("(L)ist all tasks");
			System.out.println("(E)xport the task list");
			System.out.println("(C)lear all tasks from the list");
			System.out.println("(Q)uit");

		} else {
			System.out.println("Invalid command");
		}
	}
}
}

