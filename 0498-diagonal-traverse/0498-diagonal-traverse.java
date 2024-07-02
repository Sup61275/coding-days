class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Map<Integer,List<Integer>>map=new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int key=i+j;
                if(!map.containsKey(i+j)){
                    map.put(key,new ArrayList<>());
                }
                map.get(key).add(mat[i][j]);
            }
        }
        List<Integer>result=new ArrayList<>();
        for(int i=0;i<map.size();i++){
            List<Integer>temp=map.get(i);
            if(i%2==0){
            Collections.reverse(temp);
            }
           result.addAll(temp);
        }
        int[] ans=new int[n*m];
        int idx=0;
        for(int ele:result){
            ans[idx++]=ele;
         
        }
        return ans;
    }
}