import java.util.*;

class Solution {
    public int findMaxLength(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        
        int maxLen = 0;
        int presum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] == 0) {
                presum -= 1;
            } else if(nums[i] == 1) {
                presum += 1;
            }
            
            if(map.containsKey(presum)) {
                int idx = map.get(presum);
                int currLen = i - idx;
                maxLen = Math.max(maxLen, currLen);
            } else {
                map.put(presum, i);
            }
        }
        return maxLen;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();

        String input = scanner.nextLine();
        Scanner ss = new Scanner(input);
        List<Integer> nums = new ArrayList<>();
        while (ss.hasNextInt()) {
            nums.add(ss.nextInt());
        }

        int[] numsArray = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            numsArray[i] = nums.get(i);
        }

        int result = solution.findMaxLength(numsArray);
        System.out.println(result);
    }
}
