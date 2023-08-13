import java.util.*;
class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int n1 = m + n;
        double median=0;
        int i=0,j=0,k=0;
        int[] temp = new int[n1];
        while (i < m && j < n)
        {
            if(nums1[i] <= nums2[j])
            {
                temp[k] = nums1[i];
                i++;
            }
            else
            {
                temp[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i<m)
        {
            temp[k] = nums1[i];
            i++;
            k++;
        }

        while (j<n)
        {
            temp[k] = nums2[j];
            j++;
            k++;
        }
        if (n1 % 2 == 0) {
                median = (double)(temp[n1/2-1 ] + temp[n1/2])/2;

            } else {
                median = temp[n1/2];
            }


        return median;
    }



    public static void main(String[] args) {
        int []nums1={1,2};
       int []nums2={3,4};
       System.out.println( findMedianSortedArrays( nums1,  nums2));
    }
}


