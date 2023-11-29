package manager;

import entity.GameObject;

public class CollisonChecker {


    public void checker(GameObject gameObject){
        int gameLeftX = gameObject.getX() + gameObject.getBoundsX();
        int gameRightX = gameObject.getX() + gameObject.getBoundsY();
        int gameTop = gameObject.getY() + gameObject.getBoundsHeight();


    }


}
