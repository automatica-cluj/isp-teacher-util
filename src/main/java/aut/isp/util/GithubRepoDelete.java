package aut.isp.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class GithubRepoDelete {
    public static void main(String[] args) throws IOException, InterruptedException {
        List<String> allLines = Files.readAllLines(Paths.get("todelete.txt"));
        int k=0;
        for (String line : allLines) {
            //System.out.println(line);
            List<String> note = Arrays.stream(line.split("\\s+")).toList();
            k++;
            System.out.println(""+k+" "+(note.get(0)));
            System.out.println("DELETING");
            execute(note.get(0));
            Thread.sleep(1000);
        }

       // execute(args);
    }

    private static void execute(String repoName) throws IOException {

        Process process = new ProcessBuilder("C:\\Program Files\\GitHub CLI\\gh.exe","repo","delete",repoName,"--yes").start();
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;

        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}
