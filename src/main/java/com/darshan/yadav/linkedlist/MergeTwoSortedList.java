package com.darshan.yadav.linkedlist;

public class MergeTwoSortedList {

   public static void main(String[] args) {
      MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
      ListNode l1 = new ListNode(1);
      l1.next = new ListNode(2);
      l1.next.next = new ListNode(4);
      ListNode l2 = new ListNode(1);
      l2.next = new ListNode(3);
      l2.next.next = new ListNode(4);
      ListNode mergedList = mergeTwoSortedList.mergeTwoLists(l1, l2);
      while (mergedList != null) {
         System.out.print(mergedList.val + " ");
         mergedList = mergedList.next;
      }
   }
   public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      ListNode dummy = new ListNode(-1);
      ListNode current = dummy;
      while (l1 != null && l2 != null) {
         if (l1.val <= l2.val) {
            current.next = l1;
            l1 = l1.next;
         } else {
            current.next = l2;
            l2 = l2.next;
         }
         current = current.next;
      }
      current.next = (l1 != null) ? l1 : l2;
      return dummy.next;
   }


   public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
      if (l1 == null) return l2;
      if (l2 == null) return l1;
      if (l1.val < l2.val) {
         l1.next = mergeTwoLists(l1.next, l2);
         return l1;
      } else {
         l2.next = mergeTwoLists(l1, l2.next);
         return l2;
      }
   }
}


