package main.java.com.magicvet.component;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class Sandbox {

    public void writeSandbox(String string) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream("sandbox.txt", true)
                )
        )) {
            bufferedWriter.newLine();
            bufferedWriter.write(string);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> readSandbox() {
        List<String> sandboxList;
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("sandbox.txt")
                )
        )) {
            sandboxList = bufferedReader.lines().collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sandboxList;
    }
}
