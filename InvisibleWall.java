import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase solo sirve para activar o desactivar la invisibilidad de los tipos de muros
 * 
 * @author Miguel Angel Enriquez Cisneros y Joaquin Manuel Trujillo Viveros
 * @version 1
 */
public class InvisibleWall extends Actor
{
    private boolean turnBlocksInvisible = true;
    
    /**
     * Act - do whatever the InvisibleWallLeft wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    /**
     * Vuelve invisibles a los muros
     */
    public void turnInvisible()
    {
        getImage().setTransparency(0);
    }
    
    public boolean getTurnBlocksInvisible()
    {
        return turnBlocksInvisible;
    }
}
