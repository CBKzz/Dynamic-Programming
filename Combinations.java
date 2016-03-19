/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
*/

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
       List<List<Integer>> result=new ArrayList<>();
       if(k<=0||n<=0) return result;
       if(n<=k) {List<Integer> list=new ArrayList<>();
       for(int i=1;i<=n;i++){
           list.add(i);
       }result.add(list);return result;}
       for(int i=1;i<=n-k+1;i++){
           List<Integer> list=new ArrayList<>();
           list.add(i);
           result.add(list);
       }
       int max=n-k+2;
       for(int i=2;i<=k;i++){
           List<List<Integer>> cbk=new ArrayList<>();
           for(List<Integer> temp:result){
               for(int j=temp.get(temp.size()-1)+1;j<=max;j++){
                    List<Integer> tempp=new ArrayList<>(temp);
                    tempp.add(j);
                    cbk.add(tempp);
               }
           }
           result=cbk;
           max++;
       }
       return result;
    }
}
