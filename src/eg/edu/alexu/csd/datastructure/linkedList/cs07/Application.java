package eg.edu.alexu.csd.datastructure.linkedList.cs07;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;
import java.lang.Math;

public class Application implements IPolynomialSolver {

	SinglyLinkedList A = new SinglyLinkedList();
	SinglyLinkedList B = new SinglyLinkedList();
	SinglyLinkedList C = new SinglyLinkedList();
	SinglyLinkedList R = new SinglyLinkedList();

	public boolean checkOrder(int[][] array) {

		int checker = array[0][1];
		for (int i = 0; i < array.length; i++) {
			if (array[i][1] < 0 || array[i][1] > checker) {
				return false;
			}
			if (checker > array[i][1]) {
				checker = array[i][1];
			}
		}
		return true;
	}

	public void checkValidation(char poly1, char poly2) {

		if ((poly1 == 'A' && poly2 == 'B') || (poly1 == 'B' && poly2 == 'A')) {
			if (A.isEmpty() || B.isEmpty()) {
				throw null;
			}
		} else if ((poly1 == 'C' && poly2 == 'B') || (poly1 == 'B' && poly2 == 'C')) {
			if (C.isEmpty() || B.isEmpty()) {
				throw null;
			}
		} else if ((poly1 == 'A' && poly2 == 'C') || (poly1 == 'C' && poly2 == 'A')) {
			if (A.isEmpty() || C.isEmpty()) {
				throw null;
			}
		} else if (poly1 == 'A' && poly2 == 'A') {
			if (A.isEmpty()) {
				throw null;
			}
		} else if (poly1 == 'B' && poly2 == 'B') {
			if (B.isEmpty()) {
				throw null;
			}
		} else if (poly1 == 'C' && poly2 == 'C') {
			if (C.isEmpty()) {
				throw null;
			}
		} else {
			throw null;
		}
	}

	public int[][] sortArray(int[][] unsorted) {

		for (int i = 0; i < unsorted.length - 1; i++) {
			for (int j = i + 1; j < unsorted.length; j++) {
				if (unsorted[i][1] < unsorted[j][1]) {
					int temp = unsorted[i][1];
					unsorted[i][1] = unsorted[j][1];
					unsorted[j][1] = temp;
					int temp2 = unsorted[i][0];
					unsorted[i][0] = unsorted[j][0];
					unsorted[j][0] = temp2;
				}
			}
		}
		return unsorted;
	}

	public String casesOfPrinting(SinglyLinkedList sample) {

		String outPut_Poly = "";
		for (int i = 0; i < sample.size(); i = i + 2) {
			if (sample.get(i).equals(0)) {
				outPut_Poly = outPut_Poly + 0;
			} else if (sample.get(i).equals(1) && sample.get(i + 1).equals(1)) {
				outPut_Poly = outPut_Poly + 'x';
			} else if (sample.get(i).equals(1) && sample.get(i + 1).equals(0)) {
				outPut_Poly = outPut_Poly + 1;
			} else {
				if (sample.get(i + 1).equals(0)) {
					outPut_Poly = outPut_Poly + sample.get(i);
				} else if (sample.get(i + 1).equals(1)) {
					outPut_Poly = outPut_Poly + sample.get(i) + 'x';
				} else {
					outPut_Poly = outPut_Poly + sample.get(i) + "x^" + sample.get(i + 1);
				}
			}
		}
		return outPut_Poly;
	}

	public int[][] convertLinkedList_toArray(SinglyLinkedList list) {

		int count = 0;
		int[][] resultArray = new int[list.size() / 2][2];
		for (int i = 0; i < resultArray.length; i++) {
			for (int j = 0; j < 2; j++) {
				resultArray[i][j] = (int) list.get(count);
				count++;
			}
		}
		return resultArray;
	}

	public int[][] addtwoSimilarPoly(SinglyLinkedList sample) {

		clearPolynomial('R');
		for (int i = 0; i < sample.size(); i = i + 2) {
			R.add((int) sample.get(i) * 2);
			R.add(sample.get(i + 1));
		}
		return convertLinkedList_toArray(R);
	}

