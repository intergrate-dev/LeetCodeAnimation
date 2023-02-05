
public class Solution {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode n2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        ListNode res = addTwoNumbers(n1, n2); 
        printLog(res);
    }
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        int carry = 0;

        while(l1 != null || l2 != null)
        {
            int sum = carry;
            if(l1 != null)
            {
                sum += l1.getVal();
                l1 = l1.getNext();
            }
            if(l2 != null)
            {
                sum += l2.getVal();
                l2 = l2.getNext();
            }
            // 创建新节点
            carry = sum / 10;
            cur.setNext(new ListNode(sum % 10));
            cur = cur.getNext();
    
        }
        if (carry > 0) {
            cur.setNext(new ListNode(carry));
        }
        return dummyHead.getNext();
    }

    
    public static void printLog(ListNode head) {
        String str = head.getVal() + "";
        ListNode curr = head.getNext();
        while(curr != null) {
            str = str.concat(" > ").concat(curr.getVal() + "");
            curr = curr.getNext();
        }
        System.out.println(str);
    }
    
}