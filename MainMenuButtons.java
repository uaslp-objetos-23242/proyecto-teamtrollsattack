import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase representa una instancia de MainMenuButtons, sirve para controlar las diversas paginas
 * 
 * @author Miguel Angel Enriquez Cisneros y Joaquin Manuel Trujillo Viveros
 * @version 1
 */
public class MainMenuButtons extends Actor
{
    Story s = new Story();
    PlaceHolderBG w1 = new PlaceHolderBG();
    GreenfootSound mainMenu = new GreenfootSound("TrollsAttackMainTheme.mp3");
    GreenfootSound storySong = new GreenfootSound("Exposition.mp3");

    private boolean onMainMenu = true;
    public MainMenuButtons()
    {
        getImage().setTransparency(0);
        mainMenu.setVolume(50);
        storySong.setVolume(50);
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
        {   mainMenu.play();
            if(Greenfoot.isKeyDown("space"))
            {
                mainMenu.stop();
                Greenfoot.setWorld(s);
                s.addControl(this);
                storySong.play();
                onMainMenu = false;
            }
        }
        else
        {
            if(Greenfoot.isKeyDown("enter"))
            {
                storySong.stop();
                Greenfoot.setWorld(w1);
                getWorld().removeObject(this);
            }
            else if(Greenfoot.isKeyDown("h"))
            {
                storySong.stop();
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
