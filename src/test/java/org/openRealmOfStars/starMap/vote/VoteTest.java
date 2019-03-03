package org.openRealmOfStars.starMap.vote;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

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
* Vote for single voting thing JUnit.
*
*/
public class VoteTest {

  @Test
  @Category(org.openRealmOfStars.UnitTest.class)
  public void testBasic() {
    Vote vote = new Vote(VotingType.BAN_NUCLEAR_WEAPONS, 4, 10);
    assertEquals(VotingType.BAN_NUCLEAR_WEAPONS, vote.getType());
    assertEquals(10, vote.getTurnsToVote());
    assertEquals(false, vote.getChoice(0));
    assertEquals(false, vote.getChoice(1));
    assertEquals(false, vote.getChoice(2));
    assertEquals(false, vote.getChoice(3));
    assertEquals(0, vote.getNumberOfVotes(0));
    assertEquals(0, vote.getNumberOfVotes(1));
    assertEquals(0, vote.getNumberOfVotes(2));
    assertEquals(0, vote.getNumberOfVotes(3));
    vote.setNumberOfVotes(0, 2);
    vote.setNumberOfVotes(1, 4);
    vote.setNumberOfVotes(2, 6);
    vote.setNumberOfVotes(3, 8);
    vote.setChoice(0, true);
    vote.setChoice(1, true);
    vote.setChoice(2, true);
    vote.setChoice(3, true);
    assertEquals(true, vote.getChoice(0));
    assertEquals(true, vote.getChoice(1));
    assertEquals(true, vote.getChoice(2));
    assertEquals(true, vote.getChoice(3));
    assertEquals(2, vote.getNumberOfVotes(0));
    assertEquals(4, vote.getNumberOfVotes(1));
    assertEquals(6, vote.getNumberOfVotes(2));
    assertEquals(8, vote.getNumberOfVotes(3));
  }

  @Test
  @Category(org.openRealmOfStars.UnitTest.class)
  public void testTypes() {
    assertEquals(VotingType.GALACTIC_OLYMPIC_PARTICIPATE, 
        VotingType.getTypeByIndex(0));
    assertEquals(VotingType.BAN_NUCLEAR_WEAPONS, 
        VotingType.getTypeByIndex(1));
    assertEquals(VotingType.BAN_PRIVATEER_SHIPS, 
        VotingType.getTypeByIndex(2));
    assertEquals(VotingType.GALACTIC_PEACE, 
        VotingType.getTypeByIndex(3));
    assertEquals(VotingType.TAXATION_OF_RICHEST_REALM, 
        VotingType.getTypeByIndex(4));
    assertEquals(VotingType.SECOND_CANDIDATE_MILITARY, 
        VotingType.getTypeByIndex(5));
    assertEquals(VotingType.RULER_OF_GALAXY, 
        VotingType.getTypeByIndex(6));
  }

  @Test
  @Category(org.openRealmOfStars.UnitTest.class)
  public void testTypes2() {
    assertEquals(0, VotingType.GALACTIC_OLYMPIC_PARTICIPATE.getIndex());
    assertEquals(1, VotingType.BAN_NUCLEAR_WEAPONS.getIndex());
    assertEquals(2, VotingType.BAN_PRIVATEER_SHIPS.getIndex());
    assertEquals(3, VotingType.GALACTIC_PEACE.getIndex());
    assertEquals(4, VotingType.TAXATION_OF_RICHEST_REALM.getIndex());
    assertEquals(5, VotingType.SECOND_CANDIDATE_MILITARY.getIndex());
    assertEquals(6, VotingType.RULER_OF_GALAXY.getIndex());
  }
}