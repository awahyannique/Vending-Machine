package com.company;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    double dime, nickel, quater, OneDollar, FiveDollar, Tot;

    double tDime = 20, tNickel = 20, tQuarter = 20, tOneDollar = 20, tFiveDollar = 20;

    short Coke = 30, Pepsi = 30, Snickers = 30, Chexmix = 30, Doritos = 30;

    Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        /*double dime, nickel, quater, OneDollar, FiveDollar, Tot;

        double tDime = 20, tNickel = 20, tQuarter = 20, tOneDollar = 20, tFiveDollar = 20;

        short Coke = 30, Pepsi = 30, Snickers = 30, Chexmix = 30, Doritos = 30;*/

        Scanner scanner = new Scanner(System.in);

        int userIput;
        boolean check = true;
        while (check) {

            System.out.println(" Welcome to the Vending Machine");

            System.out.println(" Please enter 1 to withdraw coke");
            System.out.println(" Please enter 2 to withdraw Doritos");
            System.out.println(" Please enter 3 to withdraw Snickers");

            System.out.println(" Please enter 4 to withdraw Chex Mix,");
            System.out.println(" Please enter 5 to withdraw Pepsi");
            System.out.println(" Please enter 6 for admin access");
            System.out.println(" Please enter 7 to exit ");

            userIput = scanner.nextInt();
            Main main = new Main();
            main.Vending(userIput);

    }

}

    public  void refill(){
        if (Coke < 5) {
            Coke = 30;
        } if (Pepsi < 5) {
            Pepsi = 30;
        } if (Snickers < 5) {
            Snickers = 30;
        } if (Chexmix < 5) {
            Chexmix = 30;
        } if (Doritos < 5) {
            Doritos = 30;
        } if (tDime < 30) {
            tDime = 20;
        } if (tNickel < 20) {
            tNickel = 20;
        } if (tQuarter < 20) {
            tQuarter = 20;
        } if (tOneDollar < 20) {
            tOneDollar = 20;
        } if (tFiveDollar < 20) {
            tFiveDollar = 20;
        }

    }


    public static double getTotalCoin(double Nickel, double Dime, double Quarter, double OneDollar, double FiveDollar){
        double D;

        D = ((Nickel * 5) + (Dime * 10) + (Quarter * 25) + (OneDollar * 100) + (FiveDollar * 500)) / 100;

        return D;
    }

    public static void emptyContainer(double tDime, double tNickel, double tQuarter, double tOneDollar, double tFiveDollar) {

        if (tDime > 100) {
            tDime = 20;
        } if (tNickel > 100) {
            tNickel = 20;
        } if (tQuarter > 100) {
            tQuarter = 20;
        } if (tOneDollar > 100) {
            tOneDollar = 20;
        } if (tFiveDollar > 100) {
            tFiveDollar = 20;
        }
    }

    public void returnCoin(double input, double cost) {

        double change = input - cost;

        if (change > 1) {
            tOneDollar = tOneDollar - (int)change;
            change = change - (int)change;
            refill();
        } if (change > .25) {
            tQuarter = tQuarter - (int)(change / 0.25);
            change = change - (((int)(change / 0.25))*0.25);
            refill();
        } if (change > .10){
            tNickel = tNickel - (int)(change / 0.10);
            change = change - (((int)(change / 0.10))*0.10);
            refill();
        } if (change > .05) {
            tDime = tDime - (int)(change / 0.05);
            change = change - (((int)(change / 0.05))*0.05);
            refill();
        }

    }


    public  void insertCoin() {
        System.out.println(" Please enter the number of Dimes");
        dime = scanner.nextDouble();
        tDime =+ dime;

        System.out.println(" Please enter the number of Nickels");
        nickel = scanner.nextDouble();
        tNickel = tNickel + nickel;

        System.out.println(" Please enter the number of Quarters ");
        quater = scanner.nextDouble();
        tQuarter = tQuarter + quater;


        System.out.println(" Please enter the number of One Dollar Bills ");
        OneDollar = scanner.nextDouble();
        tOneDollar = tOneDollar + OneDollar;


        System.out.println(" Please enter the number of Five Dollar Bills");
        FiveDollar = scanner.nextDouble();
        tFiveDollar = tFiveDollar + FiveDollar;
    }

    public  void Vending(int choice) {

        double tsales, laborcost, costofitems, overhead;
        switch (choice) {
            case 1:
                insertCoin();
                emptyContainer(tDime, tNickel, tQuarter, tOneDollar, tFiveDollar);
                Tot = getTotalCoin(dime, nickel, quater, OneDollar, tFiveDollar);

                if (Tot > 0.95) {
                    Coke--;
                    refill();
                    System.out.println("Please collect your coke and collect your extra " +(Tot - 0.95) + " from cah dispenser");
                    returnCoin(Tot, 0.95);
                } else if (Tot < 0.95) {
                    System.out.println("Coke costs $0.95, Please Enter " + (0.95 - Tot) +  "more.");
                }
                break;
            case 2:

                insertCoin();
                emptyContainer(tDime, tNickel, tQuarter, tOneDollar, tFiveDollar);
                Tot = getTotalCoin(dime, nickel, quater, OneDollar, FiveDollar);
                if (Tot > 0.75) {

                    Doritos--;
                    refill();
                    System.out.println("Please collect your Doritos and collect your extra " + (Tot - 0.75) + " from the cash dispenser");
                    returnCoin(Tot, 0.75);
                } else if (Tot < 0.75) {
                    System.out.println("Doritos costs $0.75, Enter" + (0.75 - Tot) + " more.");
                }
                break;

            case 3:

                insertCoin();
                emptyContainer(tDime, tNickel, tQuarter, tOneDollar, tFiveDollar);
                Tot = getTotalCoin(dime, nickel, quater, OneDollar, FiveDollar);

                if (Tot > 0.55) {
                    Snickers--;
                    refill();

                    System.out.println("Please collect your Snickers and collect your extra " +  (Tot - 0.75 )+ " from the cash dispenser");
                    returnCoin(Tot, 0.55);

                } else if (Tot < 0.55) {
                    System.out.println("\"Snickers cost $0.55, Please enter "  + (0.55 - Tot) + " more.");
                }

                break;

            case 4:

                insertCoin();
                emptyContainer(tDime, tNickel, tQuarter, tOneDollar, tFiveDollar);
                Tot = getTotalCoin(dime, nickel, quater, OneDollar, FiveDollar);

                if (Tot > 0.60) {
                    Chexmix--;
                    refill();
                    System.out.println(" Please collect your Chexmix and collect your extra " + (Tot - 0.60) +"from the cash dispenser");
                    returnCoin(Tot, 0.60);

                } else if (Tot < 0.60) {
                    System.out.println("ChexMix cost 0.60, Please enter " + (0.60 - Tot) + " more.");
                }

                break;

            case 5:

                insertCoin();
                emptyContainer(tDime, tNickel, tQuarter, tOneDollar, tFiveDollar);
                Tot = getTotalCoin(dime, nickel, quater, OneDollar, FiveDollar);

                if (Tot > 0.90) {
                    Pepsi--;
                    refill();
                    System.out.println("Please collect your Pepsi and collect your extra " + (Tot - 0.90) + " from the cash dispenser");
                    returnCoin(Tot, 0.90);
                } else if (Tot < 0.90) {
                    System.out.println("Pepsi costs $0.90, Please enter " + (0.90 - Tot) + " more.");
                }

                break;

            case 6:

                System.out.println("Total coin in container are " + tDime + " tDime, " + tNickel + "Nickel ," + tQuarter + "Quarter");
                System.out.println(tOneDollar + " One Dollar, and " +  tFiveDollar + " Five Dollar");
                System.out.println("Coke sales: " + (30 - Coke));
                System.out.println("Doritos sales: " + (30 - Doritos));
                System.out.println("Snickers sales:: " + (30 - Snickers));
                System.out.println("Chex Mix sales: " + (30 - Chexmix));
                System.out.println("Pepsi sales: " + (30 - Pepsi));

                tsales = (.95*(30 - Coke)) + (0.75*(30 - Doritos)) + (.55*(30 - Snickers)) + (.6*(30 - Chexmix)) + (.9* (30 - Pepsi));
                System.out.println("Total sales (in amount): " + (tsales));

                costofitems = .35*tsales;
                laborcost = .25*tsales;
                overhead = .05*tsales;
                System.out.println("The cost of items are " + (costofitems));
                System.out.println("The labor cost are " + (laborcost));
                System.out.println("The overheads are " + (overhead));
                break;

            case 7:
                exit(0);
                break;
        }

    }
}
