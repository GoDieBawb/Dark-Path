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
public class DevilWallQuest extends Quest {
    
    public DevilWallQuest(AppStateManager stateManager, Node holder) {
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
                speech = "This seems to be a very strange wall";
                break;
            case "FindWall":
                speech = "The wall falls away as you press one of the bricks";
                holder.removeFromParent();
                stateManager.getState(SceneManager.class).addPhys();
                devilQuest.step = "FindDoor";
                break;
            case "FindDoor":
                speech = "";
                break;
            case "FatherTalk":
                speech = "";
                break;
            case "FindAxe":
                speech = "";
                break;
            case "ChopDoor":
                speech = "";
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
