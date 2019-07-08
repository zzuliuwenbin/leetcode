package pkg;
/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * */
import java.util.Stack;

public class MinStack {
	
//	Stack<Integer> data = new Stack<Integer>();
//	Stack<Integer> mini = new Stack<Integer>();
//	
//	/** initialize your data structure here. */
//    public MinStack() {
//        
//    }
//    
//    public void push(int x) {
//        data.push(x);
//        if(mini.empty()) {
//        	mini.push(x);
//        }else {
//        	if(x<=mini.peek()) {
//        		mini.push(x);
//        	}
//        }
//    }
//    
//    public void pop() {
//    	if(data.empty()) {
//    		return;
//    	}
//        int t = data.pop();
//        if(t==mini.peek()) {
//        	mini.pop();
//        }
//    }
//    
//    public int top() {
//    	if(data.empty()) {
//    		return 0;
//    	}
//        return data.peek();
//    }
//    
//    public int getMin() {
//    	if(data.empty()) {
//    		return 0;
//    	}
//        return mini.peek();
//    }

	
	 /** initialize your data structure here. */
    Stack<Integer> stack;
    int min = Integer.MAX_VALUE;
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if(x <= min){//把当前最小值存在x前面，
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.pop() == min) {
            min = stack.pop();//上次的最小值更新到min
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack test = new MinStack();
		test.push(5);
		test.push(6);
		test.push(7);
		test.push(8);
		test.push(9);
		test.push(4);
		test.pop();
		System.out.println(test.getMin());
		

	}

}
