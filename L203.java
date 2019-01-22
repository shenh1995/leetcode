package Algorithm;

public class L203 {
	public class ListNode{
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
    public ListNode removeElements(ListNode head, int val) {
        //做判断的时候一定head ！= null在head.val == val之前
        while(head != null && head.val == val) {
        	head = head.next;
        }
        //条件判断
        if (head == null) {
			return head;
		}
        ListNode pre = head;
        ListNode last = head.next;
        while(pre != null && last != null) {
        	if(last.val == val) {
        		pre.next = last.next;
        		last = last.next;
        	}else {//else部分一定需要
				pre = pre.next;
				last = last.next;
			}
        }
        return head;
    }
}
