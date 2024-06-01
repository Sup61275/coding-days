class Solution {
    public int nthUglyNumber(int n) {
        int[] arr = new int[n];
        arr[0] = 1; 
        int i1 = 0, i2 = 0, i3 = 0;
        for (int i = 1; i < n; i++) {
            int numi1 = arr[i1] * 2;
            int numi2 = arr[i2] * 3;
            int numi3 = arr[i3] * 5;
            int curr_uglyNo = Math.min(numi1, Math.min(numi2, numi3));
            arr[i] = curr_uglyNo;

            if (curr_uglyNo == numi1) i1++;
            if (curr_uglyNo == numi2) i2++;
            if (curr_uglyNo == numi3) i3++;
        }

        return arr[n - 1];
    }
}