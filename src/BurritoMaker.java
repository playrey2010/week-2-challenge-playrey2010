import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

public class BurritoMaker {

    static int j;
    static int whiteRiceCounter = 0, brownRiceCounter = 0,
            chickenCounter = 0, steakCounter = 0, carnitasCounter = 0, chorizoCounter = 0, sofritasCounter = 0, veggiesCounter = 0,
            pintoCounter = 0, blackBeanCounter = 0,
            mildSalsaCounter = 0, mediumSalsaCounter = 0, hotSalsaCounter = 0,
            lettuceCounter = 0, fajitaVeggCounter = 0,
            cheeseCounter = 0, guacCounter = 0, quesoCounter = 0, sourCreamCounter = 0;
    static double totalPrice = 0.0;

    public static void main(String[] args) {
        System.out.println("Price guide: base burrito is $3.00, EACH additional item is $0.50.\nFor more than one item per category (e.g. \"white & brown rice\"), you will be charged individually for each item ($1.00).\n");
        String[] burritos = new String[25];
        for (int i=0; i<25; i++) {
            burritos[i] = "Burrito " + (i+1) + ": "+ burritoMaker() + "\n";
        }
        for (int i=0; i<25; i++) {
            System.out.println(burritos[i]);
        }

        String countedItems = "This order has " + whiteRiceCounter + " white rice, " + brownRiceCounter + " brown rice, " + chickenCounter
                + " chicken, " + steakCounter + " steak, " + carnitasCounter + " carnitas, " + chorizoCounter + " chorizos, " + sofritasCounter
                + " sofritas, " + veggiesCounter + " veggies(as a meat option), " + blackBeanCounter + " black beans, " + pintoCounter
                + " pinto beans, " + mildSalsaCounter + " mild salsas, " + mediumSalsaCounter + " medium salsas, " + hotSalsaCounter + " hot salsas, "
                + fajitaVeggCounter + " fajitas, " + lettuceCounter + " lettuce, " + cheeseCounter + " cheese, "
                + guacCounter + " guac, " + quesoCounter + " quesos, " + sourCreamCounter + " sour cream, and the sum is $"
                + totalPrice;

        System.out.println("The counted items: " + "\n" + countedItems);
        // part 4 solution
        for (int i = 0; i<countedItems.length(); i++) {
            if (i % 50 == 0) {
                System.out.println();
            }
            System.out.print(countedItems.charAt(i));
        }

        System.out.println("\n\n\n");

        // part 5 solution
        String[] testArray = countedItems.split(" ");
//        System.out.println("test array length " + testArray.length);
//        System.out.println(testArray[0]);// I can use testArray[0].length() to see if it will exceed the 50 char limit
        String formattedReceipt = "";
//        static int j = 0;
        int lineLimit = 50;
        for (j = 0; j < testArray.length; j++) {
            if (testArray[j].length() + formattedReceipt.length() > lineLimit) {
                formattedReceipt += "\n";
                formattedReceipt += testArray[j] + " ";
                lineLimit += 50;
            }
            else {
                formattedReceipt += testArray[j] + " ";
            }
        }
//        System.out.println("j is at " + j);
        System.out.println(formattedReceipt);




        char[] itemsArray = new char[countedItems.length()];
        itemsArray = countedItems.toCharArray();

        for (int i = 0; i < itemsArray.length; i++) {
            System.out.print(itemsArray[i]);
        }


    }


