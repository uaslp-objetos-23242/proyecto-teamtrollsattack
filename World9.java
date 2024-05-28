import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase es el nivel 9 del juego
 * 
 * @author Miguel Angel Enriquez Cisneros y Joaquin Manuel Trujillo Viveros 
 * @version 1
 */
public class World9 extends World
{

    /**
     * Constructor for objects of class World9.
     * 
     */
    public World9()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640,460, 1);
        prepare();
    }
    
    private void prepare()
    {
        setPaintOrder(Player.class, Enemy.class, Goal.class, InvisibleWall.class, Floor.class);
        Floor floorInicial = new Floor();
        Floor floor = new Floor();
        Floor floor2 = new Floor();
        Floor floor3 = new Floor();
        Floor floor4 = new Floor();
        Floor floor5 = new Floor();
        Floor floor6 = new Floor();
        TrollGeneral trollGeneral = new TrollGeneral();
        TrollGeneral trollGeneral2 = new TrollGeneral();
        RangerTroll rangerTroll = new RangerTroll();
        InvisibleCeiling invisibleCeiling = new InvisibleCeiling(440, 30);
        InvisibleCeiling invisibleCeiling2 = new InvisibleCeiling(200, 30);
        InvisibleWallRight invisibleWallRight = new InvisibleWallRight(25, 30);
        InvisibleWallLeft invisibleWallLeft = new InvisibleWallLeft(25, 20);
        InvisibleWallLeft invisibleWallLeft2 = new InvisibleWallLeft(25, 55);
        addObject(floorInicial, 540, 140);
        addObject(floor, 100, 460);
        addObject(floor2, 315, 460);
        addObject(floor3, 533, 460);
        addObject(floor4, 330, 180);
        addObject(floor5, 100, 320);
        addObject(floor6, 315, 320);
        addObject(trollGeneral,533, 400);
        addObject(trollGeneral2,315, 400);
        addObject(rangerTroll,100, 400);
        addObject(invisibleCeiling,190, 320);
        addObject(invisibleCeiling2,330, 180);
        addObject(invisibleWallRight,415, 317);
        addObject(invisibleWallLeft,237, 175);
        addObject(invisibleWallLeft2,446,154);
    }

    /**
     * Agrega una instancia de la clase jugador
     * @Param El jugador con sus datos actuales, como la salud
     */
    public void addPlayer(Player player)
    {
        addObject(player, 540, 70);
    }
}
