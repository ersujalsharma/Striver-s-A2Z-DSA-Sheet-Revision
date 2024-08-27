/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
class Pair{
    String word;
    int distance;
    public Pair(String word,int distance){
        this.word = word;
        this.distance = distance;
    }
}
public class Main
{
	public static void main(String[] args) {
		String beginWord = "hit", endWord = "cog";
		List<String> wordList = Arrays.asList( new String[]{"hot","dot","dog","lot","log","cog"});
		int ans = ladderLength(beginWord,endWord,wordList);
		System.out.print(ans);
	}
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean visited[] = new boolean[wordList.size()];
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(beginWord,1));
        while(!q.isEmpty()){
            Pair p = q.poll();
            String str = p.word;
            int val = p.distance;
            if(str.equals(endWord)) return val;
            for(int i=0;i<wordList.size();i++){
                if(!visited[i] && checkDifference(str,wordList.get(i))){
                    visited[i] = true;
                    q.add(new Pair(wordList.get(i),val+1));
                }
            }
        }
        return 0;
    }
    public static boolean checkDifference(String str, String other){
        int count = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=other.charAt(i)){
                count++;
            }
        }
        return count == 1;
    }
}
