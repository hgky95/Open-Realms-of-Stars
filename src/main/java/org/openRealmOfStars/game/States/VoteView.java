package org.openRealmOfStars.game.States;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;

import org.openRealmOfStars.game.GameCommands;
import org.openRealmOfStars.gui.buttons.IconButton;
import org.openRealmOfStars.gui.buttons.SpaceButton;
import org.openRealmOfStars.gui.infopanel.EmptyInfoPanel;
import org.openRealmOfStars.gui.infopanel.InfoPanel;
import org.openRealmOfStars.gui.labels.SpaceLabel;
import org.openRealmOfStars.gui.panels.BlackPanel;
import org.openRealmOfStars.gui.utilies.GuiStatics;
import org.openRealmOfStars.starMap.StarMap;
import org.openRealmOfStars.starMap.vote.Vote;

/**
*
* Open Realm of Stars game project
* Copyright (C) 2019 Tuomo Untinen
*
* This program is free software; you can redistribute it and/or
* modify it under the terms of the GNU General Public License
* as published by the Free Software Foundation; either version 2
* of the License, or (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program; if not, see http://www.gnu.org/licenses/
*
*
* Vote view for voting and showing voting result.
*
*/
public class VoteView extends BlackPanel {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  /**
   * Label containing number of votes
   */
  private SpaceLabel voteLabel;
  /**
   * Voting index
   */
  private int voteIndex;
  /**
   * StarMap for whole starmap.
   */
  private StarMap map;
  /**
   * Create new vote view
   * @param map StarMap which contains players and planet lists.
   * @param listener Action Listener
   */
  public VoteView(final StarMap map, final ActionListener listener) {
    this.setLayout(new BorderLayout());
    InfoPanel base = new InfoPanel();
    base.setLayout(new BorderLayout());
    base.setTitle("Voting");
    this.add(base, BorderLayout.NORTH);

    EmptyInfoPanel panel = new EmptyInfoPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
    IconButton iBtn = new IconButton(GuiStatics.LEFT_ARROW,
        GuiStatics.LEFT_ARROW_PRESSED, false, GameCommands.COMMAND_PREV_VOTE,
        this);
    iBtn.setToolTipText("Previous vote");
    iBtn.addActionListener(listener);
    panel.add(iBtn);
    panel.add(Box.createRigidArea(new Dimension(10, 10)));
    ArrayList<Vote> votes = map.getVotes().getVotes();
    voteIndex = votes.size() - 1;
    for (int i = 0; i < votes.size(); i++) {
      if (votes.get(i).getTurnsToVote() > 0) {
        voteIndex = i;
        break;
      }
    }
    voteLabel = new SpaceLabel("Vote " + votes.size() + "/" + votes.size());
    this.map = map;
    panel.add(voteLabel);
    panel.add(Box.createRigidArea(new Dimension(10, 10)));
    iBtn = new IconButton(GuiStatics.RIGHT_ARROW,
        GuiStatics.RIGHT_ARROW_PRESSED, false, GameCommands.COMMAND_NEXT_VOTE,
        this);
    iBtn.setToolTipText("Next vote");
    iBtn.addActionListener(listener);
    panel.add(iBtn);
    panel.add(Box.createRigidArea(new Dimension(10, 10)));
    EmptyInfoPanel panel2 = new EmptyInfoPanel();
    panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
    panel2.add(panel);
    base.add(panel2, BorderLayout.CENTER);

    // Bottom panel
    InfoPanel bottomPanel = new InfoPanel();
    bottomPanel.setLayout(new BorderLayout());
    bottomPanel.setTitle(null);
    SpaceButton backBtn = new SpaceButton("Back to star map",
        GameCommands.COMMAND_VIEW_STARMAP);
    backBtn.addActionListener(listener);
    bottomPanel.add(backBtn, BorderLayout.CENTER);
    this.add(bottomPanel, BorderLayout.SOUTH);
    updatePanels();
  }

  /**
   * Update panels in view.
   */
  public void updatePanels() {
    if (map.getVotes().getVotes().size() > 0) {
      voteLabel.setText("Vote " + (voteIndex + 1) + "/"
          + map.getVotes().getVotes().size());
    } else {
      voteLabel.setText("Vote 0/0");
    }
  }
}
