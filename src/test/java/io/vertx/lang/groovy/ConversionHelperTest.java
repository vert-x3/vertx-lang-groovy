package io.vertx.lang.groovy;

import io.vertx.core.json.JsonObject;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by dphillips on 1/14/17.
 */
public class ConversionHelperTest {
    @Test
    public void toJsonObject() throws Exception {
        Map<String, Object> testMap = new LinkedHashMap<>();
        testMap.put("keyOne", null);
        testMap.put("keyTwo", "a");
        testMap.put("keyThree", Boolean.TRUE);
        testMap.put("keyFour", Integer.valueOf(12));

        JsonObject result = ConversionHelper.toJsonObject(testMap);
        assertNull(result.getValue("keyOne"));
    }

    @Test
    public void toJsonElement() throws Exception {
        Object result = ConversionHelper.toJsonElement(null);
    }
}