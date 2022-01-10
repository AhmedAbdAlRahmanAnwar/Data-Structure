package eg.edu.alexu.csd.datastructure.queue.cs07;

import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

public class QueueArrayBased implements IQueue, IArrayBased {

	public Object[] queue;
	int counter = 0;

	public QueueArrayBased(int num) {
		queue = new Object[num];
	}

	@Override
	public void enqueue(Object item) {

		if (size() < queue.length) {
			queue[counter] = item;
			counter++;
		} else {
			throw null;
		}
	}

	@Override
	public Object dequeue() {

		if (queue.length > 0) {
			counter--;

			if (size() > 0) {
				Object removedElement = queue[0];
				for (int i = 0; i < size(); i++) {
					queue[i] = queue[i + 1];
				}
				queue[counter] = null;
				return removedElement;
			} else {
				if (queue[0] != null) {
					Object removedElement2 = queue[0];
					queue[0] = null;
					return removedElement2;
				}
				throw null;
			}
		}
			throw null;
	}

	@Override
	public boolean isEmpty() {
		if (size() > 0 || (size() == 0 && queue[0] != null)) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public int size() {
		if (counter < 0) {
			return 0;
		}
		return counter;
	}

}
