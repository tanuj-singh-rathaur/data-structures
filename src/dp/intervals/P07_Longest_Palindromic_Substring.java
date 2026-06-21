package dp.intervals;
import util.Test;
/**
 * Longest Palindromic Substring
 * Topic    : DP Intervals
 * Pattern  : dp[i][j] true iff s[i..j] is palindrome; expand-around-centre alt
 * Difficulty: Medium
 * Source   : LC 5
 */
public class P07_Longest_Palindromic_Substring {
    public static void main(String[] args) {
        P07_Longest_Palindromic_Substring sol = new P07_Longest_Palindromic_Substring();
        Test.summary();
    }
}
