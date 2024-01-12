package nefja.arcticlaboratories;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.PlanetAPI;
import com.fs.starfarer.api.campaign.SectorAPI;
import com.fs.starfarer.api.campaign.StarSystemAPI;
import com.fs.starfarer.api.campaign.econ.EconomyAPI;
import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.impl.campaign.ids.Conditions;
import com.fs.starfarer.api.impl.campaign.ids.Industries;
import com.fs.starfarer.api.impl.campaign.ids.StarTypes;
import com.fs.starfarer.api.impl.campaign.ids.Submarkets;
import com.fs.starfarer.api.util.Misc;

public class ArcticLaboratoriesPlugin extends BaseModPlugin {
//    @Override
//    public void onApplicationLoad() throws Exception {
//        super.onApplicationLoad();
//
//        // Test that the .jar is loaded and working, using the most obnoxious way possible.
//        // throw new RuntimeException("Template mod loaded! Remove this crash in TemplateModPlugin.");
//    }

    @Override
    public void onNewGame() {
        super.onNewGame();

        SectorAPI sector = Global.getSector();
        StarSystemAPI system = sector.createStarSystem("Arctic Star");

        PlanetAPI star = system.initStar(
            "arctic_star",
                StarTypes.WHITE_DWARF,
            250,
            -400,
            -9400,
            100
        );

        PlanetAPI arcticVolatilePlanet = system.addPlanet(
            "arctic_volatile",
            star,
            "Power Source X",
            "gas_giant",
            0,
            229,
            1000,
            120
        );
        arcticVolatilePlanet.setFaction("arctic_arctic_laboratories");

        Misc.initConditionMarket(arcticVolatilePlanet);

        MarketAPI arcticVolatileMarket = Global.getFactory().createMarket(
            "arctic_volatile_market",
            arcticVolatilePlanet.getName(),
            6
        );

        arcticVolatileMarket.setPrimaryEntity(arcticVolatilePlanet);
        arcticVolatilePlanet.setMarket(arcticVolatileMarket);

        arcticVolatileMarket.setSurveyLevel(MarketAPI.SurveyLevel.FULL);

        arcticVolatileMarket.getTariff().modifyFlat("generator", 0.3f);
        arcticVolatileMarket.setPlanetConditionMarketOnly(false);
        arcticVolatileMarket.addCondition(Conditions.VOLATILES_PLENTIFUL);
        arcticVolatileMarket.addCondition(Conditions.DENSE_ATMOSPHERE);
        arcticVolatileMarket.addCondition(Conditions.HIGH_GRAVITY);
        arcticVolatileMarket.addCondition(Conditions.POPULATION_6);

        arcticVolatileMarket.setFactionId("arctic_arctic_laboratories");

        arcticVolatileMarket.addIndustry(Industries.POPULATION);
        arcticVolatileMarket.addIndustry(Industries.MEGAPORT);
        arcticVolatileMarket.addIndustry(Industries.STARFORTRESS_HIGH);
        arcticVolatileMarket.addIndustry(Industries.MINING);

        arcticVolatileMarket.addSubmarket(Submarkets.SUBMARKET_BLACK);
        arcticVolatileMarket.addSubmarket(Submarkets.SUBMARKET_OPEN);
        arcticVolatileMarket.addSubmarket(Submarkets.SUBMARKET_STORAGE);

        EconomyAPI globalEconomy = Global.getSector().getEconomy();
        globalEconomy.addMarket(arcticVolatileMarket, false);

        // Set the auto jump points
        system.autogenerateHyperspaceJumpPoints(true, true);

        // The code below requires that Nexerelin is added as a library (not a dependency, it's only needed to compile the mod).
//        boolean isNexerelinEnabled = Global.getSettings().getModManager().isModEnabled("nexerelin");

//        if (!isNexerelinEnabled || SectorManager.getManager().isCorvusMode()) {
//                    new MySectorGen().generate(Global.getSector());
            // Add code that creates a new star system (will only run if Nexerelin's Random (corvus) mode is disabled).
//        }
    }
}
