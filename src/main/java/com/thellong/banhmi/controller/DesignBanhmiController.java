package com.thellong.banhmi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thellong.banhmi.model.BanhMi;
import com.thellong.banhmi.model.Design;
import com.thellong.banhmi.model.Ingredient;
import com.thellong.banhmi.model.Ingredient.TYPE;
import com.thellong.banhmi.model.repos.IngredientRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignBanhmiController {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public DesignBanhmiController (IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }
    
    @GetMapping
    public String showDesignForm(Model model) {

        // Create a hard list of ingredients
        // List<Ingredient> ingredients = Arrays.asList(
        //     new Ingredient("TUONG", "Tuong ot", TYPE.SAUCE),
        //     new Ingredient("OT_TRAI", "Ot trai", TYPE.SAUCE),
        //     new Ingredient("P_HEO", "Pate Heo", TYPE.SAUCE),
        //     new Ingredient("TH_LUOC", "Thit heo luoc", TYPE.PORK),
        //     new Ingredient("TH_NUONG", "Thit heo nuong", TYPE.PORK),
        //     new Ingredient("TB_NUONG_T", "Thit bo nuong thuong", TYPE.BEEF),
        //     new Ingredient("TB_NUONG_DB", "Thit bo nuong dac biet", TYPE.BEEF),
        //     new Ingredient("OMELET", "Trung op la", TYPE.EGG),
        //     new Ingredient("OMELET_N", "Trung op la chin ki", TYPE.EGG),
        //     new Ingredient("RAU_T", "Co rau", TYPE.VEGES),
        //     new Ingredient("RAU_K", "Khong rau", TYPE.VEGES)
        // );
                                                                                         
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredients::add);

        TYPE[] types = Ingredient.TYPE.values();
        for (TYPE type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }

        model.addAttribute("design", new BanhMi());
        return "design";
    }

    // Add validate for the needed method
    @PostMapping
    public String processDesign(@Valid Design design, Errors errors) {
        if (errors.hasErrors()) {
            return "design";
        }

        log.info("Processing design: " + design);
        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, TYPE type) {
        return ingredients.stream().filter(item  -> item.getType().equals(type))
                            .collect(Collectors.toList());
    }
}
