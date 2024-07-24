class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
       int n=nums.length;
       int mappedNum=0;
       int[][]Mappedlist=new int[n][2];
       for(int i=0;i<n;i++){
        mappedNum=mappednum(mapping,nums[i]);
        Mappedlist[i][0]=mappedNum;
        Mappedlist[i][1]=i;
       }
       Arrays.sort(Mappedlist,(a,b)->Integer.compare(a[0],b[0]));
       int[]result= new int[n];
       for(int i=0;i<n;i++){
        result[i]=nums[Mappedlist[i][1]];
       }
       return result;

    }
    int mappednum(int[]mapping, int num){
        if(num<10){
            return mapping[num];
        }
        int placevalue=1;
        int mappednum=0;
        while(num>0){
            int lastdigit=num%10;
            mappednum+=mapping[lastdigit]*placevalue;
            placevalue*=10;
            num/=10;
            
        }
        return mappednum;
    }
    
}