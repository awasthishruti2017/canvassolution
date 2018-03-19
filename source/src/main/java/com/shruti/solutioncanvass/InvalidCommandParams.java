package com.shruti.solutioncanvass;

public class InvalidCommandParams extends RuntimeException {

    private final String help;

    public InvalidCommandParams(String message, String _help) {
        super(message);
        help = _help;
    }

    public String getHelpMessage() {
        return help;
    }
}