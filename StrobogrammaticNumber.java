public class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> odd=new ArrayList<>();
        if(n==0) return odd;
        odd.add("0");
        odd.add("1");
        odd.add("8");
        if(n==1) return odd;
        List<String> even=new ArrayList<>();
        even.add("");
        int i=2;
        while(true){
            if((i&1)==0){
                even=modify(even);
                if(i==n){
                    return removeZero(even);
                }
            }
            else{
                odd=modify(odd);
                if(i==n){
                    return removeZero(odd);
                }
            }
            i++;
        }
    }
    public List<String> removeZero(List<String> list){
        List<String> result=new ArrayList<>();
        for(String s:list){
            if(!s.startsWith("0")) result.add(s);
        }
        return result;
    }
    public List<String> modify(List<String> list){
        List<String> temp=new ArrayList<>();
        for(String s:list){
            temp.add(6+s+9);
            temp.add(9+s+6);
            temp.add(1+s+1);
            temp.add(8+s+8);
            temp.add(0+s+0);
        }
        return temp;
    }
}
