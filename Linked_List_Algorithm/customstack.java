package Linked_List_Algorithm;

public class customstack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int ptr = -1;

    public customstack(){
        this(DEFAULT_SIZE);
    }

    public customstack(int size){
        this.data = new int[size];
    }

    public boolean push(int item){
        if(isfull()){
            System.out.println("full");
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws Exception {
        if(isEmpty()){
            throw new Exception("Cannot Pop");
        }
        int removed = data[ptr];
        ptr--;
        return removed;
    }

    public int peek() throws Exception {
        if(isEmpty()){
            throw new Exception("Cannot Peek");
        }
        return data[ptr];
    }


    public boolean isfull() {
        return ptr == data.length - 1;
    }
    public boolean isEmpty(){
        return ptr == -1;
    }

}