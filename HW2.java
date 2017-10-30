import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/*
 * ID: B0544147
 * Name: ³s¥Ð¥Ð
 * Try to write some comments for your codes (methods, 15 points)
 */
public class HW2 {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("input N (deck of cards):");
	String testn= sc.nextLine(); 
 
	int nDeck=Integer.parseInt(testn);
	Deck deck=new Deck(nDeck);
	//TODO: please check your output, make sure that you print all cards on your screen (10 points)
	deck.printDeck();
	
	if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
	System.out.println("Well done!");
	}else{
	System.out.println("Error, please check your sourse code");
	}
	}
	/*
	* This method is used for checking your result, not a part of your HW2
	*/
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
	//check the output 
	boolean isCorrect=true;;
	HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
	for(Card card:allCards){
	int suit= card.getSuit();
	int rank = card.getRank();
	if(suit>4||suit<1||rank>13||rank<1){
	isCorrect=false;
	break;
	}
	if(checkHash.containsKey(suit+","+rank)){
	checkHash.put(suit+","+rank, 
	checkHash.get(suit+","+rank)+1);
	}else{
	checkHash.put(suit+","+rank, 1);
	}

	}
	if(checkHash.keySet().size()==52){
	for(int value:checkHash.values()){
	if(value!=nDeck){
	isCorrect=false;
	break;
	}
	}
	}else{
	isCorrect=false;
	}
	return isCorrect;
	}

}
/*
 * Description: "Deck" creates a pair of cards(a pair includes 52 cards)
 * ArrayList<Card> cards to store all cards
 * Deck will create all cards orderly and store into "cards"(start from Clubs ace, after storing every card of a suit then it will start to store next suit)
 * printDeck() prints all cards which have been required
 */
class Deck{
	private ArrayList<Card> cards;
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){
	cards=new ArrayList<Card>();
	//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
	//Hint: Use new Card(x,y) and 3 for loops to add card into deck
	//Sample code start
	//Card card=new Card(1,1); ->means new card as clubs ace
	//cards.add(card);
	//Sample code end
	for(int deck=1;deck<=nDeck;deck++)
	{
	for(int suit=1;suit<=4;suit++)
	{
	for(int Rank=1;Rank<=13;Rank++)
	{
	Card card=new Card(suit,Rank);
	cards.add(card);
	}
	}
	}
	
	}	//
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
	//Hint: print all items in ArrayList<Card> cards, 
	//TODO: please implement and reuse printCard method in Card class (5 points)
	int n=0;//to get cards.get()
	while(cards.size()>n)//in this loop, n add 1 after every execution
	{ 
	Card card=new Card(cards.get(n).getSuit(),cards.get(n).getRank());
	//instance Card, cards.get().getSuit() for suit and cards.get(n).getRank() for numbers
	card.printCard();//run printCard() in Card class to print this card
	n++;
	}
	
	
	}
	public ArrayList<Card> getAllCards(){
	return cards;
	}
}
/*
 * Description:Card create cards including suit and rank
 * cards include 4 suit and 13 numbers, 52 combinations total
 * getSuit()to get suit
 * getRank()to get number(rank)
 * printCard() transform getSuit() and getRank() into suit and number and print the card
 */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	public Card(int s,int r){
	suit=s;
	rank=r;
	}
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(){
	//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
	String []R={"Ace","2","3","4","5","6","7","8","9","10","J","Q","K"};
	if((getSuit()==1))//getSuit()=1,the suit is Club
	{
	System.out.println("Clubs,"+R[(getRank()-1)]);//-1 to get the rank of card correctly
	}
	else if(getSuit()==2)//getSuit()=2,the suit is Diamond
	{
	System.out.println("Diamonds,"+R[(getRank()-1)]); 
	}
	else if(getSuit()==3)//getSuit()=3,,the suit is Heart
	{
	System.out.println("Hearts,"+R[(getRank()-1)]); 
	}
	else//getSuit()=4,the suit is Spade
	{
	System.out.println("Spades,"+R[(getRank()-1)]); 
	}
	}
	public int getSuit(){
	return suit;
	}
	public int getRank(){
	return rank;
	}
}