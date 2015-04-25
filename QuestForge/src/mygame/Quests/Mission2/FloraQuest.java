/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission2;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.GuiManager;
import mygame.Quest;
import mygame.SceneManager;

/**
 *
 * @author Bob
 */
public class FloraQuest extends Quest {
  
  public FloraQuest(AppStateManager stateManager, Node holder) {
    super(stateManager, holder);
    name = "FloraQuest";
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
    
    if (floraQuest.step.equals("Start")) {
      speech = "Hello Traveler, many years ago I lost a ring, maybe you have seen it?";
      floraQuest.step = "FindDampe";
      }
    
    else if (floraQuest.step.equals("FindDampe")) {
      speech = "A ring... I lost it years ago, I was hoping maybe you'd seen it in your travels.";
      }

    else if (floraQuest.step.equals("FindBottle")) {
      speech = "If you find the ring, I'd be very thankful";
      }

    else if (floraQuest.step.equals("HasBottle")) {
      speech = "If you find the ring, I'd be very thankful";
      }
    
    else if (floraQuest.step.equals("FindShovel")) {
      speech = "If you find the ring, I'd be very thankful";
      }
    
    else if (floraQuest.step.equals("HasRing")) {
      speech = "You found the ring in a grave? Why were you digging in the Graveyard?";
      floraQuest.step = "Done";
      }

    else if (floraQuest.step.equals("Done")) {
      speech = "Dampe? Dampe was hung and buried for Grave Robbery... 10 years ago. Whose grave was this from?";
      }
    
    else {
      speech = "Grave robbers always get what they deserve...";
      }
    
    gui.showAlert(holder.getName(), speech);
      
    }

  }
