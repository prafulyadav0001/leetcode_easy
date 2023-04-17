class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res=new ArrayList<>();
        int maxcandy=0;
        for (int can:candies) {
            maxcandy=Math.max(maxcandy,can);
        }
        for (int candy:candies) {
            res.add(candy+extraCandies>=maxcandy);
        }
      return res;
    }
}