import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase es el ultimo nivel del juego
 * 
 * @author Miguel Angel Enriquez Cisneros y Joaquin Manuel Trujillo Viveros 
 * @version 1
 */
public class WorldFinal extends World
{

    private GreenfootSound risaTrollBoss = new GreenfootSound("Risa_Troll_Boss.mp3");
    private boolean risaYaActivada = false;
    /**
     * Constructor for objects of class WorldFinal.
     * 
     */
    public WorldFinal()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640,460, 1); 
        prepare();
        risaTrollBoss.setVolume(80);
    }
    
    public void act()
    {
        if(!risaYaActivada)
            risa();
    }

    private void prepare()
    {
        setPaintOrder(Player.class, Enemy.class, Goal.class, Goal.class, Floor.class);
        Floor floorInicial = new Floor();
        Floor floor = new Floor();
        Floor floor2 = new Floor();
        Floor floor3 = new Floor();
        Floor floor4 = new Floor();
        addObject(floorInicial, 50, 200);
        addObject(floor, 100, 460);
        addObject(floor2, 315, 460);
        addObject(floor3, 533, 460);
        TrollBoss trollBoss = new TrollBoss(true);
        addObject(trollBoss,400,380);
    }
    
    /**
     * Reproduce la risa del jefe final
     */
    public void risa()
    {
        risaTrollBoss.play();
        risaYaActivada = true;
    }

    /**
     * Agrega una instancia de la clase jugador
     * @Param El jugador con sus datos actuales, como la salud
     */
    public void addPlayer(Player player)
    {
        addObject(player, 200, 95);
    }
}
