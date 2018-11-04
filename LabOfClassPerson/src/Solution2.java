/*
 * Exercise 1-1
 */
public class Solution2 {

    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,4};
        int[] array2 = {3,1,4,1,5,9,2,6,5,3,5,8,9,3,9};
        int[] array3 = {1,1,1,1};
        showNonDuplicateArray(array1);
        showNonDuplicateArray(array2);
        showNonDuplicateArray(array3);
    }

    /*
     * Remove duplicate elements in an array
     * and print it in the standard output
     * @param a the input array
     */
    public static void showNonDuplicateArray(int[] a) {
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]==a[j]){
                    a[j] = -1;
                }
            }
        }
        for(int i=0;i<a.length;i++){
            if(a[i]>0){
                System.out.print(a[i]);
            }
        }
        System.out.println("\n");
    }

}

