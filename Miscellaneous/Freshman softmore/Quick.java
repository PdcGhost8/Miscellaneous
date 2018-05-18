/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
public class Quick {

    /*public static void main(String[] args)
    {
        //Create an array of 20 random integers.
        int[] values = new int[20];
        for(int i=0; i<values.length; i++)
            values[i] = (int)(100*Math.random());

        System.out.println("Unsorted: " + Arrays.toString(values));
        sort(values);
        System.out.println("  Sorted: " + Arrays.toString(values));
    }
*/
    public static int sort(int[] data)
    {
        sort(data, 0, data.length-1);
    }

    //sort
    //  This method sorts a sublist of an array.  It sorts the values between
    //  the indexes min and max, inclusively, in the data array.
    //
    private static int sort(int[] data, int min, int max)
    {
        if(max>min)
        {
            //We have a list with at least two elements.
            //Partition the list, and recurse on the sublists.
            int pivotIndex = partition(data, min, max);
            sort(data, min, pivotIndex-1);
            sort(data, pivotIndex+1, max);
        }
    }

    //partition
    //  This method partitions the data so that small values are on the left
    //  and big values are on the right, relative to some pivot value.  The
    //  index of the pivot value is returned.
    //
    //  The last value in the list is always selected as the pivot value. The
    //  method works by looping from the left to the right through the list,
    //  while tracking the leftmost value that is bigger than the pivot.  If
    //  a value is found that is smaller than the pivot, then that value is
    //  swapped with the leftmost big value.  This causes all of the small
    //  values to the pushed to the left, while the big values are pushed to
    //  the right.
    //
    private static int partition(int[] data, int min, int max)
    {
        //Choose the value at the end of the list as initial pivot value.
        int pivotIndex = max;
        int pivotValue = data[max];

        //The boundary variable tracks the index of the leftmost big value.
        //It acts as a boundary such that all of the values to its left are
        //guaranteed to be smaller than the pivot.
        int boundary = min;

        //Loop through all of the values (except the pivot value)
        for(int i=min; i<max; i++)
        {
            //If the current value is less than the pivot, then swap it with
            //the boundary value.  This moves small values to the left and big
            //ones to the right.  It also allows us to move the boundary to
            //the right accordingly.
            if(data[i]<pivotValue)
            {
                swap(data, i, boundary);
                boundary++;
            }
        }

        //At this point, all the small values are to the left of the big
        //values.  The pivot is still sitting at the end.  So swap the pivot
        //with the boundary.  That places the pivot between the smalls and
        //bigs, which is exactly where it should be.
        swap(data, boundary, max);

        //Return the boundary, which is now where the pivot value sits.
        return(boundary);
    }

    //swap
    //  This method swaps the value at index x with the value at index y
    //  in the data array.
    //
    private static void swap(int[] data, int x, int y)
    {
        int temp = data[x];
        data[x] = data[y];
        data[y] = temp;
    }
}    

