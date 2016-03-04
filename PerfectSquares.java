public class Solution {
    /*
public static int numSquares(int n) {
	        int[] a=new int[n+1];
	        a[1]=1;
	        for(int i=2;i<=n;i++){
	            if(Math.sqrt(i)%1==0) {
	                a[i]=1;continue;
	            }
	            int min=n;
	            for(int j=1;j<=i/2;j++){
	                if(a[i-j]+a[j]<min) min=a[i-j]+a[j];
	            }
	            a[i]=min;
	        }
	        return a[n];
	    }
	    */
	    public int numSquares(int n){
		     int[] a=new int[n+1];
		     for(int i=1;i<=n;i++){
		         int sqr=(int)Math.sqrt(i);
		        
		         if(sqr*sqr==i){ a[i]=1;continue;}
		         int min=n;
		         for(int j=1;j<=sqr;j++){
		        	 
		             if(a[i-j*j]+1<min) min=a[i-j*j]+1;
		         }
		         a[i]=min;
		     }
		     return a[n];
		 }
    
}
