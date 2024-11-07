package org.example.vic.leetcode;

/**
 * T24
 *
 * @author vic
 * @since 2024-11-07
 */
public class T24 {
    /**
     * 两两交换链表中的节点
     * temp->next->next
     *
     *
     * @param head 链表
     * @return 修改后的链表
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            // 下一节点迭代
            temp = node1;
        }
        return dummyHead.next;
    }
}
