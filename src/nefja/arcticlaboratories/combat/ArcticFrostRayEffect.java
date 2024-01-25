package nefja.arcticlaboratories.combat;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.combat.*;
import com.fs.starfarer.api.combat.listeners.ApplyDamageResultAPI;
import com.fs.starfarer.api.graphics.SpriteAPI;
import com.fs.starfarer.api.impl.campaign.ids.Stats;
import com.fs.starfarer.api.util.FaderUtil;
import com.fs.starfarer.api.util.IntervalUtil;
import com.fs.starfarer.api.util.Misc;
import com.thoughtworks.xstream.mapper.Mapper;
import org.lwjgl.Sys;
import org.lwjgl.opengl.GL14;
import org.lwjgl.util.vector.Vector2f;

import java.awt.*;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class ArcticFrostRayEffect extends BaseCombatLayeredRenderingPlugin implements BeamEffectPlugin {

	private IntervalUtil fireInterval = new IntervalUtil(0.2f, 0.3f);
	private boolean wasZero = true;

	public void advance(float amount, CombatEngineAPI engine, BeamAPI beam) {
//		advanceEffect(amount, beam);
		CombatEntityAPI target = beam.getDamageTarget();
		if (beam.getBrightness() < 1f || !(target instanceof ShipAPI)) return;
		// All this commented out stuff was for ArcticFrostEffect, a failed attempt at adding a frozen effect to ships
//		float dur = beam.getDamage().getDpsDuration();
		// needed because when the ship is in fast-time, dpsDuration will not be reset every frame as it should be
//		if (!wasZero) dur = 0;
//		wasZero = beam.getDamage().getDpsDuration() <= 0;
//		fireInterval.advance(dur);
//		if (fireInterval.intervalElapsed()) {
//			ShipAPI ship = (ShipAPI) target;
//			boolean hitShield = target.getShield() != null && target.getShield().isWithinArc(beam.getTo());
//			float pierceChance = ((ShipAPI)target).getHardFluxLevel() - 0.1f;
//			pierceChance *= ship.getMutableStats().getDynamic().getValue(Stats.SHIELD_PIERCED_MULT);
//
//			boolean piercedShield = hitShield && (float) Math.random() < pierceChance;
			//piercedShield = true;

//			if (!hitShield) {
//				Global.getSoundPlayer().playSound("cryoflamer_hit_solid", 1f, 1f, target.getLocation(), target.getVelocity());
//				Vector2f point = beam.getRayEndPrevFrame();
//				Vector2f offset = Vector2f.sub(point, target.getLocation(), new Vector2f());
//				offset = Misc.rotateAroundOrigin(offset, -target.getFacing());
//				ArcticFrostEffect effect = new ArcticFrostEffect(ship, offset);
//				CombatEntityAPI e = engine.addLayeredRenderingPlugin(effect);
//				e.getLocation().set(point);
//			}
//			else {
//				Global.getSoundPlayer().playSound("cryoflamer_hit_shield_solid", 1f, 1f, target.getLocation(), target.getVelocity());
//			}
//		}
		Vector2f vel = new Vector2f();
		vel.set(target.getVelocity());

		Vector2f point = beam.getRayEndPrevFrame();

		Color color = new Color(220, 220, 255);
		float size = beam.getWidth() * 1f;
		//size = Misc.getHitGlowSize(size, projectile.getDamage().getBaseDamage(), damageResult);
		float sizeMult = beam.getHitGlowRadius() / 100f;
//		sizeMult = 1.5f;
//		System.out.println(sizeMult);
		float dur2 = 1f;
		float rampUp = 0f;
		Color c = Misc.scaleAlpha(color, beam.getBrightness());
		engine.addNebulaParticle(point, vel, size, 5f + 3f * sizeMult,
				rampUp, 0f, dur2, c);
	}
}




