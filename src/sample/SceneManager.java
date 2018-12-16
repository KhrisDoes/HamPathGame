package sample;

import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.Map;

public class SceneManager {


    private static Map<String, Pane> screenMap = new HashMap<>();

    public static void addScreen(String name, Pane pane){
        screenMap.put(name, pane);
    }

    public static Pane getScreen(String name){
        return screenMap.get(name);
    }




}
