package domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Category {

private Long categoryId;
private String name;

@JsonIgnore
@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
private List<Recipe> recipe;

public Category(){}

public Category(String name){
    super();
    this.name=name;
}

public Long getCategoryId() {
    return categoryId;
}

public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public List<Recipe> getRecipe() {
    return recipe;
}

public void setRecipe(List<Recipe> rooks) {
    this.recipe = recipe;


@Override
	public String toString() {
		return "Category [categoryid=" + categoryId + ", name= " + name + "]";
	}


}
