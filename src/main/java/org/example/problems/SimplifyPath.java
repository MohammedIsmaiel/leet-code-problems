package org.example.problems;

import java.util.Stack;

/**
 * SimplifyPath
 */
public class SimplifyPath {
    public static void main(String[] args) {
        String[] subPaths = "/sdsds/./../..///asda/asd".split("(?=/)");
        for (String s : subPaths) {
            System.out.println(s);
        }
    }

    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        String[] subPaths = path.split("(?=/)");
        for (String s : subPaths) {
            switch (s) {
                case "/":
                    if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '/') {
                        break;
                    }
                    sb.append(s);
                    break;
                case "/.":
                    break;
                case "/..":
                    // Handle removing the last input in the StringBuilder
                    int lastSlashIndex = sb.lastIndexOf("/");
                    if (lastSlashIndex > 0) {
                        sb.delete(lastSlashIndex, sb.length());
                    }
                    break;
                default:
                    sb.append(s);
                    break;
            }
        }
        if (sb.length() > 1 && sb.charAt(sb.length() - 1) == '/')
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public String simplifyPath2(String path) {
        Stack<String> stack = new Stack<>();
        String[] subPaths = path.split("(?=/)");
        for (String s : subPaths) {
            switch (s) {
                case "/":
                    if (stack.isEmpty())
                        break;
                    if (stack.peek() == "/")
                        break;
                    break;
                case "/.":
                    break;
                case "/..":
                    if (stack.isEmpty())
                        break;
                    stack.pop();
                    break;
                default:
                    stack.push(s);
                    break;
            }
        }
        return stack.isEmpty() ? "/" : String.join("", stack);
    }
}