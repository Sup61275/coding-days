class WordDictionary {
    private Set<String>set;
    public WordDictionary() {
        set= new HashSet<>();
    }
    
    public void addWord(String word) {
        set.add(word);
    }
    
    public boolean search(String word) {
        if(set.contains(word)){
            return true;
        }
        if(word.contains(".")){
            for(String setword:set){
                if(matches(setword,word)){
                    return true;
                }
            }
        }

        return false;
    }
    private boolean matches(String setword,String searchword){
        if(setword.length()!=searchword.length()){
            return false;
        }
        for(int i=0;i<setword.length();i++){
            if(searchword.charAt(i)!='.'&& searchword.charAt(i)!=setword.charAt(i)){
                return false;
            }
        }
        return true;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */