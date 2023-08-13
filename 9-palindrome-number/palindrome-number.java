class Solution {
    public static boolean isPalindrome(int x) {
          int rev=0;
          int original=x;
        if (x < 0) {
            return false;
        }

        while(x!=0){
               rev=rev*10+x%10;
              x/=10;
          }



              return original==rev;

    }
    public static void main(String[] args) {
      int x=121;
        System.out.println(isPalindrome(x));

    }
}