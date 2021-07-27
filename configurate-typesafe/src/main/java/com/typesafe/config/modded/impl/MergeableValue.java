package com.typesafe.config.modded.impl;

import com.typesafe.config.modded.ConfigMergeable;
import com.typesafe.config.modded.ConfigValue;

interface MergeableValue extends ConfigMergeable {
    // converts a Config to its root object and a ConfigValue to itself
    ConfigValue toFallbackValue();
}
