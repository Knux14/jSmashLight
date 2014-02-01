package fr.Knux14.jSmashLight.Score;

import java.util.*;
import java.io.*;

/**
 * Thanks to http://forum.codecall.net/topic/50071-making-a-simple-high-score-system/
 * for helped me
 */

public class ScoreboardManager {
	private ArrayList<Score> scores;
	private static final String FILE = "scores.dat";
	ObjectOutputStream outputStream = null;
	ObjectInputStream inputStream = null;

	public ScoreboardManager() {
		scores = new ArrayList<Score>();
	}

	public ArrayList<Score> getScores() {
		loadScoreFile();
		sort();
		return scores;
	}

	private void sort() {
		ScoreComparator comparator = new ScoreComparator();
		Collections.sort(scores, comparator);
	}

	public void addScore(String name, int score, int size, int errors) {
		loadScoreFile();
		scores.add(new Score(name, score, size, errors));
		updateScoreFile();
	}

	@SuppressWarnings("unchecked")
	public void loadScoreFile() {
		try {
			inputStream = new ObjectInputStream(new FileInputStream(FILE));
			scores = (ArrayList<Score>) inputStream.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("[Scoreboard Manager: Loading] FNF Error: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("[Scoreboard Manager: Loading] IO Error: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("[Scoreboard Manager: Loading] CNF Error: " + e.getMessage());
		} finally {
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException e) {
				System.out.println("[Scoreboard Manager: Loading] IO Error: " + e.getMessage());
			}
		}
	}
	
	public void updateScoreFile() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(FILE));
            outputStream.writeObject(scores);
        } catch (FileNotFoundException e) {
            System.out.println("[Scoreboard Manager: Save] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
        } catch (IOException e) {
            System.out.println("[Scoreboard Manager: Save] IO Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Scoreboard Manager: Save] Error: " + e.getMessage());
            }
        }
	}
}