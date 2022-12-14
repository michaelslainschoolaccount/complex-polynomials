import java.util.ArrayList;

public class Complex {
    private int[] coefficents;

    public Complex(int[] coefficents) {
        this.coefficents = new int[coefficents.length];

        // shallow copy
        for (int i = 0; i < getLength(); i++)
            this.coefficents[i] = coefficents[i];
    }

    public int getLength() {
        return coefficents.length;
    }

    public int getCoefficent(int index) {
        return coefficents[index];
    }

    public int[] getCoefficents() {
        return coefficents;
    }

    public void addCoefficent(int index, int value) {
        coefficents[index] += value;
    }

    public void subtractCoefficent(int index, int value) {
        coefficents[index] -= value;
    }

    public Complex add(Complex other) {
        int minLength = Math.min(getLength(), other.getLength());

        for (int i = 0; i < minLength; i++)
            addCoefficent(i, other.getCoefficent(i));

        return this;
    }

    public Complex subtract(Complex other) {
        int minLength = Math.min(getLength(), other.getLength());

        for (int i = 0; i < minLength; i++)
            subtractCoefficent(i, other.getCoefficent(i));

        return this;
    }

    public Complex multiply(Complex other) {
        int[] otherCoefficents = other.getCoefficents();

        ArrayList<Complex> polys = new ArrayList<Complex>();

        for (int i = 0; i < other.getLength(); i++) {
            int[] coefficents = new int[other.getLength() * getLength()];

            for (int j = 0; j < getLength(); j++) {
                int degree = i + j;
                coefficents[degree] = otherCoefficents[i] * coefficents[i];
            }

            polys.add(new Complex(coefficents));
        }

        Complex finalPoly = polys.get(0);
        for (Complex poly : polys)
            finalPoly.add(poly);

        return finalPoly;
    }

    public String toString() {
        String out = "[ ";

        for (int coefficent : coefficents)
            out += coefficent + " , ";

        out += " ]";

        return out;
    }
}