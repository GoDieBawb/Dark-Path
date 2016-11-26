/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission3;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Quest;

/**
*
* @author Bob
*/
public class BrotherQuest extends Quest {
    
    public BrotherQuest(AppStateManager stateManager, Node holder) {
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
                speech = "Speak to Father John... We do not normally welcome guests at the Hermitage";
                break;
            case "FindWall":
                speech = "You are to leave as soon as the storm passes...";
                break;
            case "FindDoor":
                speech = "There are no secret places here... Don't go looking for any";
                break;
            case "FatherTalk":
                speech = "The Father would like to speak with you about what you've seen.";
                break;
            case "FindAxe":
                speech = "Do not go near that door again!";
                break;
            case "ChopDoor":
                speech = "Put the axe down for God's sake!";
                break;
            case "Done":
                speech = "May God have mercy on your soul for the act you've committed here.";
                break;
            default:
                speech = "";
                break;
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