    public static String burritoMaker() {
        String rice = ricePicker();
        String meat = meatPicker();
        String beans = beanPicker();
        String salsa = salsaPicker();
        String veggies = veggiePicker();
        String cheese = cheesePicker();
        String guac = guacPicker();
        String queso = quesoPicker();
        String sourCream = sourCreamPicker();
        double price = 3.0;
        NumberFormat currency = NumberFormat.getCurrencyInstance();


        // price controller
        if (rice.equals("white rice") || rice.equals("brown rice")) {
            if (rice.equals("white rice")){
                whiteRiceCounter++;
            }
            if (rice.equals("brown rice")){
                brownRiceCounter++;
            }

            price += .5;
        }
        if (rice.equals("white & brown rice")) {
            whiteRiceCounter++;
            brownRiceCounter++;
            price += 1.0;
        }
        if (meat.equals("chicken") || meat.equals("steak") || meat.equals("carnitas") || meat.equals("chorizo")
        || meat.equals("sofritas") || meat.equals("veggies")){
            if (meat.equals("chicken")) {
                chickenCounter++;
            }
            if (meat.equals("steak")) {
                steakCounter++;
            }
            if (meat.equals("carnitas")) {
                carnitasCounter++;
            }
            if (meat.equals("chorizo")) {
                chorizoCounter++;
            }
            if (meat.equals("sofritas")) {
                sofritasCounter++;
            }
            if (meat.equals("veggies")) {
                veggiesCounter++;
            }
            price += .5;
        }
        if (meat.equals("chk, stk, crn, chz, sfr, vggs")) {
            price += 3.0;
            chickenCounter++;
            steakCounter++;
            carnitasCounter++;
            chorizoCounter++;
            sofritasCounter++;
            veggiesCounter++;
        }
        if (beans.equals("pinto beans") || beans.equals("black beans")) {
            if (beans.equals("pinto beans")) {
                pintoCounter++;
            }
            if (beans.equals("black beans")) {
                blackBeanCounter++;
            }
            price += .5;
        }
        if (salsa.equals("mild salsa") || salsa.equals("medium salsa") || salsa.equals("hot salsa")){
            if (salsa.equals("mild salsa")) {
                mildSalsaCounter++;
            }
            if (salsa.equals("medium salsa")) {
                mediumSalsaCounter++;
            }
            if (salsa.equals("hot salsa")) {
                hotSalsaCounter++;
            }
            price += .5;
        }
        if (salsa.equals("mild, medium and hot salsa")) {
            price += 1.5;
            mildSalsaCounter++;
            mediumSalsaCounter++;
            hotSalsaCounter++;
        }
        if (veggies.equals("lettuce") || veggies.equals("fajita veggies")) {
            if (veggies.equals("lettuce")) {
                lettuceCounter++;
            }
            if (veggies.equals("fajita veggies")) {
                fajitaVeggCounter++;
            }
            price += .5;
        }
        if (veggies.equals("lettuce and f.veggies")) {
            price += 1.0;
            lettuceCounter++;
            fajitaVeggCounter++;
        }
        if (cheese.equals("cheese")) {
            price += .5;
            cheeseCounter++;
        }
        if (guac.equals("guac")) {
            price += .5;
            guacCounter++;
        }
        if (queso.equals("queso")) {
            price += .5;
            quesoCounter++;
        }
        if (sourCream.equals("sour cream")) {
            price += .5;
            sourCreamCounter++;
        }


        totalPrice += price;

        String burrito = rice + ", " + meat + ", " + beans + ", " + salsa + ", " + veggies + ", "
                + cheese + ", " + guac + ", " + queso + ", " + sourCream + "\tPrice: " + currency.format(price);

        // polishing the output so the yes or no options are not displayed for "no"
        if (burrito.contains("no cheese,")) {
            burrito = burrito.replace(" no cheese,", "");
        }
        if (burrito.contains("no guac,")) {
            burrito = burrito.replace(" no guac,", "");
        }
        if (burrito.contains("sin queso,")) {
            burrito = burrito.replace(" sin queso,", "");
        } if (burrito.contains("no sour cream")) {
            burrito = burrito.replace(", no sour cream", "");
        }



        return burrito ;
    }

    public static String ricePicker () {
        Random r = new Random();
        ArrayList<String> riceOptions = new ArrayList<>();
        riceOptions.add("white rice");
        riceOptions.add("brown rice");
        riceOptions.add("no rice");
        riceOptions.add("white & brown rice");
        return riceOptions.get(r.nextInt(riceOptions.size()));
    }

    public static String meatPicker () {
        Random r = new Random();
        ArrayList<String> meatOptions = new ArrayList<>();
        meatOptions.add("chicken");
        meatOptions.add("steak");
        meatOptions.add("carnitas");
        meatOptions.add("chorizo");
        meatOptions.add("sofritas");
        meatOptions.add("veggies");
        meatOptions.add("no meat");
        meatOptions.add("chk, stk, crn, chz, sfr, vggs");
        return meatOptions.get(r.nextInt(meatOptions.size()));
    }

    public static String beanPicker () {
        Random r = new Random();
        ArrayList<String> beanOptions = new ArrayList<>();
        beanOptions.add("pinto beans");
        beanOptions.add("black beans");
        beanOptions.add("no beans");
        return beanOptions.get(r.nextInt(beanOptions.size()));
    }

    public static String salsaPicker () {
        Random r = new Random();
        ArrayList<String> salsaOptions = new ArrayList<>();
        salsaOptions.add("mild salsa");
        salsaOptions.add("medium salsa");
        salsaOptions.add("hot salsa");
        salsaOptions.add("no salsa");
        salsaOptions.add("mild, medium and hot salsa");
        return salsaOptions.get(r.nextInt(salsaOptions.size()));
    }

    public static String veggiePicker () {
        Random r = new Random();
        ArrayList<String> veggieOptions = new ArrayList<>();
        veggieOptions.add("lettuce");
        veggieOptions.add("fajita veggies");
        veggieOptions.add("no veggies");
        veggieOptions.add("lettuce and f.veggies");
        return veggieOptions.get(r.nextInt(veggieOptions.size()));
    }

    public static String cheesePicker () {
        Random r = new Random();
        String [] cheese = new String[2];
        cheese[0] = "cheese";
        cheese[1] = "no cheese";
        return cheese[r.nextInt(cheese.length)];
    }

    public static String guacPicker () {
        Random r = new Random();
        String [] guac = new String[2];
        guac[0] = "guac";
        guac[1] = "no guac";
        return guac[r.nextInt(guac.length)];
    }

    public static String quesoPicker () {
        Random r = new Random();
        String [] queso = new String[2];
        queso[0] = "queso";
        queso[1] = "sin queso";
        return queso[r.nextInt(queso.length)];
    }

    public static String sourCreamPicker () {
        Random r = new Random();
        String [] sourCream = new String[2];
        sourCream[0] = "sour cream";
        sourCream[1] = "no sour cream";
        return sourCream[r.nextInt(sourCream.length)];
    }
}
