
// In this approach, performing dfs and going over the list elements one by one, if integer, directly adding in sum, else if another
// nested list than making a recursive call with this list and increasing the depth.
// Time Complexity : O(n+d) n=no of elements and d=depth
// Space Complexity : O(n+d)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// DFS
public class NestedListWeightSum {
    int sum;

    public int depthSum(List<NestedInteger> nestedList) {
        // Base case
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        // Call dfs
        dfs(nestedList, 1);
        // Return sum
        return sum;
    }

    private void dfs(List<NestedInteger> nestedList, int depth) {
        // Go over each element in the list
        for (NestedInteger el : nestedList) {
            // If integer
            if (el.isInteger()) {
                // Add in sum
                sum = sum + el.getInteger() * depth;
            } else {
                // Else make dfs call with increased depth
                dfs(el.getList(), depth + 1);
            }
        }
    }

}

// In bfs approach, using a queue, putting the elements of list in the queue,
// starting bfs, polling one by one and checking if integer
// then add in sum with the lvl, other wise if list, iterate through it and
// again put in queue. Lvl will help for differentiating the
// depth.
// Time Complexity : O(n+d) n=no of elements and d=depth
// Space Complexity : O(n+d)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// BFS
public class NestedListWeightSum {
    int sum;

    public int depthSum(List<NestedInteger> nestedList) {
        // Base case
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        // Queue of type NestedInteger since we are not putting list, we are putting
        // individual elements
        Queue<NestedInteger> q = new LinkedList<>();
        // Iterate through the list and put elements
        for (NestedInteger el : nestedList) {
            q.add(el);
        }
        int lvl = 1;
        // Start bfs
        while (!q.isEmpty()) {
            // Take size
            int size = q.size();
            // Loop through size
            for (int i = 0; i < q.size(); i++) {
                // Take the curr
                NestedInteger curr = q.poll();
                // If integer, add in sum
                if (curr.isInteger()) {
                    sum = sum + curr.getInteger() * lvl;
                } else {
                    // Else iterate through list and each elements in the list
                    for (NestedInteger el : curr.getList()) {
                        q.add(el);
                    }
                }
            }
            // Do level++
            lvl++;
        }
        // Return sum
        return sum;
    }
}

// BFS - Adding List<NestedInteger> to the queue instead of individual elements
public class NestedListWeightSum {
    int sum;

    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        Queue<List<NestedInteger>> q = new LinkedList<>();
        q.add(nestedList);
        int lvl = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < q.size(); i++) {
                List<NestedInteger> curr = q.poll();
                for (NestedInteger el : curr) {
                    if (el.isInteger()) {
                        sum = sum + el.getInteger() * lvl;
                    } else {
                        q.add(el.getList());
                    }
                }

            }
            lvl++;
        }
        return sum;
    }
}
