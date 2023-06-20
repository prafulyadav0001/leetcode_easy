class Solution {
    public boolean isValid(String s) {
       if (s.length() == 1)
            return false;

        var openedBrackets = new ArrayDeque<Character>();

        for (char bracket : s.toCharArray()) {
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                openedBrackets.push(bracket);
                continue;
            } 

            if (openedBrackets.isEmpty())
                return false;

            switch (bracket) {
                case ')':
                    if (openedBrackets.pop() != '(') return false;
                    break;
                case ']':
                    if (openedBrackets.pop() != '[') return false;
                    break;
                case '}':
                    if (openedBrackets.pop() != '{') return false;
                    break;
                default:
                    return false;
            }
        }

        return openedBrackets.isEmpty();
    }
}