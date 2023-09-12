class Solution {
    public int[] sortArray(int[] nums) {
        int lb = 0;
        int ub = nums.length - 1; 
        int[] result = new int[nums.length];
        mergeSort(nums, result, lb, ub); 
        return result; 
    }

    private void mergeSort(int[] a, int[] b, int lb, int ub) {
        if (lb < ub) {
            int mid = (lb + ub) / 2;
            mergeSort(a, b, lb, mid);
            mergeSort(a, b, mid + 1, ub);
            merge(a, b, lb, mid, ub);
        }
    }

    private void merge(int[] a, int[] b, int lb, int mid, int ub) {
        int i = lb;
        int j = mid + 1;
        int k = lb;
        
        while (i <= mid && j <= ub) {
            if (a[i] < a[j]) {
                b[k] = a[i];
                i++;
            } else {
                b[k] = a[j];
                j++;
            }
            k++;
        }
        
        while (i <= mid) {
            b[k] = a[i];
            i++;
            k++;
        }
        
        while (j <= ub) {
            b[k] = a[j];
            j++;
            k++;
        }
        
        for (int f = lb; f <= ub; f++) {
            a[f] = b[f];
        }
    }
}

