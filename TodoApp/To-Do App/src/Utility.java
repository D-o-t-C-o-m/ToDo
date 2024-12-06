public class Utility {


public static String applyStrikethrough(String text) {
	return "\u001B[9m" + text + "\u001B[29m";
}

public static String applyBold(String text) {
	return "\u001B[1m" + text + "\u001B[22m";
}

public static String applyItalics(String text) {
	return "\u001B[3m" + text + "\u001B[23m";
}
}