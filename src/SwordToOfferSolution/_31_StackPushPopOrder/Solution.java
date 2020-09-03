package SwordToOfferSolution._31_StackPushPopOrder;

import java.util.Stack;

/*
 * 栈的压入、弹出序列
 *
 * 题目描述：
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列 1、2、3、4、5 是某栈的压栈序列，序列 4、5、3、2、1 是该压栈序列对应的一个弹出序列；
 * 但 4、3、5、1、2 就不可能是该压栈序列的弹出序列。
 * pushed 是 popped 的排列。
 *
 * 思路：
 * 1. 首先把入栈序列的第一个元素放入辅助栈中，这时判断栈顶元素和出栈序列的第一个元素是否相等。如果不等则继续压栈，
 *    直到相等后开始出栈；
 * 2. 出栈后再将出栈序列的位置往后移动一位，继续判断；
 * 3. 等到入栈序列都遍历完以后，如果出栈序列还有元素的话，则该出栈序列就不是该栈的弹出顺序。
 * 4. 由于 pushed 是 popped 的排列，因此无需考虑两个数组的长度不同或包含元素不同等问题。
 *
 * 总结：
 * 设置一个辅助栈，把输入的第一个序列中的数字一次压入辅助栈，然后按照第二个序列中的顺序依次从该栈中弹出。
 * 如果下一个要弹出的数字刚好是栈顶数字，则直接弹出；
 * 如果下一个要弹出的数字不在栈顶，则把压栈序列中还没有入栈的数字压入辅助栈，直到把下一个需要弹出的数字压入栈顶为止；
 * 如果所有数字都压入栈后仍没有找到下一个弹出的数字，则该序列就不是一个弹出序列。
 */
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null) {
            return false;
        }
        if (pushed.length == 0 && popped.length == 0) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 1, 2};

        System.out.println(solution.validateStackSequences(pushed, popped)); // f
    }
}
