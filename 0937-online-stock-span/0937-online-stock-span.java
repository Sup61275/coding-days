class StockSpanner {
    Stack<Integer>prices;
    Stack<Integer>spans;
    
    public StockSpanner() {
        prices= new Stack<>();
        spans=new Stack<>();
    }
    
    public int next(int price) {
        int span=1;
        while(!prices.isEmpty()&& prices.peek()<=price){
            prices.pop();
            span+=spans.pop();

        }
        prices.push(price);
        spans.push(span);
        return span;
    }
}

