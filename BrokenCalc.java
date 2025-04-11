// In this problem, trying to explore all possible paths that gives us the target, do a BFS,  we recursively multiply by 2 and 
// substract 1, and keep on adding to the queue the subtract ans if value is greater than the target, else we add both.
// But this will give us time limit exceeded.
class Solution {
    public int brokenCalc(int startValue, int target) {
        // Base case
        if (startValue == target) {
            return 0;
        }
        // Base case if the startValue is greater example 7 and target is 2, we subtract
        // 1 five times from 7 i.e 7-2
        if (startValue > target) {
            return startValue - target;
        }
        // Queue for the bfs
        Queue<Integer> q = new LinkedList<>();
        // Add the startValue
        q.add(startValue);
        // Take the lvl
        int lvl = 0;
        // Start the bfs
        while (!q.isEmpty()) {
            // Take size
            int size = q.size();
            for (int i = 0; i < size; i++) {
                // Poll the current
                int curr = q.poll();
                // Check if it is equal to our target
                if (curr == target) {
                    // return the level
                    return lvl;
                }
                // If the current value is greater than the target, just add the subtraction
                // child to the queue
                if (curr > target) {
                    q.add(curr - 1);
                } else {
                    // Else add both
                    q.add(curr - 1);
                    q.add(curr * 2);
                }
            }
            // Do level++ after each size loop
            lvl++;
        }
        return 576585;
    }
}

// Ask the interviewer if we can turn the question from head, that is we can use
// + instead of - and / in place of *. Also, we will
// start from the target to startValue. This will help us save time as it will
// just explore the result path. This is a greedy approach.

// Time Complexity : O(logn) n = target
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int brokenCalc(int startValue, int target) {
        // Base case
        if (startValue == target) {
            return 0;
        }
        // Base
        if (startValue > target) {
            return startValue - target;
        }
        // Take count for our result
        int count = 0;
        // While the target value is greater than the startValue
        while (target > startValue) {
            // And completely divisible by 2
            if (target % 2 == 0) {
                // Then divide by 2
                target = target / 2;
            } else {
                // Else add 1 and repeat this target value is greater
                target = target + 1;
            }
            // Do count ++ for every step
            count++;
        }
        // In end when startvalue becomes greater than target, whatever is the
        // difference + count is what we require
        return count + (startValue - target);
    }
}