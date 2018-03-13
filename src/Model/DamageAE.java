package Model;

public class DamageAE extends ContAE {
    private int DamageAm;
    private int duration;

    public DamageAE(dur, Am) {
        super(dur, Am);
        setDamageAm(Am);
        setDuration(dur);
    }

    public int getDamageAm() {
        return DamageAm;
    }

    public void setDamageAm(int damageAm) {
        DamageAm = damageAm;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}

