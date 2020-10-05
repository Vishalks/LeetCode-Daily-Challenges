class MovingAverage {

    Queue<Integer> q;
    int size;
    double sum = 0.0;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        q = new LinkedList();
        this.size = size;
    }
    
    public double next(int val) {
        q.add(val);
        if(q.size() <= size){
            sum += val;
        }
        else{
            int elem = q.poll();
            sum -= elem;
            sum += val;
        }
        return (double)(sum / q.size());
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */