/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission4;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Interactable;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class ThiefBodyQuest extends Quest {
    
  public ThiefBodyQuest(AppStateManager stateManager, Node holder) {
    super(stateManager, holder);  
    }
  
  @Override
  public void act(){
    
    Quest thiefQuest = player.questList.getQuest("ThiefQuest");
    String speech;
    
    if (thiefQuest == null) {
      thiefQuest      = new ThiefQuest(stateManager, player);  
      thiefQuest.step = "Start";
      player.questList.add(thiefQuest);
      }
    
    if (thiefQuest.step.equals("Start")) {
      speech = "A dead body lying on the floor";
      }
    
    else if (thiefQuest.step.equals("FindRing")) {
      speech = "This person was killed recently.";
      }

     else if (thiefQuest.step.equals("HasRing")) {
      speech = "Killed for a ring... How senseless";
      }

    else if (thiefQuest.step.equals("FindKnife")) {
      speech = "You take the knife from the dead body";
      ((Interactable) holder).model.getChild(1).removeFromParent();
      thiefQuest.step = "HasKnife";
      }
    
    else if (thiefQuest.step.equals("HasKnife")) {
      speech = "You know what you have to do now!";
      }

    else if (thiefQuest.step.equals("KillInn")) {
      speech = "You must avenge the death of this victim!";
      }

    else if (thiefQuest.step.equals("Done")) {
      speech = "The victim has been avenged";
      }
    
    else {
      speech = "";
      }
    
    gui.showAlert(holder.getName(), speech);    
      
    }
    
  }
