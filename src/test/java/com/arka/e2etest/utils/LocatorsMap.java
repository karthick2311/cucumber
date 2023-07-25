package com.arka.e2etest.utils;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
public class LocatorsMap {

//	public static JsonNode node = JsonNodeFactory.instance.objectNode();
    /**
     * read the locators
     * @return jsonNode
     *
     */
    public static JsonNode getlocators() {
        try {

            ObjectMapper mapper = new ObjectMapper();
            JsonNode carMap = mapper.readValue(new File("./locators/weblocators.json"), new TypeReference<JsonNode>() {
            });

            return carMap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

}
