import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        StringTokenizer st;
        TreeSet<Integer> treeSet = new TreeSet<>();
        
        for (String op : operations) {
            String[] arr = op.split(" ");
            String command = arr[0];
            int num = Integer.parseInt(arr[1]);
            
            switch (command) {
                case "I":
                    treeSet.add(num);
                    break;
                case "D":
                    if (treeSet.isEmpty()) break;
                    
                    if (num == 1) {
                        treeSet.pollLast();
                    } else {
                        treeSet.pollFirst();
                    }
                    
                    break;
                default:
                    break;
            }
        }
        
        return treeSet.isEmpty() ? new int[]{0, 0} : new int[]{treeSet.last(), treeSet.first()};
    }
}