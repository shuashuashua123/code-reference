// Longest Palindromic Substring

private int lo, maxLen;

public String longestPalindrome(String s) {
    int len = s.length();
    if (len < 2)
        return s;
    
    for (int i = 0; i < len - 1; i++) {
        extendPalindrome(s, i, i);   //assume odd length, try to extend Palindrome as possible
        extendPalindrome(s, i, i+1); //assume even length.
    }
    return s.substring(lo, lo + maxLen);
}

private void extendPalindrome(String s, int j, int k) {
    while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
        j--;
        k++;
    }
    if (maxLen < k - j - 1) {
        lo = j + 1;
        maxLen = k - j - 1;
    }
}

// Trapping Rain Water

public int trap(int[] height) {
    if (height == null || height.length == 0) {
        return 0;
    }
    
    int left = 0;
    int right = height.length - 1;

    int leftHeight = height[left];
    int rightHeight = height[right];
    
    int ans = 0;
    while (left < right) { // left + 1 < right is ok as well
                           // since when left + 1 == right, last loop
                           // leftHight == rightHeight
        if (height[left] < height[right]) {
            left++;
            // update status of left 
            if (leftHeight > height[left]) {
                ans += leftHeight - height[left];
            } else{
                leftHeight = height[left];                     
            }
        } else {
            right--;
            // update status of right
            if (rightHeight > height[right]) {
                ans += rightHeight - height[right];
            } else {
                rightHeight = height[right];
            }
        }
    }
    
    return ans;
}

Find All Anagrams in a String
- sliding window - fixed size 
public List<Integer> findAnagrams(String s, String p) {
    List<Integer> res = new ArrayList<>();
    
    int left = 0, right = 0;
    int matchSize = p.length();
    int[] map = new int[256];
    
    for (char c : p.toCharArray()) {
        map[c]++;
    }
    
    char[] ch = s.toCharArray();
    while (right < s.length()) {
        if (map[ch[right]] > 0) {
            matchSize--;
        }
        map[ch[right]]--;
        
        // sliding window: [left, right] - both are inclusive
        if (right - left == p.length() - 1) {
            if (matchSize == 0) {
                res.add(left);
            }
            
            if (map[ch[left]] >= 0) {
                matchSize++;
            }
            map[ch[left]]++;
            left++;
        }
        right++;
    }
    
    return res;
}