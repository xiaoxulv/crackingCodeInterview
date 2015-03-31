package sortSearch;

import java.util.ArrayList;

public class circus {

	private static ArrayList<pair> seqWithMaxLength(ArrayList<pair> seq1,
			ArrayList<pair> seq2) {
		if (seq1 == null) {
			return seq2;
		} else if (seq2 == null) {
			return seq1;
		}
		return seq1.size() > seq2.size() ? seq1 : seq2;
	}

	private static void longestIncreasingSubsequence(ArrayList<pair> array,
			ArrayList<pair>[] solutions, int current_index) {
		if (current_index >= array.size() || current_index < 0) {
			return;
		}
		pair current_element = array.get(current_index);
		
		ArrayList<pair> best_sequence = null;
		for (int i = 0; i < current_index; i++) {
			if (array.get(i).isBefore(current_element)) {
				best_sequence = seqWithMaxLength(best_sequence, solutions[i]);
			}
		}

		ArrayList<pair> new_solution = new ArrayList<pair>();
		if (best_sequence != null) {
			new_solution.addAll(best_sequence);
		}
		new_solution.add(current_element);

		solutions[current_index] = new_solution;
		longestIncreasingSubsequence(array, solutions, current_index + 1);
	}

	private static ArrayList<pair> longestIncreasingSubsequence(
			ArrayList<pair> array) {
		ArrayList<pair>[] solutions = new ArrayList[array.size()];
		longestIncreasingSubsequence(array, solutions, 0);

		ArrayList<pair> best_sequence = null;
		for (int i = 0; i < array.size(); i++) {
			best_sequence = seqWithMaxLength(best_sequence, solutions[i]);
		}
		return best_sequence;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
