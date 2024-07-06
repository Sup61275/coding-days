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
   
}
