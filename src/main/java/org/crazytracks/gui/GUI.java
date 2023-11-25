package org.crazytracks.gui;

import org.crazytracks.model.Position;

public interface GUI {

    void drawElement(Object view);

    void initGameGUI();

    void drawCoin(Position position);

    void drawSurfer(Position position);
    void drawPowerUp(Position position);
    void drawWagon(Position position);
    void putScore(int score);

}