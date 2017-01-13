
/**Author -Abhijeet Singh
   Btech 2nd Year NIT-SILCHAR
   :)  Love u Zindagi  :)
**/
import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
class solution{

    public static InputReader in;
    public static PrintWriter out;  
   // public static long mod=1000007;
    public static ArrayList<Integer> adj[];
    public static boolean []visit;
   // public static int count =0;
    //DecimalFormat newFormat = new DecimalFormat("#.##");
    //double twoDecimal =  Double.valueOf(newFormat.format(count));
    public static double pi=3.141592653589793238462643383279;
    public static String name="littlejhool";
    public static String tocheck="Bulbasaur";


    //public static String checkme="abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static void main(String[] args) throws IOException{

		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         String t=br.readLine();
         String form="";
         int []hash=new int[300]; 
         int b1=0;
         int a=0;
         int l=0;
         int b=0;
         int u=0;
         int s=0;
         int r=0; 
         for(int i=0;i<t.length();i++)
         { 
              if(t.charAt(i)=='B')
              {
              	b1++;
              }
              if(t.charAt(i)=='a')
              {
              	a++;
              }
              if(t.charAt(i)=='l')
              {
              	l++;
              }
              if(t.charAt(i)=='b')
              {
              	b++;
              }
              if(t.charAt(i)=='s')
              {
              	s++;
              }
              if(t.charAt(i)=='u')
              {
              	u++;
              }
              if(t.charAt(i)=='r')
              {
              	r++;
              }
                       
         }
         int min=Integer.MAX_VALUE;
         int ans=(Math.min(b1,Math.min(u/2,Math.min(l,Math.min(a/2,Math.min(b,Math.min(s,r)))))));
        System.out.println(ans);
  //out.close();
    }
//---------------------**********My Requried Functions**********----------------------//////////
	

	public static long gcd(long x, long y) {
	    		if (x == 0)
	    			return y;
	    		else
	    			return gcd( y % x,x);
	    	}
//----------------------------------------------------------------------------------------////////
   /* public static long modInverse(long A, long M){
                                                    
    extendedEuclid(A,M);
    return (x%M+M)%M;    //x may be negative
      }
    public static void extendedEuclid(long A, long B) {
    if(B == 0) {
        d = A;
        x = 1;
        y = 0;
    }
    else {
        extendedEuclid(B, A%B);
        long temp = x;
        x = y;
        y = temp - (A/B)*y;
    }
      }

  */  public static long mod = 1000000007, inf = 100000000000000000l;
      public static long fac[],inv[];
      public static void cal()
    {
        fac = new long[1000005];
        inv = new long[1000005];
        fac[0]=1;
        inv[0]=1;
        for(int i=1; i<=1000000; i++)
        {
            fac[i]=(fac[i-1]*i)%mod;
            inv[i]=(inv[i-1]*modPow(i,mod-2,mod))%mod;
        }
    }
    public static long ncr(int n, int r)
    {
        return (((fac[n]*inv[r])%mod)*inv[n-r])%mod;
    }

////--------------------------------------------------------------------------------------///////	    	

	public static long modPow(long base, long exp, long mod) {
        base = base % mod;
        long result =1;
        while(exp > 0)
        {
            if(exp % 2== 1)
            {
                result = (result * base) % mod;
                exp --;
            }
            else
            {
                base = (base * base) % mod;
                exp = exp >> 1;
            }
            
        }
        return result;
    }

//---------------------------------------------------------------------------------------///////
	public static String reverseString(String s) {
	    		StringBuilder sb = new StringBuilder(s);
	    		sb.reverse();
	    		return (sb.toString());
	    	}
//------------------------------------------------------------------------------------------//////
	public static int BinarySearch(int a[], int low, int high, int target) {
	    		if (low > high)
	    			return -1;
	    		int mid = low + (high - low) / 2;
	    		if (a[mid] == target)
	    			return mid;
	    		if (a[mid] > target)
	    			high = mid - 1;
	    		if (a[mid] < target)
	    			low = mid + 1;
	    		return BinarySearch(a, low, high, target);

	    	}    	
///////-----------------------------------------------------------------------------------////////
	public static boolean isPrime(int n) {
	    		// Corner cases
	    		if (n <= 1)
	    			return false;
	    		if (n <= 3)
	    			return true;
	     
	    		// This is checked so that we can skip 
	    		// middle five numbers in below loop
	    		if (n % 2 == 0 || n % 3 == 0)
	    			return false;
	     
	    		for (int i = 5; i * i <= n; i = i + 6)
	    			if (n % i == 0 || n % (i + 2) == 0)
	    				return false;
	     
	    		return true;
	    	}    	
//----------------------------------------------------------------------------------------///////
	//********************MERGE_SORT***********************//
	
	public static long sort(int a[])
	    	{  int n=a.length;
	    		int b[]=new int[n];	
	    		return mergeSort(a,b,0,n-1);
	    	}
	    	static long mergeSort(int a[],int b[],long left,long right)
	    	{ 
	    		long c=0;if(left<right)
	    	    {   
	    	 	long mid=left+(right-left)/2;
	    		 c= mergeSort(a,b,left,mid);
	    		 c+=mergeSort(a,b,mid+1,right);
	    		 c+=merge(a,b,left,mid+1,right); 
	    		}	
	    		return c;	
	    		 }
	    	static long merge(int a[],int  b[],long left,long mid,long right)
	    	{
	    		long c=0;
	    		int i=(int)left;
	    		int j=(int)mid;
	    		 int k=(int)left;
	    	while(i<=(int)mid-1&&j<=(int)right)
	    	{
	    	 if(a[i]>a[j]) {
	    	 	b[k++]=a[i++];
	    	 	 }
	    	else{ 
	    		b[k++]=a[j++];c+=mid-i;
	    	}
	       }
	    	while (i <= (int)mid - 1)  
	    	 b[k++] = a[i++]; 
	    	while (j <= (int)right) 
	    		b[k++] = a[j++];
	    	for (i=(int)left; i <= (int)right; i++) 
	    		a[i] = b[i];  
	    	return c; 
	    		 }   
	    	
//-------------------------------------------------------------------------------------////////////
    public static int nextPowerOf2(final int a) {
	    		int b = 1;
	    		while (b < a) {
	    			b = b << 1;
	    		}
	    		return b;
	    	}

///--------------------------------------------------------------------------------------///////////

	 ///comparable class.....//////
	class MyComp implements Comparator<Long>{
	        

     	public int compare(Long o1, Long o2) {
				if(o1<o2){
					return 1;
				}else if(o1>o2){
					return -1;
				}
				return 0;
				
			}
	}   	
///-------------------------------------------------------------------------------------//////////


	///////********           Reader class to imput methods         ********////////////////////


	public static void pArray(int[] arr) {
	    		for (int i = 0; i < arr.length; i++) {
	    			out.print(arr[i] + " ");
	    		}
	    		out.println();
	    		return;
	    	}
	     
	public static void pArray(long[] arr) {
	    		for (int i = 0; i < arr.length; i++) {
	    			out.print(arr[i] + " ");
	    		}
	    		out.println();
	    		return;
	    	}
	     
	public static void pArray(boolean[] arr) {
	    		for (int i = 0; i < arr.length; i++) {
	    			out.print(arr[i] + " ");
	    		}
	    		out.println();
	    		return;
	    	}

   static class InputReader {
 
        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private InputReader.SpaceCharFilter filter;
 
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
 
        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
 
        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }
 
        public String readString() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }
 
        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

/////-------------------------------------------------------------////////////////888888888888/////////////////////////////////////////////-------------------



}