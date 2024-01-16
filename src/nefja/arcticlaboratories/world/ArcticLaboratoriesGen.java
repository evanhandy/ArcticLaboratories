package nefja.arcticlaboratories.world;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.SectorAPI;
import exerelin.campaign.SectorManager;

public class ArcticLaboratoriesGen {
    public void generate(SectorAPI sector) {
        // Check to see if Nexerelin is enabled. Only generate our new system if its random sector mode is off
        boolean isNexerelinEnabled = Global.getSettings().getModManager().isModEnabled("nexerelin");

        if (!isNexerelinEnabled || SectorManager.getManager().isCorvusMode()) {
            new ArcticStar().generate(Global.getSector());
        }
    }


}
