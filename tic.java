import java.io.*;
import java.util.*;
class solution{
  public static InputReader in;
    public static PrintWriter out; 
    public static char [][]board=new char[4][4];
public static void main(String[] args) throws IOException{

		 in = new InputReader(System.in);
         out = new PrintWriter(System.out);
      //  int n=in.nextInt();
        char [][]c=new char[4][4];
       String row1=in.readString();
       String row2=in.readString();
       String row3=in.readString();
       String row4=in.readString();
       for(int i=0;i<4;i++)
       {
       	  board[0][i]=row1.charAt(i);
       }
       for(int i=0;i<4;i++)
       {
       	  board[1][i]=row2.charAt(i);
       }
       for(int i=0;i<4;i++)
       {
       	  board[2][i]=row3.charAt(i);
       }
       for(int i=0;i<4;i++)
       {
       	  board[3][i]=row4.charAt(i);
       }
      /* for (int i=0;i<4 ;i++ ) {
       	for(int j=0;j<4;j++)
       	{
       		System.out.print(c[i][j]);
       	}
       	System.out.println();
       }
      */ 
       int t=CheckTicTacToe();
      if(t==1)
      {
        System.out.println("No");
      }
      else{
        System.out.println("Yes");
      } 
       
 
         
}
public static int CheckTicTacToe()
{  

    int count = 0;
    int row; int col;

    // Check each of 3 rows:
    for(row = 0; row < 4; ++row)
    {
        count = 0;
        for(col=0; col < 4; ++col)
        {
            count += (board[row][col] == 'X')?  1 :
                     (board[row][col] == 'O')? -1 : 0;
        }
        if (count == 4 || count == -4)
        {
            return count / Math.abs(count); // Return either 1 or -1
        }
    }

    // Check each of 3 columns.
    for(col = 0; col < 4; ++col)
    {
        count = 0;
        for(row=0; row < 4; ++row)
        {
            count += (board[row][col] == 'X')?  1 :
                     (board[row][col] == 'O')? -1 : 0;
        }
        if (count == 4 || count == -4)
        {
            return count / Math.abs(count); // Return either 1 or -1
        }
    }

    // Check Left-to-Right downward Diagonal:
    count = 0;
    for(col = 0; col < 4; ++col)
    {
        count += (board[col][col] == 'X')?  1 :
                 (board[col][col] == 'O')? -1 : 0;
    }
    if (count == 4 || count == -4)
    {
        return count / Math.abs(count); // Return either 1 or -1
    }

    // Check Left-to-Right upward Diagonal
    count = 0;
    for(col = 0; col < 4; ++col)
    {
        count += (board[col][3-col] == 'X')?  1 :
                 (board[col][3-col] == 'O')? -1 : 0;
    }
    if (count == 4 || count == -4)
    {
        return count / Math.abs(count); // Return either 1 or -1
    }

    return 0;
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

}