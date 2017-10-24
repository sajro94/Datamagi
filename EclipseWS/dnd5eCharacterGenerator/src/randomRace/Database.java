package randomRace;

public class Database {
	public Die d6 = new Die(1, 6);
	public Die d8 = new Die(1, 8);
	public Die d10 = new Die(1, 10);
	public Die d20 = new Die(1, 20);
	public Die d100 = new Die(1, 100);

	public Table s1Var = new Table();
	public Table s1Abi = new Table();
	public Table s2Mov = new Table();
	public Table s3BaH = new Table();
	public Table s3MoH = new Table();
	public Table s3BaW = new Table();
	public Table s3MoW = new Table();
	public Table s4BeR = new Table();
	public Table s5Sen = new Table();
	public Table s6Lan = new Table();
	public Table s7RaS = new Table();
	public Table s7Ski = new Table();
	public Table s8Fea = new Table();
	public Table s8Can = new Table();
	public Table s81st = new Table();
	public Table s82nd = new Table();

	public Database() {
		s1();
	}

	private void s1() {
		RacialFeature rf1 = new RacialFeature();
	}
}
