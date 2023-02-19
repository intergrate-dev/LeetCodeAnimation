
/**
 * 001 two sum
 * 计算两个数(链表方式逆序存储)相加和（新的链表来表示）
 */
public class AddTwoSum {
    public static void main(String[] args) {
        // 个->十->百->千 ...
        ListNode n1 = new ListNode(2, new ListNode(4, new ListNode(4, null)));
        ListNode n2 = new ListNode(5, new ListNode(6, new ListNode(1, null)));
        ListNode res = addTwoNumbers(n1, n2); 
        printLog(res);
    }
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        int carry = 0;

        while(l1 != null || l2 != null)  {
            int sum = carry;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            // 创建新节点
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
    
        }
        // 最高位进1
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        // curr: (9, null)
        // dummyHead: 0>7>0>9
        return dummyHead.next;
    }

    
    public static void printLog(ListNode head) {
        String str = head.val + "";
        ListNode curr = head.next;
        while(curr != null) {
            str = str.concat(" > ").concat(curr.val + "");
            curr = curr.next;
        }
        System.out.println(str);
    }

  
  
    
}