//SC: O(1)
//TC: O(n)
/*iterate over the numbers in secret and in guess and count all bulls right away. For cows maintain an array that stores count of the number appearances in secret and in guess. Increment cows when either number from secret was already seen in guest or vice versa. This is taken care by the fact that we do nums[g]-- and then check if nums[s] < 0 which means character s from secret was found somewhere in guess. 
*/
class Solution {
    public String getHint(String secret, String guess) {
    int bulls = 0;
    int cows = 0;
    int[] numbers = new int[10];
    for (int i = 0; i < secret.length(); i++) {
        int s = Character.getNumericValue(secret.charAt(i));
        int g = Character.getNumericValue(guess.charAt(i));
        if (s == g)//both chars match so increse bulls
            bulls++;
        else {
            if(numbers[s] < 0)//this number which was in guess, was also found in secret
                cows++;
            if(numbers[g] > 0)//this number which was in secretalso found in guess
                cows++;
            numbers[s] ++;
            numbers[g] --;
        }
    }
    return bulls + "A" + cows + "B";
}
}