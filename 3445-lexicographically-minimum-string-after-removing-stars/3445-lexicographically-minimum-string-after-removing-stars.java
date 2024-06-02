class Solution {
    public String clearStars(String s) {
    StringBuilder sb= new StringBuilder();
    PriorityQueue<Character>pq= new PriorityQueue<>();
    for(char c:s.toCharArray()){
        if(c!='*'){
            sb.append(c);
        }else{
            if(!pq.isEmpty()){
                char removedchar=pq.poll();
                sb.deleteCharAt(sb.lastIndexOf(Character.toString(removedchar)));
            }
        }
        if(c!='*'){
            pq.offer(c);
        }
    }
    return sb.toString();
    }
}