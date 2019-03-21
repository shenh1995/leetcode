package Algorithm;


public class L445 {

	public static class ListNode{
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	/*
	 * 这里的链表是顺序的数字，不和第2道一样。
	 * 思想是先计算两者的长度，保持l1.length > l2.length,然后计算每位相加的和
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode pre = new ListNode(0);
		
		int length1 = 0, length2 = 0;
		ListNode next = l1, next2 = l2;
		
		while (next != null) {
			length1 ++;
			next = next.next;
		}
		
		while (next2 != null) {
			length2 ++;
			next2 = next2.next;
		}
		
		if(length1 < length2) 
			return addTwoNumbers(l2, l1);
		
		next = l1; next2 = l2;
		int [] temp = new int [length1];
		//因为l1.length > l2.length，所以一开始temp[i] = l1[i] + 0
		for(int i = 0; i < length1; i ++) {
			if(i < length1 - length2) {
				temp[i] = next.val;
				next = next.next;
			}else {
				temp[i] = next.val + next2.val;
				next = next.next;
				next2 = next2.next;
			}
		}
		//然后逆序求，插入节点是直接插在头节点的后面，这个是重点。
		int carry = 0;
	    pre.next = null;
		for(int j = length1 - 1; j >= 0; j --) {
			ListNode tmp = new ListNode((temp[j] + carry) % 10);
			carry = (temp[j] + carry) / 10;
			tmp.next = pre.next;
			pre.next = tmp;
		}
		if(carry != 0) {
			ListNode tmp = new ListNode(carry);
			tmp.next = pre.next;
			pre.next = tmp;
		}
		
		return pre.next;
	}
	
	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(7);
		listNode1.next = new ListNode(2);
		listNode1.next.next = new ListNode(4);
		listNode1.next.next.next = new ListNode(3);
		listNode1.next.next.next.next = null;
		ListNode listNode2 = new ListNode(5);
		listNode2.next = new ListNode(6);
		listNode2.next.next = new ListNode(4);
		listNode2.next.next.next = null;
		new L445().addTwoNumbers(listNode1, listNode2);
	}
}
