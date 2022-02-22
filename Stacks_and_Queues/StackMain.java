package com.Avik;

public class StackMain {
    public static void main(String[] args) throws Exception {
        DynamicStack stack = new DynamicStack(5);
        stack.push(34);
        stack.push(45);
        stack.push(2);
        stack.push(9);
        stack.push(18);
        stack.push(48);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
