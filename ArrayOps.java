public class ArrayOps {
    public static void main(String[] args) {
        int [] a = {3, 3, 3, 1, 2, 3};
        System.out.println(isSorted(a));
        //System.out.println(secondMaxValue(a));
    }
    
    public static int findMissingInt (int [] array) {
        boolean [] temp = new boolean[array.length + 1];
        for (int i = 0; i < temp.length; i++){
            temp[i] = false;
        }
        for(int num : array)
        {
            temp[num] = true;
        }
        for (int i = 0; i < temp.length;i++){
            if (!temp[i]) return i;
        }

        return -1;
    }

    public static int secondMaxValue(int [] array) {
        int max = array[0];
        int secondMax = array[0];
        int indexOFfirstMax = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                indexOFfirstMax = i;
            }
        }
        for (int i = 1; i < array.length; i++) {
            if ((array[i] > secondMax && array[i] != max) || (array[i] == max && indexOFfirstMax != i)) 
                secondMax = array[i]; // checking whether it's second max or there is more than one value same as max.
        }
        return secondMax;
    }

    public static boolean containsTheSameElements(int [] array1,int [] array2) { //{2, 2, 3, 7, 8, 3, 2}, new int[] {8, 2, 7, 7, 3}
        for (int i = 0; i < array1.length; i++)
        {
            if (!contains(array2, array1[i])) return false;
        }
        return true;
    }
    public static boolean contains(int [] array, int num)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == num) return true;
        }
        return false;
    }

    public static boolean isSorted(int [] array) {
        if (array.length < 3) return true; // if the array has two values or one it's sorted.
        int count = 0;
        for(int i = 0; i < array.length - 1; i++)
            if(array[i] == array[i + 1]) count++;
            
        if (count == array.length - 1) return true; // Checking if the given array has only one value
        else if (array[count] > array[count + 1]){
            for (int i = count + 1; i < array.length - 1; i++)
            {
                if (array[i] < array[i + 1]) return false;
            }
        }
        else if (array[count] < array[count + 1]){
            for (int i = count + 1; i < array.length - 1; i++)
            {
                if (array[i] > array[i + 1]) return false;
            }
        }
        return true;
    }

}
