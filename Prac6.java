//Min Cost to buy Tickets
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        if(days == null || days.length == 0) {
            return 0;
        }
        int max = days[days.length - 1];
        HashSet<Integer> set = new HashSet<>();
        
        for(int i : days) {
            set.add(i);
        }
        int[] dp = new int[max+1];
        
        for(int i = 1 ; i < dp.length; i++) {
            if(set.contains(i)) {
                int oneDay = dp[i-1] + costs[0];
                int sevenDay = dp[Math.max(i-7, 0)] + costs[1];
                int thirtyDay = dp[Math.max(i-30, 0)] + costs[2];
                dp[i] = Math.min(oneDay, Math.min(sevenDay,thirtyDay));
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[max];
    }
}

//Delete and Earn

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        
        for(int i : nums) {
            max = Math.max(max, i);
        }
        
        int[] arr = new int[max + 1];
        
        for(int i : nums) {
            arr[i] += i;
        }
        
        //System.out.println(Arrays.toString(arr));
        int skip = 0;
        int choose = arr[0];
        for(int i = 0 ; i < arr.length; i++) {
            int tempSkip = skip;
            skip = Math.max(skip,choose);
            choose = tempSkip + arr[i];
        }
        return Math.max(skip,choose);
    }
}

//Set Matrix Zeros

class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return;
        }
        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];
        
        for(int i = 0 ; i < matrix.length; i++) {
            for(int j = 0 ; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }
        
        for(int i = 0 ; i < matrix.length; i++) {
            for(int j = 0 ; j < matrix[0].length; j++) {
                if(rows[i] || columns[j]) {
                    matrix[i][j] = 0;
                } 
                
            }
        }
    }
}

//House Robber
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0 || nums == null) {
            return 0;
        }
        int[] dp = new int[nums.length];
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.max(nums[0],nums[1]);
        }
        
        int skip = 0;
        int choose = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            int prevSkip = skip;
            skip = Math.max(skip,choose);
            choose = prevSkip + nums[i];
        }
        return Math.max(skip, choose);
    }
}