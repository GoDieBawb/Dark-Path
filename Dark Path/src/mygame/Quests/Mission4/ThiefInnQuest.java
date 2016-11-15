/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission4;

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
public class ThiefInnQuest extends Quest {
    
  public ThiefInnQuest(AppStateManager stateManager, Node holder) {
    super(stateManager, holder);
    }
  
  @Override
  public void act() {
      
    Quest thiefQuest = player.questList.getQuest("ThiefQuest");
    String speech;
    
    if (thiefQuest == null) {
      thiefQuest      = new ThiefQuest(stateManager, player);  
      thiefQuest.step = "Start";
      player.questList.add(thiefQuest);
      }
    
    if (thiefQuest.step.equals("Start")) {
      speech = "I guess that good for nothing murder is going to get hung any minute";
      }
    
    else if (thiefQuest.step.equals("KillInn")) {
      speech  = "You approach the InnKeep drawing the knife, you stab him to death...";
      Npc bla = (Npc) stateManager.getState(NpcManager.class).npcNode.getChild("Thief");
      bla.phys.warp(new Vector3f(-8, 2, 31));
      holder.removeFromParent();
      thiefQuest.step = "Done";
      }
    
    else {
      speech = "I'm glad that murderer is going to get what he deserves... I never liked him.";
      }
    
    gui.showAlert(holder.getName(), speech);
      
    }
    
  }
