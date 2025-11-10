//package utils;
//
//import org.json.JSONObject;
//import org.json.J
//import org.json.simple.parser.ParseException;
//
//public class JSONHelper extends Helper{
//
//    public static JSONObject parseJsonData(String jsonPath){
//        JSONParser parser = new JSONParser();
//        Object obj;
//        try {
//            obj = parser.parse(new FileReader(jsonPath));
//        } catch (IOException | ParseException e) {
//            throw new RuntimeException(e);
//        }
//        JSONObject jsonObject = (JSONObject) obj;
//        return jsonObject;
//    }
//}
