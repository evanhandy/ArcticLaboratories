package nefja.arcticlaboratories.world;

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

public class ArcticStar {

    public void generate(SectorAPI sector) {
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
                1300,
                120
        );
        arcticVolatilePlanet.setFaction("arctic_laboratories");

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

        arcticVolatileMarket.setFactionId("arctic_laboratories");

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
    }
}
