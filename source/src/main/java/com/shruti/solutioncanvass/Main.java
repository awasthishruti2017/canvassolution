package com.shruti.solutioncanvass;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Canvas         canvas;
    private static Scanner        scanner;
    private static EntityFactory  entityFactory;

    public static void main(String[] args) throws NumberFormatException, InterruptedException {
        scanner = new Scanner(System.in);
        entityFactory = new EntityFactory();

        System.out.println("Enter command:");

        while (true) {
            process(scanner.nextLine());
            System.out.println("Enter command:");
        }
    }

    private static void process(String commandLine) {
        Command command = null;

        try {
            commandLine = commandLine.trim().replaceAll(" {2}", " ");
            String[] split       = commandLine.split(" ");
            String   mainCommand = split[0].toUpperCase();
            String[] params      = Arrays.copyOfRange(split, 1, split.length);
            switch (mainCommand) {
                case "Q":
                    command =  new QuitCommand();
                    break;
                case "C":
                	command = new CreateCommand(params);
                	break;
                case "L":
                	command = new DrawLineCommand(params);
                	break;
                case "R":
                	command = new DrawRectangleCommand(params);
                	break;
                case "B":
                	command = new BucketFillCommand(params);
                	break;
                default:
                    System.out.println("Please enter a valid command.");
                    command = new BlankCommand();
                    break;
            }
        	        	
        }   catch (InvalidCommandParams invalidCommandParams) {
            System.out.println("Command syntax is not correct: " + invalidCommandParams.getMessage());
            System.out.println("Refer to following correct syntax: \n" + invalidCommandParams.getHelpMessage());
        }

        if (command instanceof QuitCommand) {
            quit();
        }

        if (command instanceof CreateCommand) {
            createNewCanvas((CreateCommand) command);
            return;
        }

        if (command instanceof DrawEntityCommand) {
            draw((DrawEntityCommand) command);
        }
    }

    private static void draw(DrawEntityCommand command) {
        if (canvas == null) {
            System.out.println("You need to create a canvas first");
            return;
        }
        try {
            canvas.addEntity(entityFactory.getEntity(command));
            System.out.println(canvas.render());
        } catch (InvalidEntityException e) {
            System.out.println("Can not add the model to canvas: " + e.getMessage());
        }
    }

    private static void createNewCanvas(CreateCommand command) {
        canvas = new CanvasImpl(command.getWidth(), command.getHeight());
        System.out.println(canvas.render());
    }

    private static void quit() {
        scanner.close();
        System.out.println("Exiting...");
        System.exit(0);
    }
}
