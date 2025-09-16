class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int l = 0, r = 0, subl = 0, subr = 0, formed = 0, total = map.size();
        int lenans = Integer.MAX_VALUE;

        while (r < s.length()) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) formed++;
            }

            while (l <= r && formed == total) {
                int curlen = r - l + 1;
                if (curlen < lenans) {
                    lenans = curlen;
                    subl = l;
                    subr = r + 1;
                }
                char leftc = s.charAt(l);
                if (map.containsKey(leftc)) {
                    if (map.get(leftc) == 0) formed--;
                    map.put(leftc, map.get(leftc) + 1);
                }
                l++;
            }
            r++;
        }
        return lenans == Integer.MAX_VALUE ? "" : s.substring(subl, subr);
    }
}