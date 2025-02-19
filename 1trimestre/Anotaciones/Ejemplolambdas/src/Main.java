import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));


        // 1 Encuentre todas las transacciones del año 2011 y ordénelas por valor (menor a mayor).
        List<Transaction> transacciones2011 =
                transactions.stream()
                        .filter(transaction -> transaction.getAnio() == 2011)
                        .sorted()
                        .toList();

        // 2 ¿Cuáles son todas las ciudades (sin repetición) donde trabajan los traders?
        List<String> ciudad_traders = transactions.stream()
                .map(transaction -> transaction.getTrader().getCiudad())
                .distinct().toList();

            // O mediante toSet
            Set<String> ciudad_traders_set = transactions.stream()
                    .map(transaction -> transaction.getTrader().getCiudad())
                    .collect(toSet());

        // 3 Encuentre todos los traders de Cambridge y ordénelos por nombre.
        List<Trader> trader_cambrige = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> "Cambridge".equals(t.getCiudad()))
                .sorted()
                .toList();

        // 4 Devuelva los nombres de todos los traders ordenados alfabéticamente en una sola cadena
        String nombre_traders = transactions.stream()
                .map(transaction -> transaction.getTrader().getNombre())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);

            // O mediante joining
        String nombre_traders_joining = transactions.stream()
                .map(transaction -> transaction.getTrader().getNombre())
                .distinct()
                .sorted()
                .collect(joining());

        // 5 ¿Hay traders con sede en Milán? Sí o no

        Boolean traders_milan =
                transactions.stream()
                        .anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCiudad()));

        // 6 Imprime los valores de todas las transacciones de los traders que viven en Cambridge.

        transactions.stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCiudad()))
                .map(Transaction::getValor)
                .forEach(System.out::println);


        // 7 ¿Cuál es el valor más alto de todas las transacciones?

        Optional<Integer> highestValue = transactions.stream()
                .map(Transaction::getValor)
                .reduce(Integer::max);


        // 8 Encuentra la transacción con el valor más pequeño.

    }
}