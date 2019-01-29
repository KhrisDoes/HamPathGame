package sample;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;


public class SceneManager {


    private static int currentIndex = 0;
    private static List<Pane> scenes = new ArrayList<>();

    public static void addScreen(Pane pane){
        scenes.add(pane);
    }

    public static Pane getNextScene(){
        currentIndex += 1;
        return scenes.get(currentIndex - 1);
    }





}
