package gg.swgoh.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Character {
    private String name;
    @JsonProperty("base_id")
    private String baseId;
    private int pk;
    private String url;
    private String image;
    private int power;
    private String description;
    @JsonProperty("combat_type")
    private int combatType;
    @JsonProperty("gear_levels")
    private List<GearLevel> gearLevels;
    private String alignment;
    private List<String> categories;
    @JsonProperty("ability_classes")
    private List<String> abilityClasses;
    private String role;
    private String ship;
    @JsonProperty("ship_slot")
    private String shipSlot;
    @JsonProperty("activate_shard_count")
    private int activateShardCount;


    @Data
    public static class GearLevel {
        private int tier;
        private List<String> gear;
    }
}
