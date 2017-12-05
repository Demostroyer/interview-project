package mu_ian_dempsey;
/**
 * Similar to powerOfThree. 
 * 
 * @author Ian Dempsey
 *
 */
public class powerOfFour342 {
	
    public boolean isPowerOfFour(int n) {
        if(n<1){return false;}//negative numbers are not allowed
    //want to check if n is actually a number that has 4 as a factor, ie: 1,4,16,64,256 are correct answers as 4^0,4^1,4^2,4^3,4^4 are these
        //numbers respectfully. 
        //main idea then is to try to see if 4 divides into the n with no remainder(this means that 3 is a factor of it)
        while(n %4==0){//whilst n mod 4 is 0
            //now need to get closer to 4! So divide n by 4
            n/=4;
        }
        //the true case is that the remainder is 1, as we eventually get down to 4/4=1 in the above loop, then guard asks:
        //1%4==0? returns false, so we have reached 1! And we know intuitively that 1 is a result of 4^0. 
        if(n==1){
            return true;
        }
        return false;//finally it is not.
    }
}
