package dao;

import entities.Ingredient;

public class IngredientDao extends AbstractDao<Ingredient>{

    public IngredientDao() {
        super(Ingredient.class);
    }
}