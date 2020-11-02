package programmablethermostat;
/** @author CharlesAllen */

//import Scanner utility to be able to read user input
import java.io.*;
import java.net.URL;
import org.json.simple.*;
import org.json.simple.parser.*;


public class ProgrammableThermostat {

    public static void main(String[] args) throws Exception {
        
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
        


        
    }

}

