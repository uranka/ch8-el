package elfunctions;

public class DiceRoller {
// method must be public and static	
	public static int rollDice() {
		return (int) ((Math.random() * 6) + 1);
	}
}