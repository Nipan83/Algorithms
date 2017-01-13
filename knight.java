import java.io.*;
import java.util.*;
//import javafx.util.pair;
class knight{

       public static int []x={0,-1,-1,-2,-2,2,2,1,1};
       public static int []y={0,-2,2,-1,1,-1,1,-2,2};
 
       public static void main(String[] args) throws IOException{
       	   
          BufferedReader br=new BufferedReader(new InputStreamReader(System.in));   
          // System.out.println(bfs(a1-'a'+1,b1,a2-'a'+1,b2));
          int t=Integer.parseInt(br.readLine());
          while(t-->0)
          {
            String []str=br.readLine().split(" ");
            String sor=str[0];
            String des=str[1];
            char a1=sor.charAt(0);
            char a2=des.charAt(0);
              
            String ak1=" "+sor.charAt(1);
            String ak2=" "+des.charAt(1);
            int b1=Integer.parseInt(ak1.trim()); 
            int b2=Integer.parseInt(ak2.trim());
           // System.out.println((a1-'a'+1)+" "+b1+" "+(a2-'a'+1)+" " +b2);
            System.out.println(bfs(a1-'a'+1,b1,a2-'a'+1,b2)); 



          } 
          // System.out.println((a1-'a'+1));


       }
      public static int bfs(int a1,int b1,int a2,int b2)
       {
             int m=0,n=0;  
             int [][]moves=new int[9][9];
             int [][]visited=new int[9][9];
          Queue<pair> q =new LinkedList<pair>();
          q.add(new pair(a1,b1));
          visited[a1][b1]=1;
          while(q.size()!=0)
          {
            pair p=q.poll();
             if(p.getfirst()==a2 && p.getsecond()==b2)
             return moves[a2][b2];
            
             for(int i=1;i<=8;i++)
             {
                 m=p.getfirst()+x[i];n=p.getsecond()+y[i];
                 if(m>8 || m<1 || n>8 || n<1)
                 continue;
                 else if(visited[m][n]==0)
                {    
                	 visited[m][n]=1;
                     moves[m][n]=moves[p.getfirst()][p.getsecond()]+1;
                     
                     q.add(new pair(m,n));
                }   

             }
         

         } 
         return 0;
       }
  public static class pair{
                int first;
                int second;
           pair(int first,int second)
           {
           	  this.first=first;
           	  this.second=second;

           }
           pair()
           {

           }
           public void setfirst(int f)
           {
           	  this.first=f;

           }
           public void setsecond(int s)
           {
           	  this.second=s ;
           }
           public int getfirst()
           {
           	return first;
           }
           public int getsecond()
           {
           	return second;
           }     

	   }














}
