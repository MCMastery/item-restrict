### Download: (http://dev.bukkit.org/bukkit-plugins/itemrestrict/)

# Item Restrict
This plugin allows the restriction of crafting certain items. Don't want your players to be allowed to craft hoppers?
 Simple. Just don't give them the permission `itemrestrict.craft.hopper`.

## `config.yml`
The config contains a single variable: `show-result`. If you want the recipe's result to display
 (which it normally does in a crafting table), set this to `true`. Otherwise, set this to `false`.

## Permissions

**Note:** When giving permissions, they **must be completely lower-case.**

- `itemrestrict.*` - Allows the player to craft all items
- `itemrestrict.craft.*` - Same as `itemrestrict.*`
- `itemrestrict.craft.<item_name>` - Allows the player to craft `<item_name>`. For a list of viable item names, please see
 (https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Material.html).