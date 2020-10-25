//SC: O(1)
//TC: O(logT) where T is index of target value in the array
class Solution {
  public int search(ArrayReader reader, int target) {
    if(reader.get(0) == target)
        return 0;

    // start with initial left and right boundaries as 0 and 1 respectively.
    //While target is on the right to the right boundary, Set left boundary equal to the right one,
    //Extend right boundary to right boundary * 2
    int start = 0, end = 1;
    while (reader.get(end) < target){
      start = end;
      end *= 2;
    }

    // binary search
    int mid, num;
    while (start <= end) {
      mid = start + ((end - start) >> 1);
      num = reader.get(mid);

      if (num == target)
          return mid;
      if (num > target)
          end = mid - 1;
      else
          start = mid + 1;
    }

    // there is no target element
    return -1;
  }
}