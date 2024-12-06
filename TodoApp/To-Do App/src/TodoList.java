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

public void print(){
	int i = 1;
	for(String task : this.list){
		System.out.println(i+". "+task);
		i++;;
	}
}
}
	 