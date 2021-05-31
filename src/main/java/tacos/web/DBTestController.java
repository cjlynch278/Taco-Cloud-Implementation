package tacos.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tacos.Ingredient;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import tacos.data.IngredientRepository;

@Slf4j
@Controller
public class DBTestController{
    private final IngredientRepository ingredientRepo;

    @Autowired
    public DBTestController(IngredientRepository ingredientRepo){
        this.ingredientRepo = ingredientRepo;
    }
    @GetMapping("/testit")
    public String printDB(){
        log.info("Starting");
        List<Ingredient> ingredients = new ArrayList<>();

        log.info(ingredientRepo.findOne("SRCR").toString());
        return "/AdminScreen";
    }


    @PostMapping("/submitNewIngredient")
    public String submitNewIngredient(){
        log.info("I don't do anything yet");
        return "/AdminScreen";

    }

}