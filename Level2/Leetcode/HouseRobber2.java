public class HouseRobber2 {

    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        // either include first element or inclde last element
        // hence find for both two and return max
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int lo, int hi) {

        int p = 0, rob = 0, notRob = 0;
        for (int i = lo; i <= hi; i++) {
            p = rob;
            rob = notRob + nums[i];
            notRob = Math.max(p, notRob);

        }
        return Math.max(rob, notRob);
    }
}
