package graphics;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class AnimationSet {
    private Map<String, Image> animationSheets;


    public AnimationSet() {
        this.animationSheets = new HashMap<>();

    }
    public void addSheet(String name, Image animationSheet){
        animationSheets.put(name,animationSheet);
    }
    public Image getSheet(String name){
        return animationSheets.get(name);
    }
}
