class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drink = numBottles;
        while (numBottles >= numExchange) {
            int newBottles = numBottles / numExchange;  
            int remainingBottles = numBottles % numExchange;  
            drink += newBottles; 
            numBottles = newBottles + remainingBottles;  
        }
        
        return drink;  
    }
}
