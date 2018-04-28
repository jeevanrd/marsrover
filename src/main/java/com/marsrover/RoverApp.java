package com.marsrover;

import com.marsrover.parser.InputUtil;
import com.marsrover.parser.StringCommandParser;
import com.marsrover.universe.Plateau;
import com.marsrover.universe.RoverPosition;
import com.sun.deploy.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RoverApp {
    public static void main(String args[]) throws IOException {
        if(args.length <= 0) {
            System.out.println("Please pass an input file argument");
            return;
        }

        String filePath = args[0];
        List<String> inputFileAsList = InputUtil.parseFile(filePath);
        List<String> output = InputUtil.process(inputFileAsList);
        System.out.println("INPUT AND OUTPUT:");
        System.out.println("Test Input:");
        System.out.println(StringUtils.join(inputFileAsList, "\n"));
        System.out.println("\nTest Output:");
        System.out.println(StringUtils.join(output, "\n"));
    }
}
