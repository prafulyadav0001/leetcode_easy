class Solution {
    static Set<Character> OPERATIONS = Set.of('*', '+', '-');
    public List<Integer> diffWaysToCompute(String expression) {
        Map<String, List<Integer>> memo = new HashMap<>();
        return solve(expression, memo); 
    }

    List<Integer> solve(String expression, Map<String, List<Integer>> memo) {
        if(memo.containsKey(expression)) {
            return memo.get(expression);
        }
        List<Integer> results = new ArrayList<>();
        int length = expression.length();
        if(length > 0 && length < 3) {
            results.add(Integer.parseInt(expression));
        }
        else {
            for(int i = 0; i < length; i++) {
                char currentChar = expression.charAt(i);
                if(OPERATIONS.contains(currentChar)) {
            List<Integer> leftResults = solve(expression.substring(0, i), memo); 
         List<Integer> rightResults = solve(expression.substring(i+1, length), memo); 
                    for(Integer left : leftResults) {
                        for(Integer right : rightResults) {
                            switch(currentChar) {
                                case '*':                           
                                    results.add(left * right);
                                    break;
                                case '+':
                                    results.add(left + right);
                                    break;
                                case '-':
                                    results.add(left - right);
                                    break;   
                            }              
                        }
                    }
                }
            }
        }
        memo.put(expression, results);
        return memo.get(expression);
    }
}