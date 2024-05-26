import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase representa una instancia de MainMenuButtons, sirve para controlar las diversas paginas
 * 
 * @author Miguel Angel Enriquez Cisneros y Joaquin Manuel Trujillo Viveros
 * @version 1
 */
public class MainMenuButtons extends Actor
{
    private Story s = new Story();
    private PlaceHolderBG w1 = new PlaceHolderBG();

    private boolean onMainMenu = true;
    public MainMenuButtons()
    {
        getImage().setTransparency(0);
    }

    /**
     * Act - do whatever the MainMenuButtons wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        advance();
    }

    /**
     * Esta clase muestra los diversos controles del personaje sobre el mundo
     */
    public void advance()
    {   
        if(onMainMenu)
        {
            if(Greenfoot.isKeyDown("space"))
            {
                Greenfoot.setWorld(s);
                s.addControl(this);
                onMainMenu = false;
            }
        }
        else
        {
            if(Greenfoot.isKeyDown("enter"))
            {
                Greenfoot.setWorld(w1);
                getWorld().removeObject(this);
            }
            else if(Greenfoot.isKeyDown("h"))
            {
                Greenfoot.setWorld(w1);
                w1.addControl(this);
                getPlayerInfo().setDifficulty(true);
                getWorld().removeObject(this);
            }
        }
    }

    /**
     * Adquiere una copia del jugador para obtener datos relevantes
     */
    public Player getPlayerInfo()
    {
        return getWorld().getObjects(Player.class).get(0);
    }
}
