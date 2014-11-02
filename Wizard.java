public class Wizard extends Adventurer{
    public int mana;
    public Wizard(){
	super("Tim",40,10,10,10);
	setMana(25);
    }

    public Wizard(String s){
	super(s,40,10,10,10);
	setMana(25);
    }


    public Wizard(String s, int startHP, int mana){
	super(s,startHP,10,10,10);
	setMana(mana);
    }


    public void setMana(int m){
	mana = m;
    }
    public int getMana(){
	return mana;
    }
    public void setResources(int m){
	 mana=m;
    }
    public int getResources(){
	return mana;
    }
    public void useMana(int  manaused){
	mana=mana-manaused;
    }
    public void attack(Adventurer other){
	int r=(rand.nextInt(4)+1);
	if (hit(other)==true){
	    System.out.println(this.getName()+ " pokes " +other.getName()+" and it only did " + r +" damage");
	    other.damage(r);
	}
	else{
	    System.out.println(this.getName()+" tries to attack " +other.getName());
	}
    }
    public void specialAttack(Adventurer other){
	int r=(rand.nextInt(10)+10);
	if (hit(other)==true){
	    System.out.println(this.getName()+ " shocks  " +other.getName()+" with lightning and it was super effective, dealing " + r +" damage");
	    other.damage(r);
	    this.useMana(5);
	}
	else{
	    System.out.println(this.getName()+" tried to attack" +other.getName()+" but missed");
	}
    }			       
    public String getStats(){
	return super.getStats()+ " Mana: "+ mana;
    }
}
