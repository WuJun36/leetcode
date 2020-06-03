package addtwonumber;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        ListNode l10 = new ListNode(9);
//        ListNode l11 = new ListNode(4);
//        ListNode l12 = new ListNode(3);
//        l10.next = l11;
//        l11.next = l12;

        ListNode l20 = new ListNode(1);
        ListNode l21 = new ListNode(9);
        ListNode l22 = new ListNode(9);
        ListNode l23 = new ListNode(9);
        ListNode l24 = new ListNode(9);
        ListNode l25 = new ListNode(9);
        ListNode l26 = new ListNode(9);
        ListNode l27 = new ListNode(9);
        ListNode l28 = new ListNode(9);
        ListNode l29 = new ListNode(9);
        l20.next = l21;
        l21.next = l22;
        l22.next = l23;
        l23.next = l24;
        l24.next = l25;
        l25.next = l26;
        l26.next = l27;
        l27.next = l28;
        l28.next = l29;
        ListNode node = solution2(l10, l20);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    // TODO 会超出int的范围
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

    public static ListNode solution2(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode ret = node;
        int carry = 0;
        while (!(l1 == null && l2 == null)) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            if (carry >= 10) node.val = carry % 10;
            else node.val = carry;
            carry /= 10;
            node.next = new ListNode(carry);
            node = node.next;
        }
        if (node.val == 0) node = null;
        return ret;
    }
}
