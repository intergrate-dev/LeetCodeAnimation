import java.util.Stack;

/**
 * 无重复字符的最长子串
 * 
 */
public class LongestSubstrNoRepeate {
    public static void main(String[] args) {
        // String input = "abcabcbbc";
        String input = "pwwkew"; //pwke  // wke  
        String input1 = "aabcabcbbc";
         searchAndPushByStack(input);
        // slidingWindow(input);
//        slidingWindow(input1);
    }

    private static void searchAndPushByStack(String input) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            String curr = input.charAt(i) + "";
            // stack.search(curr) < 0
            if (stack.indexOf(curr) < 0) {
                stack.push(curr);
            } else {
                String pre = input.charAt(i-1) + "";
                //"cdddddd" 错误
                if (curr.equals(pre) && stack.size() <= 2) {
                    stack.clear();
                    stack.push(curr);
                }
            }
        }
        System.out.println(stack.size()); // stack.stream().count()
    }

    private static void slidingWindow(String input) {
        int[] freq = new int[128];
        int left = 0, right = -1;
        int res = 0;
        while(left < input.length()) {
            if (right + 1 < input.length() && freq[input.charAt(right + 1)] == 0) {
                right++;// (0)
                freq[input.charAt(right)]++;// (97,1)
            } else {
                freq[input.charAt(left)]--;
                left++;
            }
                res = Math.max(res, right - left + 1);// (1)
        }
        System.out.println(res); // stack.stream().count()
    }
}
