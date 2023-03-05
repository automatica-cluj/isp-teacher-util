package aut.isp.util;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@SpringBootApplication
public class StudentCodeGenerator {
    public static String getClassCode(String input){
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);




            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args) throws IOException {

        List<String> allLines = Files.readAllLines(Paths.get("lista_studenti.txt"));
//        int k=0;
//        for (String line : allLines) {
//            //System.out.println(line);
//            List<String> note = Arrays.stream(line.split("\\s+")).toList();
//            k++;
//            System.out.println(""+k+" "+getClassCode(note.get(0))+" "+note.get(1));
//        }

        int k=0;
        for (String line : allLines) {
            System.out.println(getClassCode(line));
        }

    }

}
