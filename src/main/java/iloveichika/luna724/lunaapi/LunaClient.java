package iloveichika.luna724.lunaapi;

public class LunaClient {
    private final Main main;
    private final LunaAPI lunaAPI;
    public LunaClient(LunaAPI lunaApi, Main main) {
        this.lunaAPI = lunaApi;
        this.main = main;
    }

    private String failEvent() {
        return lunaAPI.Identifier + "An Error occurred. See logs for more Information. §7**LC-Identifier";
    }

    public String processCommand(String[] args) {
        String message;
        if (args.length < 2) {
            System.out.println(lunaAPI.Identifier + "Not Enough Args. (args.length < 2)");
            return failEvent();

        }
        String argType = args[1];

        if (argType.equalsIgnoreCase("getversion")) {
            // getVersion = 現在の LunaAPI のバージョンを返す
            message = lunaAPI.Identifier + "Version: " + main.VERSION;
            return message;
        }


        else {
            System.out.println(lunaAPI.Identifier + "Unknown Args: " + argType);
            return failEvent();
        }
    }
}