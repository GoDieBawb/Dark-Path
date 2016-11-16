/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission6;

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
public class StinkPaulQuest extends Quest {
    
  public StinkPaulQuest(AppStateManager stateManager, Node holder) { 
    super(stateManager, holder);
    }
  
  @Override
  public void act() {
    
    Quest stinkQuest =  player.questList.getQuest("StinkQuest");
    String speech;
    
    if (stinkQuest ==  null) {
      stinkQuest = new StinkWellQuest(stateManager, player);
      stinkQuest.step  = "Start";
      player.questList.add(stinkQuest);
      }
    
    if (stinkQuest.step.equals("Start")) {
      speech = "Hello traveler... Welcome to Wellington";  
      }
    
    else if (stinkQuest.step.equals("FindStink")) {
      speech = "Well I sure hope I'm not the source of that smell!";  
      }

    else if (stinkQuest.step.equals("ReportStink")) {
      speech = "A smell... from the well. Peter will want to determine... our course.";  
      }

    else if (stinkQuest.step.equals("FindPaul")) {
      speech = "So, the well must be cleansed. The cleansing takes ingredients that I don't have. I'll need some mushrooms";  
      stinkQuest.step = "FindShovel";
      } 

    else if (stinkQuest.step.equals("FindShovel")) {
      speech = "Find me some mushrooms.... They are the first object needed for the cleansing";  
      }

    else if (stinkQuest.step.equals("FindShrooms")) {
      speech = "Those shrooms are not going to dig themselves up!";  
      }

    else if (stinkQuest.step.equals("HasShrooms")) {
      speech = "Ah... Those are exactly what I needed. Next I'll need some acorns.";  
      stinkQuest.step = "FindAxe";
      }

    else if (stinkQuest.step.equals("FindAxe")) {
      speech = "Some acorns from an oak tree... There's always one around when we need it";  
      }

    else if (stinkQuest.step.equals("FindAcorns")) {
      speech = "That oak tree will not cut itself down, go take my axe.";  
      }

    else if (stinkQuest.step.equals("HasAcorns")) {
      speech = "Those are some nice acorns... The well will be pleased with these.";  
      stinkQuest.step = "KillSpider";
      }

    else if (stinkQuest.step.equals("KillSpider")) {
      speech = "The final ingredient... Spider guts. In a valley nearby a poisonous spider is there, the axe should dispatch it.";  
      }

    else if (stinkQuest.step.equals("KilledSpider")) {
      speech = "So you've got the final indredient...  Let me mix the cleansing concoction";
      Npc bla = (Npc) stateManager.getState(NpcManager.class).npcNode.getChild("Peter");
      bla.phys.warp(new Vector3f(2, 0, 5));
      gui.delayAlert("Concoction", "Paul mixes the ingredients into a bottle and hand it to you", 2);
      stinkQuest.step =  "CleanWell";
      }

    else if (stinkQuest.step.equals("CleanWell")) {
      speech = "Take that... and pour it down the well. The cleansing can then begin.";  
      }
    
    else {
      speech = "";
      }
    
    gui.showAlert(holder.getName(), speech);
      
    }
    
  }
