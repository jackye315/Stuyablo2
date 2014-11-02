import java.util.Random;   
public abstract  class Adventurer{
    String name;
    int HP;
    int STR;
    int DEX;
    int INT;
    int Resource=10;
    
Random rand = new Random();
    
    public Adventurer(String n,int startHP, int startSTR, int startDEX, int startINT ){
	name = n;
	HP = startHP;
	STR=startSTR;
	DEX=startDEX;
	INT=startINT;

    }
    public Adventurer(String n){
	this(n,40,10,15,10);
    }
 
    public Adventurer(){
	this("Lester",40, 10, 15, 10);
    }


    

    public String toString(){
	return getName();
    }
    public void setName(String name){
	this.name=name;
    }
    public String getName(){
	return name;
    }
    public void setHP(int HP){
	this.HP=HP;
	    }
    public int getHP(){
	return HP;
    }

    public void setSTR(int STR){
	this.STR=STR;
    }
    public int getSTR(){
	return STR;
    }
    public void setDEX(int DEX){
	this.DEX=DEX;
    }
    public int getDEX(){
	return DEX;
    }
  
    public void setINT(int INT){
	this.INT=INT;
    }
    public int getINT(){
	return INT;
    }
    public String getStats(){
	return this.getName()+"'s stats are "+ "HP: "+HP+" INT: "+INT+" STR: "+STR+" DEX: "+DEX;
    }
public void setResources(int r){
	 Resource=r;
    }
    public int getResources(){
	return Resource;
    }
    public void damage(int d){
	HP=HP-d;
    }

    public boolean hit(Adventurer other){
	if (rand.nextInt(20)>2){
	    return true;
	}
	else{
	    return false;
	}
    }
int r=(rand.nextInt(5)+1);
    abstract void attack(Adventurer other);
    abstract void specialAttack(Adventurer other);

}


