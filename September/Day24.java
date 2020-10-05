//TC: O(n)
//SC: O(1)
/*
every time we go to the next station as far as possible (remained gas is bigger or equal to 0) until we can not (remained gas is less than 0).
Then we must extend our start station to the "last station" ( the station before start station) to find a possible solution.
Repeat these two steps until we have checked all stations(start == end).

We can travel around the circuit only if the remained gas is bigger or equal to 0
*/
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = gas.length - 1;//set start to the last station
        int end = 0;//set end to first station
        int sum = gas[start] - cost[start];
        
        while(start > end){
            //this means we can go to the next station. Hence add the cost for end station to the sum and increase end(move to the next station)
            if(sum >= 0){
                sum += gas[end] - cost[end];
                end++;
            }
            //Since it is not posible to go to next station from current start, we decrease start and then try covering all stations from this new start. Add the cost for this station to the sum
            else{
                --start;
                sum += gas[start] - cost[start];
            }
        }
        //if sum >= 0, this means we can cover all stations without ever getting the sum as negative and hence return start as answer else return -1.
        return sum >= 0 ? start : -1;
    }
}