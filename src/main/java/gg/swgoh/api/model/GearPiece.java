package gg.swgoh.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class GearPiece {
    @JsonProperty("base_id")
    private String baseId;
    private List<Recipe> recipes;
    private int tier;
    @JsonProperty("required_level")
    private int requiredLevel;
    private Map<String, Integer> stats;
    private String mark;
    private int cost;
    private String image;
    private String url;
    private List<Ingredient> ingredients;
    private String name;


    @Data
    private static class Recipe {
        @JsonProperty("base_id")
        private String baseId;
        @JsonProperty("result_id")
        private String resultId;
        private int cost;
        private List<Ingredient> ingredients;
    }

    @Data
    private static class Ingredient {
        private int amount;
        private String gear;
    }
}
