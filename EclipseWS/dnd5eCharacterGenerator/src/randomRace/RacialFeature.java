package randomRace;

public class RacialFeature {
	private String name; // The Features name.
	private String desc; // A short description of the feature
	private String full; // The full description of the feature
	private String type; // This is used when multiple features might need to override each other
	private int power; // This is uses to determine which feature is the "strongest" feature when
	// overriding
	private int rp; // The cost of the feature in RP
}
