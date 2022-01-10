package eg.edu.alexu.csd.datastructure.queue.cs07;

import java.util.LinkedList;
import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

public class QueueLinkedBased implements IQueue, ILinkedBased {

	public LinkedList<Object> list = new LinkedList<>();
	
	@Override
	public void enqueue(Object item) {
		list.add(item);
	}

	@Override
	public Object dequeue() {

		if (list.isEmpty()) {
			throw null;
		} else {
			Object element = list.get(0);
			list.remove(0);
			return element;
		}
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public int size() {
		return list.size();
	}

}