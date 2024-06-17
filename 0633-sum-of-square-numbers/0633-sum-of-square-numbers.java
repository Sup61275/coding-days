class Solution {
    public boolean judgeSquareSum(int c) {
         if(c==0){
            return true;
         }
        long a=0;
        double sqrtC = Math.sqrt(c);

        // Cast the result to an int
        long b = (long) sqrtC;
       
        while(a<=b){
            if(a*a+b*b>c){
              b--;
            }else if(a*a+b*b<c) {
               a++;
            }
            if(a*a+b*b==c){
                return true;
            }
           
        }
         return false;
    }
}