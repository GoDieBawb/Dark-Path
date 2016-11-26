/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission3;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Quest;
import mygame.SceneManager;

/**
*
* @author Bob
*/
public class DevilDoorQuest extends Quest {
    
    public DevilDoorQuest(AppStateManager stateManager, Node holder) {
        super(stateManager, holder);
    }
    
    @Override
    public void act() {
        
        String speech;
        Quest devilQuest = player.questList.getQuest("DevilQuest");
        
        if (devilQuest == null) {
            
            devilQuest      = new DevilQuest(stateManager, player);
            devilQuest.step = "Start";
            player.questList.add(devilQuest);
            
        }
        
        switch (devilQuest.step) {
            case "Start":
                speech = "A dark force resides inside";
                break;
            case "FindWall":
                speech = "A dark force eminates from within...";
                break;
            case "FindDoor":
                speech = "You hear a voice coming from the inside...";
                break;
            case "FatherTalk":
                speech = "The door is securely locked";
                break;
            case "FindAxe":
                speech = "The door is blocked by planks... If only you had something to remove this.";
                break;
            case "ChopDoor":
                speech = "You chop the planks away from the door and it immediately flies open...";
                holder.removeFromParent();
                stateManager.getState(SceneManager.class).addPhys();
                devilQuest.step = "Done";
                break;
            case "Done":
                speech = "";
                break;
            default:
                speech = "";
                break;
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
