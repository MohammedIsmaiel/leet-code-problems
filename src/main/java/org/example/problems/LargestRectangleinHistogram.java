package org.example.problems;

import java.util.Stack;

/**
 * LargestRectangleinHistogram
 */
public class LargestRectangleinHistogram {

    public int largestRectangleArea(int[] heights) {
        var maxArea = 0;
        var index = 0;
        var heightss = new Stack<Integer>();
        var indeces = new Stack<Integer>();
        for (int i = 0; i < heights.length; i++) {
            if (heightss.isEmpty() || heightss.peek() <= heights[i]) {
                heightss.push(heights[i]);
                indeces.push(i);
            } else {
                while (!heightss.isEmpty() && heightss.peek() > heights[i]) {
                    index = indeces.pop();
                    maxArea = Math.max(maxArea, heightss.pop() * (i - index));
                }
                heightss.push(heights[i]);
                indeces.push(index);
            }
        }
        while (!heightss.isEmpty()) {
            var area = heightss.peek() * (heights.length - indeces.peek());
            heightss.pop();
            indeces.pop();
            maxArea = area > maxArea ? area : maxArea;
        }
        return maxArea;
    }
}