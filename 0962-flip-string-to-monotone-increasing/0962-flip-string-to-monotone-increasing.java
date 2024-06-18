class Solution {
    public int minFlipsMonoIncr(String s) {
       int count_ofOnes=0;
       int flip=0;
       for(int i=0;i<s.length();i++){
        if(s.charAt(i)=='1'){
            count_ofOnes++;
        }else{
            flip=Math.min(flip+1,count_ofOnes);
        }
       }
       return flip;
    }
}
