package mindtech.expand.block.power;

import arc.math.Mathf;
import arc.util.Time;
import mindustry.content.Fx;
import mindustry.entities.Damage;
import mindustry.type.Liquid;
import mindustry.world.blocks.power.NuclearReactor;
import mindustry.world.meta.Stat;

public class LiquidNuclearReactor extends NuclearReactor {
    public float heating = 0.015f;
    public float coolantPower = 0.5f;
    public float explosionRadius = 20f;
    public float explosionDamage = 1500f;

    public Liquid fuelLiquid;

    public LiquidNuclearReactor(String name) {
        super(name);
        hasLiquids = true;
        hasPower = true;
        outputsPower = true;
    }

    @Override
    public void setStats() {
        super.setStats();
        if (fuelLiquid != null) {
            stats.add(Stat.input, fuelLiquid);
        }
    }

    public class LiquidNuclearReactor extends GeneratorBuild {
        public float heat = 0f;

        @Override
        public void updateTile() {
            if (fuelLiquid == null) return;

            float fuelAmount = liquids.get(fuelLiquid);

            if (fuelAmount > 0.001f && enabled) {
                productionEfficiency = 1f;

                heat += heating * productionEfficiency * Time.delta;

                liquids.remove(fuelLiquid, 0.05f * Time.delta);
            } else {
                productionEfficiency = 0f;
            }

            if (heat > 0) {
                Liquid coolant = liquids.current();
                if (coolant != null && coolant != fuelLiquid && liquids.get(coolant) > 0) {
                    float coolantAmount = liquids.get(coolant);
                    float coolingNeeded = heat / (coolant.heatCapacity * coolantPower);
                    float usedCoolant = Math.min(coolantAmount, coolingNeeded);

                    heat -= usedCoolant * coolant.heatCapacity * coolantPower;
                    liquids.remove(coolant, usedCoolant);
                };
                heat = Math.max(0f, heat - 0.0005f * Time.delta);
            }

            if (heat >= 1f) {
                kill();
            }
        }

        @Override
        public void onDestroyed() {
            super.onDestroyed();
            if (heat >= 0.4f) {
                Damage.dynamicExplosion(x, y, explosionDamage, 0.5f, bounds() /2f, explosionRadius * 0.8f, true, true);
            }
        }
    }
}