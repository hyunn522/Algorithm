import java.util.*;


class Solution {
    
    static List<Integer> prevLeft = new ArrayList<>();
    static List<Integer> prevRight = new ArrayList<>();
    static int prevLeftIdx = -1;
    static int prevRightIdx = -1;
    static String result = "";
    
    public String solution(int[] numbers, String hand) {
        
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (num == 1 || num == 4 || num == 7) {
                moveLeft(num);
            } else if (num == 3 || num == 6 || num == 9) {
                moveRight(num);
            } else {
                int leftDistance = calculateDistance(prevLeftIdx >= 0 ? prevLeft.get(prevLeftIdx) : -1, num);
                int rightDistance = calculateDistance(num, prevRightIdx >= 0 ? prevRight.get(prevRightIdx) : -1);

                // 거리가 같을 경우
                if (leftDistance == rightDistance) {
                    if (hand.equals("left")) {
                        moveLeft(num);
                    } else {
                        moveRight(num);
                    }
                } else { // 거리가 같지 않을 경우
                    if (leftDistance > rightDistance) {
                        moveRight(num);
                    } else {
                        moveLeft(num);
                    }
                }
            }
        }
        return result;
    }
    
    private int calculateDistance(int a, int b) {
        int ax, ay, bx, by;
        
        if (a > 0) {
            ax = (a - 1) % 3;
            ay = (a - 1) / 3;
        } else if (a == 0) {
            ax = 1;
            ay = 3;
        } else {
            ax = 0;
            ay = 3;
        }
        
        if (b > 0) {
            bx = (b - 1) % 3;
            by = (b - 1) / 3;
        } else if (b == 0) {
            bx = 1;
            by = 3;
        } else {
            bx = 2;
            by = 3;
        }
        
        return Math.abs(ax - bx) + Math.abs(ay - by);
    }
    
    private void moveLeft(int num) {
        prevLeft.add(num);
        prevLeftIdx++;
        result += "L";
    }
    
    private void moveRight(int num) {
        prevRight.add(num);
        prevRightIdx++;
        result += "R";
    }
}