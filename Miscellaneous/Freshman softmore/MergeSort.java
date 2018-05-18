import java.util.Arrays;

public class MergeSort
{
    public static void main(String[] args)
    {
        //Create an array of 20 random integers.
        int[] values = new int[20];
        for(int i=0; i<values.length; i++)
            values[i] = (int)(100*Math.random());

        System.out.println("Unsorted: " + Arrays.toString(values));
        sort(values);
        System.out.println("  Sorted: " + Arrays.toString(values));
    }

    public static int sort(int[] data)
    {
        sort(data, 0, data.length-1);
        return data;
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
            //Spilt the list in half and recurse on each half.
            int pivot = (min+max)/2;
            sort(data, min, pivot);
            sort(data, pivot+1, max);

            int left = min;         //the beginning of the left sublist
            int right = pivot+1;    //the beginning of the right sublist

            //Create a new list to store the merged list.
            int[] merged = new int[max-min+1];

            //Loop through each sublist and merge them.
            for(int i=0; i<merged.length; i++)
            {
                if(left<=pivot && (right>max || data[left]<data[right]))
                    merged[i] = data[left++];
                else
                    merged[i] = data[right++];
            }

            //Copy the values from the temp array back into the data array.
            for(int i=0, j=min; i<merged.length; i++, j++)
                data[j] = merged[i];
        }
    }
}

