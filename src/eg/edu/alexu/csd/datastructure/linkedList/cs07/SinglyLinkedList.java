package eg.edu.alexu.csd.datastructure.linkedList.cs07;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class SinglyLinkedList implements ILinkedList {

	private SinglyLinkedListNode head = null;

	@Override
	public void add(int index, Object element) {

		SinglyLinkedListNode newNode = new SinglyLinkedListNode(element);
		SinglyLinkedListNode i = head;

		if (index >= 0) {
			if (index == 0) {
				newNode.next = head;
				head = newNode;
			} else {
				if (head == null) {
					throw null;
				} else {
					for (int j = 0; j < index - 1; j++) {
						i = i.next;
						if (i == null) {
							throw null;
						}
					}
					newNode.next = i.next;
					i.next = newNode;
				}
			}
		} else {
			throw null;
		}
	}

	@Override
	public void add(Object element) {

		SinglyLinkedListNode newNode = new SinglyLinkedListNode(element);
		SinglyLinkedListNode i = head;
		int counter = 0;

		if (head == null) {
			newNode.next = head;
			head = newNode;
		} else {
			while (i != null) {
				counter++;
				i = i.next;
			}

			i = head;
			for (int j = 0; j < counter - 1; j++) {
				i = i.next;
			}
			newNode.next = i.next;
			i.next = newNode;
		}
	}

	@Override
	public Object get(int index) {

		SinglyLinkedListNode i = head;
		int counter = 0;

		if (head == null) {
			throw null;
		} else {
			if (index == 0) {
				return i.element;
			} else {
				if (index > 0) {
					while (counter != index) {
						counter++;
						i = i.next;
						if (i == null) {
							throw null;
						}
					}
					return i.element;
				}
				throw null;
			}
		}
	}

	@Override
	public void set(int index, Object element) {

		SinglyLinkedListNode newNode = new SinglyLinkedListNode(element);
		SinglyLinkedListNode i = head;

		if (i == null) {
			throw null;
		} else {
			if (index >= 0) {
				if (index == 0) {
					newNode.next = head.next;
					head = newNode;
				} else {

					for (int j = 0; j < index - 1; j++) {
						i = i.next;
						if (i == null || i.next == null) {
							throw null;
						}
					}
					newNode.next = i.next.next;
					i.next = newNode;
				}
			}else{
			throw null;
		}}
	}

	@Override
	public void clear() {

		head = null;
	}

	@Override
	public boolean isEmpty() {

		if (head == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void remove(int index) {

		SinglyLinkedListNode i = head;

		if (i == null) {
			throw null;
		} else {
			if (index >= 0) {
				if (index == 0) {
					head = i.next;
				} else {

					for (int j = 0; j < index - 1; j++) {
						i = i.next;
						if (i == null || i.next == null) {
							throw null;
						}
					}
					if (i.next != null && i.next.next != null) {
						i.next = i.next.next;
					} else if (i.next == null) {
						throw null;
					} else {
						i.next = i.next.next;
					}
				}
			}else{
			throw null;
		}}
	}

	@Override
	public int size() {

		SinglyLinkedListNode i = head;
		int counter = 0;
		while (i != null) {
			counter++;
			i = i.next;
		}
		return counter;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {

		SinglyLinkedList subList = new SinglyLinkedList();
		SinglyLinkedListNode i = head;
		int counter = 0;

		if (i == null) {
			throw null;
		} else {
			if (fromIndex >= 0 && toIndex >= 0 && toIndex >= fromIndex) {
				while (counter <= fromIndex) {
					if (counter == fromIndex) {
						while (counter <= toIndex) {
							// if toIndex out of bound
							if (i == null) {
								throw null;
							}
							subList.add(i.element);
							counter++;
							i = i.next;
						}
						return subList;
					}
					i = i.next;
					counter++;
					// if fromIndex doesn't exist
					if (i == null) {
						throw null;
					}
				}
				return subList;
			} else {
				throw null;
			}
		}
	}

	@Override
	public boolean contains(Object o) {

		SinglyLinkedListNode i = head;
		if (i == null) {
			return false;
		} else {
			while (!i.element.equals(o)) {
				i = i.next;
				if (i == null) {
					return false;
				}
			}
			return true;
		}
	}
}
