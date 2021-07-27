/**
 *   Copyright (C) 2011-2012 Typesafe Inc. <http://typesafe.com>
 */
package com.typesafe.config.modded.impl;

import com.typesafe.config.modded.ConfigIncluder;
import com.typesafe.config.modded.ConfigIncluderClasspath;
import com.typesafe.config.modded.ConfigIncluderFile;
import com.typesafe.config.modded.ConfigIncluderURL;

interface FullIncluder extends ConfigIncluder, ConfigIncluderFile, ConfigIncluderURL,
        ConfigIncluderClasspath {

}
