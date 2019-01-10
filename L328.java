package Algorithm;

/*
 * 题目是把所有奇数下标节点放在偶数下标节点之后
 */
public class L328 {
	
	public class ListNode{
		
		int val;
		ListNode next;
		
		public ListNode(int val) {
			this.val = val;
		}
	}
	
    public ListNode oddEvenList(ListNode head) {
       if(head == null)
    	   return head;
       
       ListNode result = head;
       ListNode p1 = head;
       ListNode p2 = head.next;
       ListNode connectNode = head.next;
       
       while(p1 != null && p2 != null) {
    	   ListNode t = p2.next;
    	   if(t == null)
    		   break;
    	   
    	   p1.next = p2.next;
    	   p1 = p1.next;
    	   
    	   p2.next = p1.next;
    	   p2 = p2.next;
       }
     p1.next = connectNode;
     
     return result;
    }

}


