package com.temporal.api.core.event.trade;

import com.temporal.api.core.event.trade.object.*;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

import java.util.List;

public class SimpleTradeCustomizer implements TradeCustomizer {
    @Override
    public void customize(VillagerTradesEvent event, VillagerTrade villagerTrade) {
        VillagerTradeDescription tradeDescription = villagerTrade.getTradeDescription();
        if (event.getType() == tradeDescription.getVillagerProfession()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            TradingItemHolder itemStack1 = villagerTrade.getHolder1();
            TradingItemHolder itemStack2 = villagerTrade.getHolder2();
            trades.get(tradeDescription.getLevel()).add((trader, random) -> new MerchantOffer(
                    new ItemCost(itemStack1.item(), itemStack1.itemCount()),
                    new ItemStack(itemStack2.item(), itemStack2.itemCount()),
                    tradeDescription.getMaxUses(), tradeDescription.getXP(), tradeDescription.getPriceMultiplier()
            ));
        }
    }

    @Override
    public void customize(WandererTradesEvent event, WandererTrade wandererTrade) {
        WandererTradeDescription tradeDescription = wandererTrade.getTradeDescription();
        TradingItemHolder itemStack1 = wandererTrade.getHolder1();
        TradingItemHolder itemStack2 = wandererTrade.getHolder2();
        if (tradeDescription.getTradeRarity() == WandererTradeDescription.TradeRarity.GENERIC) {
            event.getGenericTrades().add(((trader, random) -> new MerchantOffer(
                    new ItemCost(itemStack1.item(), itemStack1.itemCount()),
                    new ItemStack(itemStack2.item(), itemStack2.itemCount()),
                    tradeDescription.getMaxUses(), tradeDescription.getXP(), tradeDescription.getPriceMultiplier()
            )));
        } else {
            event.getRareTrades().add(((trader, random) -> new MerchantOffer(
                    new ItemCost(itemStack1.item(), itemStack1.itemCount()),
                    new ItemStack(itemStack2.item(), itemStack2.itemCount()),
                    tradeDescription.getMaxUses(), tradeDescription.getXP(), tradeDescription.getPriceMultiplier()
            )));
        }
    }
}
