/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission1;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class BillyTreeQuest extends Quest {
  
  public BillyTreeQuest(AppStateManager stateManager, Node holder) {
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
        holder.removeFromParent();
        speech = "You chop down the tree and retrieve the wood";
        billyQuest.step = "HasWood";
        }
      
      else {
        speech = "You'll probably need to find an axe to cut down the tre";
        }
      
      }
    
    else {
      speech = "You don't need to be chopping down any trees";
      }

    gui.showAlert(holder.getName(), speech);
    
    }
    
  }
