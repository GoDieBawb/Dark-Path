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
    
    if (floraQuest.step.equals("Start")) {
      speech = "Hello traveler... I'm just a lonely old grave keeper.";
      }
    
    else if (floraQuest.step.equals("FindDampe")) {
      speech = "A ring you say? I may have seen one... If you could do something for me";
      floraQuest.step = "FindBottle";
      }

    else if (floraQuest.step.equals("FindBottle")) {
      speech = "Find me a bottle of vodka... There's one in the old house in the corner of town.";
      }

    else if (floraQuest.step.equals("HasBottle")) {
      speech = "Ah... That is some good vodka.... Oh yeah the ring.... It's buried here somewhere";
      floraQuest.step = "FindShovel";
      }
    
    else if (floraQuest.step.equals("FindShovel")) {
      speech = "I remember a body being buried with a ring like that...";
      }
    
    else if (floraQuest.step.equals("HasRing")) {
      speech = "That ring does bring back some memories... Best it gets returned to its owner";
      }

    else if (floraQuest.step.equals("Done")) {
      speech = "Dame disappears before your eyes...";
      holder.removeFromParent();
      }
    
    else {
      speech = "That ring is very important to me";
      }
    
    gui.showAlert(holder.getName(), speech);
    
    }
  
  }
