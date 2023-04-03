package goisstudy.ch03LambdaExpressions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task01 {

    public static void main(String[] args) throws IOException {
        new Task01().processFile((BufferedReader b) -> b.readLine() + "\n" + b.readLine());
        new Task01().processFile((BufferedReader b) -> b.read() + " - " + b.read());
    }

    public String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }
}

@FunctionalInterface
interface BufferedReaderProcessor {
    String process(BufferedReader bufferedReader) throws IOException;
}
