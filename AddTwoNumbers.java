public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode result = addTwoNumbers(new ListNode(1), new ListNode(2));
        System.out.println(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return plusNode(l1, l2, 0);
    }

    public static ListNode plusNode(ListNode l1, ListNode l2, int k) {
        if (l1 != null && l2 != null) {
            int sumVal = l1.val + l2.val + k;
            return new ListNode(sumVal % 10, plusNode(l1.next, l2.next, sumVal / 10));
        } else if (l1 != null) {
            int sumVal = l1.val + k;
            return new ListNode(sumVal % 10, plusNode(l1.next, null, sumVal / 10));
        } else if (l2 != null) {
            int sumVal = l2.val + k;
            return new ListNode(sumVal % 10, plusNode(l2.next, null, sumVal / 10));
        } else {
            if (k != 0) return new ListNode(k);
            return null;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
