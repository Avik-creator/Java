package Linked_List_Algorithm;
/**
 * InnerInbuitlExamples
 */

import java.util.*;
public class InbuitlExamples{
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(34);
		stack.push(45);
		stack.push(2);
		stack.push(9);
		stack.push(18);

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		queue.add(19);
		queue.add(5);
		queue.add(3);
		queue.add(6);

		System.out.println(queue.peek());

		
	}
}