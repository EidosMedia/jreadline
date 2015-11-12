/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

import org.jboss.jreadline.console.ConsoleCommand;
import org.jboss.jreadline.console.Console;
import org.jboss.jreadline.console.ConsoleOutput;
import org.jboss.jreadline.console.settings.Settings;
import org.jboss.jreadline.edit.actions.Operation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:stale.pedersen@jboss.org">Ståle W. Pedersen</a>
 */
public class RedirectExample {

    public static void main(String[] args) throws IOException {

        // Settings.getInstance().setAnsiConsole(false);
        Settings.getInstance().setReadInputrc(false);
        // Settings.getInstance().setHistoryDisabled(true);
        // Settings.getInstance().setHistoryPersistent(false);
        // Settings.getInstance().setReadAhead(false);
        // Settings.getInstance().setInputStream(System.in);

        ConsoleOutput line;
        List<String> lines = null;
        // console.pushToStdOut(ANSI.GREEN_TEXT())

        if (args.length > 0 && "-Script".equalsIgnoreCase(args[0])) {
            File file = new File("test.eomsh");
            lines = new ArrayList<String>();
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(file));
                String lineString = reader.readLine();
                while (lineString != null) {
                    lines.add(lineString);
                    lineString = reader.readLine();
                }
            } catch (Throwable e) {
                throw new IllegalStateException("Failed to process file " + file.getAbsolutePath(), e);
            } finally {
                reader.close();
            }
        }

        Console exampleConsole = new Console();

        ConsoleCommand test = new ConsoleCommand(exampleConsole) {

            @Override
            protected void afterAttach() throws IOException {

            }

            @Override
            protected void afterDetach() throws IOException {

            }

            @Override
            public void processOperation(Operation operation) throws IOException {

            }
        };

        if (lines != null && !lines.isEmpty()) {
            for (String lineString : lines)
                exampleConsole.pushToStdOut("======>\"" + lineString + "\"\n");
        } else {
            while ((line = exampleConsole.read("/ $ ")) != null) {
                if (line.getBuffer().equalsIgnoreCase("exit"))
                    break;

                exampleConsole.pushToStdOut("======>\"" + line.getBuffer() + "\"\n");
            }

            try {
                exampleConsole.stop();
            } catch (Exception e) {
            }
        }
    }

}
