import java.util.*;
import java.lang.*;

class HashMapList<T, E> {
	private HashMap<T, ArrayList<E>> map = new HashMap<T, ArrayList<E>>();
	
	/* Insert item into list at key. */
	public void put(T key, E item) {
		if (!map.containsKey(key)) {
			map.put(key, new ArrayList<E>());
		}
		map.get(key).add(item);
	}
	
	/* Insert list of items at key. */
	public void put(T key, ArrayList<E> items) {
		map.put(key, items);
	}
	
	/* Get list of items at key. */
	public ArrayList<E> get(T key) {
		return map.get(key);
	}
	
	/* Check if hashmaplist contains key. */
	public boolean containsKey(T key) {
		return map.containsKey(key);
	}
	
	/* Check if list at key contains value. */
	public boolean containsKeyValue(T key, E value) {
		ArrayList<E> list = get(key);
		if (list == null) return false;
		return list.contains(value);
	}
	
	/* Get the list of keys. */
	public Set<T> keySet() {
		return map.keySet();
	}
	
	@Override
	public String toString() {
		return map.toString();
	}
}

public class AnagramSolverHM{

    public String sort(String str)
    {
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
    
    public String[] solve(String[] arr)
    {
        HashMapList<String, String> map = new HashMapList<String, String>();
        
        for(int i = 0; i < arr.length; i++)
        {
            String key = sort(arr[i]);
            map.put(key, arr[i]);
        }
        
        String[] res = new String[arr.length];
        
        Iterator<String> it = map.keySet().iterator();
        
        int i = 0;
        
        while(it.hasNext())
        {
            String key = it.next();
            ArrayList<String> as = map.get(key);
            for(int j=0; j < as.size(); j++)
            {
                res[i] = as.get(j);
                i++;
            }
        }
        
        return res;
    }
   
    
    public static void main(String[] args)
    {
        String[] arr = {
        "bc",
        "de",
        "ef",
        "cb",
        "df",
        "fe",
        "gh",
        "ed"
        };
        
        //AnagramSolver as = new AnagramSolver();
        AnagramSolverHM as = new AnagramSolverHM();
        
        String[] res = as.solve(arr);
        
        for(int i=0; i < res.length; i++)
        {
            System.out.println(res[i]);
        }
    }
}
