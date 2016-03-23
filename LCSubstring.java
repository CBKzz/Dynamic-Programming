public int LCSubstring(String a, String b){
    	int[][] dp=new int[a.length()+1][b.length()+1];
    	int max=0;
    	StringBuilder maxstr=new StringBuilder();
    	for(int i=1;i<a.length()+1;i++){
    		for(int j=1;j<b.length()+1;j++){
    			if(a.charAt(i-1)==b.charAt(j-1)) {
    				dp[i][j]=dp[i-1][j-1]+1;
    				if(dp[i][j]>max){
    					int begin=i-dp[i][j];
    					max=dp[i][j];
    					maxstr=new StringBuilder();
    					maxstr.append(a.substring(begin,i));
    				}
    			}
    		}
    	}
    	for(int i=1;i<a.length()+1;i++){
    		for(int j=1;j<b.length()+1;j++){
    			System.out.print(dp[i][j]+"     ");
    		}
    		System.out.println();
    	}
    	System.out.println(maxstr.toString());
    	return max;
    }
