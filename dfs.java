import java.io.*;
import java.util.*;
class dfs{

	  public static  void dfs(graph g,int source)
	   {   
	   	   boolean []visit=new boolean[5]; 
           Arrays.fill(visit,false);
           Stack<Integer> s=new Stack<>();
           s.push(source);
           visit[source]=true;
           while(!s.empty())
           {
           	   int v=s.pop();
           	   System.out.print(v+" ");
           	   Iterator<Integer> itr=g.adj[v].iterator();
           	   while(itr.hasNext())
           	   {
           	   	   int k=itr.next();
           	   	   if(!visit[k])
           	   	   {
           	   	   	  visit[k]=true;
           	   	   	  s.push(k);
           	   	   }
           	   }
           }



	   }

        public static void main(String[] args) {
        	graph g=new graph(5);
        	 g.addedge(0,2);
           	g.addedge(0,1);
           
            g.addedge(1,3);
            g.addedge(1,4);

            dfs(g,0);
        	


        }
  
      static class graph{
           public ArrayList<Integer> adj[];
           public int nodes; 

           public graph(int nodes)
           {
               this.nodes=nodes;
               adj=new ArrayList[nodes];
               for(int i=0;i<nodes;i++)
               {
                   
                   adj[i]=new ArrayList<>();
               }


           }  

            public void addedge(int to,int from)
            {
                 adj[to].add(from);
                // adj[from].add(to);

            }

     }




} 