package utils;

import entities.ItemEntity;

public class EntitiesFactory {

    public static ItemEntity getItem(String dataFile) throws Exception {
        return JSONReader.toObjectFromFile(ItemEntity.class, dataFile);
    }
}
