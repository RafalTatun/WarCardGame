class Card {

    // Wartości kart
    private int rank;

    // Kolor kart
    private int suit;

    public Card(int suit, int rank){
        this.rank = rank;
        this.suit = suit;
    }

    public int getCard(){
        return rank;
    }

    public String toString(){
        // Tworzenie kart np. Dama trefl

        StringBuilder displayCard = new StringBuilder();

        switch(rank){

            case 11:
                displayCard.append("Walet");
                break;
            case 12:
                displayCard.append("Dama");
                break;
            case 13:
                displayCard.append("Król");
                break;
            case 14:
                displayCard.append("As");
                break;
            default:
                displayCard.append(rank);
                break;
        }

        displayCard.append(" ");

        switch(suit){
            case 0:
                displayCard.append("Pik");
                break;
            case 1:
                displayCard.append("Serce");
                break;
            case 2:
                displayCard.append("Trefl");
                break;
            case 3:
                displayCard.append("Dzwonek");
                break;

                // Nic nie robi
            default:
                break;
        }

        // Zwraca wszystko
        return displayCard.toString();
    }
}