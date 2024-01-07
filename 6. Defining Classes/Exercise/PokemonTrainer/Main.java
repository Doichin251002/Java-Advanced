package PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        Map<String, List<Pokemon>> trainerPokemons = new LinkedHashMap<>();
        while (!command.equals("Tournament")) {
            String[] data = command.split("\\s+");
            String trainerName = data[0];
            String pokemonName = data[1];
            String element = data[2];
            int health = Integer.parseInt(data[3]);

            Pokemon pokemon = new Pokemon(pokemonName, element, health);
            trainerPokemons.putIfAbsent(trainerName, new ArrayList<>());
            trainerPokemons.get(trainerName).add(pokemon);

            command = scan.nextLine();
        }

        List<Trainer> trainerList = trainerPokemons.entrySet().stream()
                .map(e -> new Trainer(e.getKey(), e.getValue()))
                .collect(Collectors.toList());

        command = scan.nextLine();
        while (!command.equals("End")) {
            for (Trainer trainer : trainerList) {
                trainer.commandExecuting(command);
            }
            command = scan.nextLine();
        }

        trainerList.stream()
                .sorted(Comparator.comparingInt(Trainer::getBadges).reversed())
                .forEach(System.out::println);
    }
}
