package org.zhang.mvc.v1;

public class ResponseUtil {


    public static Response success(Object content) {
        Response response = new Response();
        response.setContent(content);
        return response;
    }
    /* final static String STR_STATUS = "status";
    final static String STR_BODY = "content";


    public static <T> Response success(T t){
        Response reponse = new Response<String,Object>();
        reponse.put(STR_STATUS,"0");
        reponse.put(STR_BODY,t);
        return reponse;
    }*/
}
