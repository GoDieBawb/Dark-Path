/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission5;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class PoisonCookQuest extends Quest {
    
  public PoisonCookQuest(AppStateManager stateManager, Node holder){
    super(stateManager, holder);
    }
  
  @Override
  public void act(){
      
    Quest poisonQuest = player.questList.getQuest("PoisonQuest");
    String speech;
    
    if (poisonQuest == null) {
      poisonQuest =  new PoisonQuest(stateManager, player);
      poisonQuest.step = "Start";
      player.questList.add(poisonQuest);
      }
    
    if (poisonQuest.step.equals("Start")) {
      speech = "You'll be wanting to see the Master. It's wise not to keep him waiting.";
      }

    else if (poisonQuest.step.equals("GetWeapon")) {
      speech = "Do as the Master says.... Always.";  
      }

    else if (poisonQuest.step.equals("KillPrisoner")) {
      speech = "Whatever the Master asks.... Do it";  
      }

    else if (poisonQuest.step.equals("KilledPrisoner")) {
      speech = "The Master wishes to speak with you.";  
      }
    
    else if (poisonQuest.step.equals("SeeChef")) {
      speech = "The Master wishes to poison the Butler... But I will not. We are conspiring to kill the Master.";  
      poisonQuest.step = "SeeButler";
      }
    
    else if (poisonQuest.step.equals("SeeButler")) {
      speech = "Go see the Butler... We have a plan to betray the Master. He's mad!";  
      }

    else if (poisonQuest.step.equals("Poison")) {
      speech = "Go plant the Poison as instructed by the Butler, and the Master's wealth will be ours!";  
      }

    else if (poisonQuest.step.equals("Done")) {
      speech = "I told you he was no good! I did good Master!";
      holder.removeFromParent();
      }
    
    else {
      speech = "";
      }
    
    gui.showAlert(holder.getName(), speech);
      
    }
    
  }
