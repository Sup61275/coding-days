class BrowserHistory {
    Stack<String> history;
    Stack<String> future;
    String curr;

    public BrowserHistory(String homepage) {
        history = new Stack<>();
        future = new Stack<>();
        curr = homepage;
    }
    public void visit(String url) {
        history.add(curr);
        curr = url;
        future = new Stack<>(); // This clears the future stack
    }
    public String back(int steps) {
        while (steps-- > 0 && !history.isEmpty()) {
            future.add(curr); // Move the current page to the future stack
            curr = history.pop();
        }
        return curr;
    }
    public String forward(int steps) {
        while (steps-- > 0 && !future.isEmpty()) {
            history.add(curr); // Move the current page to the history stack
            curr = future.pop();
        }
        return curr;
    }
}

