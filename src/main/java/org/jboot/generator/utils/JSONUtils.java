package org.jboot.generator.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JSONUtils {

    public JSONObject parseObject(String str) {
        return JSONObject.parseObject(JSON.toJSONString(str));
    }

    public String getString(String str, String key) {
        return parseObject(str).getString(key);
    }

}
