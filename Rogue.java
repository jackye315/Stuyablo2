public class Rogue extends Adventurer{
    public int endurance;
    public Rogue( int startendurance){
    super("Traiter",40,10,10,10);
	endurance=startendurance;
    }
     public Rogue(){
	 super("Traiter",40,10,10,10);
	 setEndurance(25);
    }
    public Rogue(String s){
	super(s,40,10,10,10);
	setEndurance(25);
    }
    public void setEndurance(int e){
	endurance=e;
    }
    public int getEndurance(){
	return endurance;
    }
     public void setResources(int e){
	 endurance=e;
     }
    public int getResources(){
	return endurance;
    }
    public void useEndurance(int Enduranceused){
	endurance=endurance-Enduranceused;
    }

    public void attack(Adventurer other){
	int r=(rand.nextInt(5)+1);
	if (hit(other)==true){
	    System.out.println(this.getName()+" very quickly attacks "+other.getName()+ "and does "+ r +" damage");
	    other.damage(r);
	}
	else {
	     System.out.println(this.getName()+" very slowly attacks "+other.getName()+" and misses");
	
	}
    }
    
  public void specialAttack(Adventurer other){
	int r=(rand.nextInt(10)+9);
	if (hit(other)==true){
	    System.out.println(this.getName()+" gets behind "+other.getName()+ " and deals a big blow of "+ r +" damage");
	    other.damage(r);
	    this.useEndurance(3);
	}
	else {
	     System.out.println(this.getName()+" very slowly attacks "+other.getName()+" and misses");
	
	}
    }
    public String getStats(){
	return super.getStats()+ " Endurance: " + endurance;
    }
}
