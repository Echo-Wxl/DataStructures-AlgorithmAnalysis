class Solution{
    private String s = new String();
    private int left = -1;
    int[] cnt = new int[256];
    int i = -1;

    public void insert(char ch) {
        i++;
        s += ch;
        cnt[(int)ch]++;
        while (left < i && cnt[(int) s.charAt(left + 1)] > 1) {
            ++left;
        }
    }

    public char firstAppearingOnce() {
        if (left >= i) {
            return '#';
        }
        return s.charAt(left+1);
    }
}