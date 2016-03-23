    public int LCS(String a, String b){
    	int[][] dp=new int[a.length()+1][b.length()+1];
    	
    	Set<StringBuilder>[][] result=new Set[a.length()+1][b.length()+1];
    	for(int i=1;i<a.length()+1;i++){
    		for(int j=1;j<b.length()+1;j++){
    			if(a.charAt(i-1)==b.charAt(j-1)){
    				dp[i][j]=dp[i-1][j-1]+1;
    				Set<StringBuilder> list=new HashSet<>();
    				if(result[i-1][j-1]==null) {
    					StringBuilder sss=new StringBuilder();
    					sss.append(a.charAt(i-1));
    					list.add(sss);
    					result[i][j]=list;
    					continue;
    				}
    				for(StringBuilder s:result[i-1][j-1]){
    					StringBuilder temp=new StringBuilder(s);
    					temp.append(a.charAt(i-1));
    					list.add(temp);
    				}
    				result[i][j]=list;
    			}
    			else{
    				dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
    				Set<StringBuilder> list1=result[i-1][j];
    				Set<StringBuilder> list2=result[i][j-1];
    				if(list1!=null&&list2==null) result[i][j]=new HashSet<>(list1);
    				else if(list1==null&&list2!=null) result[i][j]=new HashSet<>(list2);
    				else if(list1!=null&&list2!=null) {
    					if(dp[i-1][j]>dp[i][j-1]){
    						result[i][j]=new HashSet<>(list1);
    					}
    					else if(dp[i-1][j]<dp[i][j-1]){
    						result[i][j]=new HashSet<>(list2);
    					}
    					else {
    						result[i][j]=new HashSet<>(list1);
    						result[i][j].addAll(list2);
    					}
    				}
    				
    			}
    		}
    	}
    	for(int i=0;i<a.length()+1;i++){
    		for(int j=0;j<b.length()+1;j++){
    			String temp=result[i][j]==null?"null":result[i][j].toString();
    			System.out.print(temp+"         ");
    		}
    		System.out.println();
    	}
    	return dp[a.length()][b.length()];
    }
