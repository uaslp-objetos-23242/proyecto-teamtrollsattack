import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase representa una instancia de InvisibleWallRight, el cual empuja a la derecha al jugador al chocar
 * 
 * @author Miguel Angel Enriquez Cisneros y Joaquin Manuel Trujillo Viveros
 * @version 1
 */
public class InvisibleWallRight extends InvisibleWall
{
    public InvisibleWallRight(int ancho, int alto)
    {
        getImage().scale(ancho, alto);
        if(turnBlocksInvisible)
            turnInvisible();
    }

    /**
     * Act - do whatever the InvisibleWallLeft wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
