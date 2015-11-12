/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jboss.jreadline.console.alias;

import junit.framework.TestCase;
import org.jboss.jreadline.console.Config;

import java.io.File;

/**
 * @author <a href="mailto:stale.pedersen@jboss.org">Ståle W. Pedersen</a>
 */
public class AliasManagerTest extends TestCase {

    public AliasManagerTest(String name) {
        super(name);
    }

    public void testParseAlias() throws Exception {
        AliasManager manager = new AliasManager(new File("foo"));

        assertNull(manager.parseAlias("alias foo2='bar -s -h'"));
        assertNull(manager.parseAlias("alias foo=bar"));
        assertNull(manager.parseAlias("alias foo3=bar --help"));

        String out = manager.parseAlias("alias foo");
<<<<<<< HEAD
        assertEquals("alias foo='bar'" + Config.getLineSeparator(), out);
        out = manager.parseAlias("alias foo2");
        assertEquals("alias foo2='bar -s -h'" + Config.getLineSeparator(), out);
        out = manager.parseAlias("alias foo3");
        assertEquals("alias foo3='bar --help'" + Config.getLineSeparator(), out);
        out = manager.parseAlias("alias");
        StringBuilder sb = new StringBuilder();
        sb.append("alias foo='bar'" + Config.getLineSeparator())
                .append("alias foo2='bar -s -h'" + Config.getLineSeparator())
                .append("alias foo3='bar --help'" + Config.getLineSeparator());
=======
        assertEquals("alias foo='bar'"+ Config.getLineSeparator(), out);
        out = manager.parseAlias("alias foo2");
        assertEquals("alias foo2='bar -s -h'"+ Config.getLineSeparator(), out);
        out = manager.parseAlias("alias foo3");
        assertEquals("alias foo3='bar --help'"+ Config.getLineSeparator(), out);
        out = manager.parseAlias("alias");
        StringBuilder sb = new StringBuilder();
        sb.append("alias foo='bar'"+ Config.getLineSeparator())
                .append("alias foo2='bar -s -h'"+ Config.getLineSeparator())
                .append("alias foo3='bar --help'"+ Config.getLineSeparator());
>>>>>>> e482a2f12b2a252d96d6b0b5de4625705ed22a7b
        assertEquals(sb.toString(), out);
    }

    public void testUnalias() throws Exception {
        AliasManager manager = new AliasManager(new File("foo"));

        manager.parseAlias("alias foo2='bar -s -h'");
        manager.parseAlias("alias foo=bar");
        manager.parseAlias("alias foo3=bar --help");

        manager.removeAlias("unalias foo3");
<<<<<<< HEAD
        assertEquals("jreadline: unalias: foo3: not found" + Config.getLineSeparator(),
                manager.removeAlias("unalias foo3"));
=======
        assertEquals("jreadline: unalias: foo3: not found"+Config.getLineSeparator(), manager.removeAlias("unalias foo3"));

>>>>>>> e482a2f12b2a252d96d6b0b5de4625705ed22a7b

    }
}
