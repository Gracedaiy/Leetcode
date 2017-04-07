/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> st1 = new Stack<Integer>();
        Stack<Integer> st2 = new Stack<Integer>();
        LinkedList res = new LinkedList();
        int carry = 0;
        ListNode prev = null;
        ListNode resault = null;
        
        while(l1 != null){
            st1.push(l1.val);
            l1 = l1.next;
            //System.out.println("st1:" + st1);
        }
        
        while(l2 != null){
            st2.push(l2.val);
            l2 = l2.next;
        }
        
        int min = Math.min(st1.size(), st2.size());
        for(int i = 0; i < min; i++){
            int value = (st1.peek() + st2.peek() + carry) % 10;
            carry = (st1.peek() + st2.peek() + carry) / 10;
            //res.addFirst(value);
            resault = new ListNode(value);
            resault.next = prev;
            prev = resault;
            st1.pop();
            st2.pop();
        }
        
        while(!st1.empty() && st2.empty()){
            int value = (st1.peek() + carry) % 10;
            //res.addFirst(value);
            resault = new ListNode(value);
            resault.next = prev;
            prev = resault;
            carry = (st1.peek() + carry) / 10;
            st1.pop();
        }
        
        while(st1.empty() && !st2.empty()){
            int value = (st2.peek() + carry) % 10;
            //res.addFirst(value);
            resault = new ListNode(value);
            resault.next = prev;
            prev = resault;
            carry = (st2.peek() + carry) / 10;
            st2.pop();
        }
        //System.out.println("res:" + res);
        
        if(carry != 0){
            resault = new ListNode(carry);
            resault.next = prev;
            prev = resault;
        }
        
        return resault;
    }
}