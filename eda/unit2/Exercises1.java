/*
Class containing the first set of exercises: "Recursivity and Recurrence Relations"
*/

public class Exercises1 {

  /*
  Exercise 1.1: Let v be an array of integers conforming to the profile of a continuous
  monotonically increasing curve, such that v[0]<0 and v[v.length-1]>0.
  There exists a unique position k of v, 0≤k<v.length-1, such that between v[k] and v[k+1]
  the function is 0, i.e. such that v[k]≤0 and v[k+1]>0.

  Design the "best" recursive method that computes k and analyse its cost.

  */
  public static int firstWhole(int [] v)
  {
    return firstWhole(v, 0, v.length-1);
  }

  public static int firstWhole(int [] v, int i, int f)
  {
    int m = (f + i)/2; //Calculates middle point

    if(v[m] > 0)
    {
      return firstWhole(v, i, m);
    }
    if(v[m] <= 0)
    {
      if(v[m+1] > 0)
      {
        return m;
      }
      return firstWhole(v,m,f);
    }
  }

/*
Exercise 1.2: Let v be an array of positive integers that conform to the profile of a
concave curve, i.e. there exists a unique position k of v, 0≤k<v.length, such that:
For all j : 0≤j<k : v[j]>v[j+1] & for all j : k<j<v.length : v[j-1]<v[j].
Design the best recursive method that computes k and analyse its cost
*/
  public static int concaveMin(int [] v)
  {
    return concaveMin(v, 0, v.length-1);
  }

  public static int concaveMin(int [] v, int i, int f)
  {
    int m = (f + i) / 2;

    if(v[m] < v[m+1])
    {
      if(v[m] < v[m-1])
      {
        return m;
      }
      return concaveMin(v,m,f);
    }

    return concaveMin(v,i,m);
  }

  /*

  Exercise 1.3: Design the best recursive method that searches for the component of an
  array with value equal to position. Design a recursive method that, with the least
  possible cost, determines whether an array v of integers, sorted in ascending order and
  with no repeated elements, contains any component whose value is equal to the
  position it occupies.
  If such a component exists, the method returns its position, otherwise -1.
  (Assume that the component, if exists, it is unique)

  */

  //CHECK
  public static int sameValueIndex(int [] v)
  {
    return sameValueIndex(v,0, v.length-1);
  }

  public static int sameValueIndex(int [] v, int i, int f)
  {
    int m = (i+f) / 2;

    if(m == v[m]) //Checks if element is same as index
    {
      return m;
    }

    else if(f == i) // If there is only one element the condition doesn't hold
    {
      return -1;
    }
    else if (m < v[m])
    {
      return sameValueIndex(v, m, f);
    }
    /*If the middle point is greater than m we cannot assume there is not such
     element at the right or left of the array*/
    int temp = sameValueIndex(v,i,m); //Checks the left part of the array

    if(temp == -1) //If there is not such element it checks on the right part
    {
      return sameValueIndex(v,m,f);
    }
    else //If there is it returns it
    {
      return temp;
    }
  }

  /*
  Exercise 1.4: Design the best recursive method that searches for two Strings
  in consecutive positions of an array.
  The method, with the lowest possible cost, checks whether two Strings x and y
  (such that x is strictly less than y) occupy consecutive positions in an array
  of String v, sorted in ascending order and with no repeated elements.

  */

  public static boolean areConsecutive(String [] v, String x, String y)
  {
    return areConsecutive(v, x, y, 0, v.length-1);
  }

  public static boolean areConsecutive(String [] v, String x, String y,
                                       int i, int f)
  {
    int m = (i+f) /2;

    if(x.compareTo(v[m]) < 0)
    {
      return areConsecutive(v,x,y,i,m);
    }

    else if(x.comapareTo(v[m]) > 0)
    {
      return areConsecutive(v,x,y,i,m);
    }

    else
    {
      return y.compareTo(v[m+1]) == 0;
    }


  }

}
