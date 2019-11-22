package kr.or.ddit.base.uri.adapter;

import java.util.Map;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.base.uri.mapper.URIHandlerMapper;

public class URIHandlerAdpter {
   public static IAction getAction(String servletPath){
      Map<String, String> actionMap = URIHandlerMapper.getActionMap();
      
      IAction action = null;
      
      if(actionMap.containsKey(servletPath)){
         try {
            Class targetClass = Class.forName(actionMap.get(servletPath));
            action = (IAction) targetClass.newInstance();
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         } catch (InstantiationException e) {
            e.printStackTrace();
         } catch (IllegalAccessException e) {
            e.printStackTrace();
         }
      }
      
       return action;
   }
}