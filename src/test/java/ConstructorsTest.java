import org.crazytracks.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ConstructorsTest {

    @Test
    public void testCoinConstructor() {
        Coin coin = new Coin(new Position(0, 0));
        Assertions.assertEquals(0, coin.getPosition().getX());
        Assertions.assertEquals(0, coin.getPosition().getY());
    }

    @Test
    public void testPowerUpConstructor() {
        PowerUp powerUp = new PowerUp(new Position(0, 0));
        Assertions.assertEquals(0, powerUp.getPosition().getX());
        Assertions.assertEquals(0, powerUp.getPosition().getY());
    }

    @Test
    public void testWagonConstructor() {
        Wagon wagon = new Wagon(new Position(0, 0));
        wagon.setWagon_lenght(5);
        Assertions.assertEquals(0, wagon.getPosition().getX());
        Assertions.assertEquals(0, wagon.getPosition().getY());
        Assertions.assertEquals(5, wagon.getWagon_lenght());
    }

    @Test
    public void testSurferConstructor() {
        Surfer surfer = new Surfer(new Position(0, 0));
        Assertions.assertEquals(0, surfer.getPosition().getX());
        Assertions.assertEquals(0, surfer.getPosition().getY());
        Assertions.assertEquals(0, surfer.getScore());
    }

    @Test
    public void GameStateConstructor() {
        Track track = new Track();
        GameState gameState = new GameState(track);
        Assertions.assertEquals(track, gameState.getModel());
    }

    @Test
    public void MenuStateConstructor() {
        Menu menu = new Menu();
        MenuState menuState = new MenuState(menu);
        Assertions.assertEquals(menu, menuState.getModel());
    }

    @Test
    public void TrackConstructor() {
        Track track = new Track();
        Surfer surfer = new Surfer(new Position(0, 0));
        track.setSurfer(surfer);
        List<TrackElement> trackElements = new ArrayList<>();
        track.setTrackElements(trackElements);
        Assertions.assertEquals(0, track.getSurfer().getPosition().getX());
        Assertions.assertEquals(0, track.getSurfer().getPosition().getY());
        Assertions.assertEquals(0, track.getSurfer().getScore());
        Assertions.assertEquals(0, track.getTrackElements().size());
    }
}
