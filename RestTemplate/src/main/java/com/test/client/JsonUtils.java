package com.test.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonUtils {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    //private final static ObjectMapper JSON = new ObjectMapper();

    static {
        //JSON.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    	objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private JsonUtils() {

    }

    public static ObjectMapper getInstance() {

        return objectMapper;
    }

    /**
     * javaBean,list,array convert to json string
     */
    public static String obj2json(Object obj) {
        String rString = null;
        try {
			rString = objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    	return rString;
    }

    /**
     * json string convert to javaBean
     */
    public static <T> T json2pojo(String jsonStr, Class<T> clazz)
            {
    	T t =null;
    	try {
			t = objectMapper.readValue(jsonStr, clazz);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return t;
    }

    /**
     * json string convert to map
     */
    @SuppressWarnings("unchecked")
	public static <T> Map<String, Object> json2map(String jsonStr)
            throws Exception {
        return objectMapper.readValue(jsonStr, Map.class);
    }

    /**
     * json string convert to map with javaBean
     */
    public static <T> Map<String, T> json2map(String jsonStr, Class<T> clazz)
            throws Exception {
        Map<String, Map<String, Object>> map = objectMapper.readValue(jsonStr,
                new TypeReference<Map<String, T>>() {
                });
        Map<String, T> result = new HashMap<String, T>();
        for (Entry<String, Map<String, Object>> entry : map.entrySet()) {
            result.put(entry.getKey(), map2pojo(entry.getValue(), clazz));
        }
        return result;
    }

    /**
     * json array string convert to list with javaBean
     */
    public static <T> List<T> json2list(String jsonArrayStr, Class<T> clazz)
            throws Exception {
        List<Map<String, Object>> list = objectMapper.readValue(jsonArrayStr,
                new TypeReference<List<T>>() {
                });
        List<T> result = new ArrayList<T>();
        for (Map<String, Object> map : list) {
            result.add(map2pojo(map, clazz));
        }
        return result;
    }

    /**
     * map convert to javaBean
     */
    @SuppressWarnings("rawtypes")
	public static <T> T map2pojo(Map map, Class<T> clazz) {
        return objectMapper.convertValue(map, clazz);
    }

    public static byte[] toJsonAsBytes(Object object) {
        try {
            return objectMapper.writeValueAsBytes(object);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}