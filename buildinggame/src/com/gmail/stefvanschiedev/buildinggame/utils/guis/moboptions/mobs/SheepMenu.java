package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs;

import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.color.ColorMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Sheep;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * A menu for changing the options of a sheep
 *
 * @since 5.3.0
 */
public class SheepMenu extends ColorMenu {

    /**
     * {@inheritDoc}
     */
    public SheepMenu(Plot plot, Sheep sheep) {
        super(plot, sheep);

        //sheared
        ItemStack shears = new ItemStack(Material.SHEARS);
        ItemMeta shearsMeta = shears.getItemMeta();
        shearsMeta.setDisplayName(ChatColor.GREEN + "Change whether this sheep is sheared");
        shears.setItemMeta(shearsMeta);

        insertItem(shears, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                sheep.setSheared(!sheep.isSheared());

                return true;
            }
        }, 0);
    }
}
