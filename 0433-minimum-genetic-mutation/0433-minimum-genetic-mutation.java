class Solution {
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String>bankSet= new HashSet<>(Arrays.asList(bank));
        Set<String>visited= new HashSet<>();
        Queue<String>que= new LinkedList<>();
        que.add(start);
        visited.add(start);
        int level=0;
        while(!que.isEmpty()){
            int n = que.size();
            while(n-->0){
            String curr= que.poll();
            if(curr.equals(end)){
                return level;
            }
            for(char ch:"ACGT".toCharArray()){
                for(int i=0;i<curr.length();i++){
                    char[]neighbourArray=curr.toCharArray();
                    neighbourArray[i]=ch;
                    String neighbour= new String(neighbourArray);
                    if(!visited.contains(neighbour) && bankSet.contains(neighbour)){
                        visited.add(neighbour);
                        que.add(neighbour);
                    }
                }

            }
            }
            level++;
        }
        return -1;
    }
}