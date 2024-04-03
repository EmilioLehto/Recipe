package domain;
import java.util.List;



public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    List<Recipe> findByTitle(String recipeName);

}