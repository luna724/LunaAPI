package iloveichika.luna724.lunaapi;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class Commands extends CommandBase {
    private final LunaAPI lunaAPI;
    private final LunaClient lunaClient;
    public Commands (LunaAPI lunaAPI, LunaClient lunaClient) {
        this.lunaAPI = lunaAPI;
        this.lunaClient = lunaClient;
    }

    @Override
    public String getCommandName() {
        return "lunaapi";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "/lunaapi <lunaclient>";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length < 1) { return; }

        String argType = args[0];
        if (argType.equalsIgnoreCase("getisworldload")) {
            boolean isWorldLoaded = lunaAPI.getIsWorldLoad();
            String message = lunaAPI.Identifier + "isWorldLoad: " + isWorldLoaded;
            sender.addChatMessage(new ChatComponentText(message));
        } else if (argType.equalsIgnoreCase("lunaclient")) {
            String message = lunaClient.processCommand(args);
            sender.addChatMessage(new ChatComponentText(message));
        }
        return;
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;  // 権限レベル0（すべてのプレイヤーが使用可能）
    }
}
