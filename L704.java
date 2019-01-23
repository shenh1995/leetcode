package Algorithm;

/*
 * 二分法
 */
public class L704 {
    public int search(int[] nums, int target) {
        if(nums.length == 0 || nums == null) 
        	return -1;
        
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end) {
        	int medium = (end + start) / 2;  //记住这儿是（end + start）/ 2
        	if(nums[medium] == target) {
        		return medium;
        	}else if (nums[medium] < target) {
				start = medium + 1;
			}else {
				end = medium - 1;
			}
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
		int [] nums = {-1,0,3,5,9,12};
	    int target = 9;
	    int result = new L704().search(nums, target);
	    System.out.println(result);
	}
}


