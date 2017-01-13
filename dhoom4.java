import java.io.*;
import java.util.*;
class dhoom4{
  public static int mod=100000;
public static void main(String[] args) {
	
     FastReader in=new FastReader();
     long start=in.nextLong();
     long result=in.nextLong();
     int n=in.nextInt();
     int []arr=new int[n];

     for(int i=0 ;i<n ;i++ )
     {
         arr[i]=in.nextInt();

     }
     Queue<Long> q=new LinkedList<>();
     long []visittime=new long[100000];
     Arrays.fill(visittime,-1);
     visittime[(int)start]=0;
     q.add(start);
     if(visittime[(int)result]!=-1)
     {
     	System.out.println(visittime[(int)result]);
     	return;
     }
     boolean flag=true;
     while(flag)
     {  
     	 flag=false; 
         long temp=q.poll();
        // System.out.println(temp+" "+"tit");
         if(temp==result)
         {  
         	  flag=true;
         	 System.out.println(visittime[(int)temp]); 
         	 break;
         }
         for(int i=0;i<n;i++)
         {
         	long x=(temp*arr[i])%mod;
         //	System.out.println(x);
         	if(visittime[(int)x]==-1 && x>=0)
         	{
         		flag=true;
         		visittime[(int)x]=visittime[(int)temp]+1;
         		q.add(x);
         	}
         }
         if(q.size()!=0)
         {
         	flag=true;
         }    


     }
     if(!flag)
     {
     	System.out.println("-1");
     }

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