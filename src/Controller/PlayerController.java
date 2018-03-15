package Controller;

import Model.Player;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javax.swing.text.Position;
import java.awt.event.KeyListener;
import java.util.ArrayList;

//Player Controlls: 0 = up, 1 = right, 2 = down, 3 = left

public class PlayerController extends SubKeyController {
    private Player player;
    private boolean inputRegistered;
    private boolean isListeningforRebind;
    private int rebindIndex;

    private ArrayList<KeyCode> playerControls;
    private ArrayList<String> controlFunctions; //Represents control functions (i.e. moveUp, attack, etc.)
    public PlayerController(Player player){
        super();
        this.player = player;
        inputRegistered = false;


        //Initialize default controls
        playerControls = new ArrayList<>();
        playerControls.add(KeyCode.UP);
        playerControls.add(KeyCode.RIGHT);
        playerControls.add(KeyCode.DOWN);
        playerControls.add(KeyCode.LEFT);
        playerControls.add(KeyCode.NUMPAD9);
        playerControls.add(KeyCode.NUMPAD3);
        playerControls.add(KeyCode.NUMPAD1);
        playerControls.add(KeyCode.NUMPAD7);
        playerControls.add(KeyCode.F);

        controlFunctions = new ArrayList<>();
        controlFunctions.add("Up");
        controlFunctions.add("Right");
        controlFunctions.add("Down");
        controlFunctions.add("Left");
        controlFunctions.add("NE");
        controlFunctions.add("SE");
        controlFunctions.add("SW");
        controlFunctions.add("NW");
        controlFunctions.add("Interact");

        isListeningforRebind = false;
        rebindIndex = 0;
    }





    public boolean isInputRegistered() {
        return inputRegistered;
    }

    public void resetInputRegistered() {
        inputRegistered = false;
    }

    @Override
    void keyInput(KeyCode code) {
        inputRegistered = true;

        if(isListeningforRebind) {
            playerControls.set(rebindIndex, code);
            isListeningforRebind = false;
        }

        if(code == playerControls.get(0)) {//MoveUp
            player.moveNorth();
        } else if(code == playerControls.get(1)) {//MoveRight
            player.moveEast();
        } else if(code == playerControls.get(2)) {//MoveDown
            player.moveSouth();
        } else if(code == playerControls.get(3)) {//MoveLeft
            player.moveWest();
        } else if(code == playerControls.get(4)) {//MoveNE
            player.moveNorthEast();
        } else if(code == playerControls.get(5)) {//MoveSE
            player.moveSouthEast();
        } else if(code == playerControls.get(6)) {//MoveSW
            player.moveSouthWest();
        } else if(code == playerControls.get(7)) {//MoveNW
            player.moveNorthWest();
        } else if(code == playerControls.get(8)) {//Interact
            //player.checkForNPC;
        }
    }


    public ArrayList<String> generateControlsList() {
        ArrayList<String> controlsList = new ArrayList<>();
        for(int i = 0; i < playerControls.size(); i++) {
            controlsList.add(controlFunctions.get(i) + ": " + playerControls.get(i).toString());
        }
        return controlsList;
    }

    public int getNumOfControls() {
        return playerControls.size();
    }

    public void startListenForRebind(int controlIndex) {
        isListeningforRebind = true;
        rebindIndex = controlIndex;
    }

    public String getKeyBindingAsString(int index) {
        if(index >= playerControls.size()) {
            return "";
        }
        return playerControls.get(index).toString();
    }
}
