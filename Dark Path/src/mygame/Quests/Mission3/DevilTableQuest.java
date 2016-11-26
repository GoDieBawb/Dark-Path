/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission3;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Interactable;
import mygame.Quest;

/**
*
* @author Bob
*/
public class DevilTableQuest extends Quest {
    
    public DevilTableQuest(AppStateManager stateManager, Node holder) {
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
                speech = "You shouldn't go messing with people's stuff.";
                break;
            case "FindWall":
                speech = "Brother Jerome eyes you suspiciously";
                break;
            case "FindDoor":
                speech = "Brother Jerome eyes you suspiciously";
                break;
            case "FatherTalk":
                speech = "You should talk to Father John before doing anything crazy.";
                break;
            case "FindAxe":
                speech = "You take the axe from the table...";
                devilQuest.step = "ChopDoor";
                ((Interactable) holder).model.getChild(1).removeFromParent();
                break;
            case "ChopDoor":
                speech = "An empty table...";
                break;
            case "Done":
                speech = "You should never have grabbed the axe...";
                break;
            default:
                speech = "";
                break;
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
