package DSA.Strings;

/*
notes:
this implements atoi exactly as defined in the problem, step by step. 
the logic is intentionally broken into phases so edge cases don’t mix up.

first, all leading spaces are removed. if the string becomes empty after trimming, return 0 immediately. 
then the sign is handled. only one sign is allowed at the beginning. 
if the first non-space character is not a digit or a sign, the result is 0.

after that, digits are read one by one. leading zeros are skipped so they don’t mess with overflow checks later. 
digit reading stops as soon as a non-digit character is found. everything after that is ignored.

overflow is handled without using long. instead, the length of the collected digits is checked. 
if digits exceed 10, it will definitely overflow int range. 
if exactly 10 digits, a string comparison with INT_MAX or INT_MIN boundary is done.
this avoids arithmetic overflow and keeps the solution safe.

finally the number is parsed and the sign is applied. 
overall this follows the problem constraints strictly and handles all tricky cases.
*/

class Solution {
    public int myAtoi(String s) {

        // step-1
        String str = s.trim();
        int n = str.length();
        if (n == 0) return 0;

        //step-2
        int i = 0;
        boolean minus = false;
        char init = str.charAt(0);
        if (init == '-') {
            minus = true;
            i++;
        } else if (init == '+') {
            i++;
        } else if (!Character.isDigit(init)) {
            return 0;
        }

        if (i < n && !Character.isDigit(str.charAt(i))) {
            return 0;
        }

        //step-3
        boolean leading = true;
        StringBuilder sb = new StringBuilder();
        while (i < n) {
            char c = str.charAt(i);

            if (leading && c == '0') {
                i++;
                continue;
            } else if (leading && c != '0') {
                leading = false;
            }

            if (!leading) {
                if (Character.isDigit(c)) {
                    sb.append(c);
                } else {
                    break;
                }
                i++;
            }
        }

        if (sb.length() == 0) return 0;

        //step-4
        if (sb.length() > 10) {
            return minus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        if (sb.length() == 10) {
            String limit = minus ? "2147483648" : "2147483647";
            if (sb.toString().compareTo(limit) > 0) {
                return minus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            if (minus && sb.toString().equals("2147483648")) {
                return Integer.MIN_VALUE;
            }
        }

        int res = Integer.parseInt(sb.toString());
        return minus ? -res : res;
    }
}
