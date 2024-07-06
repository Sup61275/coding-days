class Solution {
    public int passThePillow(int n, int time) {
        int period = 2 * (n - 1);
        int effectiveTime = time % period;
        if (effectiveTime < n) {
            return effectiveTime + 1;
        } else {
           
            return 2 * n - effectiveTime - 1;
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n1 = 4, time1 = 5;
        System.out.println(sol.passThePillow(n1, time1)); 
        int n2 = 3, time2 = 2;
        System.out.println(sol.passThePillow(n2, time2));
    }
}
