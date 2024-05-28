import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase es el nivel 5 del juego
 * 
 * @author Miguel Angel Enriquez Cisneros y Joaquin Manuel Trujillo Viveros 
 * @version 1
 */
public class World5 extends World
{

    /**
     * Constructor for objects of class World5.
     * 
     */
    public World5()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640,460, 1); 
        prepare();
    }
    
    private void prepare()
    {
        setPaintOrder(Player.class, Enemy.class, Goal.class, Goal.class, InvisibleWall.class, Floor.class);
        Floor floorInicial = new Floor();
        Floor floor = new Floor();
        Floor floor2 = new Floor();
        Floor floor3 = new Floor();
        Floor floor4 = new Floor();
        Floor floor5 = new Floor();
        MountainTroll mountainTroll = new MountainTroll();
        TrollBoss trollBoss = new TrollBoss(false);
        addObject(floorInicial, 80, 150);
        addObject(floor, 100, 460);
        addObject(floor2, 315, 460);
        addObject(floor3, 533, 460);
        addObject(floor4,290,180);
        addObject(floor5,495,210);
        addObject(mountainTroll,495,140);
        addObject(trollBoss,315, 380);
        InvisibleWallRight invisibleWallRight = new InvisibleWallRight(25, 25);
        addObject(invisibleWallRight,175, 145);
        InvisibleWallRight invisibleWallRight2 = new InvisibleWallRight(25, 35);
        addObject(invisibleWallRight2,589,207);
        InvisibleWallRight invisibleWallRight3 = new InvisibleWallRight(25, 25);
        addObject(invisibleWallRight3,385,175);
    }

    /**
     * Agrega una instancia de la clase jugador
     * @Param El jugador con sus datos actuales, como la salud
     */
    public void addPlayer(Player player)
    {
        addObject(player, 50, 90);
    }
}
