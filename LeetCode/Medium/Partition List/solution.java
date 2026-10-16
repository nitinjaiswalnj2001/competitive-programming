class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode beforeDummy = new ListNode(0);
        ListNode afterDummy = new ListNode(0);

        ListNode before = beforeDummy;
        ListNode after = afterDummy;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }

            head = head.next;
        }

        // Prevent possible cycle / stale connection
        after.next = null;

        before.next = afterDummy.next;

        return beforeDummy.next;
    }
}