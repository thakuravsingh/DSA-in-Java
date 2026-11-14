class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        int n = s.length();
        int m = a.length();
        int[] lps1 = new int[m];
        lps1[0] = 0;
        int len = 0;
        int i = 1;
        while(i < m){
            if(a.charAt(i) == a.charAt(len)){
                len++;
                lps1[i] = len;
                i++;
            }
            else{
                if(len != 0) len = lps1[len-1];
                else{
                    lps1[i] = 0;
                    i++;
                }
            }
        }
        List<Integer> list1 = new ArrayList<>();
        i = 0;
        int j = 0;
        while(i < n){
            if(s.charAt(i) == a.charAt(j)){
                i++;
                j++;
            }
            if(j == m){
                list1.add(i-j);
                j = lps1[j-1];
            }
            if(i < n && s.charAt(i) != a.charAt(j)){
                if(j != 0) j = lps1[j-1];
                else i++;
            }
        }
        m = b.length();
        int[] lps2 = new int[m];
        lps2[0] = 0;
        len = 0;
        i = 1;
        while(i < m){
            if(b.charAt(i) == b.charAt(len)){
                len++;
                lps2[i] = len;
                i++;
            }
            else{
                if(len != 0) len = lps2[len-1];
                else{
                    lps2[i] = 0;
                    i++;
                }
            }
        }
        List<Integer> list2 = new ArrayList<>();
        i = 0;
        j = 0;
        while(i < n){
            if(s.charAt(i) == b.charAt(j)){
                i++;
                j++;
            }
            if(j == m){
                list2.add(i-j);
                j = lps2[j-1];
            }
            if(i < n && s.charAt(i) != b.charAt(j)){
                if(j != 0) j = lps2[j-1];
                else i++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        j = 0;
        for(int idx : list1){
            while(j < list2.size() && list2.get(j) < idx - k) j++; 
            if(j < list2.size() && list2.get(j) <= idx + k) ans.add(idx);
        }
        return ans;
    }
}