import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase representa una instancia de InvisibleWallLeft, el cual empuja a la izquierda al jugador al chocar
 * 
 * @author Miguel Angel Enriquez Cisneros y Joaquin Manuel Trujillo Viveros
 * @version 1
 */
public class InvisibleWallLeft extends InvisibleWall
{
    public InvisibleWallLeft(int ancho, int alto)
    {
        getImage().scale(ancho, alto);
        if(getTurnBlocksInvisible())
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
