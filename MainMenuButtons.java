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
    GreenfootSound mainMenu = new GreenfootSound("TrollsAttackMainTheme.mp3");
    GreenfootSound storySong = new GreenfootSound("Exposition.mp3");

    private boolean onMainMenu = true;
    public MainMenuButtons()
    {
        getImage().setTransparency(0);
        mainMenu.setVolume(50);
        storySong.setVolume(50);
    }
    
    public void act()
    {
        advance();
    }

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
    
    public Player getPlayerInfo()
    {
        return getWorld().getObjects(Player.class).get(0);
    }
}
