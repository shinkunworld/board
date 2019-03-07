package model;

import java.util.List;

public class PostMutterLogic {
	public static void execute(Mutter mutter, List<Mutter> mutterList) {
		mutterList.add(0, mutter);
	}

}
