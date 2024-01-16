package nefja.arcticlaboratories.world;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.FactionAPI;
import com.fs.starfarer.api.campaign.RepLevel;
import com.fs.starfarer.api.campaign.SectorAPI;
import com.fs.starfarer.api.impl.campaign.ids.Factions;
import com.fs.starfarer.api.impl.campaign.shared.SharedData;
import exerelin.campaign.ExerelinSetupData;
import exerelin.campaign.SectorManager;

import javax.management.relation.Relation;

public class ArcticLaboratoriesGen {
    public void generate(SectorAPI sector) {
        // Check to see if Nexerelin is enabled. Only generate our new system if its random sector mode is off
        boolean isNexerelinEnabled = Global.getSettings().getModManager().isModEnabled("nexerelin");

        if (!isNexerelinEnabled || SectorManager.getManager().isCorvusMode()) {
            new ArcticStar().generate(sector);
        }

        SharedData.getData().getPersonBountyEventData().addParticipatingFaction("arctic_laboratories");

        setupRelations(sector);
    }

    public void setupRelations(SectorAPI sector) {
        FactionAPI arctic = sector.getFaction("arctic_laboratories");

        arctic.setRelationship(Factions.PLAYER, RepLevel.NEUTRAL);
        arctic.setRelationship(Factions.HEGEMONY, RepLevel.SUSPICIOUS);
        arctic.setRelationship(Factions.TRITACHYON, RepLevel.FAVORABLE);
        arctic.setRelationship(Factions.LUDDIC_CHURCH, RepLevel.SUSPICIOUS);
        arctic.setRelationship(Factions.KOL, RepLevel.SUSPICIOUS);
        arctic.setRelationship(Factions.PERSEAN, RepLevel.NEUTRAL);
        arctic.setRelationship(Factions.DIKTAT, RepLevel.INHOSPITABLE);
        arctic.setRelationship(Factions.LIONS_GUARD, RepLevel.INHOSPITABLE);
        arctic.setRelationship(Factions.INDEPENDENT, RepLevel.FRIENDLY);
        arctic.setRelationship(Factions.LUDDIC_PATH, RepLevel.HOSTILE);
        arctic.setRelationship(Factions.PIRATES, RepLevel.HOSTILE);
    }
}
