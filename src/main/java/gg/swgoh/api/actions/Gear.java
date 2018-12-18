package gg.swgoh.api.actions;

import gg.swgoh.api.Client;
import gg.swgoh.api.model.GearPiece;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Gear implements ListAction<GearPiece>, ReadAction<GearPiece> {
    private final Client client;

    public Gear(Client client) {
        this.client = client;
    }

    @Override
    public List<GearPiece> list() {
        return Arrays.asList(this.client.action("gear", GearPiece[].class));
    }

    @Override
    public GearPiece read(String id) {
        return this.client.action("gear/{id}", Collections.singletonMap("id", id), GearPiece.class);
    }
}
