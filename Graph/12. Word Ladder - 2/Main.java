/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    
	    String beginWord = "hit", endWord = "cog";
	    String[] list = {"hot","dot","dog","lot","log","cog"};
	    List<String> wordList = new ArrayList<>(Arrays.asList(list));
	    /*
	    // Used BFS to traverse all the list<String> and generate all the list string ans.
	
	    List<List<String>> ans = new ArrayList<>();
        Queue<List<String>> q = new ArrayDeque<>();
        List<String> first = new ArrayList<>();
        boolean visited[] = new boolean[wordList.size()];
        first.add(beginWord);
        q.add(new ArrayList<>(first));
        HashSet<String> previouslyUsed = new HashSet<>();
        while(!q.isEmpty()){
            int size = q.size();
            if(!ans.isEmpty() && q.peek().size()>ans.get(0).size()){
                break;
            }
            HashSet<String> thisLayer = new HashSet<>();
            for(int i=0;i<size;i++){
                List<String> poppedList = q.poll();
                // System.out.println(poppedList);
                String last = poppedList.get(poppedList.size()-1);
                if(last.equals(endWord)){
                    ans.add(new ArrayList(poppedList));
                }
                else{
                    for(int k=0;k<wordList.size();k++){
                        if(!previouslyUsed.contains(wordList.get(k)) && check(last,wordList.get(k))){
                            thisLayer.add(wordList.get(k));
                            poppedList.add(wordList.get(k));
                            q.add(new ArrayList<>(poppedList));
                            poppedList.remove(poppedList.size()-1);
                        }
                    }
                }
            }
            previouslyUsed.addAll(thisLayer);
            // System.out.println(q);
        }
        System.out.print(ans);
	
	    // used hashmap to find endWord, and for implementing the bfs we assign the layers number in the hashmap, 
	    // and in last we traverse from end to begin and whenever we keep outside from end to begin we try to traverse only those word which are lesser than that depth.
	*/
	    
	    List<List<String>> ans = findLadders(beginWord,endWord,wordList);
	    System.out.println(ans);
	}
    public static boolean check(String last,String another){
        int count = 0;
        for(int i=0;i<last.length();i++){
            if(last.charAt(i)!=another.charAt(i)){
                count++;
            }
            if(count>1) return false;
        }
        return count == 1;
    }
	public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
            HashMap<String,Integer> hm = new HashMap<>();
            Queue<Pair> q=new ArrayDeque<>();
            q.add(new Pair(beginWord,1));
            HashSet<String> visited=new HashSet<>();
            visited.add(beginWord);
            while(q.size()>0)
            {
                Pair rem=q.remove();
                String word=rem.word;
                int steps=rem.steps;
                hm.put(word,steps);
                if(endWord.equals(word)){
                    break;
                }
                
                for(String trav:wordList)
                {
                    if( visited.contains(trav)==false && isDiffOne(word,trav))
                    {
                        visited.add(trav);
                        q.add(new Pair(trav,steps+1));
                    }
                }
            }
        
        
        List<String> arl=new ArrayList<>();
        ans=new ArrayList<>();
        
        System.out.println(hm);
        
        if(hm.containsKey(endWord)==false)
            return ans;
        
        dfs(endWord,beginWord,wordList,hm,arl);
        
        return ans;
            
    }
    static List<List<String>> ans;
    
    
    public static void dfs(String end, String begin, List<String> wordList, HashMap<String,                     Integer> hm, List<String> arl)
    {
          
        
        if(end.equals(begin)){
              arl.add(0,begin);
              List<String> temp=new ArrayList(arl);
              ans.add(temp);
              arl.remove(0);
              return;
          }
        
          arl.add(0,end);
          for(String trav:hm.keySet())
          {
              if(hm.get(trav)<hm.get(end) && isDiffOne(end,trav))
                  dfs(trav,begin,wordList,hm,arl);
          }
         arl.remove(0);
    }
    
    
    
    public static boolean isDiffOne(String s1, String s2)
    {
        if(s1.equals(s2))return false;
        int count=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i))count++;
            if(count>=2)return false;
        }
        if(count==1)return true;
        return false;
    }
    static class Pair{
        String word;
        int steps;
        Pair(String word, int steps){
            this.word=word;
            this.steps=steps;
        }
    }
}
