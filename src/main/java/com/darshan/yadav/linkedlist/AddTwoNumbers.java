package com.darshan.yadav.linkedlist;

public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
        while(result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Handle the case when both lists are null
        if(l1 == null && l2 == null) return null;

        // Dummy node to simplify the code
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        recurssion(l1, l2, prev, 0);
        return dummy.next;
    }

    public void recurssion(ListNode l1, ListNode l2, ListNode prev, int carry){
        if(l1 != null || l2 != null || carry > 0){
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry ;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            prev.next = new ListNode(sum%10);
            prev = prev.next;
            carry = sum/10;
            recurssion(l1, l2, prev, carry);
        }

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
