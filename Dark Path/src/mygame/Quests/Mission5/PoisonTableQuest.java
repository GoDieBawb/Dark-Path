/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission5;

import com.jme3.app.state.AppStateManager;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import mygame.Npc;
import mygame.NpcManager;
import mygame.Quest;

/**
*
* @author Bob
*/
public class PoisonTableQuest extends Quest {
    
    public PoisonTableQuest(AppStateManager stateManager, Node holder){
        super(stateManager, holder);
    }
    
    @Override
    public void act(){
        
        Quest poisonQuest = player.questList.getQuest("PoisonQuest");
        String speech;
        
        if (poisonQuest == null) {
            poisonQuest =  new PoisonQuest(stateManager, player);
            poisonQuest.step = "Start";
            player.questList.add(poisonQuest);
        }
        
        switch (poisonQuest.step) {
            case "Start":
                speech = "Looks like the Master of the Manor's Table.";
                break;
            case "GetWeapon":
                speech = "A fancy eating area for fancy people.";
                break;
            case "KillPrisoner":
                speech = "A lunatic must eat here...";
                break;
            case "KilledPrisoner":
                speech = "Wonder if the prisoner is on the menu...";
                break;
            case "SeeChef":
                speech = "A table... Fit for a madman";
                break;
            case "SeeButler":
                speech = "Another murder... Why did you come here?";
                break;
            case "Poison":
                speech = "You place the poison into the kings food";
                poisonQuest.step = "Done";
                Node npcNode = stateManager.getState(NpcManager.class).npcNode;
                ((Npc) npcNode.getChild("Master")).phys.warp(new Vector3f(-16, 0, -8));
                ((Npc) npcNode.getChild("Cook")).phys.warp(new Vector3f(-16, 0, -7));
                ((Npc) npcNode.getChild("Butler")).phys.warp(new Vector3f(-16, 0, -9));
                break;
            case "Done":
                speech = "You're going to die...";
                break;
            default:
                speech = "";
                break;
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
