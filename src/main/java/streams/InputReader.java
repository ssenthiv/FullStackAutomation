package streams;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Stream;
// Taken from git - FastIO - #3 - Competitive Programming In Java
import java.io.InputStream; 
class InputReader {

    private InputStream stream;
    
    private byte[] buf = new byte[1024];

    

    private int curChar;



    private int numChars;

public  static void main(String[] args) throws IOException{
	
	InputReader ir=new InputReader(System.in);
	
	
	ir.facade();
	
	
}

public void facade() throws IOException{
	
	menu();
	int caseVariable=readInt();
	
	switch(caseVariable){
	case 1 : System.out.println("\t\t Integer = "+ readInt());
			break;
	case 2 : System.out.println("\t\t Long = "+readLong());
			break;
	case 3 : System.out.println("\t\t String = "+readString());
			break;
	case 4 : break;
	default :System.out.println("*** Invalid Input ***"); 
			break;
	}
	if (caseVariable != 4)
		facade();
	else
		return;
	
}
public void menu(){
	
	
	System.out.println("1. Integer");
	System.out.println("2. Long");
	System.out.println("3. String");
	System.out.println("4. Quit");
	System.out.print(" Enter  the number : ");
	
}

    public InputReader(InputStream stream) {

        this.stream = stream;

    }



    public int read() {
    	
    	/* This method will read only once into byte[]
    	 * Then take the value from buffer
    	 */
    	
        if (numChars == -1)

            throw new RuntimeException();

        if (curChar >= numChars) {

            curChar = 0;

            try {

                numChars = stream.read(buf);
                
            } catch (IOException e) {

                throw new RuntimeException();

            }

            if (numChars <= 0)

                return -1;

        }
        
        return buf[curChar++];

    }



    public String readString() throws IOException {

        final StringBuilder stringBuilder = new StringBuilder();
        
        //int c = read();
        int c=stream.read();    // This is used to check stream.skip() and stream.available()
        while (isSpaceChar(c))

            //c = read();
        	c=stream.read();
        	
        do {
        	
            stringBuilder.append((char)c);

            //c = read();
            c=stream.read();
        } while (!isSpaceChar(c));
      //} while (c != 10);				// this is to read till \n
        
        
        int size =stream.available();
        //System.out.println("size ="+ size);
        long skiped=stream.skip(size);
        //System.out.println("skipped ="+ skiped);
      
        

        return stringBuilder.toString();

    }



    public int readInt() {

        int c = read();

        while (isSpaceChar(c))

            c = read();

        int sgn = 1;

        if (c == '-') {

            sgn = -1;

            c = read();

        }

        int res = 0;

        do {

            res *= 10;

             res += c - '0';	// this is required to convert the ascci into actual value
            
            
            c = read();

        } while (!isSpaceChar(c));

        return res * sgn;

    }



    public long readLong() {

        int c = read();

        while (isSpaceChar(c))

            c = read();

        int sgn = 1;

        if (c == '-') {

            sgn = -1;

            c = read();

        }

        long res = 0;

        do {

            res *= 10;

            res += c - '0';

            c = read();

        } while (!isSpaceChar(c));

        return res * sgn;

    }



    public boolean isSpaceChar(int c) {

        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;

    }

    // Not used 
    public long skip(long numbytes) throws IOException {
        if (numbytes <= 0) {
            return 0;
        }
        long n = numbytes;
        int buflen = (int) Math.min(1024, n);
        byte data[] = new byte[buflen];
        while (n > 0) {
            int r = stream.read(data, 0, (int) Math.min((long) buflen, n));
            System.out.println("r ="+r);
            if (r < 0) {
                break;
            }
            n -= r;
        }
        return numbytes - n;
    }
    
}
    
