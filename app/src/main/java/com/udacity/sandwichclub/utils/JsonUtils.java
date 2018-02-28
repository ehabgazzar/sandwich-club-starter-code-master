package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json)  {
        Sandwich sandwich = null;
        try {
            JSONObject jsonObject= new JSONObject(json);
            JSONObject jsonName= jsonObject.getJSONObject("name");
            JSONArray alsoKnownAs = jsonName.optJSONArray("alsoKnownAs");
            List<String> knownAs = new ArrayList<String>();
            for (int i=0;i<alsoKnownAs.length();i++){
                knownAs.add(alsoKnownAs.getString(i));
            }
            JSONArray JsonIngredients =  jsonObject.optJSONArray("ingredients");
            List<String> ingredients= new ArrayList<String>();
            for (int i=0;i<JsonIngredients.length();i++){
                ingredients.add(JsonIngredients.getString(i));
            }
            sandwich= new Sandwich(jsonName.optString("mainName"),knownAs,
                     jsonObject.optString("placeOfOrigin"),jsonObject.optString("description"),jsonObject.optString("image"),ingredients
                    );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwich;
    }
}
