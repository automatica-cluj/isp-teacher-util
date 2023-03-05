package aut.isp.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class GithubRepoCloneAll {
    public static void main(String[] args) throws IOException, InterruptedException {
        List<String> allLines = Files.readAllLines(Paths.get("repo_list.txt"));
        int k=0;
        for (String line : allLines) {
            System.out.println("Clone repo:"+line);
            execute(line);
            Thread.sleep(1000);
        }

        // execute(args);
    }

    private static void execute(String repoName) throws IOException {

        Process process = new ProcessBuilder("C:\\Program Files\\GitHub CLI\\gh.exe","repo","clone",repoName).start();
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;

        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}
