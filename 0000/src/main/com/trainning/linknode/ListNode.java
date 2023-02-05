public class ListNode {
    private int val;
    private ListNode next;

    public ListNode(int x) {
        val = x; 
    }
    
    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode n) {
        next = n;
    }

    public ListNode(int x, ListNode n) { 
        val = x; 
        next = n;
    }

}