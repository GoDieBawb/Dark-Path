/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission4;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class ThiefCrateQuest extends Quest {
    
  public ThiefCrateQuest(AppStateManager stateManager, Node holder) {
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
      speech = "You shouldn't go diggint through other people's stuff";
      }
    
    else if (thiefQuest.step.equals("FindRing")) {
      speech = "As you look in the great sure enough you find a bloody ring.";
      thiefQuest.step = "HasRing";
      }

     else if (thiefQuest.step.equals("HasRing")) {
      speech = "You've already found the ring...";
      }

    else if (thiefQuest.step.equals("FindKnife")) {
      speech = "Nothing in here is going to help you.";
      }
    
    else if (thiefQuest.step.equals("HasKnife")) {
      speech = "You must avenge the death of the victim!";
      }

    else if (thiefQuest.step.equals("KillInn")) {
      speech = "You must avenge the death of this victim!";
      }

    else if (thiefQuest.step.equals("Done")) {
      speech = "Nothing left to do but save the thief";
      }
    
    else {
      speech = "";
      }
    
    gui.showAlert(holder.getName(), speech);    
      
    }
    
  }
