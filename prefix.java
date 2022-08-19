class prefix {

    public String longestCommonPrefix(String[] strs) {

            if(strs.length==0)
                return"";
            String pref=strs[0];                               //taking only first string to compare all strings in array
            for(int i=1;i<strs.length;i++){              // taking from 2nd string to last number of string.
                while(strs[i].indexOf(pref)!=0){             // comparing 2nd string to first string
                    pref=pref.substring(0, pref.length()-1);    // if does not match with 2nd string i will delete last letter of the 1st string and again  i will compare with 2nd string..i will do till end of the string
                }
            }


            return pref;
        }

    public static void main(String[] args) {
        prefix p=new prefix();
        String [] s={"dog","d","d"};
        System.out.println(p.longestCommonPrefix(s));
    }
}