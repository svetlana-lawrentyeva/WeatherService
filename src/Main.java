/**
 * Created with IntelliJ IDEA.
 * User: nau
 * Date: 15.01.15
 * Time: 9:46
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        for(int i=0;i<2;++i){
            Thread weatherThread = new Thread(new WeatherGetter());
            weatherThread.start();
        }
    }
}
