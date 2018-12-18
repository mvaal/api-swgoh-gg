package gg.swgoh.api.actions;

import gg.swgoh.api.Client;
import gg.swgoh.api.model.Ability;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Abilities implements ListAction<Ability>, ReadAction<Ability, Integer> {
    private final Client client;

    public Abilities(Client client) {
        this.client = client;
    }

    @Override
    public List<Ability> list() {
        return Arrays.asList(this.client.action("abilities", Ability[].class));
    }

    @Override
    public Ability read(Integer id) {
        throw new UnsupportedOperationException("This is supposed to be there, but abilities do not seem to have an ID.");
    }

    public List<Ability> forCharacter(String characterBaseId) {
        return list().stream()
                .filter(ability ->
                        Optional.ofNullable(ability.getCharacterBaseId())
                                .map(id -> id.equals(characterBaseId))
                                .orElse(false)
                )
                .collect(Collectors.toList());
    }
}
