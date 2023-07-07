class Solution {
      public boolean isHappy(int n) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        while(n!=1)
        {
            int t=n;
            n=0;
            while(t>0)
            {
                n+= Math.pow((t%10),2);
                t=t/10;
            }
            if(l.contains(n))
                return false;
                
            else
                l.add(n);
        }
        return true;
    }
}