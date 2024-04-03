# Starfleet Command Game

## User Stories

1. **As a player, I want to view a main menu, so that I can choose what action to take next in the game.**
   - Implement a main menu with options like 'Start Battle', 'View Stats', 'Repair Ship', and 'Exit'.
   - Allow the user to select an option.

2. **As a player, I want to start a battle, so that I can engage with enemy ships.**
   - Implement the 'Start Battle' option in the main menu.
   - Randomly select an enemy ship from a predefined list when a battle starts.

3. **As a player, I want to attack the enemy ship, so that I can score points in the game.**
   - Implement an attack option during the battle.
   - Determine randomly whether the attack is successful and update the score accordingly.

4. **As a player, I want the option to retreat, so that I can avoid losing health if the battle is unfavorable.**
   - Implement a retreat option during the battle.
   - Ensure that retreating ends the current battle without affecting the player’s health.

5. **As a player, I want to view my current stats, so that I can make informed decisions in the game.**
   - Implement the 'View Stats' option to display the player’s current health and score.

6. **As a player, I want to be able to repair my ship, so that I can restore health lost in battle.**
   - Implement the 'Repair Ship' option to restore the player’s health to full.

7. **As a player, I want to be able to exit the game, so that I can stop playing when I want to.**
   - Implement the 'Exit' option to allow the user to quit the game.
   - Display the final score upon exiting.

8. **As a player, I want to see different types of enemy ships, so that the game is more interesting.**
   - Create an array of different enemy ship names.
   - Randomly select an enemy ship type for each battle.

