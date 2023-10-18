package unl.soc;

/**
 * Name: Luciano Carvalho (lguedesdecarvalhon2@huskers.unl.edu)
 * 
 * Date: 2023 - 08 - 06
 * 
 * Uses the argument line to say the remain gigabites by the user, the average
 * use and how much can he uses.
 */

public class DataPlan {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.printf("ERROR: incorrect number of command line arguments\n\n");

        }

        double numberGBTotal = Double.parseDouble(args[0]);
        int dayPeriod = Integer.parseInt(args[1]);
        double totalUsedGB = Double.parseDouble(args[2]);

        double expectedDailyAverage = numberGBTotal / 30.0;
        double realDailyAverage = (totalUsedGB) / (dayPeriod);
        boolean valid = true;

        // error conditions

        if (dayPeriod < 1 || dayPeriod > 30) {
            System.out.printf(
                    "ERROR: incorrect number of command line arguments!! Input a valid day between 1 - 30!\n\n");
            valid = false;
        }
        if (numberGBTotal < 0 || totalUsedGB < 0) {
            System.out
                    .printf("ERROR: incorrect number of command line arguments!! Impossible negative GB values!!\n\n");
            valid = false;
        }

        // validation
        if (valid) {
            System.out.printf("%d days used, %d days remainig\n", dayPeriod, 30 - dayPeriod);
            System.out.printf("Average daily use: %.3f GB/day\n\n", realDailyAverage);

            if (realDailyAverage > expectedDailyAverage && ((numberGBTotal - totalUsedGB) / (30 - dayPeriod)) > 0) {
                System.out.printf("You are EXCEEDING your average daily use (%.3f GB/day).\n", expectedDailyAverage);
                System.out.printf("Continuing this high usage, you'll exceed your data plan by %.3f GB.\n\n",
                        (realDailyAverage * (30 - dayPeriod) + totalUsedGB) - (numberGBTotal));

                System.out.printf("To stay below your data plan, use no more than %.3f GB/day.\n",
                        (numberGBTotal - totalUsedGB) / (30 - dayPeriod));
            } else if (realDailyAverage < expectedDailyAverage
                    && (numberGBTotal - totalUsedGB) / (30 - dayPeriod) > 0) {
                System.out.printf("You are at or below your average daily use (%.3f GB/day)\n", expectedDailyAverage);
                System.out.printf("You can use up to %.3f GB/day and stay bellow your data plan limit.\n",
                        (numberGBTotal - totalUsedGB) / (30 - dayPeriod));
            } else {
                System.out.printf(
                        "You have already met your limit for this month.  Looks like you're getting some overage charges...");
            }
        }
    }

}
