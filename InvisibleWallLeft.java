import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InvisibleWallLeft here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InvisibleWallLeft extends InvisibleWall
{
    /**
     * Act - do whatever the InvisibleWallLeft wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public InvisibleWallLeft(int ancho, int alto)
    {
        getImage().scale(ancho, alto);
        if(turnBlocksInvisible)
            turnInvisible();
    }

    public void act()
    {
        // Add your action code here.
    }
}
