package a0624.stackqueque;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueTest {
	public static void main(String[] args) {
		
		//이제 이거 안쓰고
		//Queue<String> queque = new LinkedList<>();
		// 이거 씀
		ArrayDeque<String> queque = new ArrayDeque<>();
		queque.offer("강호동");
		queque.offer("저팔계");
		queque.offer("사오정");
		queque.offer("손오공");
		queque.offer("홍길동");
		
		System.out.println(queque.peek()+" "+queque.size());
		System.out.println(queque.peek()+" "+queque.size());
		System.out.println(queque.peek()+" "+queque.size());
		System.out.println(queque.poll()+" "+queque.size());
		System.out.println(queque.isEmpty());
		System.out.println(queque.poll()+" "+queque.size());
		System.out.println(queque);
		
		
		
		//이제 이거 안쓰고
		//Stack<String> stack = new Stack<>();
		ArrayDeque<String> stack = new ArrayDeque<>();
		stack.push("강호동");
		stack.push("저팔계");
		stack.push("사오정");
		stack.push("손오공");
		stack.push("홍길동");
		
		System.out.println(stack.peek()+" "+stack.size());
		System.out.println(stack.peek()+" "+stack.size());
		System.out.println(stack.peek()+" "+stack.size());
		System.out.println(stack.pop()+" "+stack.size());
		System.out.println(stack.isEmpty());
		System.out.println(stack.pop()+" "+stack.size());
		System.out.println(stack);
	}

}
