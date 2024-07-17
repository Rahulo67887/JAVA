import java.util.Stack;

public class trappedWater {
    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        Stack<Integer> stack = new Stack<>();
        int waterTrapped = 0;
        int current = 0;

        while (current < n) {
            // While stack is not empty and the current height is greater than the height of the top bar of the stack
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();

                if (stack.isEmpty()) {
                    break;
                }

                int distance = current - stack.peek() - 1;
                int boundedHeight = Math.min(height[current], height[stack.peek()]) - height[top];
                waterTrapped += distance * boundedHeight;
            }

            stack.push(current++);
        }

        return waterTrapped;
    }

    public static void main(String[] args) {
        int[] height = {7,0,4,2,5,0,6,4,0,5};
        System.out.println("Water trapped: " + trap(height)); // Output: 6
    }
}
