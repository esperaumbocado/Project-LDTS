package org.crazytracks.control;

import org.crazytracks.Game;
import org.crazytracks.gui.GUI;
import org.crazytracks.model.leaderboard.InputName;
import org.crazytracks.model.leaderboard.Player;
import org.crazytracks.model.GameOver;
import org.crazytracks.model.Menu;
import org.crazytracks.states.GameOverState;
import org.crazytracks.states.MenuState;

import java.io.IOException;

public class InputNameController extends Controller<InputName>{
    public InputNameController(InputName model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.TYPING){
            char currChar = getModel().getGUI().getCurrChar();
            getModel().setInputText(getModel().getInputText() + currChar);
        }
        if (action == GUI.ACTION.UNDO){
            getModel().eraseLastChar();
        }
        if (action == GUI.ACTION.SELECT){
            if (getModel().getInputText().matches(".*[a-zA-Z0-9].*")) {
                Player player = new Player(
                        getModel().getInputText(),
                        getModel().getSurfer().getScore(),
                        (int) getModel().getSurfer().getSurferSpeed()
                );
                game.getLeaderboard().insertPlayer(player);
                game.setState(new GameOverState(new GameOver(player)));
            } else {
                getModel().sendInvalidInputWarning();
            }
        }
        if (action == GUI.ACTION.QUIT){
            game.setState(new MenuState(new Menu()));
        }
    }
}