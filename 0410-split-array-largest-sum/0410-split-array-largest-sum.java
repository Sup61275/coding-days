// class Solution {
//     public int splitArray(int[] nums, int k) {
//     int n = nums.length;
//     int sum = 0;
//     int max = 0;
//      for (int i = 0; i < nums.length; i++) {
//         sum += nums[i];
//         max = Math.max(max, nums[i]);
//     }
//     int start = max;
//     int end = sum;
//     int res = 0;
//     while (start <= end) {
//         int mid = start + (end - start) / 2;
        
//         if (check(nums, k, mid)) {
//             res = mid;
//             start = mid + 1;
//             } else {
//             end = mid - 1;
//         }
//     }
//     return res; 
//     }
//    boolean check(int[] nums, int k, int sum) {
//     int n = nums.length;
//     int equal_sum = 0;
//     int count_of_subarray = 1; // We start with one subarray

//     for (int i = 0; i < n; i++) {
//         if (equal_sum + nums[i] > sum) {
//             count_of_subarray++;
//             equal_sum = nums[i]; // Start new subarray with current element
//             if (count_of_subarray > k) {
//                 return false;
//             }
//         } else {
//             equal_sum += nums[i];
//         }
//     }
//     return true;
// }

// }
class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }

        int start = max;
        int end = sum;
        int res = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (check(nums, k, mid)) {
                res = mid;
                end = mid - 1;  
            } else {
                start = mid + 1;  
            }
        }

        return res;
    }
    boolean check(int[] nums, int k, int maxSum) {
        int count_of_subarray = 1;
        int current_sum = 0;

        for (int num : nums) {
            if (current_sum + num > maxSum) {
                count_of_subarray++;
                current_sum = num;
                if (count_of_subarray > k) {
                    return false; 
                }
            } else {
                current_sum += num;
            }
        }

        return true; 
    }
}
