//Anshul Gaur 22bcs13276 
import java.util.*;

 class CardCollection {
    private final Map<String, List<String>> cardDeck = new HashMap<>();
    private final Scanner sc = new Scanner(System.in);

    void addCard() {
        System.out.print("Enter Card Symbol (Hearts, Spades, Diamonds, Clubs): ");
        String symbol = sc.nextLine();
        System.out.print("Enter Card Name (Ace, King, Queen, etc.): ");
        String name = sc.nextLine();

        cardDeck.computeIfAbsent(symbol, k -> new ArrayList<>()).add(name);
        System.out.println("✅ Card Added: " + name + " of " + symbol);
    }

    void searchCards() {
        System.out.print("Enter Symbol to Search (Hearts, Spades, Diamonds, Clubs): ");
        String symbol = sc.nextLine();
        List<String> cards = cardDeck.get(symbol);

        if (cards == null || cards.isEmpty()) {
            System.out.println("❌ No Cards Found for " + symbol);
        } else {
            System.out.println("🃏 Cards in " + symbol + ": " + cards);
        }
    }

    void displayAllCards() {
        if (cardDeck.isEmpty()) {
            System.out.println("⚠ No Cards in Collection!");
        } else {
            cardDeck.forEach((symbol, cards) -> System.out.println("🃏 " + symbol + ": " + cards));
        }
    }}
public class Main{
    public static void main(String[] args) {
        CardCollection collection = new CardCollection();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1️⃣ Add Card  2️⃣ Search by Symbol  3️⃣ Display All Cards  4️⃣ Exit");
            System.out.print("Choice: ");
            switch (sc.nextInt()) {
                case 1 -> collection.addCard();
                case 2 -> collection.searchCards();
                case 3 -> collection.displayAllCards();
                case 4 -> { System.out.println("🚪 Exiting..."); return; }
                default -> System.out.println("❌ Invalid Choice!");
            }
            sc.nextLine(); 
        }
    }
}
