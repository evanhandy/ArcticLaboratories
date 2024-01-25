package nefja.arcticlaboratories.world;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.PlanetAPI;
import com.fs.starfarer.api.campaign.SectorAPI;
import com.fs.starfarer.api.campaign.StarSystemAPI;
import com.fs.starfarer.api.campaign.econ.EconomyAPI;
import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.impl.campaign.ids.*;
import com.fs.starfarer.api.util.Misc;

import java.awt.*;

public class ArcticStar {

    public void generate(SectorAPI sector) {
        // Used for adding markets to the economy
        EconomyAPI globalEconomy = sector.getEconomy();

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
                1500,
                120
        );

        // Give the planet hab_glows
        arcticVolatilePlanet.getSpec().setGlowTexture(Global.getSettings().getSpriteName("hab_glows", "volturn"));
        arcticVolatilePlanet.getSpec().setGlowColor(new Color(250,225,195,255));
        arcticVolatilePlanet.getSpec().setUseReverseLightForGlow(true);
        arcticVolatilePlanet.applySpecChanges();
        arcticVolatilePlanet.setFaction("arctic_laboratories");

        // Set up the market
        Misc.initConditionMarket(arcticVolatilePlanet);

        String[] arcticVolatileConditions = {Conditions.VOLATILES_PLENTIFUL, Conditions.HIGH_GRAVITY, Conditions.DENSE_ATMOSPHERE, Conditions.POPULATION_6};
        String[] arcticVolatileIndustries = {Industries.POPULATION, Industries.MEGAPORT, Industries.MINING, Industries.STARFORTRESS_HIGH};
        String[] arcticVolatileSubmarkets = {Submarkets.SUBMARKET_OPEN, Submarkets.SUBMARKET_BLACK, Submarkets.SUBMARKET_STORAGE};
        generateMarket(arcticVolatilePlanet, 6, "arctic_laboratories", arcticVolatileConditions, arcticVolatileIndustries, arcticVolatileSubmarkets, false, globalEconomy, true);

        // Set the auto jump points
        system.autogenerateHyperspaceJumpPoints(true, true);
    }

    private void generateMarket(PlanetAPI planet, int size, String factionId, String[] conditions, String[] industries, String[] submarkets, boolean freePort, EconomyAPI globalEconomy, boolean withJunkAndChatter) {
        String marketId = planet.getId() + "_market";
        String marketName = planet.getName();
        MarketAPI newMarket = Global.getFactory().createMarket(marketId, marketName, size);

        newMarket.setPrimaryEntity(planet);
        planet.setMarket(newMarket);

        newMarket.setSurveyLevel(MarketAPI.SurveyLevel.FULL);

        newMarket.getTariff().modifyFlat("generator", 0.3f);
        newMarket.setPlanetConditionMarketOnly(false);

        newMarket.setFactionId(factionId);

        for (String condition : conditions) {
            newMarket.addCondition(condition);
        }

        for (String industry : industries) {
            newMarket.addIndustry(industry);
        }

        for (String submarket : submarkets) {
            newMarket.addSubmarket(submarket);
        }

        newMarket.setFreePort(freePort);

        globalEconomy.addMarket(newMarket, withJunkAndChatter);
    }

    private void generateMarketConditionsOnly(PlanetAPI planet, MarketAPI.SurveyLevel surveyLevel, String[] conditions) {
        String marketId = planet.getId() + "_market";
        String marketName = planet.getName();
        MarketAPI newMarket = Global.getFactory().createMarket(marketId, marketName, 0);

        newMarket.setPrimaryEntity(planet);
        planet.setMarket(newMarket);

        newMarket.setSurveyLevel(surveyLevel);

        newMarket.setPlanetConditionMarketOnly(true);

        // Might not need this line
        // newMarket.setFactionId(Factions.NEUTRAL);

        for (String condition : conditions) {
            newMarket.addCondition(condition);
        }
    }
}
