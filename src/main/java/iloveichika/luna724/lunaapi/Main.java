package iloveichika.luna724.lunaapi;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main {
    public static final String MODID = "lunaapi";
    public static final String NAME = "LunaAPI";
    public static final String VERSION = "1.0";

    private LunaAPI lunaApi;
    private LunaClient lunaClient;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // 初期化
        lunaApi = new LunaAPI(); // autoMove の初期化
        lunaClient = new LunaClient(lunaApi, this);

        // イベントバスに登録
        MinecraftForge.EVENT_BUS.register(lunaApi);
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // クライアントサイドのコマンドを登録
        ClientCommandHandler.instance.registerCommand(new Commands(lunaApi, lunaClient));
    }
}