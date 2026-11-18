package assignment1;

public class item {
  private String name ; 
  private int value; 
  private boolean isMagical;
  
  public item() {
	  this.name="unknown";
	  this.value=0;
	  this.isMagical=false;
  }
  public item(String name, int value, boolean isMagical ) {
	  this.name=name;
	  setValue(value);
	  this.isMagical=isMagical;
	  
  }
  public String getName() {
	  return name;
  }
  public int getValue(){
	  return value;
  }
  
  public void setValue(int value) {
	  if(value<0) {
		  this.value=0;
	  }else {
		  this.value=value;
	  }
  }
  
}
