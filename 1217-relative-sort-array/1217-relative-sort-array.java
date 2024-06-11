class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
      TreeMap<Integer, Integer> map = new TreeMap<>();
      for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int i = 0;
        for (int num : arr2) {
            while (map.get(num) > 0) {
                arr1[i++] = num;
                map.put(num, map.get(num) - 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int freq = entry.getValue();
            while (freq > 0) {
                arr1[i++] = key;
                freq--;
            }
        }

        return arr1;
    }
}