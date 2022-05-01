class MedianFinder {
    // O(log(N)) approach
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder()); // to store the lower half in descending order.
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); // to store the upper half in ascending order.    
    boolean even = true; // refers to the existing count of elements.
    public MedianFinder() {           
       
    }
    
    public void addNum(int num) {               
        // Doesn't matter which order I choose - first add to min and then to max or vice versa.
       // Important is add and remove from one heap and then add to another.
       // This will make sure the number is in its correct place according to BOTH heaps. 
       if(even) 
       {
          System.out.println("adding to maxHeap " + num); 
          maxHeap.offer(num); // this will make sure whatever is added to maxHeap is the smallest from minHeap after //adding num.
          System.out.println("polling from maxHeap and adding to minHeap " + maxHeap.peek()); 
          minHeap.offer(maxHeap.poll()); // we're adding odd numbered index to maxHeap.          
       }
       else
       {
           System.out.println("adding to minHeap " + num); 
           minHeap.offer(num);
           System.out.println("polling from minHeap and adding to maxHeap " + minHeap.peek()); 
           maxHeap.offer(minHeap.poll());            
       }
       even = !even; // flip 
    }
    
    public double findMedian(){
        if(!even)
            return minHeap.peek(); // since out of maxHeap and minHeap, maxHeap has odd numbered elements.
        return (maxHeap.peek() + minHeap.peek())/2.0;
    }
