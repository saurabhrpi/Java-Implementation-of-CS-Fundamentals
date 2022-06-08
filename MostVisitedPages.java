import java.util.*;
import java.io.*;

class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        TrieDriver trie = new TrieDriver();
        HashMap<String, ArrayList<String>> uwMap = new HashMap<>();
        int numEntries = username.length;
        Log[] logs = new Log[numEntries];
        for(int i1 = 0; i1 < numEntries; i1++) {
            Log log = new Log(username[i1], timestamp[i1], website[i1]);
            logs[i1] = log;
        }
        Arrays.sort(logs);
        for(Log log: logs) {
            if(!uwMap.containsKey(log.u)) {
                uwMap.put(log.u, new ArrayList<>());
            }
            uwMap.get(log.u).add(log.w);
        }
        for (Object o : uwMap.entrySet()) {
            Map.Entry mapElement = (Map.Entry) o;
            ArrayList<String> uw = (ArrayList<String>)mapElement.getValue();
            if (uw.size() < 3)
                continue;
            ArrayList<String> seq = new ArrayList<>(3);
            seq.add(uw.get(0));
            seq.add(uw.get(1));
            seq.add(uw.get(2));
            trie.add(seq);
            for (String web : uw) {
                seq.remove(0);
                seq.add(web);
                trie.add(seq);
            }
        }
        trie.maxSeqList.remove(0);
        return trie.maxSeqList;
    }

    class Log implements Comparable<Log> {
        String u;
        Integer t;
        String w;

        Log(String u, int t, String w) {
            this.u = u;
            this.t = t;
            this.w = w;
        }

        @Override
        public int compareTo(Log log) {
            int ct = this.t.compareTo(log.t);
            if(ct == 0)
                ct = this.u.compareTo(log.u);
            return ct;
        }
    }

    class TrieNode {
        String website;
        public HashMap<String, TrieNode> children;
        public int count;
        public TrieNode parent;
        public ArrayList<String> seq;

        TrieNode(String w, TrieNode parent) {
            this.parent = parent;
            this.website = w;
            this.count = 1;
            this.children = new HashMap<>();
            if(this.parent != null) {
                this.seq = new ArrayList<>(this.parent.seq);
            } else {
                this.seq = new ArrayList<>();
            }
            this.seq.add(w);
        }
    }

    class TrieDriver {
        TrieNode root;
        int maxCount;
        String maxSeqCon;
        ArrayList<String> maxSeqList;
        TrieDriver() {
            this.maxCount = Integer.MIN_VALUE;
            this.root = new TrieNode("", null);
        }

        void add(ArrayList<String> seq) {
            TrieNode prev = this.root;
            prev.count++;
            TrieNode curr = null;
            for(String website: seq) {
                if(prev.children.containsKey(website)) {
                    curr = prev.children.get(website);
                    curr.count++;
                    prev = curr;
                } else {
                    TrieNode newNode = new TrieNode(website, prev);
                    prev.children.put(website, newNode);
                    prev = newNode;
                }
            }

            //curr is leaf
            if(prev.count > maxCount) {
                maxCount = prev.count;
                maxSeqCon = this.concatAL(prev.seq);
                maxSeqList = prev.seq;
                System.out.println(maxSeqCon + " " + maxCount);
            } else if(prev.count == maxCount) {
                String currSeq = this.concatAL(prev.seq);
                if(currSeq.compareTo(maxSeqCon) < 0) {
                    maxSeqCon = currSeq;
                    maxSeqList = prev.seq;
                    System.out.println(maxSeqCon + " " + maxCount);
                }
            }
        }

        private String concatAL(ArrayList<String> strList) {
            StringBuilder sb = new StringBuilder();
            for(String web: strList) {
                sb.append(web);
            }
            return sb.toString();
        }
    }
}

public class MainClass {
    public static String[] stringToStringArray(String line) {
        //JsonArray jsonArray = JsonArray.readFrom(line);
        List<String> jsonArray = new ArrayList<>();
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
          arr[i] = jsonArray.get(i);
        }
        return arr;
    }
    
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }
    
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String[] username = stringToStringArray(line);
            line = in.readLine();
            int[] timestamp = stringToIntegerArray(line);
            line = in.readLine();
            String[] website = stringToStringArray(line);
            
            List<String> ret = new Solution().mostVisitedPattern(username, timestamp, website);
            
            String out = stringListToString(ret);
            
            System.out.print(out);
        }
    }
}
