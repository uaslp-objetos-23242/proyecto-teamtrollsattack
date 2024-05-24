import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenuButtons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenuButtons extends Actor
{
    /**
     * Act - do whatever the MainMenuButtons wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Story s = new Story();
    PlaceHolderBG w1 = new PlaceHolderBG();

    private boolean onMainMenu = true;
    public MainMenuButtons()
    {
        getImage().setTransparency(0);
    }
    
    public void act()
    {
        advance();
    }

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
    
    public Player getPlayerInfo()
    {
        return getWorld().getObjects(Player.class).get(0);
    }
}
