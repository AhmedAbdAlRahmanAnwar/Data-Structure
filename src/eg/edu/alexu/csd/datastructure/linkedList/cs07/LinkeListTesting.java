package eg.edu.alexu.csd.datastructure.linkedList.cs07;

import org.junit.Assert;
import org.junit.Test;

public class LinkeListTesting {

	@Test
	public void checkAddToIndex_Function() {

		SinglyLinkedList test = new SinglyLinkedList();
		int index = 0;
		int datainIndex = 1;
		test.add(index, datainIndex);
		test.add(index++, datainIndex++);
		test.add(index++, datainIndex++);
		test.add(index++, datainIndex++);
		test.add(index++, datainIndex++);

		final int expectedData1 = 2;
		final int expectedData2 = 3;
		final int expectedData3 = 4;

		Assert.assertEquals(expectedData1, test.get(1));
		Assert.assertEquals(expectedData2, test.get(2));
		Assert.assertEquals(expectedData3, test.get(3));
	}

	@Test
	public void checkAdd_Function() {

		SinglyLinkedList test = new SinglyLinkedList();
		test.add(10);
		test.add(20);
		test.add(30);
		test.add(40);
		test.add(50);
		test.add(60);

		int expectedData = 10;

		for (int i = 0; i < 6; i++) {
			Assert.assertEquals(expectedData, test.get(i));
			expectedData = expectedData + 10;
		}
	}

	@Test
	public void checkSet_Function() {

		SinglyLinkedList test = new SinglyLinkedList();
		test.add(10);
		test.add(20);
		test.add(30);
		test.add(40);
		test.add(50);
		test.add(60);

		int count = 0;

		for (int i = 0; i < 6; i++) {
			test.set(i, count);
			count++;
		}
		for (int i = 0; i < 6; i++) {
			Assert.assertEquals(i, test.get(i));
		}
	}

	@Test
	public void checkclear_Function() {

		SinglyLinkedList test = new SinglyLinkedList();
		test.add(1010);
		test.add(2098);
		test.add(301);
		test.add(402);
		test.add(50);
		test.add(601);
		test.clear();
		Assert.assertEquals(true, test.isEmpty());
	}

	@Test
	public void checkSize_Function1() {

		SinglyLinkedList test = new SinglyLinkedList();
		test.add(1010);
		test.add(2098);
		test.add(301);
		test.add(402);
		test.add(50);
		test.add(601);
		test.clear();
		Assert.assertEquals(0, test.size());
	}

	@Test
	public void checkSize_Function2() {

		SinglyLinkedList test = new SinglyLinkedList();
		test.add(1010);
		test.add(2098);
		test.add(301);
		test.add(402);
		test.add(50);
		test.add(601);
		Assert.assertEquals(6, test.size());
	}

	@Test
	public void checkSize_Function3() {

		SinglyLinkedList test = new SinglyLinkedList();
		int datainIndex = 1;
		test.add(0, datainIndex++);
		test.add(1, datainIndex++);
		test.add(2, datainIndex++);
		Assert.assertEquals(3, test.size());
	}

	@Test
	public void checkIsEmpty_Function3() {

		SinglyLinkedList test = new SinglyLinkedList();
		Assert.assertEquals(true, test.isEmpty());
	}

	@Test
	public void checkContains_Function() {

		SinglyLinkedList test = new SinglyLinkedList();
		test.add(10);
		test.add(20);
		test.add(30);
		test.add(40);
		test.add(50);
		test.add(60);

		int count = 10;
		for (int i = 0; i < 6; i++) {
			Assert.assertEquals(true, test.contains(count));
			count = count + 10;
		}
		Assert.assertEquals(false, test.contains(64));
		Assert.assertEquals(false, test.contains(23));
	}

	@Test
	public void checkRemove_Function() {

		SinglyLinkedList test = new SinglyLinkedList();
		test.add(10);
		test.add(20);
		test.add(30);
		test.add(40);
		test.add(50);
		test.add(60);
		test.add(70);
		test.add(80);

		test.remove(2);
		test.remove(3);
		test.remove(4);

		Assert.assertEquals(5, test.size());
		Assert.assertEquals(40, test.get(2));
	}

	@Test
	public void checkSublist_Function() {

		SinglyLinkedList test = new SinglyLinkedList();
		test.add(10);
		test.add(20);
		test.add(30);
		test.add(40);
		test.add(50);
		test.add(60);
		test.add(70);
		test.add(80);

		test.sublist(2, 6);

		Assert.assertEquals(30, test.sublist(2, 6).get(0));
		Assert.assertEquals(40, test.sublist(2, 6).get(1));
		Assert.assertEquals(50, test.sublist(2, 6).get(2));
		Assert.assertEquals(60, test.sublist(2, 6).get(3));
	}

}
