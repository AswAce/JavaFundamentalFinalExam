package com.asen.test;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Concert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, ArrayList<String>> bands = new TreeMap<>();
        Map<String, Integer> bandsTime = new TreeMap<>();
        String command = scanner.nextLine();
        while (!"start of concert".equals(command)) {
            String[] token = command.split(";\\s+|,\\s+");
            String order = token[0];
            String bandName;
            if ("Add".equals(order)) {
                bandName = token[1];
                ArrayList<String> tempSIngers = bands.get(bandName);
                if (tempSIngers == null) {
                    bands.put(bandName, new ArrayList<>());
                }
                for (int i = 2; i < token.length; i++) {
                    if (!bands.get(bandName).contains(token[i])) {
                        bands.get(bandName).add(token[i]);
                    }
                }
                bandsTime.putIfAbsent(bandName, 0);

            } else if ("Play".equals(order)) {
                bandName = token[1];
                int bandPlay = Integer.parseInt(token[2].trim());
                bandsTime.putIfAbsent(bandName, 0);
                bandsTime.put(bandName, bandPlay + bandsTime.get(bandName));
                bands.putIfAbsent(bandName, new ArrayList<>());
            }
            command = scanner.nextLine();
        }
        String bandArtists=scanner.nextLine();

        int playTime=0;
        for (Integer value : bandsTime.values()) {
            playTime+=value;
        }
        System.out.println("Total time: "+playTime);
        bandsTime.entrySet().stream().sorted((a1,a2)->{
            int match=a2.getValue()-a1.getValue();
            if (match==0){
                return a1.getKey().compareTo(a2.getKey());
            }
            else return match;

        }).forEach(e-> System.out.println(String.format("%s -> %s",e.getKey(),e.getValue())));
        System.out.println(bandArtists);
       bands.get(bandArtists).forEach(e-> System.out.println(String.format("=> %s",e)));

    }


}
