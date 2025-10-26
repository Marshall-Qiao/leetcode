class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        Stack<Integer> st = new Stack<>();
        int n = 0;
        StringBuilder sb = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                n = n * 10 + (c - '0');
                continue;
            }
            if (c == '[') {
                st.push(n);
                n = 0;
                stack.push(sb);
                sb = new StringBuilder();
                continue;
            }
            if (c == ']') {
                int k = st.pop();
                StringBuilder temp = sb;
                sb = stack.pop();
                while (k > 0) {
                    sb.append(temp);
                    k--;
                }
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}