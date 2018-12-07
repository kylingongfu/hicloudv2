package org.zhang.mvc.v1;


import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class Response{
    private int status = 0;
    private String msg;
    private Object content;


    public int getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getContent() {
        return content;
    }

    public <T> T getContentType(Class<T> clazz){
        T t = null;
        try {

            t = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            BeanUtils.populate(t, (Map) getContent());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return t;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Response{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", content=" + content +
                '}';
    }
}
