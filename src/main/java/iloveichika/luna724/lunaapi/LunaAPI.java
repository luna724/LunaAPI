package iloveichika.luna724.lunaapi;

import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LunaAPI {
    public static String Identifier = "§7[§dLunaAPI§7]:§7§f ";
    /*
    isWorldLoad: bool
    ワールドが読み込み状態にあるかどうかを取得する

    isWorldLoaded() にて読み込み状態であるかどうかを取得する
    getIsWorldLoad() にて isWorldLoad の値を返す
    */
    private boolean isWorldLoad = false;

    @SubscribeEvent
    public void onWorldLoad(WorldEvent.Load event) {
        isWorldLoad = true;
    }

    @SubscribeEvent
    public void onWorldUnload(WorldEvent.Unload event) {
        isWorldLoad = false;
    }

    public synchronized boolean getIsWorldLoad() {
        return isWorldLoad;
    }

    public synchronized boolean isWorldLoaded() {
        return isWorldLoad;
    }
}
