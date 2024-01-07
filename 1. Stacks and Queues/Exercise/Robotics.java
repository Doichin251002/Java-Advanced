package Queues;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] robotsArr = scan.nextLine().split(";");

        LinkedHashMap<String, Integer> robotsTime = getRobotsMap(robotsArr);
        LinkedHashMap<String, Integer> robotsWorkingTime = getRobotsWorkingTimeMap(robotsArr);

        String startTime = scan.nextLine();
        int startTimeSeconds = getStartTimeSeconds(startTime);

        ArrayDeque<String> products = new ArrayDeque<>();
        String product = scan.nextLine();
        while (!product.equals("End")) {
            products.offer(product);
            product = scan.nextLine();
        }

        while (!products.isEmpty()) {
            String currentProduct = products.poll();
            boolean isToken = false;
            startTimeSeconds++;
            decreaseWorkingTime(robotsWorkingTime);
            for (Map.Entry<String, Integer> robot : robotsWorkingTime.entrySet()) {
                if (robot.getValue() == 0) {
                    System.out.println(robot.getKey() + " - " + currentProduct + getStartTime(startTimeSeconds));
                    robotsWorkingTime.put(robot.getKey(), robotsTime.get(robot.getKey()));
                    isToken = true;
                    break;
                }
            }

            if (!isToken) {
                products.offer(currentProduct);
            }
        }
    }

    private static int getStartTimeSeconds(String startTime) {
        int hours = Integer.parseInt(startTime.split(":")[0]);
        int minutes = Integer.parseInt(startTime.split(":")[1]);
        int seconds = Integer.parseInt(startTime.split(":")[2]);
        return hours * 3600 + minutes * 60 + seconds;
    }

    private static LinkedHashMap<String, Integer> getRobotsMap(String[] robotsArr) {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (String robot : robotsArr) {
            String robotName = robot.split("-")[0];
            int processingTime = Integer.parseInt(robot.split("-")[1]);

            robots.put(robotName, processingTime);
        }
        return robots;
    }

    private static LinkedHashMap<String, Integer> getRobotsWorkingTimeMap(String[] robotsArr) {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (String robot : robotsArr) {
            String robotName = robot.split("-")[0];

            robots.put(robotName, 0);
        }
        return robots;
    }

    private static String getStartTime (int startTimeSeconds) {
        int hours = (startTimeSeconds / 3600) % 24;
        int minutes = startTimeSeconds % 3600 / 60;
        int seconds = startTimeSeconds % 60;

        return String.format(" [%02d:%02d:%02d]", hours, minutes, seconds);
    }

    private static void decreaseWorkingTime(LinkedHashMap<String, Integer> robotsWorkingTime) {
        for (Map.Entry<String, Integer> robot : robotsWorkingTime.entrySet()) {
            if (robot.getValue() > 0) {
                robotsWorkingTime.put(robot.getKey(), robot.getValue() - 1);
            }
        }
    }
}
