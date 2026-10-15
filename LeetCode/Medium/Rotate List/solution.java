class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k %= length;

        if (k == 0) {
            return head;
        }

        // Create circular list
        tail.next = head;

        // New tail is at length - k - 1
        int steps = length - k;

        ListNode newTail = tail;

        while (steps-- > 0) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;

        // Break circle
        newTail.next = null;

        return newHead;
    }
}