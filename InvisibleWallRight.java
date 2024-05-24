import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InvisibleWallRight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InvisibleWallRight extends InvisibleWall
{
    /**
     * Act - do whatever the InvisibleWallRight wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public InvisibleWallRight(int ancho, int alto)
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
