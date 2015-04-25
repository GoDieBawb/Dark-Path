/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission2;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Interactable;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class GraveTableQuest extends Quest{
  
  public GraveTableQuest(AppStateManager stateManager, Node holder) {
    super(stateManager, holder);
    }
  
  @Override
  public void act(){
    
    Quest floraQuest = player.questList.getQuest("FloraQuest");
    String speech;
    
    if (floraQuest == null) {
      floraQuest      = new FloraQuest(stateManager, player);
      floraQuest.step = "Start";
      player.questList.add(floraQuest);
      }
    
    if (floraQuest.step.equals("FindBottle")) {
      speech          = "You grab the bottle of vodka.";
      ((Interactable) holder).model.getChild(1).removeFromParent();
      floraQuest.step = "HasBottle";
      }
    
    else {
      speech = "Looks like an old table... Nothing important here though.";
      }
    
    
    gui.showAlert(holder.getName(), speech);
      
    }
    
  }
