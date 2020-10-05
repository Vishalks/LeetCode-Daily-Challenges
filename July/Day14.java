class Solution {
    public double angleClock(int hour, int minutes) {
        
        if(minutes == 0 && hour == 12)//no displacement
            return 0.0;
        
        //take 12 as the reference point and calculate displacement for both hands from 12
        double hourHand = (hour%12)*30 + (0.5*minutes);//for each hour 30 degrees + 0.5* minutes(since hour hand covers 0.5 degree for each minute)
        double minutesHand = minutes*6;//for each minutes, it completes 6 degrees
        
        double diff  = Math.abs(hourHand-minutesHand);//take absoulte difference
        if(diff > 180)//if obtuse, change to acute
            diff = 360 - diff;
        return diff;
    }
}