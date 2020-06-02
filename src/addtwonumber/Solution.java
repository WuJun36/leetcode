package addtwonumber;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.List;

public class Solution {
    public static void main(String[] args){
        ListNode l10 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(3);
        l10.next = l11;
        l11.next = l12;

        ListNode l20 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        ListNode l22 = new ListNode(4);
        l20.next = l21;
        l21.next = l22;

        System.out.println(addTwoNumber(l10,l20).val);
    }
    public static ListNode addTwoNumber(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        int count = 0;
        int num1 = 0;
        while (l1 != null) {
            num1 += l1.val * Math.pow(10, count++);
            l1 = l1.next;
        }
        int num2 = 0;
        count = 0;
        while (l2 != null) {
            num2 += l2.val * Math.pow(10, count++);
            l2 = l2.next;
        }

        int num = num1 + num2;
        ret.val = num % 10;
        ListNode ret0 = ret;
        num /= 10;
        while (num > 0) {
            ret.next = new ListNode(num % 10);
            ret = ret.next;
            num /= 10;
        }

        return ret0;
    }
}
