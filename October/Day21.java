class Solution {
    public int[] asteroidCollision(int[] a) {
        LinkedList<Integer> s = new LinkedList<>(); // use LinkedList to simulate stack so that we don't need to reverse at end.
        for (int i : a) {
            while (!s.isEmpty() && s.getLast() > 0 && s.getLast() < -i)
                s.pollLast();
            if (s.isEmpty() || i > 0 || s.getLast() < 0)
                s.add(i);
            else if (i < 0 && s.getLast() == -i)
                s.pollLast();
        }
        return s.stream().mapToInt(i->i).toArray();
    }
}