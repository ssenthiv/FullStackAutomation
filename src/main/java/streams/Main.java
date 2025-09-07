package streams;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

// Taken from git - FastIO - #3 - Competitive Programming In Java
import java.io.InputStream; 
class InputReader1 {

    private InputStream stream;

    private byte[] buf = new byte[1024];



    private int curChar;



    private int numChars;



    public InputReader1(InputStream stream) {

        this.stream = stream;

    }



    public int read() {

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



    public String readString() {

        final StringBuilder stringBuilder = new StringBuilder();

        int c = read();

        while (isSpaceChar(c))

            c = read();

        do {

            stringBuilder.append(c);

            c = read();

        } while (!isSpaceChar(c));

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

             res += c - '0';
            //res += c ;
            
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

}
    class TaskManager {
        private List<Thread> tasks = new ArrayList<>();

        public void acceptTask(Runnable task) {
            tasks.add(new Thread(task));
        }

        private void startAllTasks() {
            tasks.stream().forEach(Thread::start);
        }

        private void waitForAllToComplete() {
            tasks.stream().forEach(thread -> {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        private void removeAllTasks() {
            tasks = new ArrayList<>();
        }

        public void completeAllTasks() {
            startAllTasks();
            waitForAllToComplete();
            removeAllTasks();
        }

        private LongAdder counter = new LongAdder();

        public void cyclicInputReader(final int testCases,
                                      final int noOfThreads,
                                      InputReader1 inputReader, final int k) {
            for (int thread = 0; thread < noOfThreads; thread++) {
                final int threadIndex = thread;
                acceptTask(() -> {
                    for (int i = threadIndex; i < testCases; i = i + noOfThreads) {
                        if (inputReader.readInt() % k == 0) {
                            counter.increment();
                        }
                    }
                });
            }
            completeAllTasks();
        }

        public LongAdder getCounter() {
            return counter;
        }
    }

   public  class Main {
        public static void main(String args[]) throws IOException {
            final InputReader1 reader = new InputReader1(System.in);
            final TaskManager taskManager = new TaskManager();
            taskManager.cyclicInputReader(reader.readInt(), Runtime.getRuntime().availableProcessors(), reader, reader.readInt());
            System.out.println(taskManager.getCounter());
        }
}

