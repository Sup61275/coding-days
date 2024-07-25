class Solution {
    public int[] sortArray(int[] nums) {
       int n=nums.length;
       int lb=0,ub=n-1;
       int[]result= new int[n];
       mergeSort(nums,result,lb,ub);
       return result; 
    }
    public void mergeSort(int[]a,int[]b,int lb,int ub){
        if(lb<ub){// it means we have atleast 2 elements so we can divide it.
        int mid=lb+(ub-lb)/2;
        mergeSort(a,b,lb,mid);
        mergeSort(a,b,mid+1,ub);
        merge(a,b,lb,mid,ub);
        }
    }
    public void merge(int[]a,int[]b,int lb,int mid,int ub){
        int i=lb,j=mid+1,k=lb;
        while(i<=mid&&j<=ub){
            if(a[i]<a[j]){
                b[k]=a[i];
                i++;
            }else{
                b[k]=a[j];
                j++;
            }
            k++;
        }
        while(i<=mid){
            b[k]=a[i];
            i++;
            k++;
        }
        while(j<=ub){
            b[k]=a[j];
            j++;
            k++;
        }
        for(int f=lb;f<=ub;f++){
            a[f]=b[f];
        }

    }
}