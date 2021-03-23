package uti;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Postfix {

	public static void main(String[] args) {
				System.out.println("Enter an expression: ");
				Scanner sc = new Scanner(System.in);
				String expression = sc.nextLine();
				try {
					System.out.println(evaluateExpression(expression));
				} catch (Exception ex) {
					System.out.println("Wrong expression: " + expression + ex);
					ex.printStackTrace();
				}

			}

			public static int evaluateExpression(String expression) {
				Stack<Integer> operandStack = new Stack<Integer>();
				expression =  insertBlanks(expression);
				String[] tokens = expression.split(" ");
				
				ArrayList<String> acceptedCharacters = new ArrayList<>(Arrays.asList("+" , "-", "*", "/", "^"));
				for (String token : tokens) {
					if (token.length() == 0) {
						continue;
					} else if (acceptedCharacters.contains(token)) {
						processAnOperator(operandStack, token);
					} else {
						operandStack.push(Integer.valueOf(token));
					}
				}
				return operandStack.pop();

			}

			public static void processAnOperator(Stack<Integer> operandStack, String s) {
				int op1 = operandStack.pop();
				int op2 = operandStack.pop();
				
				if (s.equals("+")) {
					operandStack.push(op2 + op1);
				}
				else if (s.equals("-")) {
					operandStack.push(op2 - op1);
				}
				else if (s.equals("*")) {
					operandStack.push(op2 * op1);
				}
				else if (s.equals("/")) {
					operandStack.push(op2 / op1);
				}
				else if (s.equals("^")) {
					operandStack.push((int)Math.pow(op2, op1));
				}
			}

			public static String insertBlanks(String s) {
				String result = "";
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == '+' || s.charAt(i) == '-'
							|| s.charAt(i) == '*' || s.charAt(i) == '/' || s.charAt(i) == '^') {
						result += " " + s.charAt(i) + " ";
					}
					else {
						result += s.charAt(i);
					}
				}
				return result;
			}
		}
