//First element should be present in a lower index than the second element.
//First element should be strictly lesser than the second element.
//all elements are positive
public int maxProduct(int[] nums){
	int result=-1;
    	int max=nums[nums.length-1];
    	for(int i=nums.length-2;i>=0;i--){
    		if(nums[i]>=max){//strictly lesser than!!! so if we want no greater than, we can take off the equal
    			max=nums[i];//possible right
	    	}
	    	else{
	    		result=Math.max(result, max*nums[i]);//possible left
	    	}
    	}
	return result;
}
//common maximum product
//scan the array, denote four numbers, two smallest negative numbers and two biggest positive numbers

//what if this question has negative elements?

/*
method one:
we are looking for such a and b, so a.index<b.index and a<b

*/
public static int maxProduct(int[] a){
	    	int result=-1;
	    	int[] nums=new int[a.length];
	    	for(int i=0;i<nums.length;i++){
	    		nums[i]=-a[i];
	    	}
	    	int max=nums[0];
	    	for(int i=1;i<nums.length;i++){
	    		if(nums[i]>=max){
	    			max=nums[i];
	    		}
	    		else{
	    			result=Math.max(result, max*nums[i]);
	    		}
	    	}
	    	return result;
	
}
/*
method two:
for positive numbers, we use a max to denote the so_far_largest element, because the largest value must be onbtained by the product the two biggest one
while, for negative numbers, the maximum product can be obtained by the product of the smallest element. Therefore we should scan
from the head of the array.
*/
public static int maxProduct2(int[] nums){
	int result=-1;
    	int min=nums[0];
    	for(int i=0;i<nums.length;i++){
    		if(nums[i]<=min){
    			min=nums[i];
	    	}
	    	else{			
	    		result=Math.max(result, min*nums[i]);
	    	}
	}
	return result;
}

//test programm
public static void main(String[] args) {
	
	for(int j=0;j<1000;j++){
		Random r=new Random();
		int l=r.nextInt(5)+1;
		int[] nums=new int[l];
		for(int i=0;i<l;i++){
			nums[i]=-(r.nextInt(50)+1);
		}
		if(maxProduct(nums)!=maxProduct2(nums))
		{
			System.out.println(Arrays.toString(nums));
			System.out.println("je");
			break;
		}
		
	}
}

