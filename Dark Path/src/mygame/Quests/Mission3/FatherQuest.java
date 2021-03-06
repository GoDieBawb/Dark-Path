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
public class FatherQuest extends Quest {
    
    public FatherQuest(AppStateManager stateManager, Node holder) {
        super(stateManager, holder);
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
                speech = "You may stay here at the Hermitage until the storm passes... Just mind your own business";
                devilQuest.step = "FindWall";
                break;
            case "FindWall":
                speech = "Do not go looking for things... You may not like what you find here.";
                break;
            case "FindDoor":
                speech = "I haven't the faintest idea of a secret wall...";
                break;
            case "FatherTalk":
                speech = "The man behind that door is no man... It's the devil himself, you'd be wise not to release him.";
                devilQuest.step = "FindAxe";
                break;
            case "FindAxe":
                speech = "Like I said... Satan himself is locked behind that door. Do not go near there again";
                break;
            case "ChopDoor":
                speech = "What is the axe for... Go put it back on the table.";
                break;
            case "Done":
                speech = "I pity you my child.... You've released Satan back into the world. May God have mercy on your soul";
                break;
            default:
                speech = "";
                break;
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
