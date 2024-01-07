package PokemonTrainer;

import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer(String name, List<Pokemon> pokemons) {
        this.name = name;
        this.badges = 0;
        this.pokemons = pokemons;
    }

    public int getBadges() {
        return badges;
    }

    public void commandExecuting(String command) {
        if (isExistElement(command)) {
            badges++;
        } else {
            for (int i = 0; i < pokemons.size(); i++) {
                Pokemon currentPokemon = pokemons.get(i);
                currentPokemon.setHealth(currentPokemon.getHealth() - 10);
                if (currentPokemon.getHealth() <= 0) {
                    pokemons.remove(currentPokemon);
                    i--;
                }
            }
        }
    }

    public boolean isExistElement(String command) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getElement().equals(command)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return String.format("%s %d %d", name, badges, pokemons.size());
    }
}
