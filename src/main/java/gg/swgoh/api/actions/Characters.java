package gg.swgoh.api.actions;

import gg.swgoh.api.Client;
import gg.swgoh.api.model.Character;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Characters implements ListAction<Character>, ReadAction<Character> {
    private final Client client;

    public Characters(Client client) {
        this.client = client;
    }

    @Override
    public List<Character> list() {
        return Arrays.asList(this.client.action("characters", Character[].class));
    }

    @Override
    public Character read(String id) {
        return this.client.action("characters/{id}", Collections.singletonMap("id", id), Character.class);
    }
}
