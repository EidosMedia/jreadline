/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jboss.jreadline.console;

import junit.framework.TestCase;

/**
 * @author <a href="mailto:stale.pedersen@jboss.org">Ståle W. Pedersen</a>
 */
public class BufferTest extends TestCase {

<<<<<<< HEAD
=======

>>>>>>> e482a2f12b2a252d96d6b0b5de4625705ed22a7b
    public BufferTest(String name) {
        super(name);
    }

    public void testMove() {
        String input = "foo-bar";
        Buffer buffer = new Buffer(null);
        buffer.write(input);

        char[] out = buffer.move(-1, 80);
<<<<<<< HEAD
        char[] expected = new char[] { (char) 27, '[', '1', 'D' };
=======
        char[] expected = new char[] {(char) 27,'[','1','D'};
>>>>>>> e482a2f12b2a252d96d6b0b5de4625705ed22a7b
        assertEquals(new String(expected), new String(out));
        assertEquals(6, buffer.getCursor());

        out = buffer.move(1, 80);
<<<<<<< HEAD
        expected = new char[] { (char) 27, '[', '1', 'C' };
        assertEquals(new String(expected), new String(out));
        assertEquals(7, buffer.getCursor());

        out = buffer.move(-5, 80);
        expected = new char[] { (char) 27, '[', '5', 'D' };
=======
        expected = new char[] {(char) 27,'[','1','C'};
        assertEquals(new String(expected), new String(out));
        assertEquals(7, buffer.getCursor());


        out = buffer.move(-5, 80);
        expected = new char[] {(char) 27,'[','5','D'};
>>>>>>> e482a2f12b2a252d96d6b0b5de4625705ed22a7b
        assertEquals(new String(expected), new String(out));
        assertEquals(2, buffer.getCursor());

        out = buffer.move(-3, 80);
<<<<<<< HEAD
        expected = new char[] { (char) 27, '[', '2', 'D' };
=======
        expected = new char[] {(char) 27,'[','2','D'};
>>>>>>> e482a2f12b2a252d96d6b0b5de4625705ed22a7b
        assertEquals(new String(expected), new String(out));
        assertEquals(0, buffer.getCursor());

        out = buffer.move(-3, 80);
        expected = new char[0];
        assertEquals(new String(expected), new String(out));
        assertEquals(0, buffer.getCursor());

<<<<<<< HEAD
        out = buffer.move(10, 80);
        expected = new char[] { (char) 27, '[', '7', 'C' };
=======

        out = buffer.move(10, 80);
        expected = new char[] {(char) 27,'[','7','C'};
>>>>>>> e482a2f12b2a252d96d6b0b5de4625705ed22a7b
        assertEquals(new String(expected), new String(out));
        assertEquals(7, buffer.getCursor());

        String prompt = "foo@bar:";

        buffer.reset(prompt);
        buffer.write(input);
<<<<<<< HEAD
        // buffer.setCursor(5);

        out = buffer.move(-1, 80);
        expected = new char[] { (char) 27, '[', '1', 'D' };
        assertEquals(new String(expected), new String(out));
        assertEquals(input.length() - 1, buffer.getCursor());
        assertEquals(prompt.length() + input.length(), buffer.getCursorWithPrompt());

        out = buffer.move(1, 80);
        expected = new char[] { (char) 27, '[', '1', 'C' };
=======
        //buffer.setCursor(5);

        out = buffer.move(-1, 80);
        expected = new char[] {(char) 27,'[','1','D'};
        assertEquals(new String(expected), new String(out));
        assertEquals(input.length()-1, buffer.getCursor());
        assertEquals(prompt.length()+input.length(), buffer.getCursorWithPrompt());

        out = buffer.move(1, 80);
        expected = new char[] {(char) 27,'[','1','C'};
>>>>>>> e482a2f12b2a252d96d6b0b5de4625705ed22a7b
        assertEquals(new String(expected), new String(out));
        assertEquals(7, buffer.getCursor());

        out = buffer.move(-5, 80);
<<<<<<< HEAD
        expected = new char[] { (char) 27, '[', '5', 'D' };
=======
        expected = new char[] {(char) 27,'[','5','D'};
>>>>>>> e482a2f12b2a252d96d6b0b5de4625705ed22a7b
        assertEquals(new String(expected), new String(out));
        assertEquals(2, buffer.getCursor());

        out = buffer.move(-6, 80);
<<<<<<< HEAD
        expected = new char[] { (char) 27, '[', '2', 'D' };
=======
        expected = new char[] {(char) 27,'[','2','D'};
>>>>>>> e482a2f12b2a252d96d6b0b5de4625705ed22a7b
        assertEquals(new String(expected), new String(out));
        assertEquals(0, buffer.getCursor());

        out = buffer.move(10, 80);
<<<<<<< HEAD
        expected = new char[] { (char) 27, '[', '7', 'C' };
=======
        expected = new char[] {(char) 27,'[','7','C'};
>>>>>>> e482a2f12b2a252d96d6b0b5de4625705ed22a7b
        assertEquals(new String(expected), new String(out));
        assertEquals(7, buffer.getCursor());

        buffer.reset(">");
        buffer.write("foo");
        buffer.move(-4, 80, true);

        assertEquals(2, buffer.getCursorWithPrompt());

        buffer.move(5, 80, true);
        assertEquals(4, buffer.getCursorWithPrompt());

        buffer.move(-4, 80, true);
        assertEquals(2, buffer.getCursorWithPrompt());
    }

    public void testPrintAnsi() {
<<<<<<< HEAD
        char[] expected = new char[] { (char) 27, '[', 'J' };
        assertEquals(new String(expected), new String(Buffer.printAnsi("J")));

        expected = new char[] { (char) 27, '[', 'J', 'p' };
        assertEquals(new String(expected), new String(Buffer.printAnsi("Jp")));

        expected = new char[] { (char) 27, '[', ' ', ' ', ' ', ' ' };
        assertEquals(new String(expected), new String(Buffer.printAnsi("\t")));

        expected = new char[] { (char) 27, '[', ' ', ' ', ' ', ' ', 'B' };
=======
        char[] expected = new char[] {(char) 27, '[', 'J'};
        assertEquals(new String(expected), new String(Buffer.printAnsi("J")));

        expected = new char[] {(char) 27, '[', 'J','p'};
        assertEquals(new String(expected), new String(Buffer.printAnsi("Jp")));

        expected = new char[] {(char) 27, '[', ' ',' ',' ',' '};
        assertEquals(new String(expected), new String(Buffer.printAnsi("\t")));

        expected = new char[] {(char) 27, '[', ' ',' ',' ',' ','B'};
>>>>>>> e482a2f12b2a252d96d6b0b5de4625705ed22a7b
        assertEquals(new String(expected), new String(Buffer.printAnsi("\tB")));

    }

<<<<<<< HEAD
=======

>>>>>>> e482a2f12b2a252d96d6b0b5de4625705ed22a7b
}
