package recursivedp;

/**
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
 * Implement a method to count how many possible ways the child can run up the stairs.
 */
class _08_01_TripleStep {

    int countWays(int steps) {

        if(steps == 0) {
            return 1;
        }

        int ways = 0;
        if(steps > 2) {
            ways += countWays(steps - 3);
        }

        if(steps > 1) {
            ways += countWays(steps - 2);
        }

        if(steps > 0) {
            ways += countWays(steps - 1);
        }
        return ways;
    }
}
