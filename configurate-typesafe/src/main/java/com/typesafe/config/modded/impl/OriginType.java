package com.typesafe.config.modded.impl;

// caution: ordinals used in serialization
enum OriginType {
    GENERIC,
    FILE,
    URL,
    RESOURCE
}
