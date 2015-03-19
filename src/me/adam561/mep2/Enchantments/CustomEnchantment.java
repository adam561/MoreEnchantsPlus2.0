package me.adam561.mep2.Enchantments;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 3/19/2015.
 */
public abstract class CustomEnchantment {
    private String name;
    private ChatColor color;

    public CustomEnchantment(String name, ChatColor color) {
        this.name = name;
        this.color = color;
    }

    public boolean enchantItem(ItemStack itemToEnchant){

        if(!itemToEnchant.hasItemMeta()){
            ItemMeta im = itemToEnchant.getItemMeta();
            List<String> lore = new ArrayList<String>();
            lore.add(color + name);
            im.setLore(lore);
            itemToEnchant.setItemMeta(im);
            return true;
        }

        ItemMeta im = itemToEnchant.getItemMeta();
        if(im.getLore().contains(color+name)){
            return false;
        }
        List<String> lore = new ArrayList<String>();
        lore.add(color + name);
        im.setLore(lore);
        itemToEnchant.setItemMeta(im);
        return true;
    }

    @Override
    public String toString(){
        return name;
    }


}