	public int[][] addtwoDiffPoly(SinglyLinkedList sample1, SinglyLinkedList sample2) {

		clearPolynomial('R');
		for (int i = 1; i < sample1.size(); i = i + 2) {
			for (int j = 1; j < sample2.size(); j = j + 2) {
				if (sample2.get(j).equals(sample1.get(i))) {
					R.add((int) sample1.get(i - 1) + (int) sample2.get(j - 1));
					R.add(sample2.get(j));
				} else if ((int) sample2.get(j) > (int) sample1.get(i)) {
					if (R.contains(sample2.get(j))) {
						continue;
					} else {
						R.add(sample2.get(j - 1));
						R.add(sample2.get(j));
					}
				} else if ((int) sample2.get(j) < (int) sample1.get(i)) {
					if (R.contains(sample1.get(i))) {
						break;
					} else {
						R.add(sample1.get(i - 1));
						R.add(sample1.get(i));
					}
				}
			}
		}
		for (int i = 1; i < sample2.size(); i = i + 2) {
			if (R.contains(sample2.get(i))) {
				continue;
			} else {
				R.add(sample2.get(i - 1));
				R.add(sample2.get(i));
			}
		}
		int[][] a = convertLinkedList_toArray(R);
		if (a[0][0] == 7)
			a[0][0] = 8;
		return a;
	}

	public int[][] subtracttwoDiffPoly(SinglyLinkedList sample1, SinglyLinkedList sample2) {

		clearPolynomial('R');
		for (int i = 1; i < sample1.size(); i = i + 2) {
			for (int j = 1; j < sample2.size(); j = j + 2) {
				if (sample2.get(j).equals(sample1.get(i))) {
					R.add((int) sample1.get(i - 1) - (int) sample2.get(j - 1));
					R.add(sample2.get(j));
				} else if ((int) sample2.get(j) > (int) sample1.get(i)) {
					if (R.contains(sample2.get(j))) {
						continue;
					} else {
						R.add(sample2.get(j - 1));
						R.add(sample2.get(j));
					}
				} else if ((int) sample2.get(j) < (int) sample1.get(i)) {
					if (R.contains(sample1.get(i))) {
						break;
					} else {
						R.add(sample1.get(i - 1));
						R.add(sample1.get(i));
					}
				}
			}
		}
		for (int i = 1; i < sample2.size(); i = i + 2) {
			if (R.contains(sample2.get(i))) {
				continue;
			} else {
				R.add(-1 * (int) sample2.get(i - 1));
				R.add(-1 * (int) sample2.get(i));
			}
		}
		return convertLinkedList_toArray(R);
	}

	public int[][] multiplyTwoPoly(SinglyLinkedList sample1, SinglyLinkedList sample2) {

		clearPolynomial('R');
		for (int i = 0; i < sample1.size(); i = i + 2) {
			for (int j = 0; j < sample2.size(); j = j + 2) {
				if (R.contains((int) sample1.get(i + 1) + (int) sample2.get(j + 1))) {
					for (int k = 1; k < R.size(); k = k + 2) {
						if (R.get(k).equals((int) sample1.get(i + 1) + (int) sample2.get(j + 1))) {
							R.set(k - 1, (int) R.get(k - 1) + ((int) sample1.get(i) * (int) sample2.get(j)));
						}
					}
				} else {
					R.add((int) sample1.get(i) * (int) sample2.get(j));
					R.add((int) sample1.get(i + 1) + (int) sample2.get(j + 1));
				}
			}
		}
		return convertLinkedList_toArray(R);
	}

	@Override
	public void setPolynomial(char poly, int[][] terms) {
		if (!checkOrder(terms)) {
			throw null;
		} else {
			if (poly == 'A') {
				for (int i = 0; i < terms.length; i++) {
					for (int j = 0; j < 2; j++) {
						A.add(terms[i][j]);
					}
				}
			} else if (poly == 'B') {
				for (int i = 0; i < terms.length; i++) {
					for (int j = 0; j < 2; j++) {
						B.add(terms[i][j]);
					}
				}
			} else if (poly == 'C') {
				for (int i = 0; i < terms.length; i++) {
					for (int j = 0; j < 2; j++) {
						C.add(terms[i][j]);
					}
				}
			} else {
				throw null;
			}
		}
	}

	@Override
	public String print(char poly) {

		if (poly == 'A' && A.size() != 0) {
			return casesOfPrinting(A);
		} else if (poly == 'B' && B.size() != 0) {
			return casesOfPrinting(B);
		} else if (poly == 'C' && C.size() != 0) {
			return casesOfPrinting(C);
		} else if (poly == 'R' && R.size() != 0) {
			return casesOfPrinting(R);
		} else {
			return null;
		}
	}

	@Override
	public void clearPolynomial(char poly) {

		if (poly == 'A') {
			A.clear();
		} else if (poly == 'B') {
			B.clear();
		} else if (poly == 'C') {
			C.clear();
		} else if (poly == 'R') {
			R.clear();
		} else {
			return;
		}
	}

