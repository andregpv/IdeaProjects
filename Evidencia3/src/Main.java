import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {

    static class Card {
        private final String palo;
        private final String color;
        private final String valor;

        public Card(String palo, String valor) {
            this.palo = palo;
            this.valor = valor;
            if (palo.equals("corazones") || palo.equals("diamantes")) {
                this.color = "rojo";
            } else {
                this.color = "negro";
            }
        }

        public String toString() {
            return palo + color + valor;
        }
    }

    static class Deck {
        private final List<Card> cartas;

        public Deck() {
            cartas = new ArrayList<>();
            String[] palos = {"treboles", "corazones", "picas", "diamantes"};
            String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

            for (String palo : palos) {
                for (String valor : valores) {
                    cartas.add(new Card(palo, valor));
                }
            }
        }

        public void shuffle() {
            Collections.shuffle(cartas);
            System.out.println("Se mezclo el Deck.");
        }

        public void head() {
            Card carta = cartas.removeFirst();
            System.out.println(carta);
            System.out.println("Quedan " + cartas.size());
        }

        public void pick() {

            int index = new Random().nextInt(cartas.size());
            Card carta = cartas.remove(index);
            System.out.println(carta);
            System.out.println("Quedan " + cartas.size());
        }

        public void hand() {
            for (int i = 0; i < 5; i++) {
                Card carta = cartas.removeFirst();
                System.out.println(carta);
            }
            System.out.println("Quedan " + cartas.size());
        }
    }

    public static void main(String[] args) {
        Deck deck = new Deck();

        deck.shuffle();
        deck.head();
        deck.pick();
        deck.hand();
    }
}