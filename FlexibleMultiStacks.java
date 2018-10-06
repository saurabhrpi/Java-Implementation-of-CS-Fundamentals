import java.io.*;
import java.lang.RuntimeException;

public class FlexibleMultiStack{
    
    private class StackInfo{
        
        int start, capacity, size;
        
        public StackInfo(int start, int capacity)
        {
            this.start = start;
            this.capacity = capacity;
        }
        
        public boolean isWithinStackCapacity(int index)
        {
            if(index < 0 || index >= values.length)
            {
                return false;
            }
            
            //int contiguousIndex = index < start ? index + values.length : index;
            int end = start + capacity;
            //return start <= contiguousIndex && contiguousIndex < end;
            return start <= index && index < end;
        }
        
        public int lastCapacityIndex()
        {
            return adjustIndex(start + capacity - 1); // for e.g. pass 19 for a stack of capacity 10 and start 10 and get back 9.
        }
        
        public int lastElementIndex()
        {
            return adjustIndex(start + size - 1); // for e.g. pass 5 for a stack having 6 valid elements
        }
        
        public boolean isFull()
        {
            return size == capacity;
        }
        
        public boolean isEmpty()
        {
            return size == 0;
        }
        
    }
    
    private StackInfo[] info;
    private int[] values;
    
    public FlexibleMultiStack(int numberOfStacks, int defaultSize)
    {
        info = new StackInfo[numberOfStacks];
        for(int i = 0; i < numberOfStacks ; i++)
        {
            info[i] = new StackInfo(i*defaultSize, defaultSize);
        }
        
        values = new int[numberOfStacks*defaultSize]; // initially all stacks are assigned equal space
    }
    
    public void push(int stackNum, int value) throws RuntimeException
    {
        if(allStacksAreFull())
        {
            throw new RuntimeException("All stacks are full");
        }
        
        StackInfo stackInfo = info[stackNum];
        
        if(stackInfo.isFull())
        {
            expand(stackNum);
        }
        
        stackInfo.size++;
        values[stackInfo.lastElementIndex()] = value;
    
    }
    
    public void expand(int stackNum)
    {
        shift((stackNum + 1) % info.length);
        info[stackNum].capacity++;
    }
    
    private void shift(int nexStackNum)
    {
        System.out.println("Shifting " + nexStackNum);
        
        StackInfo nexStackInfo = info[nexStackNum];
        
        if(nexStackInfo.size >= nexStackInfo.capacity)
        {
            int stillNextStack = (nexStackNum + 1) % info.length;
            shift(stillNextStack);
            nexStackInfo.capacity++;
        }
        
        int index = nexStackInfo.lastCapacityIndex();
        
        while(nexStackInfo.isWithinStackCapacity(index)) // moving data ahead one index at a time till we go beyond the end
        {
            values[index] = values[previousIndex(index)]; 
            index = previousIndex(index);
        }
        
        values[nexStackInfo.start] = 0;
        nexStackInfo.start = nextIndex(nexStackInfo.start); // reset the start of nextStack
        nexStackInfo.capacity--;
    }
    
    private int nextIndex(int index)
    {
        return adjustIndex(index + 1);
    }
    
    private int previousIndex(int index)
    {
        return adjustIndex(index - 1);
    }
    
    private int adjustIndex(int index)
    {
        int max = values.length;
        return ((index % max) + max) % max;
    }
    
    public boolean allStacksAreFull()
    {
        return numOfElements() == values.length;
    }
    
    public int numOfElements()
    {
        int size = 0;
        for(int i=0; i < info.length; i++)
        {
            size += info[i].size;
        }
        
        return size;
    }
    
    public int pop(int stackNum) throws RuntimeException
    {
        StackInfo stackInfo = info[stackNum];
        if(stackInfo.isEmpty())
        {
            throw new RuntimeException("Stack Underflow");
        }
        
        int val = values[stackInfo.lastElementIndex()];
        values[stackInfo.lastElementIndex()] = 0;
        stackInfo.size--;
        return val;
    }
    
    public int peek(int stackNum)
    {
        StackInfo stackInfo = info[stackNum];
        if(stackInfo.isEmpty())
        {
            System.out.println("No element found");
        }
        return values[stackInfo.lastElementIndex()];
    }
    
    public void printMultiStacks()
    {
        int k = 0;
        for(int i=0; i < values.length; i++)
        {
            //System.out.println("i inside print: " + i);
            if(values[i] != 0)
            {
                System.out.println("stack #" + (findStackNo(i) + 1) + "'s element #" + (findElementNo(i) + 1) + " is " + values[i]);
            }
        }
    }
    
    public int findStackNo(int index)
    {
        int i = 0;
        for( ; i < info.length; i++)
        {
            if(index < info[i].size)   
            {
                return i;
            }
            index -= info[i].size;
        }
        return i;
    }
    
    public int findElementNo(int valInd)
    {
        int i = 0;
        int k = 0;
        while(i < valInd)
        {
            if(i == info[k].size)
            {
                valInd -= info[k].capacity;
                i = 0;
                k++;
            }
            else
            {
                i++;   
            }
           // System.out.println("i " + i);
            //System.out.println("valInd " + valInd);
            //System.out.println("info[k] size " + info[k].size);
        }
        return i;
    }
    
    public static void main(String args[]) {
        
    FlexibleMultiStack m = new FlexibleMultiStack(3, 4);
    
    m.push(0,8);
    m.push(0,2);
    m.push(0,3);
    m.push(1,90);
    m.push(1,200);
    m.push(1,22);
    m.push(0,133);
    m.push(0,212);
    m.push(0,233);
    
    m.printMultiStacks();    
    
    //m.pop(1);
    //System.out.println("popped " + 2);
    
    //m.pop(1);
    //System.out.println("popped again" + 2);
    
    //m.printMultiStacks();    
    }
}
