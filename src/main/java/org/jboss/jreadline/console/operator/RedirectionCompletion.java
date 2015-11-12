/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jboss.jreadline.console.operator;

import org.jboss.jreadline.complete.CompleteOperation;
import org.jboss.jreadline.complete.Completion;
import org.jboss.jreadline.util.FileUtils;
import org.jboss.jreadline.util.Parser;

import java.io.File;

/**
 * ControlOperator completor
 *
 * @author <a href="mailto:stale.pedersen@jboss.org">Ståle W. Pedersen</a>
 */
public class RedirectionCompletion implements Completion {

    @Override
    public void complete(CompleteOperation completeOperation) {

        if (ControlOperatorParser.doStringContainRedirectionNoPipeline(completeOperation.getBuffer())) {
            int redirectPos = ControlOperatorParser.findLastRedirectionPositionBeforeCursor(
                    completeOperation.getBuffer(), completeOperation.getCursor());

            String word = Parser.findWordClosestToCursor(
                    completeOperation.getBuffer().substring(redirectPos, completeOperation.getCursor()),
                    completeOperation.getCursor() - redirectPos);

            completeOperation.setOffset(completeOperation.getCursor());
            FileUtils.listMatchingDirectories(completeOperation, word, new File(System.getProperty("user.dir")));
            // if we only have one complete candidate, leave the escaped space be
            if (completeOperation.getCompletionCandidates().size() > 1)
                completeOperation.removeEscapedSpacesFromCompletionCandidates();
        }
    }
}
