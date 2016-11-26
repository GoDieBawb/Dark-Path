/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission2;

import com.jme3.app.state.AppStateManager;
import com.jme3.asset.TextureKey;
import com.jme3.material.Material;
import com.jme3.scene.Node;
import com.jme3.texture.Texture;
import mygame.Quest;

/**
*
* @author Bob
*/
public class DampeQuest extends Quest {
    
    public DampeQuest(AppStateManager stateManager, Node holder) {
        super(stateManager, holder);
        name = "FloraQuest";
    }
    
    @Override
    public void act() {
        Quest floraQuest = player.questList.getQuest("FloraQuest");
        String speech;
        
        if (floraQuest == null) {
            floraQuest      = new FloraQuest(stateManager, player);
            floraQuest.step = "Start";
            player.questList.add(floraQuest);
        }
        
        switch (floraQuest.step) {
            case "Start":
                speech = "Hello traveler... I'm just a lonely old grave keeper.";
                break;
            case "FindDampe":
                speech = "A ring you say? I may have seen one... If you could do something for me";
                floraQuest.step = "FindBottle";
                break;
            case "FindBottle":
                speech = "Find me a bottle of vodka... There's one in the old house in the corner of town.";
                break;
            case "HasBottle":
                speech = "Ah... That is some good vodka.... Oh yeah the ring.... It's buried here somewhere";
                floraQuest.step = "FindShovel";
                break;
            case "FindShovel":
                speech = "I remember a body being buried with a ring like that...";
                break;
            case "HasRing":
                speech = "That ring does bring back some memories... Best it gets returned to its owner";
                break;
            case "Done":
                speech = "Dampe disappears before your eyes...";
                holder.removeFromParent();
                break;
            default:
                speech = "That ring is very important to me";
                break;
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
