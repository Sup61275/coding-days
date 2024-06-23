class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer>map= new HashMap<>();
        for(int i=0;i<p.length();i++){
            char c=p.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Integer>result= new ArrayList<>();
        int i=0,n=s.length(),j=0,count=p.length();
        while(j<n){
            char ch=s.charAt(j);
           if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)>=0){
                    count--;
                }
           }
           if(j-i+1>p.length()){
            char start= s.charAt(i);
            if(map.containsKey(start)){
                map.put(start,map.get(start)+1);
                if(map.get(start)>0){
                    count++;
                }
              
            }
              i++;
           }
           if(count==0){
            result.add(i);
           }
           j++;
        }
        return result;
    }
}