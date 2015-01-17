/**
 * Created by therioyo on 15.01.15.
 */
public class XMLParser {
//    public static String parse(String _xml){
//        xml=_xml;
//        parseTag(-1,0);
//        return builder.toString();
//    }
//    private  static void parseTag(int close, int level){
//        if(xml.length()-close<3)return;
//        int open=close+1;
//        if(xml.charAt(open+1)!='?' && xml.charAt(open+1)!='/'){
//            close=xml.indexOf('>', open);
//            for(int i=0;i<level;++i){
//                builder.append(" ");
//            }
//            builder.append(xml.substring(open+1,close)).append("\n");
//            if(xml.charAt(close+1)=='<'){
//                parseTag(close, ++level);
//            }
//            else parseValue(close, level);
//        } else {
//            close=xml.indexOf('>', open);
//            parseTag(close, --level);
//        }
//    }

//    private static void parseValue(int close, int level) {
//        int open=close+1;
//        close=xml.indexOf('<', open);
//        for(int i=0;i<level;++i){
//            builder.append(" ");
//        }
//        builder.append(" ").append(xml.substring(open,close)).append("\n");
//        if(xml.charAt(close)=='<')parseTag(close - 1, ++level);
//        else parseValue(close-1, level);
//    }

    public static String getTemperature(String xml){
        String temperature = "";
        String startTag =  "<temp_C>";
        String endTag = "</temp_C>";
        int startIndex=xml.indexOf(startTag)+startTag.length();
        int endIndex = xml.indexOf(endTag);
        temperature =xml.substring(startIndex, endIndex);
        return temperature;
    }
}
