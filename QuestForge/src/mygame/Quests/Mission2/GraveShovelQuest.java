/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission2;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class GraveShovelQuest extends Quest {
    
  public GraveShovelQuest(AppStateManager stateManager, Node holder) {
    super(stateManager, holder);  
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
    
    if (floraQuest.step.equals("FindShovel")) {
      speech = "You pick up the shovel";
      holder.removeFromParent();
      player.inventory.add("Shovel");
      }
    
    else {
      speech = "You shouldn't go messing around with other people's tools.";
      }
    
    gui.showAlert(holder.getName(), speech);
      
    }
    
  }
