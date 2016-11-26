/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission3;

import com.jme3.app.state.AppStateManager;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import mygame.Npc;
import mygame.Quest;

/**
*
* @author Bob
*/
public class DevilQuest extends Quest {
    
    public DevilQuest(AppStateManager stateManager, Node holder) {
        super(stateManager, holder);
        name = "DevilQuest";
    }
    
    @Override
    public void act(){
        
        String speech;
        Quest devilQuest = player.questList.getQuest("DevilQuest");
        
        if (devilQuest == null) {
            
            devilQuest      = new DevilQuest(stateManager, player);
            devilQuest.step = "Start";
            player.questList.add(devilQuest);
            
        }
        
        switch (devilQuest.step) {
            case "Start":
                speech = "A dark force resides here...";
                break;
            case "FindWall":
                speech = "A dark force resides here...";
                break;
            case "FindDoor":
                speech = "I'm trapped by these insane Monks... Please friend break me out!";
                Npc brother = (Npc) ((Node) ((Node) holder.getParent().getParent()).getChild("NpcNode")).getChild("Brother Jerome");
                brother.phys.warp(new Vector3f(-19, 0, 26));
                devilQuest.step = "FatherTalk";
                break;
            case "FatherTalk":
                speech = "Please friend, I'm locked in here! Let me out.";
                break;
            case "FindAxe":
                speech = "Find a way to chop away the planks from the door.";
                break;
            case "ChopDoor":
                speech = "Quickly chop the planks away from the door!";
                break;
            case "Done":
                speech = "As the door opens you see... This is no man standing here but Satan himself. But in a moment... He disappears.";
                holder.removeFromParent();
                break;
            default:
                speech = "";
                break;
        }
        
        gui.delayAlert(holder.getName(), speech, 2);
        
    }
    
}
