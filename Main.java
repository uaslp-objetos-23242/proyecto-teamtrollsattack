import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase es la pantalla de titulo
 * 
 * @author Miguel Angel Enriquez Cisneros y Joaquin Manuel Trujillo Viveros 
 * @version 1
 */
public class Main extends World
{

    private MainMenuButtons mmb = new MainMenuButtons();
    /**
     * Constructor for objects of class Main.
     * 
     */
    public Main()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640,460, 1);
        prepare();
    }
    
    public void prepare()
    {
        addObject(mmb, 0, 0);
        showText("Presiona espacio para iniciar", getWidth()/2, getHeight()/2);
    }
}
