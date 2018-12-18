package gg.swgoh.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Ability {
    @JsonProperty("base_id")
    private String baseId;
    private String name;
    private String image;
    private String url;
    @JsonProperty("tier_max")
    private int tierMax;
    @JsonProperty("is_zeta")
    private boolean isZeta;
    @JsonProperty("is_omega")
    private boolean isOmega;
    @JsonProperty("combat_type")
    private int combatType;
    private int type;
    @JsonProperty("character_base_id")
    private String characterBaseId;
}
