package com.marsrover.parser;

import com.marsrover.MarsRover;
import com.marsrover.universe.Coordinates;
import com.marsrover.universe.Direction;
import com.marsrover.universe.Plateau;
import com.marsrover.universe.RoverPosition;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeevan on 28/04/18.
 */

public class InputUtil {
    public static Plateau parsePlateauInput(String plateauInput) {
        String[] inputArray = plateauInput.split(" ");
        int plateauUpperBoundCoordinateX = Integer.parseInt(inputArray[0]);
        int plateauUpperBoundCoordinateY = Integer.parseInt(inputArray[1]);
        return new Plateau(plateauUpperBoundCoordinateX, plateauUpperBoundCoordinateY);
    }

    public static RoverPosition parseRoverPositionInput(String positionInput) {
        String[] inputArray = positionInput.split(" ");
        int x = Integer.parseInt(inputArray[0]);
        int y = Integer.parseInt(inputArray[1]);
        Coordinates coords = new Coordinates(x, y);
        String direction = inputArray[2];
        Direction d = Direction.valueOf(direction);
        RoverPosition rp = new RoverPosition(coords, d);
        return rp;
    }

    public static ArrayList<String> parseFile(String filepath) throws IOException {
        ArrayList<String> inputsFromFile = new ArrayList<>();
        File file = new File(filepath);
        InputStream inputStream = new FileInputStream(file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String fileLine;

        while ((fileLine = bufferedReader.readLine()) != null)
            inputsFromFile.add(fileLine);

        bufferedReader.close();
        return inputsFromFile;
    }

    public static List<String> process(List<String> lines){
        Plateau p;
        int size = lines.size();

        List<String> output = new ArrayList<>();
        if(size > 0) {
            try {
                p = InputUtil.parsePlateauInput(lines.get(0));
            } catch(Exception e) {
                System.out.println("Invalid plateau coordinates");
                return output;
            }

            for(int i=1;i<size;i=i+2) {
                RoverPosition rp;
                try {
                    rp = InputUtil.parseRoverPositionInput(lines.get(i));
                } catch(Exception e) {
                    output.add("Invalid Rover position input " + e.getMessage());
                    continue;
                }

                try {
                    StringCommandParser scp = new StringCommandParser(lines.get(i+1));
                    scp.validateCommandsList();
                } catch(Exception e) {
                    output.add("Invalid Rover command input " + e.getMessage());
                    continue;
                }

                MarsRover mr = new MarsRover(p, rp.getDirection(), rp.getCoordinates());
                mr.run(lines.get(i+1));
                output.add(mr.currentLocation());
            }
        }

        return output;
    }

}
