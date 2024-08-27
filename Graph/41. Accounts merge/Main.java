/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,Integer> emails = new TreeMap();
        DSU ds = new DSU();
        ds.initialize(accounts.size());
        for(int i=0;i<accounts.size();i++){
            for(int j=1;j<accounts.get(i).size();j++){
                if(!emails.containsKey(accounts.get(i).get(j))){
                    emails.put(accounts.get(i).get(j),i);
                }
                else{
                    ds.union(emails.get(accounts.get(i).get(j)),i);
                }
            }
        }
        HashMap<Integer,List<String>> list = new HashMap<>();
        for(String s : emails.keySet()){
            int val = emails.get(s);
            int par = ds.findParent(val);
            if(!list.containsKey(par)) list.put(par,new ArrayList<>());
            list.get(par).add(s);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int p : list.keySet()){
            List<String> inner = new ArrayList<>();
            inner.add(accounts.get(p).get(0));
            inner.addAll(list.get(p));
            ans.add(new ArrayList<>(inner));
        }
        return ans;
    }
}
class DSU{
    int par[];
    int size[];
    public void initialize(int siz){
        par = new int[siz];
        size = new int[siz];
        for(int i=0;i<siz;i++){
            par[i] = i;
            size[i] = 0;
        }
    }
    public int findParent(int data){
        if(par[data] == data) return data;
        return par[data] = findParent(par[data]);
    }
    public void union(int first,int second){
        int parA = findParent(first);
        int parB = findParent(second);
        if(size[parA]>=size[parB]){
            par[parB] = parA; 
            size[parA] += size[parB];
        }
        else{
            par[parA] = parB;
            size[parB] += size[parA];
        }
    }
}
