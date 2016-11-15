/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission1;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Interactable;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class BillyAxeQuest extends Quest {
  
  public BillyAxeQuest(AppStateManager stateManager, Node holder) {
    super(stateManager, holder);
    }
  
  @Override
  public void act(){
     
    Quest billyQuest = player.questList.getQuest("BillyQuest");
    
    if (billyQuest == null) {
      billyQuest = new BillyQuest(stateManager, player);
      player.questList.add(billyQuest);
      billyQuest.step = "Start";
      }
    
    String speech;
    
    if (billyQuest.step.equals("GetWood")) {
        
      if (player.inventory.contains("Axe")) {
        speech = "An empty chopping block...";
        }
      
      else {
        speech = "You grab the axe off the chopping block...";
        ((Interactable) holder).model.getChild(1).removeFromParent();
        player.inventory.add("Axe");
        }
      
      }
    
    else {
      
      if (player.inventory.contains("Axe")) {
        speech = "An empty chopping block...";
        }
      
      else {
        speech = "You shouldn't go messing around with people's stuff";
        }
        
      }
    
    gui.showAlert(holder.getName(), speech);
      
    }
  
  }
