public class Rational implements Showable, Arithmetic {
    private int mone, mechane;

    public Rational(int mone, int mechane) {
        if (mechane == 0) throw new IllegalArgumentException();

        this.mone = mone;
        this.mechane = mechane;
    }

    public Rational() {
        this(1, 2);
    }

    public Rational(Rational rational) {
        this(rational.mone, rational.mechane);
    }

    @Override
    public String toString() {
        return String.format("%d/%d", mone, mechane);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;

        if (object instanceof Rational) {
            final Rational rational = (Rational) object;

            return ((double) mone / (double) mechane) == ((double) rational.mone / (double) rational.mechane);
        } else return false;
    }

    @Override
    public void show() {
        System.out.println(toString());
    }

    @Override
    public Rational add(Arithmetic object) {
        if (object instanceof Rational) {
            final Rational rational = (Rational) object;

            return new Rational(rational.mone * mechane, rational.mechane * mone);
        } else return null;
    }

    @Override
    public Rational sub(Arithmetic object) {
        if (object instanceof Rational) {
            final Rational rational = (Rational) object;

            return new Rational(mone * rational.mechane - rational.mone * mechane, rational.mechane * mechane);
        } else return null;
    }

    @Override
    public Rational mul(Arithmetic object) {
        if (object instanceof Rational) {
            final Rational rational = (Rational) object;

            return new Rational(rational.mone * mone, rational.mechane * mechane);
        } else return null;
    }

    @Override
    public Rational div(Arithmetic object) {
        if (object instanceof Rational) {
            if (mechane == 0 || ((Rational) object).mechane == 0) throw new IllegalArgumentException();

            final Rational rational = (Rational) object;

            return new Rational(mone * rational.mechane, mechane * rational.mone);
        } else return null;
    }

    @Override
    public Rational clone() {
        return new Rational(mone, mechane);
    }
}
