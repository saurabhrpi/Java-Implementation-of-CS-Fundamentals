// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
import java.util.NoSuchElementException;

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iter;
    Integer peekedVal = null; 
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	     iter = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(!hasNext())
        {
            try
            {
                throw new NoSuchElementException();      
            }
            catch(NoSuchElementException n)
            {
                return null;
            }
        }
        if(peekedVal == null)
        {
            try
            {
                peekedVal = next();    
            }
            catch(NoSuchElementException ex)
            {
                return peekedVal;
            }
        }              
        return peekedVal;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next(){
	    if(!hasNext())
        {
            try
            {
                throw new Exception();   
            }
            catch(Exception ex)
            {
                return null;
            }
        }  
        if(peekedVal == null)
        {
            return iter.next();    
        }
        int res = (int)peekedVal;
        peekedVal = null;
        return res;                   
	}
	
	@Override
	public boolean hasNext() {
	    return peekedVal != null || iter.hasNext();
	}
}
