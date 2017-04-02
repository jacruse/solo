/*
Team Solo: Jack Cruse, Jack Cruse, Jack Cruse, oh and Jack Cruse
APCS2 pd4
Lab01 -- What Does the Data Say? And how?
2017-03-31
*/

/*======================================
  class QuickSortTester

  ALGORITHM:
  I used the QuickSort buildArray function to construct an array (test) to sort.
  Then I stored the time (startTime) using System.nanoTime() and then called 
  QuickSort.qsort on test to sort it. Once that was finished running, I stored
  the time (endTime) using System.nanoTime(). Then I returned the difference 
  between endTime and startTime. 

  To better time the runtime of the function, I used the function avgTime() to 
  call time() 1000 times and sum the runtimes and then divide the sum by 1000 to
  get an average runtime.

  To get an accurate reading I call avgTime on a 10 element array before calling
  it on the real test cases so that java could warm up for better timing of the 
  other function calls.


  BIG-OH CLASSIFICATION OF ALGORITHM:


  Mean execution times for dataset of size n:
  Batch size: 1000 <# of times each dataset size was run>
  n=1       time: 68.138
  n=10      time: 777.777
  n=100     time: 5515.547
  ...
  n=<huge>  time: nlog(n)
  ======================================*/


public class QuickSortTester
{
    
    public static double time( int size )
    {
	double startTime, endTime;
	int[] test = QuickSort.buildArray( size, size );
	startTime = System.nanoTime();
	QuickSort.qsort( test );
	endTime = System.nanoTime();
	return endTime - startTime;
    }//end time

    public static double avgTime( int size )
    {
	double avgTime = 0;
	for ( int i = 0; i < 1000; i++ )
	    {
		avgTime += time( size );
	    }
	avgTime = avgTime / 1000;
	return avgTime;
    }//end avgTime

    public static void main( String[] args )
    {
	System.out.println("Warming up QuickSort on a 10 element array: " + avgTime( 10 ) ) ;
	System.out.println("Average Time for Quicksort of a 1 element array: " + avgTime( 1 ) );
	System.out.println("Average Time for Quicksort of a 10 element array: " + avgTime( 10 ) );
	System.out.println("Average Time for Quicksort of a 100 element array: " + avgTime( 100 ) );
	System.out.println("Average Time for Quicksort of a 1000 element array: " + avgTime( 1000 ) );
	System.out.println("Average Time for Quicksort of a 2000 element array: " + avgTime( 2000 ) );
	System.out.println("Average Time for Quicksort of a 3000 element array: " + avgTime( 3000 ) );
	System.out.println("Average Time for Quicksort of a 4000 element array: " + avgTime( 4000 ) );
	System.out.println("Average Time for Quicksort of a 5000 element array: " + avgTime( 5000 ) );
	System.out.println("Average Time for Quicksort of a 6000 element array: " + avgTime( 6000 ) );
	System.out.println("Average Time for Quicksort of a 7000 element array: " + avgTime( 7000 ) );
	System.out.println("Average Time for Quicksort of a 8000 element array: " + avgTime( 8000 ) );
	System.out.println("Average Time for Quicksort of a 9000 element array: " + avgTime( 9000 ) );
	System.out.println("Average Time for Quicksort of a 10000 element array: " + avgTime( 10000 ) );
	System.out.println("Average Time for Quicksort of a 20000 element array: " + avgTime( 20000 ) );
	System.out.println("Average Time for Quicksort of a 30000 element array: " + avgTime( 30000 ) );
	System.out.println("Average Time for Quicksort of a 40000 element array: " + avgTime( 40000 ) );
	System.out.println("Average Time for Quicksort of a 50000 element array: " + avgTime( 50000 ) );
	System.out.println("Average Time for Quicksort of a 60000 element array: " + avgTime( 60000 ) );
	System.out.println("Average Time for Quicksort of a 70000 element array: " + avgTime( 70000 ) );
	System.out.println("Average Time for Quicksort of a 80000 element array: " + avgTime( 80000 ) );
	System.out.println("Average Time for Quicksort of a 90000 element array: " + avgTime( 90000 ) );
	System.out.println("Average Time for Quicksort of a 100000 element array: " + avgTime( 100000 ) );
	System.out.println("Average Time for Quicksort of a 1000000 element array: " + avgTime( 1000000 ) );
    }
	

}//end class QuickSortTester
