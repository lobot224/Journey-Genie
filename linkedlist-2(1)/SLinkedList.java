

public class SLinkedList {
    
    private ListNode head = null;
    private ListNode tail = null;
    private int length = 0;
    
    public void append(int item) {
        ListNode newNode = new ListNode();
        newNode.setItem(item);
        
        if (head == null) {
            // list is empty
            this.head = newNode;
            this.tail = newNode;
            // System.out.println("New node added as the head.");
        }
        else {
            // list is not empty
            this.tail.next = newNode;
            // System.out.println("New node added to non-empty list.");
        }
        
        this.length++;
        
        // System.out.println("Item added: " + item);
    }
    
    /** prints each item in the list */
    public void printList() {
        
        for (ListNode currentNode = this.head; currentNode != null; currentNode = currentNode.next) {
            System.out.print(currentNode.getItem() + " ");
        }
        
        System.out.println();
    }
    
    /** removes the first node in the list, returning the item */
    public int pop() {
        if (this.head == null) {
            return -1;  // we pretend that exceptions don't exist
        }
        
        ListNode currentNode = this.head;
        this.head = currentNode.next;
        
        if (this.head == null) {
            this.tail = null;
        }
        
        this.length--;
        
        return currentNode.getItem();
    }
    
    /** returns the item in the first node, does not remove the node */
    public int peek() {
        if (this.head == null) {
            return -1;  // this is nasty code
        }
        
        return this.head.getItem();   
    }
    
    /** adds a new node with the item to the end of the list */
    public void enqueue(int item) {
        this.append(item);
    }
    
    public void push(int item) {
        ListNode newNode = new ListNode(item);
        
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        }
        else {
            newNode.next = this.head;
            this.head = newNode;
        }
        
        this.length++;
    }
    
    public int length() {
        return this.length;
    }
}