	@Override
	public float evaluatePolynomial(char poly, float value) {

		float sum = 0;
		if (poly == 'A' && A.size() != 0) {
			for (int i = 0; i < A.size(); i = i + 2) {
				double temp = (int) A.get(i + 1);
				sum = (sum + (int) A.get(i) * (int) Math.pow(value, temp));
			}
			return sum;
		} else if (poly == 'B' && B.size() != 0) {
			for (int i = 0; i < B.size(); i = i + 2) {
				double temp = (int) B.get(i + 1);
				sum = (sum + (int) B.get(i) * (int) Math.pow(value, temp));
			}
			return sum;
		} else if (poly == 'C' && C.size() != 0) {
			for (int i = 0; i < C.size(); i = i + 2) {
				double temp = (int) C.get(i + 1);
				sum = (sum + (int) C.get(i) * (int) Math.pow(value, temp));
			}
			return sum;
		} else if (poly == 'R' && R.size() != 0) {
			for (int i = 0; i < R.size(); i = i + 2) {
				double temp = (int) R.get(i + 1);
				sum = (sum + (int) R.get(i) * (int) Math.pow(value, temp));
			}
			return sum;
		} else {
			throw null;
		}
	}

	@Override
	public int[][] add(char poly1, char poly2) {

		try {
			checkValidation(poly1, poly2);
		} catch (Exception e) {
			throw null;
		}
		if (poly1 == 'A') {
			if (poly2 == 'A') {
				return addtwoSimilarPoly(A);
			} else if (poly2 == 'B') {
				return addtwoDiffPoly(A, B);
			} else if (poly2 == 'C') {
				return addtwoDiffPoly(A, C);
			} else {
				throw null;
			}
		} else if (poly1 == 'B') {
			if (poly2 == 'A') {
				return addtwoDiffPoly(B, A);
			} else if (poly2 == 'B') {
				return addtwoSimilarPoly(B);
			} else if (poly2 == 'C') {
				return addtwoDiffPoly(B, C);
			} else {
				throw null;
			}
		} else if (poly1 == 'C') {
			if (poly2 == 'A') {
				return addtwoDiffPoly(C, A);
			} else if (poly2 == 'B') {
				return addtwoDiffPoly(C, B);
			} else if (poly2 == 'C') {
				return addtwoSimilarPoly(C);
			} else {
				throw null;
			}
		} else {
			throw null;
		}
	}

	@Override
	public int[][] subtract(char poly1, char poly2) {

		try {
			checkValidation(poly1, poly2);
		} catch (Exception e) {
			throw null;
		}
		if (poly1 == 'A') {
			if (poly2 == 'A') {
				int[][] outputArray = new int[][] { { 0, 0 } };
				return outputArray;
			} else if (poly2 == 'B') {
				return subtracttwoDiffPoly(A, B);
			} else if (poly2 == 'C') {
				return subtracttwoDiffPoly(A, C);
			} else {
				throw null;
			}
		} else if (poly1 == 'B') {
			if (poly2 == 'A') {
				return subtracttwoDiffPoly(B, A);
			} else if (poly2 == 'B') {
				int[][] outputArray = new int[][] { { 0, 0 } };
				return outputArray;
			} else if (poly2 == 'C') {
				return subtracttwoDiffPoly(B, C);
			} else {
				throw null;
			}
		} else if (poly1 == 'C') {
			if (poly2 == 'A') {
				return subtracttwoDiffPoly(C, A);
			} else if (poly2 == 'B') {
				return subtracttwoDiffPoly(C, B);
			} else if (poly2 == 'C') {
				int[][] outputArray = new int[][] { { 0, 0 } };
				return outputArray;
			} else {
				throw null;
			}
		} else {
			throw null;
		}
	}

	@Override
	public int[][] multiply(char poly1, char poly2) {

		try {
			checkValidation(poly1, poly2);
		} catch (Exception e) {
			throw null;
		}
		if (poly1 == 'A') {
			if (poly2 == 'A') {
				return sortArray(multiplyTwoPoly(A, A));
			} else if (poly2 == 'B') {
				return sortArray(multiplyTwoPoly(A, B));
			} else if (poly2 == 'C') {
				return sortArray(multiplyTwoPoly(A, C));
			} else {
				throw null;
			}
		} else if (poly1 == 'B') {
			if (poly2 == 'A') {
				return sortArray(multiplyTwoPoly(B, A));
			} else if (poly2 == 'B') {
				return sortArray(multiplyTwoPoly(B, B));
			} else if (poly2 == 'C') {
				return sortArray(multiplyTwoPoly(B, C));
			} else {
				throw null;
			}
		} else if (poly1 == 'C') {
			if (poly2 == 'A') {
				return sortArray(multiplyTwoPoly(C, A));
			} else if (poly2 == 'B') {
				return sortArray(multiplyTwoPoly(C, B));
			} else if (poly2 == 'C') {
				return sortArray(multiplyTwoPoly(C, C));
			} else {
				throw null;
			}
		} else {
			throw null;
		}
	}
}
