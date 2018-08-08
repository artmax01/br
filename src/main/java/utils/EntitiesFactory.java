package utils;

import entities.ItemEntity;
import entities.UserEntity;

public class EntitiesFactory {

    public static ItemEntity getItem(String dataFile) throws Exception {
        return JSONReader.toObjectFromFile(ItemEntity.class, dataFile);
    }

    public static UserEntity getUser(String dataFile) throws Exception {
        return JSONReader.toObjectFromFile(UserEntity.class, dataFile);
    }
}
