/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
    class Triple{
        int src;
        int stops;
        int price;
        public Triple(int src,int stops,int price){
            this.src = src;
            this.stops = stops;
            this.price = price;
        }
    }
    class Pair{
        int des;
        int price;
        public Pair(int des,int price){
            this.des = des;
            this.price = price;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // int min = help(n,flights,src,dst,k);
        // return min == 100000000 ? -1 : min;
        ArrayList<Pair> graph[] = new ArrayList[n];
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        for(int edge[] : flights){
            graph[edge[0]].add(new Pair(edge[1],edge[2]));
        }
        int min = Integer.MAX_VALUE;
        Queue<Triple> q = new LinkedList<>();
        int cost[] = new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        q.add(new Triple(src,0,0));
        while(!q.isEmpty()){
            Triple popped = q.poll();
            if(popped.stops >k) continue;
            for(int i=0;i<graph[popped.src].size();i++){
                if(popped.price+graph[popped.src].get(i).price<cost[graph[popped.src].get(i).des]){
                    q.add(new Triple(graph[popped.src].get(i).des,popped.stops+1,popped.price+graph[popped.src].get(i).price));
                    cost[graph[popped.src].get(i).des] = popped.price+graph[popped.src].get(i).price;
                }
            }
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
}
