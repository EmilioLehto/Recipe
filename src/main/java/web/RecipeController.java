package web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import domain.CategoryRepository;
import domain.Recipe;
import domain.RecipeRepository;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class RecipeController {

@Autowired
private RecipeRepository repository;

@Autowired
private CategoryRepository drepository;



//Gives a list of all the Recipes.
@RequestMapping({"/", "/Recipelist"})
public String bookStoreList(Model model) {
    model.addAttribute("book", repository.findAll());
   
    return "Recipelist";
}

//Can search by id the recipe
@RequestMapping(value="/recipes/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Recipe> findBookRest(@PathVariable("id") Long bookId) {	
    	return repository.findById(recipeId);
    } 


//Can add recipes to the database
@RequestMapping(value="/add")
 public String addBook(Model model) {
   model.addAttribute("Recipe", new Recipe());
   model.addAttribute("Categories", drepository.findAll());
    return "addRecipe";
    
    }


@RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(Recipe recipe) {
    repository.save(recipe);
    return "redirect::Recipelist";
    
    }


//to login 
@RequestMapping(value="/login")
    public String login() {	
      return "login";
        }	
    


//Can edit recipes that are within the database
@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editRecipe(@PathVariable("id") Long recipeId, Model model) {
    model.addAttribute("recipe", repository.findById(recipeId));
    model.addAttribute("categories", drepository.findAll());
    return "editRecipe";
}



//To delete ids in the database, only for admins
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping(value = "/delete/{id}", method=RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long recipeId, Model model ) {
        repository.deleteById(recipeId);
        return "redirect:../Recipelist";
    }


}
