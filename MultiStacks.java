// Assumes equal capacity across all stacks.
// 0 is considered as null.

public class MultiStacks{
    
    private int stackCapacity;
    private int stackCount;
    public int[] sizes;
    public int[] values;
    
    public void setCapacity(int cap)
    {
        stackCapacity = cap;
    }
    
    public void createStacks()
    {
        values = new int[(sizes.length)*stackCapacity];
    }
    
    public void setNum(int count)
    {
        stackCount = count;
        sizes = new int[stackCount];
    }
    
    public void push(int value, int stackNum) throws RuntimeException
    {
        if(isFull(stackNum))
        {
            throw new RuntimeException("Stack Overflow");
        }
        
        values[topOfStack(stackNum)] = value;
        sizes[stackNum]++;
    }
    
    public boolean isFull(int stackNum)
    {
        if(stackNum >= stackCount)
        {
            System.out.println("Invalid stack num");
            return false;
        }
        
        return sizes[stackNum] == stackCapacity;
    }
    
    public int pop(int stackNum) throws RuntimeException
    {
        if(isEmpty(stackNum))
        {
            throw new RuntimeException("Stack Underflow");
        }
        
        int val = values[topOfStack(stackNum)];
        values[topOfStack(stackNum)] = 0;
        sizes[stackNum]--;
        return val;
    }
    
    public int topOfStack(int stackNum)
    {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }
    
    public boolean isEmpty(int stackNum)
    {
        if(stackNum >= stackCount)
        {
            System.out.println("Invalid stack num");
            return false;
        }
        
        return sizes[stackNum] == 0;
    }
    
    public void printMultiStacks()
    {
        int k = 0;
        for(int i=0; i < values.length; i++)
        {
            if(values[i] != 0)
            {
                System.out.println("stack " + (i/stackCapacity));
            }
        }
    }
    
    public static void main(String args[]) {
        
    MultiStacks m = new MultiStacks();
    
    m.setCapacity(10);
    m.setNum(3);
    
    m.push[0,8];
    m.push[0,2];
    m.push[0,3];
    m.push[1,90];
    m.push[1,200];
    m.push[1,22];
    m.push[2,133];
    m.push[2,212];
    m.push[2,233];
        
    }
}
