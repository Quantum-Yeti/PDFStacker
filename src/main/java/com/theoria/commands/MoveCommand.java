package com.theoria.commands;

import com.theoria.core.StackerLogic;

public class MoveCommand implements Commands {

    @Override
    public String cmdName() {
        return "move";
    }

    @Override
    public void execute(String input, StackerLogic stacker) {

        String cmd = input.substring("move".length()).trim();

        cmd = cmd.replaceAll("\\s*->\\s*", "->");

        String[] indices = cmd.split("->");
        if (indices.length != 2) {
            System.out.println("Invalid syntax. Use: move <currentIndex> -> <newIndex>");
            return;
        }

        try {
            int oldIndex = Integer.parseInt(indices[0].trim());
            int newIndex = Integer.parseInt(indices[1].trim());

            // Perform move and get direction
            StackerLogic.MoveDirection dir = stacker.movePDF(oldIndex, newIndex);

            switch (dir) {
                case UP -> System.out.println("PDF moved up from " + oldIndex + " to " + newIndex + ".");
                case DOWN -> System.out.println("PDF moved down from " + oldIndex + " to " + newIndex + ".");
                case NONE -> System.out.println("PDF stayed in the same position.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Use integers for indices.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
