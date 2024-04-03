package domain;


public class Recipe {

@Id
@Generated(strategy = Generated.AUTO)
private long id; 
private String recipeName;
private int yield;
private double prepTime;
private String ingridents;


public Recipe(){

}

public Recipe(String recipeName, int yield, double prepTime, String ingridents){
    super();
    this.recipeName=recipeName;
    this.yield=yield;
    this.prepTime=prepTime;
    this.ingridents=ingridents;
    

}

public String getRecipeName() {
    return recipeName;
}

public void setRecipeName(String recipeName) {
    this.recipeName = recipeName;
}

public int getYield() {
    return yield;
}

public void setYield(int yield) {
    this.yield = yield;
}

public double getPrepTime() {
    return prepTime;
}

public void setPrepTime(double prepTime) {
    this.prepTime = prepTime;
}

public String getIngridents() {
    return ingridents;
}

public void setIngridents(String ingridents) {
    this.ingridents = ingridents;
}


}
