package Algorithm;

public class L41 {

    public int firstMissingPositive(int[] nums) {
    	int n = nums.length;
    	
    	for(int i = 0; i < n; i ++) {
    		//这个地方是为了把数字放在相应的下标位置，数字2要放在nums[1]的地方
    		while(nums[i] != i + 1) {
    			//这个是因为不可能进行交换，所以要跳出去
    			if(nums[i] <= 0 || nums[i] >= n)
    				break;
    			//这块是防止重复循环
    			if(nums[i] == nums[nums[i] - 1]) 
    				break;
    			
    			int temp = nums[i];
    			nums[i] = nums[temp - 1];
    			nums[temp - 1] = temp;
    		}
    	}
    	//经过上面的步骤，那么只要是从1到n的出现过的数字都放在了相应的位置，所以只需要从开始进行判断
    	for(int i = 0; i < n; i ++) {
    		if(nums[i] != i + 1) {
    			return i + 1;
    		}
    	}
    	return n + 1;
    }
	
}
