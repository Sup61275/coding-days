class Solution {
    public int minOperations(String[] logs) {
        int count=0;
        String check="";
        for(int i=0;i<logs.length;i++){
            if(logs[i].equals("../")&& count>0){
                count--;
            }
            else if(logs[i].equals("../")&& count<=0){
                continue;
            }else if(logs[i].equals("./")){
                continue;
            }else{
                count++;
            }
        }
        return count;
    }
}