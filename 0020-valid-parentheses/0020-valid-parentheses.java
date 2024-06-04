class Solution {
    public boolean isValid(String s) {
        
        Stack<Character>stack= new  Stack<>();
        for(int i=0;i<s.length();i++){
            char currEle=s.charAt(i);
            if(!stack.isEmpty()){
            char topEle=stack.peek();
            
            if(topEle=='('&&currEle==')'||topEle=='{'&&currEle=='}'||topEle=='['&&currEle==']'){
                stack.pop();
                continue;
                }
            }
            stack.push(s.charAt(i));
            
            
        }
        return stack.isEmpty();
       
    }
}