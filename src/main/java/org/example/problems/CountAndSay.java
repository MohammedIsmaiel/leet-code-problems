package org.example.problems;

public class CountAndSay {

    public String countAndSay(int n) {
        String num = "1";

        if (n == 1) {
            return num;
        }
        for (int i = 1; i <= n - 1; i++) {
            num = say(num);
        }
        return num;
    }

    public String say(String string) {
        StringBuilder output = new StringBuilder("");
        int start = 0;
        for (int i = 1; i <= string.length(); i++) {
            if (i == string.length() || string.charAt(i) != string.charAt(start)) {
                output.append(string.substring(start, i).length()).append(string.charAt(start));
                start = i;
            }
        }
        return output.toString();
    }

        public String countAndSay2(int n) {
            String num = "1";
            if (n == 1) {
                return num;
            }
            for (int i = 2; i <= n; i++) {
                num = say(num);
            }
            return num;
        }
    
        public String say2(String string) {
            StringBuilder output = new StringBuilder();
            int count = 1;
            char prev = string.charAt(0);
            for (int i = 1; i < string.length(); i++) {
                if (string.charAt(i) == prev) {
                    count++;
                } else {
                    output.append(count).append(prev);
                    count = 1;
                    prev = string.charAt(i);
                }
            }
            output.append(count).append(prev);
            return output.toString();
        }
    
    
    
    
    
    
    
}
