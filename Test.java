public class Test {
    private int testAmount = 0;
    private int amountPassed = 0;

    public void run() {
        int[] a = new int[] { 0, 3, 2, 1 };
        Complex poly = new Complex(a);
        boolean criteria = poly.getLength() == a.length;
        create(criteria, "getLength()");

        criteria = poly.getCoefficent(2) == a[2];
        create(criteria, "getCoefficent()");

        criteria = true;
        int[] gottenCoefficents = poly.getCoefficents();
        for (int i = 0; i < a.length; i++)
            if (gottenCoefficents[i] != a[i])
                criteria = false;
        create(criteria, "getCoefficents()");

        poly.addCoefficent(0, 1);
        criteria = poly.getCoefficent(0) == 1;
        create(criteria, "addCoefficent()");

        for (int d : a)
            System.out.println(d);
        poly = new Complex(a);
        poly.subtractCoefficent(0, 1);
        criteria = poly.getCoefficent(0) == -1;
        create(criteria, "subtractCoefficent()");

        int[] b = new int[] { 4, 1, 2, 3 };
        Complex poly2 = new Complex(b);
        poly = new Complex(a);
        poly.add(poly2);
        criteria = true;
        for (int i : poly.getCoefficents())
            if (i != 4)
                criteria = false;
        create(criteria, "add()");

        poly = new Complex(a);
        poly2 = new Complex(a);
        poly.subtract(poly2);
        criteria = true;
        for (int i : poly.getCoefficents())
            if (i != 0)
                criteria = false;
        create(criteria, "subtract()");

        stop();
    }

    private void create(boolean criteria, String name) {
        System.out.println("Test");
        System.out.println("-- id: " + ++testAmount);
        System.out.println("-- name: " + name);

        if (criteria) {
            System.out.println("-- passed");
            amountPassed++;
            return;
        }

        System.out.println("-- failed");
    }

    private void stop() {
        System.out.println();
        System.out.println(amountPassed + " out of " + testAmount + " passed");
        if (testAmount != amountPassed)
            System.out.println("Haha you suck (:");
    }
}
