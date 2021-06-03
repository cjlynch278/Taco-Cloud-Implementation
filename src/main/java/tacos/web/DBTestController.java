package tacos.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tacos.Ingredient;
import tacos.Ingredient.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import tacos.data.IngredientRepository;

@Slf4j
@Controller
@RequestMapping("/admin")
public class DBTestController{
    private final IngredientRepository ingredientRepo;

    @Autowired
    public DBTestController(IngredientRepository ingredientRepo){
        this.ingredientRepo = ingredientRepo;
    }

    @GetMapping
    public String showAdminScreen(Model model){
        log.info("Starting");
        List<Ingredient> ingredients = new ArrayList<>();

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType((ArrayList)ingredientRepo.findAll(), type));
        }
        Map<String,Object> updatedModelMap = model.asMap();
        log.info("Keys: " + updatedModelMap.keySet().toString());
        for(String key: updatedModelMap.keySet()){
            log.info(updatedModelMap.get(key).toString());
        }
        return "AdminScreen";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @PostMapping("/submitNewIngredient")
    public String submitNewIngredient(){
        log.info("I don't do anything yet");
        return "/AdminScreen";

    }

}