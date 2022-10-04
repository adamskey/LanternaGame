package org.example;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class Main {
    public static void main(String[] args) throws Exception{

        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        TerminalSize ts = new TerminalSize(30, 20);
        terminalFactory.setInitialTerminalSize(ts);
        Terminal terminal = terminalFactory.createTerminal();

    }
}