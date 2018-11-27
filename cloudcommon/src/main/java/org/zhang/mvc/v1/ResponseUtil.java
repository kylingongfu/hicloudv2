package org.zhang.mvc.v1;

public class ResponseUtil {
    final static String STR_STATUS = "status";
    final static String STR_BODY = "content";


    public static <T> Response success(T t){
        Response reponse = new Response<String,Object>();
        reponse.put(STR_STATUS,"0");
        reponse.put(STR_BODY,t);
        return reponse;
    }
}
