//Given an array which contains just 3 elements i.e. 0s, 1s and 2s.
//Sort the array in linear time and using constant space.
//
//Eg. Input: [0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0]
//    Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2]

class Solution {
    public void sort(int[] arr) {
        int start = 0;
        int mid = 0;
        int end = arr.length - 1;
        int pivot = 1;

        while (mid <= end)
        {
            // current element is 0
            if (arr[mid] < pivot)
            {
                swap(arr, start, mid);
                start++;
                mid++;
            }
            else if (arr[mid] > pivot)
            {
                // current element is 2
                swap(arr, mid, end);
                end--;
            }
            else {
                // current element is 1
                mid++;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}