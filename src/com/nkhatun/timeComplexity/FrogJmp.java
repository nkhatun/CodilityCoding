package com.nkhatun.timeComplexity;

import com.nkhatun.iterations.BinaryGap;

import java.util.logging.Logger;
/* A small frog wants to get to the other side of the road. The frog is currently located at position X and wants to get to a position greater than or equal to Y.
The small frog always jumps a fixed distance, D.
Count the minimal number of jumps that the small frog must perform to reach its target.
Write a function:
class Solution { public int solution(int X, int Y, int D); }
that, given three integers X, Y and D, returns the minimal number of jumps from position X to a position equal to or greater than Y.
Write an efficient algorithm for the following assumptions:
X, Y and D are integers within the range [1..1,000,000,000];
X ≤ Y.
*/
public class FrogJmp {
    private static Logger log = Logger.getLogger(FrogJmp.class.getName());

    public static int solution(int X, int Y, int D) {
        long XL = Long.valueOf(X);
        long YL = Long.valueOf(Y);
        long DL = Long.valueOf(D);
        if(XL < YL){
            return (int) Math.ceil((YL*1.0 - XL*1.0) / DL);
        }
        return 0;
    }
    public static void main(String[] args) {
        log.info("COUNT OF minimal number of jumps:: "+ solution(10,101,30));
    }
}
