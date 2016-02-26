public int maxProduct(int[] nums){
	    	int result=-1;
	    	int max=nums[nums.length-1];
	    	for(int i=nums.length-2;i>=0;i--){
	    		if(nums[i]>max){
	    			max=nums[i];
	    		}
	    		else{
	    			result=Math.max(result, max*nums[i]);
	    		}
	    	}
	    	return result;
	    }
