import java.util.Scanner;
import java.util.Random;  
public class Game{
static String ans;
static String name;
static	int S;
static	int I;
static	int D;
static String Response="";
    static String playAgain="";
    static int HPall;
    //static int choice;

    //static Adventurer [] team;
static Scanner in = new Scanner(System.in);   
static Scanner out = new Scanner(System.in); 
static Random rand = new Random();
    static Adventurer player, player2,player3,player4, opponent;






    //////////////////////////////////////////////////////////////////////////////////////////////////////////////


public static void turn(Adventurer me, Adventurer other){
if (rand.nextInt(10)<3){
int r=(rand.nextInt(2)+1);
try {
    Thread.sleep(1000);
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
if (r==1){
	System.out.println("Randomly, your opponnent went first...\nWaiting for your other to make his move...");
	other.attack(me);
	System.out.println("\n");
}
else if (r==2 && other.getResources()>0){
	System.out.println("Randomly, your opponent went first...\nWaiting for your other to make his move...");
	other.specialAttack(me);
	System.out.println("\n");
    }
    else{
	System.out.println("Waiting for your opponent to make his move...");
	other.attack(me);
	System.out.println("\n");
    }
try {
    Thread.sleep(1000);
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
System.out.println("What would you like to do?\nAttack\nSpecial Attack\nGive up\n");
Response=in.nextLine();
if (Response.equals("Give up")){
    System.out.println("You lose");
	 System.exit(0);
    }
if (Response.equals("Attack")){
    me.attack(other);
    System.out.println("\n");
}
else if (Response.equals("Special Attack")&& me.getResources()>0){
    me.specialAttack(other);
     System.out.println("\n");
}
else{
    System.out.println("sorry, you can't use your speical attack at the moment. You used your attack instead");
    me.attack(other);
    System.out.println("\n");
}
}

else if (rand.nextInt(10)>3){
System.out.println("What would you like to do?\nAttack\nSpecial Attack\nGive up\n");
Response=in.nextLine();
if (Response.equals("Give up")){
    System.out.println("You lose");
	 System.exit(0);
    }

if (Response.equals("Attack")){
    me.attack(other);
    System.out.println("\n");
}
else if (Response.equals("Special Attack")&& me.getResources()>0){
    me.specialAttack(other);
     System.out.println("\n");
}
else{
    System.out.println("sorry, you can't use your speical attack at the moment. You used your attack instead");
    me.attack(other);
    System.out.println("\n");
}

int r=(rand.nextInt(2)+1);
if (r==1){
	System.out.println("Waiting for your opponent to make his move...");
	other.attack(me);
	System.out.println("\n");
}
else if (r==2 && other.getResources()>0){
	System.out.println("Waiting for your opponent to make his move...");
	other.specialAttack(me);
	System.out.println("\n");
    }
    else{
	System.out.println("Waiting for your opponent to make his move...");
	other.attack(me);
	System.out.println("\n");
    }
}

    }




    public static int HPall(Adventurer[]roster){
	int x=0;
	int y=0;
	while (x<roster.length){
	    if (roster[x].getHP()>1){
		y=y+roster[x].getHP();
	    }
	    x=x+1;
	}
	return y;
    }
    public static String teamStats(Adventurer[] roster){
	int x=0;
	String ans="";
	while (x<roster.length){
	    ans=ans+ roster[x].getStats()+"\n";
	    x=x+1;
        }
	return ans;
    }

	    
    public static boolean endGame(Adventurer []roster, Adventurer other){
    	if (HPall(roster)<1 || other.getHP()<1){
    	    return true;
    	}
    	else {
    	    return false;
    	}
    }

public static void Combat(Adventurer [] roster, Adventurer other){
    int x=0;
while (x<roster.length){
    if (roster[x].getHP()>1){
      	System.out.println(teamStats(roster));
	System.out.println(other.getStats()+"\n");
	turn(roster[x],other);
	//System.out.println(teamStats(roster));
	//System.out.println(other.getStats()+"\n");
    }

    x=x+1;
}
}

    public static void fullCombat(Adventurer [] roster,Adventurer enemy){
        while (endGame(roster,enemy)==false){
try {
    Thread.sleep(1000);
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
	    Combat (roster,enemy);
    }
	if (HPall<enemy.getHP()){
     System.out.println("The match is over, you lose");
     System.out.println(teamStats(roster));
     System.out.println(enemy.getStats());
     System.exit(0);
}
else {
     System.out.println("The match is over, you won!!!");
     System.out.println(teamStats(roster));
     System.out.println(enemy.getStats());

}
    }

    public static void restore(Adventurer []roster){
	int x=0;
	while (x<roster.length){
	    roster[x].setHP(40);
	    roster[x].setResources(25);
	    x=x+1;
	}
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////Front End



public static void main(String[]args){


	String ans;
	String Response="";
	int choice;
	int S;
	int I;
	int D;
	Adventurer [] team;


Random rand = new Random();

Adventurer player, player2,player3,player4, opponent;

/*player=new Adventurer();
 player2=new Adventurer ();
 player3=new Adventurer ();
 player4=new Adventurer ();
*/
Scanner in = new Scanner(System.in);   
Scanner other = new Scanner(System.in); 
team=new Adventurer[1];
System.out.println("How many players would you like to be? 1,2,3, or 4. For default players, press 5");
   choice=out.nextInt();
   if (choice==1){
	  
	    team=new Adventurer[1];
	    System.out.println("Choose a class: Warrior, Wizard, or Rogue");
ans = in.nextLine();
if (ans.equals("Warrior")){
    System.out.println("Choose your name");
    name=in.nextLine();
    player=new Warrior(name);
    System.out.println("You have choosen the warrior class! You have great physical strength");
}
else if (ans.equals("Wizard")){
     System.out.println("Choose your name");
    name=in.nextLine();
   player=new Wizard(name);
    System.out.println("You have choosen the Wizard class! You have great magical powers");
}
else if (ans.equals("Rogue")){
     System.out.println("Choose your name");
    name=in.nextLine();
   player=new Rogue(name);
    System.out.println("You have choosen the Rogue class! You are very fast");
}
else {
    System.out.println("Sorry, but you didn't choose a appropriate class, or you typed your class incorrectly. Please try again!");
    System.out.println("Choose a class: Warrior, Wizard, or Rogue");
    ans = in.nextLine();
    if (ans.equals("Warrior")){
	 System.out.println("Choose your name");
    name=in.nextLine();
     player=new Warrior(name);
    System.out.println("You have choosen the warrior class! You have great physical strength\n");
}
else if (ans.equals("Wizard")){
     System.out.println("Choose your name");
    name=in.nextLine();
    player=new Wizard(name);
    System.out.println("You have choosen the Wizard class! You have great magical powers\n");
}
else if (ans.equals("Rogue")){
     System.out.println("Choose your name");
    name=in.nextLine();
    player=new Rogue(name);
    System.out.println("You have choosen the Rogue class! You are very fast\n");
}
else{
    player=new Warrior();
	}
}

System.out.println("Please enter how much STR you want (max 30)");
S=out.nextInt();
player.setSTR(S);
S=30-S;
System.out.println("Please enter how much INT you want (max"+S+")");
I=out.nextInt();
player.setINT(I);
I=S-I;
System.out.println("Please enter how much DEX you want (max"+I+")");
D=out.nextInt();
player.setDEX(D);
System.out.println(player.getStats());
	    System.out.println(player.getStats());
	    team[0]=player;
	   
	}
     if (choice==2){
	    team=new Adventurer[2];

System.out.println("Choose a class: Warrior, Wizard, or Rogue");
ans = in.nextLine();
if (ans.equals("Warrior")){
    System.out.println("Choose your name");
    name=in.nextLine();
    player=new Warrior(name);
    System.out.println("You have choosen the warrior class! You have great physical strength");
}
else if (ans.equals("Wizard")){
     System.out.println("Choose your name");
    name=in.nextLine();
   player=new Wizard(name);
    System.out.println("You have choosen the Wizard class! You have great magical powers");
}
else if (ans.equals("Rogue")){
     System.out.println("Choose your name");
    name=in.nextLine();
   player=new Rogue(name);
    System.out.println("You have choosen the Rogue class! You are very fast");
}
else {
    System.out.println("Sorry, but you didn't choose a appropriate class, or you typed your class incorrectly. Please try again!");
    System.out.println("Choose a class: Warrior, Wizard, or Rogue");
    ans = in.nextLine();
    if (ans.equals("Warrior")){
	 System.out.println("Choose your name");
    name=in.nextLine();
     player=new Warrior(name);
    System.out.println("You have choosen the warrior class! You have great physical strength\n");
}
else if (ans.equals("Wizard")){
     System.out.println("Choose your name");
    name=in.nextLine();
    player=new Wizard(name);
    System.out.println("You have choosen the Wizard class! You have great magical powers\n");
}
else if (ans.equals("Rogue")){
     System.out.println("Choose your name");
    name=in.nextLine();
    player=new Rogue(name);
    System.out.println("You have choosen the Rogue class! You are very fast\n");
}
else{
    player=new Warrior();
	}
}

System.out.println("Please enter how much STR you want (max 30)");
S=out.nextInt();
player.setSTR(S);
S=30-S;
System.out.println("Please enter how much INT you want (max"+S+")");
I=out.nextInt();
player.setINT(I);
I=S-I;
System.out.println("Please enter how much DEX you want (max"+I+")");
D=out.nextInt();
player.setDEX(D);
System.out.println(player.getStats());
     
    






System.out.println("Choose a class: Warrior, Wizard, or Rogue");
ans = in.nextLine();
if (ans.equals("Warrior")){
    System.out.println("Choose your name");
    name=in.nextLine();
    player2=new Warrior(name);
    System.out.println("You have choosen the warrior class! You have great physical strength");
}
else if (ans.equals("Wizard")){
     System.out.println("Choose your name");
    name=in.nextLine();
   player2=new Wizard(name);
    System.out.println("You have choosen the Wizard class! You have great magical powers");
}
else if (ans.equals("Rogue")){
     System.out.println("Choose your name");
    name=in.nextLine();
   player2=new Rogue(name);
    System.out.println("You have choosen the Rogue class! You are very fast");
}
else {
    System.out.println("Sorry, but you didn't choose a appropriate class, or you typed your class incorrectly. Please try again!");
    System.out.println("Choose a class: Warrior, Wizard, or Rogue");
    ans = in.nextLine();
    if (ans.equals("Warrior")){
	 System.out.println("Choose your name");
    name=in.nextLine();
     player2=new Warrior(name);
    System.out.println("You have choosen the warrior class! You have great physical strength\n");
}
else if (ans.equals("Wizard")){
     System.out.println("Choose your name");
    name=in.nextLine();
    player2=new Wizard(name);
    System.out.println("You have choosen the Wizard class! You have great magical powers\n");
}
else if (ans.equals("Rogue")){
     System.out.println("Choose your name");
    name=in.nextLine();
    player2=new Rogue(name);
    System.out.println("You have choosen the Rogue class! You are very fast\n");
}
else{
    player2=new Warrior();
	}
}

System.out.println("Please enter how much STR you want (max 30)");
S=out.nextInt();
player2.setSTR(S);
S=30-S;
System.out.println("Please enter how much INT you want (max"+S+")");
I=out.nextInt();
player2.setINT(I);
I=S-I;
System.out.println("Please enter how much DEX you want (max"+I+")");
D=out.nextInt();
player2.setDEX(D);
System.out.println(player2.getStats());
     


	    team[0]=player;
	    team[1]=player2;
	}
    if (choice==3){
	    team=new Adventurer[3];

System.out.println("Choose a class: Warrior, Wizard, or Rogue");
ans = in.nextLine();
if (ans.equals("Warrior")){
    System.out.println("Choose your name");
    name=in.nextLine();
    player=new Warrior(name);
    System.out.println("You have choosen the warrior class! You have great physical strength");
}
else if (ans.equals("Wizard")){
     System.out.println("Choose your name");
    name=in.nextLine();
   player=new Wizard(name);
    System.out.println("You have choosen the Wizard class! You have great magical powers");
}
else if (ans.equals("Rogue")){
     System.out.println("Choose your name");
    name=in.nextLine();
   player=new Rogue(name);
    System.out.println("You have choosen the Rogue class! You are very fast");
}
else {
    System.out.println("Sorry, but you didn't choose a appropriate class, or you typed your class incorrectly. Please try again!");
    System.out.println("Choose a class: Warrior, Wizard, or Rogue");
    ans = in.nextLine();
    if (ans.equals("Warrior")){
	 System.out.println("Choose your name");
    name=in.nextLine();
     player=new Warrior(name);
    System.out.println("You have choosen the warrior class! You have great physical strength\n");
}
else if (ans.equals("Wizard")){
     System.out.println("Choose your name");
    name=in.nextLine();
    player=new Wizard(name);
    System.out.println("You have choosen the Wizard class! You have great magical powers\n");
}
else if (ans.equals("Rogue")){
     System.out.println("Choose your name");
    name=in.nextLine();
    player=new Rogue(name);
    System.out.println("You have choosen the Rogue class! You are very fast\n");
}
else{
    player=new Warrior();
	}
}

System.out.println("Please enter how much STR you want (max 30)");
S=out.nextInt();
player.setSTR(S);
S=30-S;
System.out.println("Please enter how much INT you want (max"+S+")");
I=out.nextInt();
player.setINT(I);
I=S-I;
System.out.println("Please enter how much DEX you want (max"+I+")");
D=out.nextInt();
player.setDEX(D);
System.out.println(player.getStats());
   
    






System.out.println("Choose a class: Warrior, Wizard, or Rogue");
ans = in.nextLine();
if (ans.equals("Warrior")){
    System.out.println("Choose your name");
    name=in.nextLine();
    player2=new Warrior(name);
    System.out.println("You have choosen the warrior class! You have great physical strength");
}
else if (ans.equals("Wizard")){
     System.out.println("Choose your name");
    name=in.nextLine();
   player2=new Wizard(name);
    System.out.println("You have choosen the Wizard class! You have great magical powers");
}
else if (ans.equals("Rogue")){
     System.out.println("Choose your name");
    name=in.nextLine();
   player2=new Rogue(name);
    System.out.println("You have choosen the Rogue class! You are very fast");
}
else {
    System.out.println("Sorry, but you didn't choose a appropriate class, or you typed your class incorrectly. Please try again!");
    System.out.println("Choose a class: Warrior, Wizard, or Rogue");
    ans = in.nextLine();
    if (ans.equals("Warrior")){
	 System.out.println("Choose your name");
    name=in.nextLine();
     player2=new Warrior(name);
    System.out.println("You have choosen the warrior class! You have great physical strength\n");
}
else if (ans.equals("Wizard")){
     System.out.println("Choose your name");
    name=in.nextLine();
    player2=new Wizard(name);
    System.out.println("You have choosen the Wizard class! You have great magical powers\n");
}
else if (ans.equals("Rogue")){
     System.out.println("Choose your name");
    name=in.nextLine();
    player2=new Rogue(name);
    System.out.println("You have choosen the Rogue class! You are very fast\n");
}
else{
    player2=new Warrior();
	}
}

System.out.println("Please enter how much STR you want (max 30)");
S=out.nextInt();
player2.setSTR(S);
S=30-S;
System.out.println("Please enter how much INT you want (max"+S+")");
I=out.nextInt();
player2.setINT(I);
I=S-I;
System.out.println("Please enter how much DEX you want (max"+I+")");
D=out.nextInt();
player2.setDEX(D);
System.out.println(player2.getStats());
   












System.out.println("Choose a class: Warrior, Wizard, or Rogue");
ans = in.nextLine();
if (ans.equals("Warrior")){
    System.out.println("Choose your name");
    name=in.nextLine();
    player3=new Warrior(name);
    System.out.println("You have choosen the warrior class! You have great physical strength");
}
else if (ans.equals("Wizard")){
     System.out.println("Choose your name");
    name=in.nextLine();
   player3=new Wizard(name);
    System.out.println("You have choosen the Wizard class! You have great magical powers");
}
else if (ans.equals("Rogue")){
     System.out.println("Choose your name");
    name=in.nextLine();
   player3=new Rogue(name);
    System.out.println("You have choosen the Rogue class! You are very fast");
}
else {
    System.out.println("Sorry, but you didn't choose a appropriate class, or you typed your class incorrectly. Please try again!");
    System.out.println("Choose a class: Warrior, Wizard, or Rogue");
    ans = in.nextLine();
    if (ans.equals("Warrior")){
	 System.out.println("Choose your name");
    name=in.nextLine();
     player3=new Warrior(name);
    System.out.println("You have choosen the warrior class! You have great physical strength\n");
}
else if (ans.equals("Wizard")){
     System.out.println("Choose your name");
    name=in.nextLine();
    player3=new Wizard(name);
    System.out.println("You have choosen the Wizard class! You have great magical powers\n");
}
else if (ans.equals("Rogue")){
     System.out.println("Choose your name");
    name=in.nextLine();
    player3=new Rogue(name);
    System.out.println("You have choosen the Rogue class! You are very fast\n");
}
else{
    player3=new Warrior();
	}
}

System.out.println("Please enter how much STR you want (max 30)");
S=out.nextInt();
player3.setSTR(S);
S=30-S;
System.out.println("Please enter how much INT you want (max"+S+")");
I=out.nextInt();
player3.setINT(I);
I=S-I;
System.out.println("Please enter how much DEX you want (max"+I+")");
D=out.nextInt();
player3.setDEX(D);
System.out.println(player3.getStats());
   
	    team[0]=player;
	    team[1]=player2;
	    team[2]=player3;

	    
	}
    if (choice==4){
	    team=new Adventurer[4];

System.out.println("Choose a class: Warrior, Wizard, or Rogue");
ans = in.nextLine();
if (ans.equals("Warrior")){
    System.out.println("Choose your name");
    name=in.nextLine();
    player=new Warrior(name);
    System.out.println("You have choosen the warrior class! You have great physical strength");
}
else if (ans.equals("Wizard")){
     System.out.println("Choose your name");
    name=in.nextLine();
   player=new Wizard(name);
    System.out.println("You have choosen the Wizard class! You have great magical powers");
}
else if (ans.equals("Rogue")){
     System.out.println("Choose your name");
    name=in.nextLine();
   player=new Rogue(name);
    System.out.println("You have choosen the Rogue class! You are very fast");
}
else {
    System.out.println("Sorry, but you didn't choose a appropriate class, or you typed your class incorrectly. Please try again!");
    System.out.println("Choose a class: Warrior, Wizard, or Rogue");
    ans = in.nextLine();
    if (ans.equals("Warrior")){
	 System.out.println("Choose your name");
    name=in.nextLine();
     player=new Warrior(name);
    System.out.println("You have choosen the warrior class! You have great physical strength\n");
}
else if (ans.equals("Wizard")){
     System.out.println("Choose your name");
    name=in.nextLine();
    player=new Wizard(name);
    System.out.println("You have choosen the Wizard class! You have great magical powers\n");
}
else if (ans.equals("Rogue")){
     System.out.println("Choose your name");
    name=in.nextLine();
    player=new Rogue(name);
    System.out.println("You have choosen the Rogue class! You are very fast\n");
}
else{
    player=new Warrior();
	}
}

System.out.println("Please enter how much STR you want (max 30)");
S=out.nextInt();
player.setSTR(S);
S=30-S;
System.out.println("Please enter how much INT you want (max"+S+")");
I=out.nextInt();
player.setINT(I);
I=S-I;
System.out.println("Please enter how much DEX you want (max"+I+")");
D=out.nextInt();
player.setDEX(D);
System.out.println(player.getStats());
   
    






System.out.println("Choose a class: Warrior, Wizard, or Rogue");
ans = in.nextLine();
if (ans.equals("Warrior")){
    System.out.println("Choose your name");
    name=in.nextLine();
    player2=new Warrior(name);
    System.out.println("You have choosen the warrior class! You have great physical strength");
}
else if (ans.equals("Wizard")){
     System.out.println("Choose your name");
    name=in.nextLine();
   player2=new Wizard(name);
    System.out.println("You have choosen the Wizard class! You have great magical powers");
}
else if (ans.equals("Rogue")){
     System.out.println("Choose your name");
    name=in.nextLine();
   player2=new Rogue(name);
    System.out.println("You have choosen the Rogue class! You are very fast");
}
else {
    System.out.println("Sorry, but you didn't choose a appropriate class, or you typed your class incorrectly. Please try again!");
    System.out.println("Choose a class: Warrior, Wizard, or Rogue");
    ans = in.nextLine();
    if (ans.equals("Warrior")){
	 System.out.println("Choose your name");
    name=in.nextLine();
     player2=new Warrior(name);
    System.out.println("You have choosen the warrior class! You have great physical strength\n");
}
else if (ans.equals("Wizard")){
     System.out.println("Choose your name");
    name=in.nextLine();
    player2=new Wizard(name);
    System.out.println("You have choosen the Wizard class! You have great magical powers\n");
}
else if (ans.equals("Rogue")){
     System.out.println("Choose your name");
    name=in.nextLine();
    player2=new Rogue(name);
    System.out.println("You have choosen the Rogue class! You are very fast\n");
}
else{
    player2=new Warrior();
	}
}

System.out.println("Please enter how much STR you want (max 30)");
S=out.nextInt();
player2.setSTR(S);
S=30-S;
System.out.println("Please enter how much INT you want (max"+S+")");
I=out.nextInt();
player2.setINT(I);
I=S-I;
System.out.println("Please enter how much DEX you want (max"+I+")");
D=out.nextInt();
player2.setDEX(D);
System.out.println(player2.getStats());
   












System.out.println("Choose a class: Warrior, Wizard, or Rogue");
ans = in.nextLine();
if (ans.equals("Warrior")){
    System.out.println("Choose your name");
    name=in.nextLine();
    player3=new Warrior(name);
    System.out.println("You have choosen the warrior class! You have great physical strength");
}
else if (ans.equals("Wizard")){
     System.out.println("Choose your name");
    name=in.nextLine();
   player3=new Wizard(name);
    System.out.println("You have choosen the Wizard class! You have great magical powers");
}
else if (ans.equals("Rogue")){
     System.out.println("Choose your name");
    name=in.nextLine();
   player3=new Rogue(name);
    System.out.println("You have choosen the Rogue class! You are very fast");
}
else {
    System.out.println("Sorry, but you didn't choose a appropriate class, or you typed your class incorrectly. Please try again!");
    System.out.println("Choose a class: Warrior, Wizard, or Rogue");
    ans = in.nextLine();
    if (ans.equals("Warrior")){
	 System.out.println("Choose your name");
    name=in.nextLine();
     player3=new Warrior(name);
    System.out.println("You have choosen the warrior class! You have great physical strength\n");
}
else if (ans.equals("Wizard")){
     System.out.println("Choose your name");
    name=in.nextLine();
    player3=new Wizard(name);
    System.out.println("You have choosen the Wizard class! You have great magical powers\n");
}
else if (ans.equals("Rogue")){
     System.out.println("Choose your name");
    name=in.nextLine();
    player3=new Rogue(name);
    System.out.println("You have choosen the Rogue class! You are very fast\n");
}
else{
    player3=new Warrior();
	}
}

System.out.println("Please enter how much STR you want (max 30)");
S=out.nextInt();
player3.setSTR(S);
S=30-S;
System.out.println("Please enter how much INT you want (max"+S+")");
I=out.nextInt();
player3.setINT(I);
I=S-I;
System.out.println("Please enter how much DEX you want (max"+I+")");
D=out.nextInt();
player3.setDEX(D);
System.out.println(player3.getStats());
   







System.out.println("Choose a class: Warrior, Wizard, or Rogue");
ans = in.nextLine();
if (ans.equals("Warrior")){
    System.out.println("Choose your name");
    name=in.nextLine();
    player4=new Warrior(name);
    System.out.println("You have choosen the warrior class! You have great physical strength");
}
else if (ans.equals("Wizard")){
     System.out.println("Choose your name");
    name=in.nextLine();
   player4=new Wizard(name);
    System.out.println("You have choosen the Wizard class! You have great magical powers");
}
else if (ans.equals("Rogue")){
     System.out.println("Choose your name");
    name=in.nextLine();
   player4=new Rogue(name);
    System.out.println("You have choosen the Rogue class! You are very fast");
}
else {
    System.out.println("Sorry, but you didn't choose a appropriate class, or you typed your class incorrectly. Please try again!");
    System.out.println("Choose a class: Warrior, Wizard, or Rogue");
    ans = in.nextLine();
    if (ans.equals("Warrior")){
	 System.out.println("Choose your name");
    name=in.nextLine();
     player4=new Warrior(name);
    System.out.println("You have choosen the warrior class! You have great physical strength\n");
}
else if (ans.equals("Wizard")){
     System.out.println("Choose your name");
    name=in.nextLine();
    player4=new Wizard(name);
    System.out.println("You have choosen the Wizard class! You have great magical powers\n");
}
else if (ans.equals("Rogue")){
     System.out.println("Choose your name");
    name=in.nextLine();
    player4=new Rogue(name);
    System.out.println("You have choosen the Rogue class! You are very fast\n");
}
else{
    player4=new Warrior();
	}
}

System.out.println("Please enter how much STR you want (max 30)");
S=out.nextInt();
player4.setSTR(S);
S=30-S;
System.out.println("Please enter how much INT you want (max"+S+")");
I=out.nextInt();
player4.setINT(I);
I=S-I;
System.out.println("Please enter how much DEX you want (max"+I+")");
D=out.nextInt();
player4.setDEX(D);
System.out.println(player4.getStats());
   

	    team[0]=player;
	    team[1]=player2;
	    team[2]=player3;
	    team[3]=player4;
	    // System.out.println(team[1]);



	}
    else if(choice==5){
	    team=new Adventurer[3];
            player=new Warrior ("Bum");
            player2=new Wizard ("Lazy");
            player3=new Rogue ("LazBum");
	    team[0]=player;
	    team[1]=player2;
	    team[2]=player3;

   }
   


    System.out.println("Your team consists of "+choice+" player(s)!\n");
try {
    Thread.sleep(1000);
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}

int rchoice=(rand.nextInt(4));
if (rchoice==1){
     opponent=new Warrior("Jim");
     System.out.println("Your opponent  has choosen the warrior class! Your opponent has great physical strength\n");
}
else if (rchoice==2){
    opponent=new Wizard("Jim");
    System.out.println("Your opponent has choosen the Wizard class! Your opponent has great magical powers\n");
}
else {
    opponent=new Rogue("Jim");
     System.out.println("Your opponent has choosen the Rogue class! You opponent is very fast\n");
} 


fullCombat(team, opponent);
while (playAgain.equals("Yes")||playAgain.equals("")){
System.out.println("Would you like to play again? Type Yes to play again.");
     playAgain=in.nextLine();
     if (playAgain.equals("Yes")){
	 restore(team);
System.out.println("Your things will be restored");
int rchoice1=(rand.nextInt(4));
if (rchoice1==1){
     opponent=new Warrior("Jim");
     System.out.println("Your new opponent has choosen the warrior class! Your opponent has great physical strength\n");
}
else if (rchoice1==2){
    opponent=new Wizard("Jim");
    System.out.println("Your new opponent has choosen the Wizard class! Your opponent has great magical powers\n");
}
else {
    opponent=new Rogue("Jim");
     System.out.println("Your new opponent has choosen the Rogue class! You opponent is very fast\n");
} 
	     fullCombat(team,opponent);
			}
	 else{
	     System.out.println("See you next time.");
	 }
}

/////////////////////////////////////////////////////////////////////////////////////////////////////


}
}
