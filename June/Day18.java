class Solution {
  public int hIndex(int[] citations) {
    int n = citations.length;
    int mid = 0;
    int start = 0;
    int end = n - 1;
    while (start <= end) {
      mid = start + (end - start) / 2;
      if (citations[mid] == n - mid)
          return n - mid;
      else if (citations[mid] < n - mid)
          start = mid + 1;
      else
          end = mid - 1;
    }
    return n - start;
  }
}