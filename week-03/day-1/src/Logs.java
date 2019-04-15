import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Logs {
    // Read all data from 'log.txt'.
    // Each line represents a log message from a web server
    // Write a function that returns an array with the unique IP adresses.
    // Write a function that returns the GET / POST request ratio.
    public static void main(String[] args) {
        ArrayList <String> uniqueIPs = getUniqueIPs("log.txt");
        for (String uniqueIP: uniqueIPs) {
            System.out.println(uniqueIP);
        }
        System.out.println("Number of unique IPs : " + uniqueIPs.size());
    }

    public static ArrayList getUniqueIPs(String path) {

        List<String> IPadresses;
        ArrayList<String> uniqueIPadresses = new ArrayList<>();
        try {
            Path logPath = Paths.get(path);
            IPadresses = Files.readAllLines(logPath);
            for (String IPadress : IPadresses) {
                if (!uniqueIPadresses.contains(IPadress)){
                    uniqueIPadresses.add(IPadress);


                }
            }
        } catch (IOException e) {
            System.out.println(path + " : not found");
        }
return uniqueIPadresses;
    }
}
//.substring(26,37)