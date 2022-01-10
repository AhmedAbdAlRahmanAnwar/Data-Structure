package eg.edu.alexu.csd.datastructure.stack.cs07;

import java.util.LinkedList;
import java.util.Scanner;
import eg.edu.alexu.csd.datastructure.stack.IStack;

public class StackImplementation implements IStack {

	public LinkedList<Object> list = new LinkedList<>();

	@Override
	public void add(int index, Object element) {
		list.add(index, element);
	}

	@Override
	public Object pop() {
		if (list.size() == 0) {
			throw null;
		} else {
			Object lastObject = list.get(list.size() - 1);
			list.remove(list.size() - 1);
			return lastObject;
		}
	}

	@Override
	public Object peek() {
		if (list.size() == 0) {
			throw null;
		} else {
			return list.get(list.size() - 1);
		}
	}

	@Override
	public void push(Object element) {
		list.add(element);
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public int size() {
		return list.size();
	}

	public void userActions() {
		System.out.println("1: Push\n2: Pop\n3: Peek\n4: Get size\n5: Check if empty");
		System.out.println("====================================================================");
	}

	public void userscreen(StackImplementation application) {

		application.userActions();
		Scanner src = new Scanner(System.in);
		int choice = src.nextInt();
		if (choice == 1) {
			application.firstChoice(application);
		} else if (choice == 2) {
			application.secondChoice(application);
		} else if (choice == 3) {
			application.thirdChoice(application);
		} else if (choice == 4) {
			application.forthChoice(application);
		} else if (choice == 5) {
			application.fifthChoice(application);
		}
		src.close();
	}

	public void fifthChoice(StackImplementation application) {

		if (application.size() == 0) {
			System.out.println("stack is empty");
			System.out.println("====================================================================");
			application.userscreen(application);
		} else {
			System.out.println("stack isnot empty");
			System.out.println("====================================================================");
			application.userscreen(application);
		}
	}

	public void forthChoice(StackImplementation application) {

		System.out.println("stack size is " + application.size());
		System.out.println("====================================================================");
		application.userscreen(application);
	}

	public void thirdChoice(StackImplementation application) {

		if (application.size() == 0) {
			System.out.println("stack is empty");
			System.out.println("====================================================================");
			application.userscreen(application);
		} else {
			Object element = application.peek();
			System.out.println("you peeked (" + element + ") from stack");
			System.out.println("====================================================================");
			application.userscreen(application);
		}
	}

	public void secondChoice(StackImplementation application) {

		if (application.size() == 0) {
			System.out.println("stack is empty");
			System.out.println("====================================================================");
			application.userscreen(application);
		} else {
			Object element = application.pop();
			System.out.println("you poped (" + element + ") from stack");
			System.out.println("====================================================================");
			application.userscreen(application);
		}
	}

	public void firstChoice(StackImplementation application) {

		Scanner src = new Scanner(System.in);
		System.out.println("Insert the element to push:");
		int element = src.nextInt();
		application.push(element);
		System.out.println("successfully pushed");
		System.out.println("====================================================================");
		application.userscreen(application);
		src.close();
	}

	public static void main(String[] args) {

		StackImplementation mystack = new StackImplementation();
		mystack.userscreen(mystack);
	}
}
