import java.util.*;
import java.io.*;
//import java.text.*;
import java.math.*;
class solution{

   	public static void main(String[] args){

		 FastReader in=new FastReader();
         long t=in.nextLong();
         while(t!=0)
         {
         	long c=in.nextLong();
         	long d=in.nextLong(); 
         	long count=in.nextLong();
         	long total=(c*4)+(d*4);
            if(count==0)
            {
                if(c==0&&d==0)
                {
                    System.out.println("yes");
                }else{
                    System.out.println("no");
                }
            }else{
            long sumup=(total%4); 
         	if((sumup==0) && (count<=total) && (count>=(d*4)) )
         	{
                System.out.println("yes");

         	}
            else
              {

         		System.out.println("no");
         	  }
            } 
           // total=0;
         	t--;
         } 
  //out.close();
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