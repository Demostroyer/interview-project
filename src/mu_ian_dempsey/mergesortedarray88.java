package mu_ian_dempsey;
/**
 * Create an answer array that is the size of the two added together. Biggest it could be.
 * Third options: First might be empty, or second. Or neither!
 * @author Ian Dempsey
 *date:7/10/17
 */
public class mergesortedarray88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //if the second array is empty, then just return the entire first array(it is already sorted!)
        if(n == 0){return;}
    while(n>0){
        if(m==0){nums1[m+n-1]=nums2[n-- -1];//the first is empty, so copy over the contents of second. 
        }else{
       //Else copy over the contents depending on which array is bigger. 	
            nums1[m+n-1] = (nums1[m-1]>nums2[n-1])? nums1[m-- -1]:nums2[n-- -1];
        }
       }
    }

}
