class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int unsat = 0;
        for (int i = 0; i < minutes; i++) {
            unsat += customers[i] * grumpy[i];
        }

        int maxUnsat = unsat;
        int i = 0;
        int j = minutes;

        while (j < n) {
            unsat += customers[j] * grumpy[j];  
            unsat -= customers[i] * grumpy[i]; 
            
            maxUnsat = Math.max(maxUnsat, unsat);  
            i++;
            j++;
        }

        int totalCustomers = maxUnsat;
        for (int k = 0; k < n; k++) {
            totalCustomers += customers[k] * (1 - grumpy[k]);
        }

        return totalCustomers;
    }
}