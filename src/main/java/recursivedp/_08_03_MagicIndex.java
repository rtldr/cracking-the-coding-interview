package recursivedp;

/**
 * Magic Index: A magic index in an array A[0...n-1] is defined to be an index such that A[i] = i.
 * Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
 */
class _08_03_MagicIndex {

    int findMagicIndex(int[] arr) {
        return helper(arr, 0, arr.length - 1);
    }

    int helper(int[] arr, int beg, int end) {

        if(end - beg < 3) {
            for(int i = beg; i <= end; i++) {
                if(arr[i] == i) {
                    return i;
                }
            }
            return -1;
        }

        int mid = beg + (end - beg) / 2;
        if(arr[beg] == beg) {
            return beg;
        }
        if(arr[end] == end) {
            return end;
        }

        if(arr[beg] > end || arr[end] < beg) {
            return -1;
        } else {
            return Math.max(helper(arr, beg, mid), helper(arr, mid + 1, end));
        }

    }
}
