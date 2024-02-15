# Arctic Laboratories

A faction mod with an arctic theme for the game StarSector.

## Installation instructions

First, make sure you have the latest version of StarSector (they've been updating it recently (as of 2/14/2024)). You can download the latest version for your operating system here: https://fractalsoftworks.com/category/releases/

After installing StarSector, start with this forum post: https://fractalsoftworks.com/forum/index.php?topic=25974.0

After reading, understanding, and following those instructions (for the additional RAM allocation, I use 4GB), download an additional mod by going to this forum post and clicking on the first main image (the mod will help with showcasing my mod): https://fractalsoftworks.com/forum/index.php?topic=21591.0

Next, you'll have to install (unzip) the mod and change the mod_info.json file of that mod, so it will run with the latest version of StarSector. If you're on Windows, you can do this by going to "C:\Program Files (x86)\Fractal Softworks\Starsector" (assuming you installed the base game in the default location), opening the mods folder, extracting your downloaded mod folder into that folder (making sure to follow the instructions in the mod guide forum post from earlier for keeping the folder structure intact), then selecting the freshly extracted "SCVE-v1.8.2" folder. Inside the mod_info.json file, change line 8 (where it says gameVersion) to be "gameVersion":"0.97a" if it doesn't say some variant of "0.97a" already. Remember to keep a comma at the end of the line.

Now, you can finally install my mod. On this github page, download ArcticLaboratories.zip and install it by extracting it into StarSector's mod folder as you've done previously. Now, start up the game and select the "Mods" menu option in the launcher (before it goes full screen). Activate both mods by making sure the blue box next to each mod is lit up. Click "Save" and then "Play StarSector."

Once the game has loaded (follow any troubleshooting steps from the first forum post I linked if you have any issues getting this far), click on the "Missions" button and scroll down until you see "Mod Showcase." Don't start the mission, rather, hold down the 'A' key on your keyboard and click the "Mod Showcase" mission two more times, or until the "tactical briefing" part of the mission description says it has "Heavy" filtering for weapons and wings filtered. Then, hit the "refit" button underneath the large listing of spaceships. This will bring up all the ships in my mod.

Pick whatever ship you want to test out. Fill out the weapon slots on the ship with any weapon you want to test out. Then hit "run simulation." You'll be presented with a list of ships to fight against. If you don't want any opposition, you can safely hit "cancel" to just fly the ship around. Then press the "Tab" key on your keyboard to start testing out your ship. Use the "WASD" keys on your keyboard to move around and click to shoot. If you have multiple weapon groups, you can use the number keys to switch between them. Note that the Frozen Eye family of missiles require a target in order to function properly (asteroids aren't enough).

When you're done or want to try out another ship, press teh "Esc" key and click "End Simulation." After confirming, you'll be brought back to the ship editor screen, where you can try out another ship or weapons. When finished, press "Esc" several times until you are prompted to exit the game.

## Notes for continued development

* Make sure faction knows own weapons
* finish loadouts (with new weapons)
* finish star system and determine it's final location
* write descriptions for everything