package graphics;

import util.ImageUtils;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SpriteLibrary {
    private Map<String, AnimationSet> units;
    private final static String PATH_TO_UNITS = "/character/Neg";

    public SpriteLibrary() {
        this.units = new HashMap<>();
        loadSprites();
    }

    private void loadSprites() {

        String[] folderNames = getFolderName(PATH_TO_UNITS);

        for (String folderName : folderNames) {
            AnimationSet spritesSet = new AnimationSet();
            String pathToFolder = PATH_TO_UNITS + "/" + folderName;
            String[] sheetsInFolder = getSheetsInFolder(pathToFolder);

            for (String sheetName : sheetsInFolder) {
                spritesSet.addSheet(sheetName.substring(0,sheetName.length()-4),
                        ImageUtils.loadImage(pathToFolder + "/" + sheetName));
            }
            units.put(folderName,spritesSet);
        }
    }
    private String[] getSheetsInFolder(String basePath) {
        URL resource = AnimationSet.class.getResource(basePath);
        File file = new File(resource.getFile());
        return file.list((current,name) -> new File(current,name).isFile());
    }

    private String[] getFolderName(String basePath) {
        URL resource = AnimationSet.class.getResource(basePath);
        File file = new File(resource.getFile());
        return file.list((current,name) -> new File(current,name).isDirectory());
    }

    public AnimationSet getUnit(String name) {
        return units.get(name);
    }
}
