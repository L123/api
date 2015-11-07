package com.javaer.tools.formatter;
 
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
/**
 * @author henrypoter
 * 
 */
public class JsonFormatter {
    /**
     * @param args
     */
//    public static void main(String[] args) {
//        String uglyJSONString = "{\"data1\":100,\"data2\":\"hello\",\"list\":[\"String 1\",\"String 2\",\"String 3\"]}";
//        String prettyJsonString = jsonFormatter(uglyJSONString);
//        System.out.println("JSON格式化前：");
//        System.out.println(uglyJSONString);
//        System.out.println("JSON格式化后：");
//        System.out.println(prettyJsonString);
// 
//    }
     
    public static  String jsonFormatter(String uglyJSONString){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(uglyJSONString);
        String prettyJsonString = gson.toJson(je);
        return prettyJsonString;
    }

    

 
}