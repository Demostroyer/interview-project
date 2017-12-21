package mu_ian_dempsey;
/**
 * This is question number 69. It wants the sqrt(int x) to be implemented. 
 * Idea: Use Binary Search. 
 * So have two pointers, one for the current biggest value, and the other for the smallest value. 
 * We will move these when we need to, eventually they will find the exact number, mid!
 * mid is calculated by doing left+(right-left)/2. 
 * Left is the lowest value, start at 1. Right is the upperbound. 
 * Start at being the value given to find the sqrt of, even start it at half the value of the given. 
 * This makes sense as the sqrt will always be less than the value given. 
 * Then we check if mid > x/mid. This indicates we are still to big. 
 * So we shrink the entire area by updating right to be mid-1.
 * Else, this check was false, so we know it is in the other section.
 * Inside this else we check if the result of mid+1 > x/(mid+1). 
 * If this returns true, then we have found the value at mid! So return it.
 * Else we are not up far enough, so we update left to be mid+1. This discards the entire left half. 
 * @author Ian Dempsey
 * @date 20/11/17
 *Pattern found: Binary Search
 *Time Analysis: O(logn) -> Size of the search is halved every time we check. 
 *Space Analysis: O(n).  
 */
public class sqrt69 {
	public static void main(String...args) {
		int answer=mySqrt(144);
		System.out.println("Answer is : " + answer);
	}
    public static int mySqrt(int x) {
        if(x==0) return 0;//base case
        int left =1; //lower limit
        int right =x/2;//upper limit
        while(true){//keep searching
            int mid = left +(right -left)/2;//the number to check! Depending on its value, we discard a whole section
            if(mid > x/mid){//We are bigger than the target, so shrink the upper limit
                right = mid-1;
            }else{
                if(mid+1>x/(mid+1)){//we have found it!
                    return mid;//return mid
                }
                left=mid+1;//We are smaller than the target, so expand the lower limit.
            }
        }
    }

}
