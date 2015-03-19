package me.adam561.mep2.Enchantments;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Adam on 3/19/2015.
 */
public class FirePick extends CustomEnchantment {

    public FirePick(String name) {
        super("Fire Pick", ChatColor.DARK_RED);
    }

    @Override
    public boolean enchantItem(ItemStack itemToEnchant) {
        return false;
    }
}
