/*
Class containing the second set of exercises: "Divide and Conquer Applications"
*/

public class Exercises2
{
  /*
  Exercise 2.2: Design mergeDC(T[] v, int i, int m, int j), the modification of the merge
  method that requires the Java implementation of the MergeSort strategy.
  To do so, take into account that in mergeDC:
  • Instead of two arrays a and b, it receives a single array v as parameter; the remaining
  parameters of its header (i, m, and j) allow to indicate the beginning and end of the
  (sub)arrays of v to be merged, already sorted in the calls to mergeSort (v[i, m]) and
  mergeSort (v[m + 1, j]).
  • Instead of the sum of the lengths of a and b, the size of the resulting array (res) is j-
  i+1. Instead of res, the (sub)array resulting from the merge is v[i, j].
  • The method returns void instead of an array. First the merge is performed on res
  and then its components are copied into v[i,j].

  */

  public static <T extends Comparable<T>>  merge(T[] a, int i, int m, int j)
   {
     int k = 0;
     T [] res = (T[]) new Comparable[j-i+1];
     int s = m+1;
    while (i <= m && s <= j) {
      if (a[i].compareTo(a[m+1]) < 0) res[k++] = a[i++];
      else res[k++] = b[s++];
    }

    for (int r = i; r <= m; r++) res[k++] = a[r];
    for (int r = j; r <= j; r++) res[k++] = b[r];

    arrayCopy(res, 0, a, res.length);
  }

  /*
  Exercise 2.4: The majority (predominant) element of a size n group is that
  element that is repeated more than n/2 times. As NO two elements
  can occur more than 50%, if it exists, the majority element is unique.
  So, for example:

  • If n=2, there is only a majority element if the two data match.
  • If n=8 or n=9, the majority element must be repeated at least 5 times.
  • The 1 is the majority element in the group [1, 2, 1, 1, 3, 1, 1, 1, 4, 1].
  Given this definition, implement a D&C method that returns the majority
  element of an array v whose components are integers in the interval [1, k]
  (formally, ∀i: 0 ≤ i < v.length: 1 ≤ v[i] ≤ k). The method will return 0
  if such an element does not exist.

  Study the temporal complexity of the method, in terms of the size, significant
  instances (best case, worst case), the recurrence equations, and the cost
  (using recurrence relations)
  */

  public static int predominant(int[]v)
  {
    return predominant(v, 0, v.length-1);
  }

  public static int predominant(int[]v, int i, int j)
  {

    if(j == i)
    {
      return v[i];
    }
    int m = (i+j) / 2;
    int t1 = predominant(v, i, m);
    int t2 = predominant(v, m+1, j);
    if(t1 == t2)
      {
        return t1;
      }
    else
      {
        int leftM = 0, rightM = 0, n = (i-j) / 2;
        for(int p = i; p <= j; p++)
        {
          if(t1 != 0 && v[p] == t1) leftM++;
          else if(t2 != 0 && v[p] == t2) rightM++;
        }
        if(leftM > n) return t1;
        else if(rightM > n) return t2;
        else return 0;
      }

    }

    /*
    Exercise 2.5: Given an array of integers (positive and negative), design a D&C algorithm
    to find the maximum subsequence, that is the subsequence of (consecutive) numbers
    whose sum is maximum. The function must return the value of the sum of that
    subsequence.
    Example:
    - Given the array v = {-2, 3, 4, -3, 5, 6, -2}, the function shall return 15 since the maximum
    sum subsequence is {3, 4, -3, 5, 6}.
    - Given the array v = {-2, 11, -4, 13, -5, 2}, the function will return 20 since the maximum
    sum subsequence is {11, -4, 13}.
    Study the temporal complexity of the method, in terms of the size, significant instances
    (best case, worst case), the recurrence equations, and the cost (using recurrence
    relations).

    */
    public static int maximumSubsequence(int [] v)
    {

      return maximunSubsequence(v, i, f);
    }

    public static int maximumSubsequence(int[] v, int i, int f)
    {

      if(i == f)
      {
        if(v[i] > 0) return v[i];
        else return 0;
      }
      int m = (i-f) / 2;
      int t1 = maximumSubsequence(v, i, m);
      int t2 = maximumSubsequence(v, m+1, f);

      int maxSumL = 0, sumL = 0;
      for(int k = m; k >= i; k--)
      {
        sumL += v[k];
        if(sumL > maxSumL) maxSumL = sumL;

      }

      int maxSumR = 0, sumR = 0;
      for(int k = m+1; k <= f; k++)
      {
        sumR += v[k];
        if(sumR > maxSumR) maxSumR = sumR;

      }

      return Math.max(Math.max(t1, t2), maxSumL + maxSumR);

    }




  }
}
