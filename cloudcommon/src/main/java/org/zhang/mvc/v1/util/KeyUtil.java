package org.zhang.mvc.v1.util;

import java.util.UUID;

/**
 * @Auther: zhang
 * @Date: 2018/12/1 21:19
 * @Description:
 */
public class KeyUtil {
    public static String getUUID32() {
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        return uuid;
    }
}
