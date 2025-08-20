package com.temporal.api.core.event.data.biome.dto;

public record Flower(String id, Configuration configuration, Placement placement, BiomeModifier biomeModifier) {
    public record Configuration(String blockId, int tries, int xzSpread, int ySpread,
                                long noiseSeed, float noiseScale, float noiseThreshold, float noiseHighChance,
                                int firstOctave, double[] amplitudes,
                                String[] lowStateFlowers, String[] highStateFlowers) {
    }

    public record Placement(int chance, float noiseLevel, int belowNoise, int aboveNoise) {
    }

    public record BiomeModifier(String biomeTag) {
    }
}
