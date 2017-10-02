public class MyClass {
    public static void main(String args[]) {
        int arr[] = {13,9,10,1,19};
        HeapSort s = new HeapSort();
        s.sort(arr);
        for(int i=0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
    }
}

   //HeapSort starts with the assumption that heap is a max heap.
class HeapSort{
    public void sort(int arr[]){
        int n = arr.length;
        // first make sure array is in the form of max heap
        for(int i = n/2 - 1; i >= 0; i--) 
        {
            // n/2 will always be = index of last level since 
            // there are exactly 2 trees at each level
            heapify(arr,n,i);
        }
        
        // delete (or exclude) the last node and process the entire tree, followed by deletion
        // of the max value of the new tree, and so on..
        for(int i = n-1; i >= 0; i--)
        {
            int swap = arr[0];
            arr[0] = arr[i];
            arr[i] = swap;
            
            heapify(arr,i,0);
        }
    }
    
    public void heapify(int arr[], int n, int i)
    {
        // i represents root of the subtree to be processed
        // n represents the size of the tree
        int largest = i;// largest will hold the index of the largest value. 
                         // This ideally should exist at a parent node only.
        int left = 2*i + 1;
        int right = 2*i + 2;
        if(left < n && arr[left] > arr[i]){ // make sure left child exists
            largest = left;
        }
        
        if(right < n && arr[right] > arr[largest]){
            largest = right;
        }
        
        if(largest != i)
        {
            // make root point to largest value
            int swap = arr[largest];
            arr[largest] = arr[i];
            arr[i] = swap;
            
            //make sure everytime the root is swapped the sub tree under swapped child is a max heap too
            heapify(arr,n,largest);
        }
    }
}
