public class Solution {
    public int maxArea(int[] height) {
        if (height.length<2) return 0;
        int lo=0;
        int hi=height.length-1;
        int max=Integer.MIN_VALUE;
        while(lo<hi){
            max=Math.max(max,(hi-lo)*Math.min(height[lo],height[hi]));
            if(height[lo]<height[hi]) lo++;
            else hi--;
        }
        return max;
    }
}
 
