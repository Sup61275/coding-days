class Solution {
    public List<String> commonChars(String[] words) {
        List<Character>list= new ArrayList<>();
        for(int i=0;i<words[0].length();i++){
            list.add(words[0].charAt(i));
        }
       List<String>result=new ArrayList<>();
        for(int i=1;i<words.length;i++){
            List<Character>CurrentList=new ArrayList<>();
            for(int j=0;j<words[i].length();j++){
               CurrentList.add(words[i].charAt(j));
            }
            List<Character>copy=new ArrayList<>(list);
            for(char c:copy){
                if(!CurrentList.contains(c)){
                    list.remove(Character.valueOf(c));
                }else{
                    CurrentList.remove(Character.valueOf(c));
                }
            }
           
        }
        for(Character c:list){
            result.add(String.valueOf(c));
        }
        return result;
    }
}