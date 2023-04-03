package goisstudy.ch03LambdaExpressions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task01Before {
    public String processFile() throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("data.txt"))) {
            // TODO: How could you reuse the processFile method and process files in different ways by passing
            //  different lambdas?
            return br.readLine();
        }
    }
}
