package programmablethermostat;
/** @author CharlesAllen */

//import for option 1
import java.io.*;
import java.net.URL;
import org.json.simple.*;
import org.json.simple.parser.*;

//imports for option 2
import java.net.HttpURLConnection;

public class ProgrammableThermostat {

    public static void main(String[] args) throws Exception {
        
        ///////////   OPTION 1: CODE BELOW IS USING inputstreamreader and openStream to create a connection //////////////
        //create a URL object to reference the JSON web file        
        URL url = new URL("http://media.capella.edu/BBCourse_Production/IT4774/temperature.json");
        
        //create a BufferedReader object to read the file using input stream
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        
        //create parser to parse through data
        JSONParser parser = new JSONParser();
        
        //create java objects using the parser
        JSONObject json = (JSONObject) parser.parse(reader);
        
        //variable to store the runtime object
        JSONObject runtime = (JSONObject) json.get("runtime");
        
        //variable to store the actual temperature
        int actualTemp = Integer.parseInt(runtime.get("actualTemperature").toString());
        
        //output to console
        System.out.println("Actual Temperature is " + actualTemp);
        
        
        
        
        ///////////   OPTION 2: CODE BELOW IS USING HttpURLConnection to create a connection before passing to InputStreamReader  //////////////
        /*
        URL url = new URL("http://media.capella.edu/BBCourse_Production/IT4774/temperature.json");
        
        //creates a URL connection using the URL object
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      
        //create a BufferedReader object to read the file using InputStreamReader getInputStream off the connection
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        
        //create parser to parse through data
        JSONParser parser = new JSONParser();
        
        //create java objects using the parser
        JSONObject json = (JSONObject) parser.parse(reader);
        
        //variable to store the runtime object
        JSONObject runtime = (JSONObject) json.get("runtime");
        
        //variable to store the actual temperature
        int actualTemp = Integer.parseInt(runtime.get("actualTemperature").toString());
        
        //output to console
        System.out.println("Actual Temperature is " + actualTemp);
        */


        
    }

}

