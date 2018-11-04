import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards;
    Random random;

    public Deck() {
        this.cards = new ArrayList<Card>();
        this.random = new Random();

        // create all the cards
        this.generateDeck();
    }

    /*
     * Generate all the cards for a deck 生成卡牌组成deck
     * the cards are stored in the member variable - cards
     */
    private void generateDeck() {
        Card[] cards=new Card[52];
        for(int i=0;i<13;i++){
            cards[i]=new Card(i+1,"Heart");
            this.cards.add(cards[i]);
        }
        for(int i=13;i<26;i++){
            cards[i]=new Card(i+1,"Spade");
            this.cards.add(cards[i]);
        }
        for(int i=26;i<39;i++){
            cards[i]=new Card(i+1,"Diamond");
            this.cards.add(cards[i]);
        }
        for(int i=39;i<52;i++){
            cards[i]=new Card(i+1,"Club");
            this.cards.add(cards[i]);
        }
    }

//    public void ShowCards(){
//        Iterator<Card> iterator = Deck.cards.iterator();
//        while (iterator.hasNext()){
//            Card card = iterator.next();
//            System.out.println("数字"+card.number+"花色"+card.suit);
//        }
//    }//有待实验与解决bug
    /*
     * Return a random card, remove it from the deck
     */
    public Card getRandomCard() {
        int index = this.random.nextInt(this.cards.size());//感觉有误，可以回去改
        return this.cards.remove(index);
    }

    /*
     * Create a CardGroup by picking 3 cards randomly
     */
    public CardGroup createRandomCardGroup() {
        int index1=this.random.nextInt(this.cards.size());
        Card card1 = this.cards.remove(index1);
        int index2=this.random.nextInt(this.cards.size());
        Card card2 = this.cards.remove(index2);
        int index3=this.random.nextInt(this.cards.size());
        Card card3 = this.cards.remove(index3);
        CardGroup cardGroup =new CardGroup(card1,card2,card3);
        return cardGroup; // to be replaced
    }

    public static void main(String[] args) {
        Deck deck = new Deck();

//        Deck.ShowCards();
        CardGroup cg1 = deck.createRandomCardGroup();
        System.out.println("第一个随机cardGroup为："+cg1.c1.getNumber()+cg1.c1.suit+"\t"+cg1.c2.getNumber()+cg1.c2.suit+"\t"+cg1.c3.getNumber()+cg1.c3.suit);
        CardGroup cg2 = deck.createRandomCardGroup();
        System.out.println("第二个随机cardGroup为："+cg2.c1.getNumber()+cg2.c1.suit+"\t"+cg2.c2.getNumber()+cg2.c2.suit+"\t"+cg2.c3.getNumber()+cg1.c3.suit);//未完待续
        CardGroup cg3 = deck.createRandomCardGroup();
        System.out.println("第三个随机cardGroup为："+cg3.c1.getNumber()+cg3.c1.suit+"\t"+cg3.c2.getNumber()+cg3.c2.suit+"\t"+cg3.c3.getNumber()+cg3.c3.suit);//未完待
        System.out.println("最大的组有");
        if(cg1.compare(cg2)>0 && cg1.compare(cg3)>0) {
            System.out.print("第一组");
            cg1.showResult();
        }
        if(cg2.compare(cg1)>0 && cg2.compare(cg3)>0) {
            System.out.print("第二组");
            cg2.showResult();
        }
        if(cg3.compare(cg2)>0 && cg3.compare(cg1)>0) {
            System.out.print("第三组");
            cg3.showResult();
        }

        // TODO 3.4
        // print out the biggest CardGr
    }
    public class Card {
        private int number;
        private String suit; // Heart, Spade, Diamond, Club

        public Card(int n, String s) {
            this.number = n;
            this.suit = s;
        }

        public int getNumber() {
            return number;
        }
        public void setNumber(int number) {
            this.number = number;
        }
        public String getSuit() {
            return suit;
        }
        public void setSuit(String suit) {
            this.suit = suit;
        }


    }

    public class CardGroup {
        private Card c1;
        private Card c2;
        private Card c3;

        public CardGroup(Card c1, Card c2, Card c3) {
            this.c1 = c1;
            this.c2 = c2;
            this.c3 = c3;
        }

        /*
         * Return the number of cards with the same number
         */
        public int numOfSameNumber() {
            int count=1;
            if(this.c1.number==this.c2.number)
                count++;
            if(this.c1.number==this.c3.number)
                count++;
            if(this.c2.number==this.c3.number)
                count++;
            if(count==4)
                count--;

            return count; // to be replaced
        }

        /*
         * Return the sum of all 3 numbers.
         */
        public int sumOfNumbers() {
            return this.c1.number+this.c2.number+this.c3.number; // to be replaced
        }

        public int levelSuit(){
            int level=0;
            if(this.c3.suit.equals(this.c2.suit) && this.c3.suit.equals(this.c1.suit))
                level++;
            return level;
        }
        /*
         * Compare if it is bigger than CardGroup c
         * @param c another CardGroup
         * @return 1: bigger than c; 0: the same; -1: smaller than c.
         */
        public int compare(CardGroup c) {
            if(this.levelSuit()>c.levelSuit()){
                return 1;//the winner is 1.
            }
            else if(this.levelSuit()<c.levelSuit())
                return 0;
            else{
                if(this.numOfSameNumber()>c.numOfSameNumber())
                    return 1;
                else if(this.numOfSameNumber()<c.numOfSameNumber())
                    return 0;
                else{
                    return 2;//平局返回2
                }
            }
        }

        public void showResult(){
            System.out.println("cardGroup即："+this.c1.getNumber()+this.c1.suit+"\t"+this.c2.getNumber()+this.c2.suit+"\t"+this.c3.getNumber()+this.c3.suit);
        }

    }

}



