package features.in.java15;

@SuppressWarnings("preview")
public sealed interface Command {

	permits LoginCommand, LogoutCommand, PluginCommand;
	// ...
}