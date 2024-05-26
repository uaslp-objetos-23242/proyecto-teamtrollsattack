import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase es una pantalla de victoria, se activa al derrotar al jefe final
 * 
 * @author Miguel Angel Enriquez Cisneros y Joaquin Manuel Trujillo Viveros
 * @version 1
 */
public class YouWin extends World
{
    /**
     * Constructor for objects of class YouWin.
     * 
     */
    public YouWin()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        prepare();
    }
    
    public void prepare()
    {
        showText("Victoria, la humanidad ha ganado.", getWidth()/2, getHeight()/2 - 200);
    }
}
