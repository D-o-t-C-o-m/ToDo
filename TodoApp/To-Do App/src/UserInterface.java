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
	System.out.println("To begin: (A)dd a task or (I)mport a previous List. (H)elp for commands");

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
			utility.createFile(this.todoList);

		} else if (command.equals("list") || command.equals("l")) {
			if (this.todoList.size() == 0) {
				System.out.println("There are no tasks! (A)dd one now?");
			} else {
				this.todoList.print();
			}

		} else if (command.equals("mark") || command.equals("m")) {
			if (this.todoList.size() == 0) {
				System.out.println("There are no tasks! (A)dd one now?");
			}else {
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

			} else if (command.equals("remove") || command.equals("r")) {
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

			} else if (command.equals("clear") || command.equals("c")) {
				System.out.print("Are you sure you want to clear all items? Y/N? ");
				String confirm = scanner.nextLine().toLowerCase();
				if (confirm.equals("yes") || confirm.equals("y")) {
					while (todoList.size() > 0) {
						this.todoList.remove(1);
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


