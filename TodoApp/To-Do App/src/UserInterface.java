import java.util.Scanner;

public class UserInterface {
private final Scanner scanner;
private final TodoList todoList;


public UserInterface(TodoList todoList, Scanner scan) {
	this.scanner = scan;
	this.todoList = todoList;

}

public void start() {
	System.out.println("===To Deux===");
	System.out.println("To begin: (A)dd a task or (I)mport a previous List. (H)elp for commands");

	label:
	while (true) {

		System.out.print("Command: ");
		String command = scanner.nextLine().toLowerCase();
//TODO: Create a command Class and use a switch/case to move all this code out of the UI
		switch (command) {
			case "stop":
			case "quit":
			case "q":
			case "exit":
				break label;

			case "add":
			case "a":
				System.out.print("Task to add (!B to go cancel): ");
				String task = scanner.nextLine();
				if (task.equals("!B") || task.equals("!b")) {
					System.out.println();
				} else {
					this.todoList.add(task);
				}

				break;
			case "export":
			case "e":
				Utility utility = new Utility();
				utility.createFile(this.todoList);

				break;
			case "list":
			case "l":
				if (this.todoList.size() == 0) {
					System.out.println("There are no tasks! (A)dd one now?");
				} else {
					this.todoList.print();
				}

				break;
			case "mark":
			case "m":
				if (this.todoList.size() == 0) {
					System.out.println("There are no tasks! (A)dd one now?");
				} else {
					this.todoList.print();
					int number = 0;
					System.out.print("Please enter a number: ");
					if (this.scanner.hasNextInt()) {
						number = scanner.nextInt();
						this.scanner.nextLine();
						if (number <= 0 || number > this.todoList.size()) {
							System.out.println("Invalid number!");
						} else {
							this.todoList.markComplete(number);
						}
					}
				}

				break;
			case "remove":
			case "r":
				this.todoList.print();
				int number = 0;
				System.out.print("Item # to remove: ");
				if (this.scanner.hasNextInt()) {
					number = scanner.nextInt();
					this.scanner.nextLine();
				}
				if (number <= 0 || number > this.todoList.size()) {
					System.out.println("Invalid number!");
				} else {
					this.todoList.remove(number);
				}

				break;
			case "clear":
			case "c":
				System.out.print("Are you sure you want to clear all items? Y/N? ");
				String confirm = scanner.nextLine().toLowerCase();
				if (confirm.equals("yes") || confirm.equals("y")) {
					while (todoList.size() > 0) {
						this.todoList.remove(1);
					}
				}

				break;
			case "help":
			case "h":
				System.out.println("Commands:");
				System.out.println("(A)dd a task");
				System.out.println("(M)ark a tasked completed");
				System.out.println("(R)emove a task from the list");
				System.out.println("(L)ist all tasks");
				System.out.println("(E)xport the task list");
				System.out.println("(C)lear all tasks from the list");
				System.out.println("(Q)uit");

				break;
			default:
				System.out.println("Invalid command");
				break;
		}
		}
}
}


