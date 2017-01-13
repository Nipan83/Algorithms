import java.util.*;
import java.io.*;
class happy{

   public static ArrayList<Integer> adj[];

	public static void main(String[] args) {
  
    FastReader in=new FastReader();
    int n=in.nextInt();
    int m=in.nextInt();
    adj=new ArrayList[n+1];
    for(int i=0;i<=n;i++)
    {
       adj[i]=new ArrayList<>();

    }  
    for(int i=0;i<m;i++)
    {
       int x=in.nextInt();
       int y=in.nextInt();
       adj[x].add(y);
       adj[y].add(x);

    }
    System.out.println(dfs(adj,1,n));

	}
	  public static int dfs(ArrayList<Integer> adj[],int source,int n)
	   {   
	   	   boolean []visit=new boolean[100001]; 
           Arrays.fill(visit,false);
           Stack<Integer> s=new Stack<>();
           s.push(source);
           visit[source]=true;
           int happy=0;
           while(!s.empty())
           {
           	   int v=s.pop();
           	 
           	  ArrayList<Integer>temp=adj[v];
           	  int len=temp.size();
           	//  System.out.println(parsize+"parsize");
           	  for(int i= 0;i<len;i++)
           	   {
                   if(!visit[temp.get(i)]){
                 // System.out.println(chilsize+"chilsize");
                s.push(temp.get(i));
                visit[temp.get(i)]=true;
                   if(len<adj[temp.get(i)].size())
                   {
                      happy++;
                      //System.out.println("happy badao");
                   }
                   
                   	  
                   	  
                   }

           	   }
           	}

           
           return happy;
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