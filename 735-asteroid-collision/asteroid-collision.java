class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int aster : asteroids) {
            if (aster > 0) {
                stack.push(aster);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -aster) {
                stack.pop();    
            }
            if (!stack.isEmpty() && stack.peek() > 0 && stack.peek() == -aster){
                stack.pop();
                continue;
            }
            if (stack.isEmpty() || stack.peek() < 0){
                stack.push(aster);
            }
            
        }
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; --i) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}