import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 001 two sum
 * 给定一个整数数组 `nums` 和一个目标值 `target`，请你在该数组中找出和为目标值的那 **两个** 整数，并返回他们的数组下标。  
 */
public class SearchTwoEleForTarget {
    public static void main(String[] args) {
        // target - arr[i] 差值 div，是否在数组中。输出两个索引位置。
        /* int[] nums = {12, 23, 56, 88, 76, 33, 66, 0, 99};
        int target = 99; */
        // target - arr[i] 差值 div，是否在数组中。输出两个索引位置。
        int[] nums = {-3,4,3,90};
        int target = 0;
        // 用一个栈存储差值，遍历时搜索匹配
        // int[] res = matchDivInStack(nums, target);
        // int[] res = matchDivByMap(nums, target);
        // 最优。1. 哈希表性能优于栈、链表； 2.左右双指针移动。
        int[] res = leftAndRightMatch(nums, target);
        for (int i = 0; i < res.length; i += 2) {
            /* if (res[i] == 0) {
                break;
            } */
            System.out.println("two indexs: " +res[i] + ", " + res[i+1]);
            System.out.println("two elements: " + nums[res[i]] + ", " + nums[res[i+1]]);
        }
    }

    public static int[] matchDivInStack(int[] nums, int target) {
        LinkedList stack = new LinkedList<>();
        int l = nums.length;
//        int[] ans = new int[l];
        int[] ans = new int[2];
        int i, k = 0;
        for(i = 0; i < l; i++) {
            int div = target - nums[i];
            int idx = stack.indexOf(div);
            if (idx < 0) {
                stack.add(nums[i]);
                continue;
            } 
            // 找到了将匹配的另一个值移除掉
            ans[k] = idx;
            ans[k+1] = i;
//            k += 2;
            stack.remove(idx);
        }
        return ans;
    }
    
    public static int[] matchDivByMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = nums.length;
        int[] ans = new int[2];
        int i, k = 0;
        for(i = 0; i < l; i++) {
            // 考虑负数
            /* if (nums[i] > target) {
                continue;
            } */
            if (!map.isEmpty() && map.containsKey(nums[i])) {
                ans[k] = map.get(nums[i]);
                ans[k+1] = i;
                k += 2;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return ans;
    }

    public static int[] leftAndRightMatch(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = nums.length - 1;
        // 左右指针移动
        while (left <= right) {
            int[] m1 = match(nums, left, target, map);
            if (m1 != null) {
                return m1;
            }
            int[] m2 = match(nums, right, target, map);
            if (m2 != null) {
                return m2;
            }
            left ++;
            right --;
        }
        return null;
    }

    private static int[] match(int[] nums, int curr, int target, Map<Integer, Integer> map) {
        // 映射: <div, 下标>, 当前值与key匹配。
        // 没匹配上添加映射；匹配上了，取对应的索引、当前索引。 
        int[] ans = new int[2];
        if (!map.containsKey(nums[curr])) {
            map.put(target-nums[curr], curr);
            return null;
        }
        ans[0] = map.get(nums[curr]);
        ans[1] = curr;
        // 在右半区匹配上，交换顺序
        if (ans[0] > ans[1]) {
            ans[1] = map.get(nums[curr]);
            ans[0] = curr;
        }
        return ans;
    }
}