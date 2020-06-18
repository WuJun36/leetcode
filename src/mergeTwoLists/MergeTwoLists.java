package mergeTwoLists;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */

public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode rl = mergeTwoLists(l1, l2);
        while (rl != null) {
            System.out.println(rl.val);
            rl = rl.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;
        int val1 = l1.val, val2 = l2.val;
        ListNode l = new ListNode(val1 < val2 ? val1 : val2);
        ListNode rl = l;
        while (l1 != null && l2 != null) {
            val1 = l1.val;
            val2 = l2.val;
            l.next = new ListNode();
            l = l.next;
            if (val1 >= val2) {
                l.val = val2;
                l2 = l2.next;
            }
            if (val1 < val2) {
                l.val = val1;
                l1 = l1.next;
            }
        }
        l.next = l1 == null ? l2 : l1;
        return rl.next;

    }
}
