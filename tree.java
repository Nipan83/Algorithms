import java.io.*;
import java.util.*;
class tree{
 
       public static ArrayList<Integer> adj[];

         public static void main(String[] args) {
         	    
         	 FastReader in=new FastReader();
         	 int n,m;
         	 n=in.nextInt();
         	 m=in.nextInt();
             int k=m;
             adj=new ArrayList[n+1];
             for(int i=0;i<=n;i++)
             {
                adj[i]=new ArrayList<Integer>();
             }

             while(k-->0)
             {
                 int x=in.nextInt();
                 int y=in.nextInt();
               
                 adj[x].add(y);

             }
             if(dfs(adj,1,n) && (m+1==n))
             {
                 System.out.println("YES");
             }else
             {
             	System.out.println("NO");
             }

       }

      public static boolean dfs(ArrayList<Integer> adj[],int p,int n)
       {
              boolean []visited=new boolean[n+1];
              Arrays.fill(visited,false);

              Stack<Integer> s=new Stack<>();

              s.push(p);
            //  visited[p]=true;
              int tograph=0;
              while(!s.empty())
              {   
              	  tograph++;
                  int v=s.pop();
                 //System.out.println(v);   
                    if(visited[v]==true)
                    {
                    	return false;
                    }else
                    {
                             visited[v]=true;
                           Iterator<Integer> itr=adj[v].iterator();
                          while(itr.hasNext())
                          { 
                             int temp=itr.next();
                             s.push(temp);

                          }    



                    }
              }
           //  System.out.println(tograph);
               if(tograph!=n)
               {
               	return false;
               }else
                 return true;  
        }

       static class FastReader
        {
            BufferedReader br;
            StringTokenizer st;

            public FastReader()
            {
                br = new BufferedReader(new
                        InputStreamReader(System.in));
            }

            String next()
            {
                while (st == null || !st.hasMoreElements())
                {
                    try
                    {
                        st = new StringTokenizer(br.readLine());
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                return st.nextToken();
            }

            int nextInt()
            {
                return Integer.parseInt(next());
            }

            long nextLong()
            {
                return Long.parseLong(next());
            }

            double nextDouble()
            {
                return Double.parseDouble(next());

            }

            String nextLine()
            {
                String str = "";
                try
                {
                    str = br.readLine();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                return str;
            }
        }



}
