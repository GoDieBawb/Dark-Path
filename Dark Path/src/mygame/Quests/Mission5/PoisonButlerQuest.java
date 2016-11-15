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
public class PoisonButlerQuest extends Quest {
    
  public PoisonButlerQuest(AppStateManager stateManager, Node holder){
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
      speech = "Ah... You're here for the job. The Master wishes to see you right away.";
      }

    else if (poisonQuest.step.equals("GetWeapon")) {
      speech = "Ah... I believe this is what you need to complete your task sir.";
      gui.delayAlert("Pistol", "The Butler hands to a single shot flintlock piston", 2);
      poisonQuest.step = "KillPrisoner";
      }

    else if (poisonQuest.step.equals("KillPrisoner")) {
      speech = "You are to execute the prisoner! Did not the master make this clear?";  
      }

    else if (poisonQuest.step.equals("KilledPrisoner")) {
      speech = "Good work on completing your task, you are proving much more useful than the last assistant.";  
      }
    
    else if (poisonQuest.step.equals("SeeChef")) {
      speech = "I believe you have business with the Chef.";  
      }
    
    else if (poisonQuest.step.equals("SeeButler")) {
      speech = "So... The Master wishes to poison me. Well the Chef and I have a plan";  
      poisonQuest.step = "Poison";
      }

    else if (poisonQuest.step.equals("Poison")) {
      speech = "Plant the poison in the Master's food, and his wealth will be divided among the three of us.";  
      }

    else if (poisonQuest.step.equals("Done")) {
      speech = "Ah... I had such high hopes for this one... I suppose he'd be good for dinner";  
      holder.removeFromParent();
      }
    
    else {
      speech = "";
      }
    
    gui.showAlert(holder.getName(), speech);
      
    }
    
  }
