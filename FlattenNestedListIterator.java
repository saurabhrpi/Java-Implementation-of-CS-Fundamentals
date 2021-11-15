import java.util.NoSuchElementException;
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

public class NestedIterator implements Iterator<Integer> {
    
    // Given sol of O(1)
    private Deque<List<NestedInteger>> listStack = new ArrayDeque<>(); // stores all nested lists as //non-nested lists.
    private Deque<Integer> indexStack = new ArrayDeque<>();// keeps track of the next element (list or not) of the listStack to be accessed.    
    public NestedIterator(List<NestedInteger> nestedList) {
       listStack.addFirst(nestedList);
       indexStack.addFirst(0); // put the pointer at the first element.
    }
    
    //The next() and hasNext() methods should call makeStackTopAnInteger() before doing anything else. This means that they can then assume that either the stack top is an integer, or the stack is empty. 
    @Override
    public boolean hasNext() {
        makeStackTopAnInteger();
        return !indexStack.isEmpty();
    }
    
    public void makeStackTopAnInteger()
    {
        while(!indexStack.isEmpty()) // breaks as soon as an integer is found or it's empty.
        {
            // If the top list is used up, pop it and its index.
            // indexStack will increase while updating indexStack from within next() or from within //this method itself.
            // Greater than will ensure the last element of indexStack gets removed.
            if(indexStack.peekFirst() >= listStack.peekFirst().size())
            {
                indexStack.removeFirst();
                listStack.removeFirst();
                System.out.println("start printing index after removal ");
                for(Integer i : indexStack)
                    System.out.println(i);
                System.out.println("end printing index after removal ");
                continue; // to ensure in case a indexStack is emptied, it's not accessed in the loop //later on.
            }
            
            // Otherwise, if the front element of listStack is an integer,
            // then our top of indexStack is the index of an integer. 
            // Interestingly, this integer element is accessed as a list.
            if(listStack.peekFirst().get(indexStack.peekFirst()).isInteger())
                break;
            
            // Else the top (front) of indexStack is the index of a list.
            listStack.addFirst(listStack.peekFirst().get(indexStack.peekFirst()).getList());
            System.out.println("start accessing the new list ");
            System.out.println("indexStack's size " + indexStack.size());
            System.out.println("indexStack's top value before removing" + indexStack.peekFirst());
            indexStack.addFirst(indexStack.removeFirst() + 1); // cuz if there is an integer right //after this list, its index should be 1 more than current list's index. And this will be set to //current position. In short, this index value will point to the elements of listStack (and not any //inner lists).
            System.out.println("indexStack's top value after removing" + indexStack.peekFirst());
            indexStack.addFirst(0);// start from the first element of this fresh new list.          
            System.out.println("stop accessing the new list ");
        }
    }
    
    @Override
    // Every time next is called, it will make a call to hasNext which will make a subsequent 
    // call to makeStackTopAnInteger.
    //Idea is by the time next() runs listStack's first element is always a non-nested list.
    public Integer next() {
        if(!hasNext())
        {
            try
            {
                throw new NoSuchElementException();
            }
            catch(NoSuchElementException e)
            {
                return null;
            }
        }
        int currentPosition = indexStack.removeFirst();
        System.out.println("currentPosition :" + currentPosition);
        indexStack.addFirst(currentPosition + 1); // move the pointer ahead. Will work for all cases : whether currentPosition points to an Integer or within a list.
        System.out.println("start printing listStack's first :");
        for(NestedInteger n : listStack.peekFirst())
            System.out.println(n.getInteger());
        System.out.println("end of listStack's first.");
        return listStack.peekFirst().get(currentPosition).getInteger();// print the integer at  currentPosition of the nestedInteger of listStack.
    }
    
    //For given sol of O(N)
    /*
    List<NestedInteger> nestedLists;
    List<Integer> flattenedList;    
    
    public NestedIterator(List<NestedInteger> nestedList) {
        nestedLists = nestedList;        
        //flattenedList = flattenList(nestedLists); //my Impl
        flattenedList = givenSolOofN(nestedLists);
    }   
    
    @Override
    public Integer next() {
        if(!hasNext())
        {
            try
            {
                throw new NoSuchElementException();
            }
            catch(NoSuchElementException e)
            {
                return null;
            }
        }              
        return flattenedList.remove(0);       
    }
    
    @Override
    public boolean hasNext() {
        return flattenedList != null && flattenedList.size() > 0;
    }
    
    
    public List<Integer> givenSolOofN(List<NestedInteger> nestedLists)
    {
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < nestedLists.size(); i++)
        {
            if(nestedLists.get(i).isInteger())
            {
               result.add(nestedLists.get(i).getInteger());               
            }
            else
            {
                result.addAll(givenSolOofN(nestedLists.get(i).getList()));
            }
        }
        return result;
    }
    
    //my Impl
    public List<Integer> flattenList(List<NestedInteger> nestedLists)
    {                
        List<Integer> flattenedList  = new ArrayList<Integer>();
        for(int i=0; i < nestedLists.size(); i++)
        {
            NestedInteger ni = nestedLists.get(i);
            if(ni.isInteger())
            {                
                flattenedList.add(ni.getInteger());
            } 
            else
            {                
                List<Integer> returnedList = flattenList(ni);
                flattenedList.addAll(returnedList);
            }
        }
        return flattenedList;
    }
    
    public List<Integer> flattenList(NestedInteger ni)
    {
        List<Integer> result = new ArrayList<Integer>();
        if(ni.isInteger()) 
        {            
            result.add(ni.getInteger());            
            return result;
        }
        
        List<NestedInteger> l = ni.getList();
        for(int i = 0; i < l.size(); i++)
        {
            List<Integer> res = flattenList(l.get(i));
            result.addAll(res);
        }
        return result;
    }

}
*/
    
/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
