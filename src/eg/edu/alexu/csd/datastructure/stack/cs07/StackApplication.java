package eg.edu.alexu.csd.datastructure.stack.cs07;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

public class StackApplication implements IExpressionEvaluator {

	@Override
	public String infixToPostfix(String expression) {

		StackImplementation mystack = new StackImplementation();
		String temp = "";

		if (checkExpressionValidation(expression)) {

			for (int i = 0; i < expression.length(); i++) {

				boolean test1 = expression.charAt(i) == '+';
				boolean test2 = expression.charAt(i) == '-';
				boolean test3 = expression.charAt(i) == '*';
				boolean test4 = expression.charAt(i) == '/';
				boolean test5 = expression.charAt(i) == '(';
				boolean test6 = expression.charAt(i) == ')';
				boolean test7 = expression.charAt(i) == ' ';
				char selectedChar = expression.charAt(i);

				if (test1 || test2 || test3 || test4 || test5 || test6) {

					if (mystack.size() == 0) {

						mystack.push(expression.charAt(i));

					} else {
						// higher precedence condition
						if ((((char) mystack.peek() == '+' || (char) mystack.peek() == '-') && (test4 || test3))
								|| test5) {

							mystack.push(selectedChar);

						} else if ((char) mystack.peek() == selectedChar
								|| (((char) mystack.peek() == '*' || (char) mystack.peek() == '/') && (test1 || test2))
								|| ((char) mystack.peek() == '*' && test4) || ((char) mystack.peek() == '/' && test3)
								|| ((char) mystack.peek() == '+' && test2) || ((char) mystack.peek() == '-' && test1)) {

							if (temp.charAt(temp.length() - 1) != ' ') {
								temp = temp + " ";
							}
							temp = temp + mystack.pop();
							i--;

						} else if ((char) mystack.peek() == '(') {
							mystack.push(selectedChar);
						}

						else if (selectedChar == ')') {

							while ((char) mystack.peek() != '(') {
								temp = temp + ' ' + mystack.pop();
							}

							// to delete '('
							Object garbage = mystack.pop();
						}
					}
				} else {
					if (test7) {

						if (temp.charAt(temp.length() - 1) != ' ') {
							temp = temp + " ";
						} else {
							continue;
						}

					} else {
						temp = temp + selectedChar;
					}
				}
			}

			int size = mystack.size();

			for (int i = 0; i < size; i++) {
				temp = temp + ' ' + mystack.pop();
			}

			return temp;
		} 
		else {
			throw null;
		}
	}

	@Override
	public int evaluate(String expression) {

		StackImplementation mystack = new StackImplementation();
		String temp = "";

		if (expression.length() == 0) {
			throw null;
		} else {

			for (int i = 0; i < expression.length(); i++) {
				if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*'
						|| expression.charAt(i) == '/') {

					Object operand1;
					Object operand2;

					if (mystack.size() == 1) {
						throw null;
					} else {
						operand1 = mystack.pop();
						operand2 = mystack.pop();
					}
					if (expression.charAt(i) == '+') {
						Object result = (int) operand2 + (int) operand1;
						mystack.push((int) result);
					} else if (expression.charAt(i) == '-') {
						Object result = (int) operand2 - (int) operand1;
						mystack.push((int) result);
					} else if (expression.charAt(i) == '*') {
						Object result = (int) operand2 * (int) operand1;
						mystack.push((int) result);
					} else if (expression.charAt(i) == '/') {
						Object result = (int) operand2 / (int) operand1;
						mystack.push((int) result);
					}
				} else {
					if (expression.charAt(i) != ' ') {
						temp = temp + expression.substring(i, i + 1);
					} else {
						if (temp != "") {
							mystack.push(Integer.parseInt(temp));
							temp = "";
							continue;
						} else {
							continue;
						}
					}
				}
			}
			return (int) mystack.pop();
		}
	}

	public boolean checkExpressionValidation(String expression) {

		int counter1 = 0;
		int counter2 = 0;

		if (expression.length() == 0) {
			return false;
		}

		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == ')') {
				counter1++;
			} else if (expression.charAt(i) == '(') {
				counter2++;
			} else if (expression.charAt(i) == '+') {

				if (expression.charAt(i + 2) == '+' || expression.charAt(i + 2) == '-'
						|| expression.charAt(i + 2) == '/' || expression.charAt(i + 2) == '*'
						|| expression.charAt(i + 1) == '+' || expression.charAt(i + 1) == '-'
						|| expression.charAt(i + 1) == '/' || expression.charAt(i + 1) == '*') {
					return false;
				}

			} else if (expression.charAt(i) == '-') {
				if (expression.charAt(i + 2) == '+' || expression.charAt(i + 2) == '-'
						|| expression.charAt(i + 2) == '/' || expression.charAt(i + 2) == '*'
						|| expression.charAt(i + 1) == '+' || expression.charAt(i + 1) == '-'
						|| expression.charAt(i + 1) == '/' || expression.charAt(i + 1) == '*') {
					return false;
				}
			} else if (expression.charAt(i) == '*') {
				if (expression.charAt(i + 2) == '+' || expression.charAt(i + 2) == '-'
						|| expression.charAt(i + 2) == '/' || expression.charAt(i + 2) == '*'
						|| expression.charAt(i + 1) == '+' || expression.charAt(i + 1) == '-'
						|| expression.charAt(i + 1) == '/' || expression.charAt(i + 1) == '*') {
					return false;
				}
			} else if (expression.charAt(i) == '/') {
				if (expression.charAt(i + 2) == '+' || expression.charAt(i + 2) == '-'
						|| expression.charAt(i + 2) == '/' || expression.charAt(i + 2) == '*'
						|| expression.charAt(i + 1) == '+' || expression.charAt(i + 1) == '-'
						|| expression.charAt(i + 1) == '/' || expression.charAt(i + 1) == '*') {
					return false;
				}
			}
		}

		if (counter1 == counter2) {
			return true;
		} else {
			return false;
		}
	}

}
