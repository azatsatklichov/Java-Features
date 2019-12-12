package features.in.java12;

public class z_AbortableMixedCollectionsForG1 {
	public static void main(String[] args) {
		/**
		 * Improvements in G1 efficiency include making G1 mixed collections abortable
		 * if they might exceed the defined pause target.
		 * 
		 * This is done by splitting the mixed collection set into mandatory and
		 * optional.
		 * 
		 * Thus the G1 collector can prioritize on collecting the mandatory set first to
		 * meet the pause time goal.
		 */
	}
}
