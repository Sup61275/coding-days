class Solution {
    public double myPow(double x, int n) {
     if (n == 0) {
            return 1.0;
        }
        if(n<0){
            x=1/x;
            n=-n;

        }
        return helperPow(x,n);
    }
    public double helperPow(double x, long n){
        if(n==0){
            return 1;
        }
        double half=helperPow(x,n/2);
        if(n%2==0){
            return half*half;
        }else{
            return half*half*x;
        }
    }
   
}