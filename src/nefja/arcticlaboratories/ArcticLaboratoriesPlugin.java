package nefja.arcticlaboratories;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import nefja.arcticlaboratories.world.ArcticLaboratoriesGen;

public class ArcticLaboratoriesPlugin extends BaseModPlugin {
//    @Override
//    public void onApplicationLoad() throws Exception {
//        // put dependency checks here
//        super.onApplicationLoad();
//
//        // Test that the .jar is loaded and working, using the most obnoxious way possible.
//        // throw new RuntimeException("Template mod loaded! Remove this crash in TemplateModPlugin.");
//    }

    @Override
    public void onNewGame() {
        new ArcticLaboratoriesGen().generate(Global.getSector());
    }
}
