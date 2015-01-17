import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: nau
 * Date: 17.01.15
 * Time: 13:11
 * To change this template use File | Settings | File Templates.
 */
public class WeatherGetter implements Runnable {

    public void run() {
        String input = "";
        while (true){
            System.out.println("enter the city name:");
            Scanner sc = new Scanner(System.in);
            input = sc.nextLine();
            if(input.equals("exit")) break;
            input = input.replace(" ", "-");
            String xml = executeGet(input);
            try{
                System.out.println("temp for "+input+": "+XMLParser.getTemperature(xml));
            } catch (Exception ex){
                System.out.println("wrong name of city");
            }
        }
    }
    public String executeGet(String city) {
            String res="";
            //String targetURL = "http://www.myweather2.com/developer/forecast.ashx?uac=zsTfepQPQp&output=xml&query=SW1";
            String targetURL = "http://api.worldweatheronline.com/free/v2/weather.ashx?key=b6b5c331978e18e2162bc4c07156c&q="+city+"&num_of_days=1";
            URL url;
            HttpURLConnection connection = null;
            try {
                //Create connection
                url = new URL(targetURL);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");


                InputStream is = connection.getInputStream();

                DocumentBuilderFactory builderFactory =
                        DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = null;
                try {
                    builder = builderFactory.newDocumentBuilder();
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                }

                BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                String line;
                StringBuffer response = new StringBuffer();
                while((line = rd.readLine()) != null) {
                    response.append(line);
                    response.append('\r');
                }
                rd.close();

                res=response.toString();


            } catch (Exception e) {

                e.printStackTrace();
                return null;

            } finally {

                if (connection != null) {
                    connection.disconnect();
                }
            }
            return  res;
        }
}
