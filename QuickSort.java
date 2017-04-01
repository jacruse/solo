/*
Jack Cruse
APCS2 pd4
HW15 -- So So Quick
2017-03-08
*/

/*****************************************************
 * class QuickSort
 * (skeleton)
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): 
 * 1. Check if left & right equal or if left > right
2. Run groupsort (partition) over left, right (first case being entire array)
and return the sorted value as val.
3. Run quicksort over left, val - 1 and val + 1, right. Back to top

 * 2a. Worst pivot choice / array state and associated runtime: 
 * Largest number in array / data is sorted, smallest number in array / 
data is sorted. N^2

 * 2b. Best pivot choice / array state and associated runtime:
 * Middle number, unsure of latter.

 * 3. Approach to handling duplicate values in array:
 * Just push the constraints to the left AND right of the returned 
position because regardless of if the duplicated is on the left or
right side, it will get sorted to the top or bottom (respectively) next
to the static already sorted value.
 *****************************************************/

/***
    PROTIP: Assume no duplicates during initial development phase.
    Once you have a working implementation, test against arrays 
    with duplicate values, and revise if necessary. (Backup first.)
 ***/

public class QuickSort 
{
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }
    //--------------^  HELPER METHODS  ^--------------



    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qsort( int[] d ) {
	qsortH( d, 0, d.length - 1);
    }
    
    public static void qsortH( int[] arr, int left, int right) {
	if (left == right || left > right) {
	    System.out.println("end");
	    return;
	}

	int val = groupSort(arr, left, right, (left + right) / 2);

       	System.out.println("sorting upper section");
	qsortH( arr, val + 1, right);
	System.out.println("sorting lower section");
	qsortH( arr, left, val - 1);
    }


    // Thinkers are encouraged to roll their own subroutines.
    // Insert your auxiliary helper methods here.

    public static int groupSort( int[] arr, int left, int right, int pvtPos ) {
	//v = arr[pvtPos]
	int v = arr[pvtPos];
	
	printArr(arr);

	//swap arr[pvtPos], arr[right]
	arr[pvtPos] = arr[right];
	arr[right] = v;
	
	printArr(arr);
	
	
	//s = left
	int s = left;
	int x;
	
	//for i in [left....right-1]
	for (int i = left; i < right; i++) {

	    //if arr[i] < v
	    if (arr[i] < v) {
		
		//swap arr[s], arr[i]
		x = arr[s];
		arr[s] = arr[i];
		arr[i] = x;
		
		//s+1
		s++;
	    }
	    
	    printArr(arr);

	}
	//swap arr[right], arr[s]
	x = arr[s];
	arr[s] = arr[right];
	arr[right] = x;

	printArr(arr);
	
	//return s
	return s;
    }

    public static int ySmallestValH( int[] arr, int left, int right, int y ) {
	int val = groupSort(arr, left, right, (left + right) / 2);

	if (val == y - 1 || left == right) {
	    System.out.println("found");
	    return arr[val];
	}

	else if (val > y - 1) {
	    System.out.println("too high");
	    return ySmallestValH( arr, left, val - 1, y );
	}

	else {
	    System.out.println("too low");
	    return ySmallestValH( arr, val + 1, right, arr.length - val - 1 + y );
	}
    }

    public static int ySmallestVal( int[] arr, int y ) {
	return ySmallestValH( arr, 0, arr.length - 1, y );
    }

    


    //main method for testing
    public static void main( String[] args ) 
    {

	//get-it-up-and-running, static test case:
	int [] arr1 = {7,1,5,12,3};
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);

	qsort( arr1 );	
       	System.out.println("arr1 after qsort: " );
	printArr(arr1);

	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	    arrN[i] = i;
       
	System.out.println("\narrN init'd to: " );
	printArr(arrN);

       	shuffle(arrN);
       	System.out.println("arrN post-shuffle: " );
	printArr(arrN);

	qsort( arrN );
	System.out.println("arrN after sort: " );
	printArr(arrN);
	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/



	//get-it-up-and-running, static test case w/ dupes:
	int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);

	qsort( arr2 );	
       	System.out.println("arr2 after qsort: " );
	printArr(arr2);


	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	    arrMatey[i] = (int)( 48 * Math.random() );
       
	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);

       	shuffle(arrMatey);
       	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);

	qsort( arrMatey );
	System.out.println("arrMatey after sort: " );
	printArr(arrMatey);
	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main

}//end class QuickSort
