package Linked_List_Algorithm;
public class QueueMain {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        queue.insert(3);
        queue.insert(5);
        queue.insert(10);
        queue.insert(12);
        queue.insert(15);

        queue.display();
    }
}
