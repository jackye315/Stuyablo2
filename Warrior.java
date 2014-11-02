import java.util.Random;
public class Warrior extends Adventurer{
    private int bonusHealth;
    private int rage;
    public Warrior(){
	super("Ted",40,10,10,10);
	bonusHealth = 10;
    }
    public Warrior(String s){
	super(s);
	bonusHealth = 10;
	rage=10;
    }
    public Warrior(String s,int startHP, int rage){
	super(s,startHP,10,10,10);
	bonusHealth  = 10;
	rage=10;
    }

    //Override the getHP method so it includes the bonus health.
    public int getHP(){
	return super.getHP()+bonusHealth;
    }
    public void setRage(int r){
	rage=r;
    }
    public int getRage(){
	return rage;
    }
    public void setResources(int r){
	 rage=r;
    }
    public int getResources(){
	return rage;
    }
    public void useRage(int x){
	rage=rage-x;
	    }

    public void attack(Adventurer other){
        int r=(rand.nextInt(10)+8);
	if (hit(other)==true){
	    System.out.println( this.getName() + " attacks " + other.getName()+" and so "+ other.getName()+" lost " + r + " HP" );
		other.damage(r);
		
	    }
	    else{
		System.out.println(this.getName()+" missed his attack");
	    }
    }
    public void specialAttack(Adventurer other){
	int r=(rand.nextInt(10)+8);
	if (hit(other)==true){
	    System.out.println( this.getName() + " slashes " + other.getName()+" and so "+ other.getName()+" lost " + r + " HP" );
		other.damage(r);
		this.useRage(3);
	    }
	    else{
		System.out.println(this.getName()+" missed his attack");
	    }
    }
    public String getStats(){
	return super.getStats()+ " Rage: " + rage;
    }
}

