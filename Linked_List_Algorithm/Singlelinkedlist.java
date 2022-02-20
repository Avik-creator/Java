package Linked_List_Algorithm;
/*package LinkedList;

public class Singlelinkedlist {
    public static void main(String[] args) {
        public void bubblesort(size -1,0);
        
    }

    /* class Node{
        int val
        Node next
    } */

    //          Internal Working of an Linked List          //
   /* private Node head;
    private Node tail;
    private int size;
    public Singlelinkedlist(){
        this.size = 0;
    }
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }
        size += 1;

    }

    public void insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }



    public void insert(int val, int index){
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertLast(val);
            return;
        }

        Node temp = head;
        for(int i = 1; i < index; i++){
            temp = temp.next;

        }
        Node node = new Node(val, temp.next);
        temp.next  = node;

        size++;

    }



    public void insertRec(int val, int index){
        head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int index, Node node){
        if(index == 0){
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(val, index--, node.next);
        return node;
    }






    public int deleteLast(){
        if(size <= 1){
            return deletefirst();
        }

        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        return val;
    }


    public int delete(int index){
        if(index == 0){
            return deletefirst();
        }if(index == size -1){
            return deleteLast();
        }
        Node prev = get(index - 1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        return val;
    }


    public Node find(int value){
        Node node = head;
        while (node != null) {
            if(node.value == value){
                return node;
            }
            node = node.next;
        }
        return node;
    }



    public Node get(int index){
        Node node = head;
        for(int i = 0; i < index; i++){
            node = node.next;
        }
        return node;
    }


    public int deletefirst(){
        int val = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return val;
    }






    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("End.");
    }



    private class Node{
        private int value;
        private Node next;
    
        public Node(int value){
        this.value = value;
        }
        public Node(int value, Node next){
        this.value = value;
        this.next = next;
        }



//      Remove Duplicates       //
//      Leetcode Question 83    //

        public void duplicates(){
            Node node  = head;

            while(node.next != null){
                if(node.next != null && node.value == node.next.value){
                    node.next = node.next.next;
                    size--;

                }else{
                    node = node.next;
                }
            }
            tail = node;
            tail.next = null;
        }


        //      Merge Sorted LinkedList     //
        public static LL merge(LL first, LL second){
            Node f = first.head;
            Node s = second.head;

            LL ans = new LL();
            while(f != null && s != null){
                if(f.value < s.value){
                    ans.insertLast(f.val);
                    f = f.next;
                }else{
                    ans.insertLast(s.value);
                    s = s.next;
                }
            }

            while (f != null) {
                ans.insertLast(f.value);
                f = f.next;
            }
            while (s != null) {
                ans.insertLast(s.value);
                s = s.next;
            }
            return ans;
        }


        //      Calculate the length of the cycle       //
        
            public int lengthCycle(ListNode head){
                ListNode fast = head;
                ListNode slow = head;

                While(fast != null && fast.next != null){
                    fast = fast.next.next;
                    slow = slow.next;
                    if(fast == slow){
                        // calculate the length
                        ListNode temp = slow;
                        int length = 0;
                        do{
                            temp = temp.next;
                            length;
                        }while(temp != slow);
                        return length;
                    }
                    return 0;
                }
            } 
        


        //      LeetCode Problem 142        //
        public ListNode detectCycle(ListNode head){
            int length = 0;

            ListNode fast = head;
            ListNode slow = head;

            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
                if(fast == slow){
                    length = lengthCycle(slow);
                    break;
                }
            }
            // find the start node //
            ListNode f = head;
            ListNode s = head;
            while(length > 0){
                s = s.next;
                length--;
            }
            // keep moving both forward and they will meet at start //
            while (f != s) {
                f = f.next;
                s = s.next;
            }
            return s;
        }
        public int lengthCycle(ListNode head){
            ListNode fast = head;
            ListNode slow = head;

            While(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
                if(fast == slow){
                    // calculate the length
                    ListNode temp = slow;
                    int length = 0;
                    do{
                        temp = temp.next;
                        length;
                    }while(temp != slow);
                    return length;
                }
                return 0;
            }
        } 

        private void bubblesort(int row, int col){
            if(row == 0){
                return;
            }
            if(col < row){
                Node first = get(col);
                Node second = get(col + 1);

                if(first.value > second.value){
                    //swap
                    if(first == head){
                        head = second;
                        first.next = second.next;
                        second.next = first.next;


                    }

                    else if(second == tail){
                        Node prev = get(col - 1);
                        prev.next = second;
                        tail = first;
                        first.next = null;
                        second.next = tail;
                    }else{
                        Node prev = get(col - 1);
                        prev.next = second;
                        first.next = second.next;
                        second.next = first;

                    }

                }
            
                bubblesort(row,col + 1);
            }else{
                bubblesort( row - 1, col);
            }
        }


        //recursion reverse
    private void reverse(Node node){

        if(node == tail){
            head = tail;
            return;    
        }
        reverse(node.next);

        tail.next = node;
        tail = node;
        tail.next = null;



    }
    //  iterative reversal of linkedlist
    public void reverseinplace(){
        if(size < 2){
            return;
        }
        Node prev = null;
        Node present = head;
        Node next = present.next;


        while(present != null){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null){
                next = next.next;
            }
        }
        head = prev;
    }



    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
                return head;
        }
        //Skip the first left-1 Nodes;

        ListNode present = head;
        ListNode prev = null;
        for(int i = 0; present != null && i < left-1;i++ ){
            prev = present;
            present = present.next;

        }

        ListNode last = prev;
        ListNode newEnd = present;

        // reverse between left and right
        ListNode next = present.next;
        for (int i = 0; present != null && i < right-left + 1; i++) {
            present.next = prev;
            prev = present;
            present = next;
            if(next != null){
                next = next.next;
            }
        }

        if(last != null){
            last.next = prev;

        }else{
            head = prev;
        }
        newEnd.next = present;
        return head;

    }

    public ListNode middleNode(ListNode head){
        ListNode s = head;
        ListNode f = head;

        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    public boolean isPalindrome(ListNode Head){
        ListNode mid = middleNode(head);
        ListNode headSecond = reverse(mid);
        ListNode rereversehead = headSecond;


        // compare both the halves;
        while(head != null && headSecond != null){
            if(head.value != headSecond.val){

        
                break;
            }
        
        head = head.next;
        headSecond = headSecond.next;
        }


        reverse(rereversehead);

        if(head == null || headSecond == null){
            return true;
        }
        return false;


    }
    
    

    public void reorderlist(ListNode head){
        if(head == null || head.next == null){
            return;
        }

        ListNode mid = middleNode(head);

        ListNode hs = reorderlist(mid);
        ListNode hf = head;
        
        while(hf != null && hs != null){
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;
            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }
        if(hf != null){
            hf.next = null;
        }

        public ListNode reverseKGroup(ListNode head, int k) {
            if(k <= 1 || head == null){
                return head;
            }
            ListNode present = head;
            ListNode prev = null;
            while(true){
                ListNode last = prev;
                ListNode newEnd = present;
    
            // reverse between left and right
                 ListNode next = present.next;
                for (int i = 0; present != null && i < k; i++) {
                    present.next = prev;
                    prev = present;
                    present = next;
                    if(next != null){
                        next = next.next;
                    }
                }
    
                if(last != null){
                     last.next = prev;
    
                }else{
                    head = prev;
                }
                newEnd.next = present;
                if(present == null){
                    break;
                }
                prev = newEnd;
                
            }
            return head;
    
        }


        public ListNode reverseAlternateKGroup(ListNode head, int k) {
            if(k <= 1 || head == null){
                return head;
            }
            ListNode present = head;
            ListNode prev = null;
            while(present != null){
                ListNode last = prev;
                ListNode newEnd = present;
    
            // reverse between left and right
                 ListNode next = present.next;
                for (int i = 0; present != null && i < k; i++) {
                    present.next = prev;
                    prev = present;
                    present = next;
                    if(next != null){
                        next = next.next;
                    }
                }
    
                if(last != null){
                     last.next = prev;
    
                }else{
                    head = prev;
                }
                newEnd.next = present;
                //Skip the K nodes
                for(int i = 0; present != null && i < k; i++){
                    prev = current;
                    current = current.next;

                }
                
            }
            return head;
    
        }
        


        }
    }


    public ListNode rotateRight(ListNode head, int k){
        if(head == null || head.next == null || k == 0){
            return head;
        }

        ListNode last = head;
        int length = 1;
        while(last.next != null){
            last = last.next;
            length++;
        }
        last.next = head;
        int rotations = k % length;
        int skip = length - rotations;
        ListNode newLast = head;
        for (int i = 0; i < skip - 1; i++) {
            newLast = newLast.next;

        }
        head = newLast.next;
        newLast.next = null;

        return head;
        

    }


    }
}*/
