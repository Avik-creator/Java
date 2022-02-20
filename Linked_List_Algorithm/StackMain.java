package Linked_List_Algorithm;

public class StackMain {
    public static void main(String[] args) throws Exception {
        customstack stack = new customstack(5);
        stack.push(34);
        stack.push(45);
        stack.push(2);
        stack.push(9);
        stack.push(10);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
