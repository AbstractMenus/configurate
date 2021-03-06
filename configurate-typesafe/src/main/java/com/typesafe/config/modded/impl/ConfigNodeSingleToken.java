/**
 *   Copyright (C) 2015 Typesafe Inc. <http://typesafe.com>
 */
package com.typesafe.config.modded.impl;

import java.util.Collection;
import java.util.Collections;

class ConfigNodeSingleToken extends AbstractConfigNode {
    final Token token;
    ConfigNodeSingleToken(Token t) {
        token = t;
    }

    @Override
    protected Collection<Token> tokens() {
        return Collections.singletonList(token);
    }

    protected Token token() { return token; }
}