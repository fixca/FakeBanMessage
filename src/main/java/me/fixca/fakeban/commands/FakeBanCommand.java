package me.fixca.fakeban.commands;

import me.fixca.fakeban.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.MessageFormat;
import java.util.Locale;

public class FakeBanCommand implements CommandExecutor {

    private String fakeBanMessage = "\n{0} &cwas banned from the server.\n&eRegardless, we wish you a lot of fun playing.\n";

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!commandSender.hasPermission("fakeban.admin")) {
            commandSender.sendMessage(StringUtils.color(
                    "&cYou are not allowed to use this command!"
            ));
            return true;
        }
        if(strings.length == 0) {
            commandSender.sendMessage(StringUtils.color(
                    "&cUsage : /fakeban <playerName> [rank]"
            ));
            return true;
        }

        String playerName = strings[0];
        String prefix = "&a";

        if(strings.length > 1) {
            switch (strings[1].toLowerCase(Locale.KOREAN)) {
                case "premium":
                    prefix = "&6";
                    break;
                case "vip":
                    prefix = "&9";
                    break;
                case "yt":
                case "youtube":
                    prefix = "&5";
                    break;
                case "mvp":
                    prefix = "&b";
                    break;
                case "helper":
                    prefix = "&e";
                    break;
                case "mod":
                case "moderator":
                    prefix = "&c";
                    break;
                case "admin":
                case "owner":
                    prefix = "&4";
                    break;
                default:
                    commandSender.sendMessage(StringUtils.color(
                            "&cInvalid rank [&e" + strings[1] + "&c] !\nValid rank is &e" +
                                    "premium, vip, youtube, mvp, helper, moderator, admin, owner"
                    ));
                    return true;
            }
        }

        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(StringUtils.color(MessageFormat.format(fakeBanMessage,
                    prefix + playerName)
            ));
        }

        return true;
    }
}
