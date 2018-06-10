import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.Collections;
import java.util.LinkedList;

public class WarGame {
    public static void main(String[] args) {

        List<Card> cardDeck = new ArrayList<Card>(); // Tworzę ArrayList

        for(int x=0; x<4; x++){          // Pętla z kolorami kart
            for(int y=2; y<15; y++){     // Pętla z wartościami kart
                cardDeck.add(new Card(x,y));  // Tworzy kartę i dodaję ją do talii
            }
        }

        Collections.shuffle(cardDeck, new Random()); // Tasuje karty randomowo

        // Tworzenie talii dla gracza pierwszego i drugiego (po 26 kart)
        LinkedList<Card> deck1 = new LinkedList<Card>();
        LinkedList<Card> deck2 = new LinkedList<Card>();

        deck1.addAll(cardDeck.subList(0, 25));
        deck2.addAll(cardDeck.subList(26, cardDeck.size()));

        while(true){
            Card p1Card = deck1.pop();  // Każdy gracz wykładę kartę do góry
            Card p2Card = deck2.pop();

            // Wyświetla kartę którą zagraliśmy
            System.out.println("Gracz 1 zagrał kartę " + p1Card.toString());
            System.out.println("Gracz 2 zagrał kartę " + p2Card.toString());

            // Porównanie obu kart
            if(p1Card.getCard() > p2Card.getCard()){    // Jeśli wygra gracz 1
                deck1.addLast(p1Card);  // Dodawanie na spód talii
                deck1.addLast(p2Card);
                System.out.println("Gracz 1 wygrał rundę");
            }

            else if(p1Card.getCard() < p2Card.getCard()){   // Jeśli wygra gracz 2
                deck2.addLast(p1Card);  // To samo co wyżej
                deck2.addLast(p2Card);
                System.out.println("Gracz 2 wygrał rundę");
            }

            else { // Gdy karty są równe
                System.out.println("Wojna");

                // Tworzymy kartę zakrytą
                List<Card> war1 = new ArrayList<Card>();
                List<Card> war2 = new ArrayList<Card>();

                // Sprawdza czy każdy gracz może wyłożyć kartę po wojnie
                for(int x=0; x<3; x++){
                    // Jeśli nie, przegrywa grę
                    if(deck1.size() == 0 || deck2.size() == 0 ){
                        break;
                    }

                    System.out.println("Karta zakryta 1 gracza\nKarta zakryta 2 gracza");

                    war1.add(deck1.pop());  // Każdy gracz wykłada kartę znowu
                    war2.add(deck2.pop());
                }

                // Jeśli gracze mają wystarczającą ilość kart gramy dalej
                if(war1.size() == 3 && war2.size() == 3 ){
                    //Wyświetla kartę każdego gracza
                    System.out.println("Zakryta karta gracza 1 " + war1.get(0).toString());
                    System.out.println("Zakryta karta gracza 2 " + war2.get(0).toString());

                    // Jeśli wygra gracz 1
                    if(war1.get(2).getCard() > war2.get(2).getCard()){
                        deck1.addAll(war1); // Dodaje 10 kart graczowi 1
                        deck1.addAll(war2);
                        System.out.println("Gracz 1 wygrał rundę");
                    }
                    // Jeśli wygra gracz 2
                    else{
                        deck2.addAll(war1); // Dodaje 10 kart graczowi 2
                        deck2.addAll(war2);
                        System.out.println("Gracz 2 wygrał rundę");
                    }
                }

            }

            // Koniec gry jeśli, któryś z graczy nie ma kart w talii
            if(deck1.size() == 0 ){
                System.out.println("Koniec gry \nGracz 1 wygrał!!!");
                break;
            }
            else if(deck2.size() == 0){
                System.out.println("Koniec gry \nGracz 2 wygrał!!!");
                break;
            }
        }
    }
}