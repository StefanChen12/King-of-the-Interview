/**
 * test
 */
public class QuickSort {

    static void showNums(int[] nums) {
        for (int num : nums) {
            System.out.printf("%d ", num);
        }
        System.out.println("");
    }

    private static void swap(int[] nums, int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }

    /**
     * 快速排序
     * 
     * @param nums
     * @param l
     * @param r
     */
    private static void quickSort(int[] nums, int l, int r) {
        if (l >= r)
            return;
        int i = l - 1, j = r + 1, m = nums[l + r >> 1];
        while (i < j) {
            do
                i++;
            while (nums[i] < m);
            do
                j--;
            while (nums[j] > m);
            if (i < j)
                swap(nums, i, j);
        }
        quickSort(nums, l, j); // left nums range
        quickSort(nums, j + 1, r); // right nums range
    }

    /**
     * 快速选择第K小元素
     * 
     * @param nums
     * @param l
     * @param r
     * @param k
     */
    private static int quickSelect(int[] nums, int l, int r, int k) {
        if (l >= r)
            return nums[l];
        int i = l - 1, j = r + 1, m = nums[l + r >> 1];
        while (i < j) {
            do
                i++;
            while (nums[i] < m);
            do
                j--;
            while (nums[j] > m);
            if (i < j)
                swap(nums, i, j);
        }
        if (j - l + 1 >= k) {
            return quickSelect(nums, l, j, k);
        } else {
            return quickSelect(nums, j + 1, r, k - (j - l + 1));
        }
    }

    public static void main(String[] args) {
        // 快速排序
        int[] nums = { 1, 2, 4, 3, 6, 5, 7 };
        quickSort(nums, 0, nums.length - 1);
        showNums(nums);
        // 快速选择
        int k = 3;
        int[] nums2 = { 1, 2, 4, 3, 6, 5, 7 };
        int res = quickSelect(nums2, 0, nums2.length - 1, k);
        System.out.println(res);
    }
}