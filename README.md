# QuickSort

  QuickSort operates by choosing a partition point that divides an array into
  two smaller sections, over which QuickSort is performed again until the array
  is sorted. The Big-Oh runtime classification for QuickSort is

  in the best case: O( nlog2(n) )
  This is because in the best case, the best partition will be chosen and the
  array will be partioned in half each time QuickSort is called. This results in
  a process similar to MergeSort, in which there is a traversal of n elements
  log2(n) times, for a runtime of nlog2(n).

  in most cases: O( nlog(n) )
  In most cases, the partition will fall somewhere in the middle range of the
  array. This will partition the array into uneven sections to be further
  sorted. This will result a traversal of n elements more than log2(n) times
  but less than n times, for a runtime of nlog(n).

  in the worst case: O( n^2 )
  In the worst case, the partition will be the smallest or largest value upon
  each iteration. This will partition the array into an array smaller by one
  element. This results in a traversal of n elements n times, for a runtime of
  n^2. 

![Alt text]