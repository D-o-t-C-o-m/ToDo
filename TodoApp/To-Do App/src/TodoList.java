import java.util.ArrayList;

public class TodoList {
private ArrayList<String> list;

public TodoList() {
	this.list = new ArrayList();
}

public int size() {
	return this.list.size();
}

public void add(String task){
	this.list.add(task);
}

public void remove(int number){
	this.list.remove(number-1);
}
public void markComplete(int taskNumber) {
	if(this.list.isEmpty()) {
		System.out.println("List is empty");
	}else if  (taskNumber >= 0 && taskNumber < this.list.size()+1) {
		taskNumber = taskNumber-1;
		String task = this.list.get(taskNumber);
		this.list.set(taskNumber, Utility.applyStrikethrough(task));
	} else {
		System.out.println("Invalid task number. Please enter a new command.");
	}
}

public void print(){
	int i = 1;
	for(String task : this.list){
		System.out.println(i+". "+task);
		i++;;
	}
}
}
	 