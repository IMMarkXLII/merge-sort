/**
 * @author ashish.adhikari
 */
package sort.merge;

/**
 * @author ashish.adhikari
 *
 */
public class MergeSort {
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    // Driver method
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};
 
        System.out.println("Given Array");
        printArray(arr);
 
        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length-1);
 
        System.out.println("\nSorted array");
        printArray(arr);
    }

	/**
	 * @param arr
	 * @param i
	 * @param j
	 */
	private void sort(int[] arr, int l, int r) {
		if(l < r) {
			int mid = (l+r)/2;
			
			sort(arr, l, mid);
			sort(arr, mid+1, r);
			
			merge(arr, l, r, mid);
		}
		
	}

	/**
	 * @param arr
	 * @param l
	 * @param r
	 * @param mid
	 */
	private void merge(int[] arr, int l, int r, int mid) {
		
		int leftSize = mid-l+1;
		int rightSize = r-mid;
		int[] temp = new int[leftSize + rightSize];
		int i = 0;
		int left = l, right = mid+1;
		while(left<=mid && right<=r) {
			if(arr[left] < arr[right]) {
				temp[i] = arr[left];
				left++;
			}else {
				temp[i] = arr[right];
				right++;
			}
			i++;
		}
		while(left<=mid) {
			temp[i] = arr[left];
			i++;
			left++;
		}
		while(right<=r) {
			temp[i] = arr[right];
			i++;
			right++;
		}
		
		left = l;
		i=0;
		while(i<temp.length) {
			arr[left] = temp[i];
			left++;
			i++;
		}
	}
}
