package kr.or.ddit.base.uri.mapper;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


public class URIHandlerMapper {
   private static Map<String, String> actionMap = 
         new HashMap<String, String>();
   
   static{
      ResourceBundle bundle = ResourceBundle.getBundle("kr.or.ddit.base.uri.mapper.servletPathData");
      Enumeration<String> keys = bundle.getKeys();
      while(keys.hasMoreElements()){
         String key = keys.nextElement();
         
         String value = bundle.getString(key);
         
         actionMap.put(key,value);
      }
   }
   
   public static Map<String, String> getActionMap(){
      return actionMap;
   }
}