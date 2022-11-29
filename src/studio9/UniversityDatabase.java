package studio9;

import java.util.HashMap;
import java.util.Map;

import assignment7.Student;

public class UniversityDatabase {
	//TODO: Complete this class according to the studio instructions
	private final Map<String, Student> map;
	
	public UniversityDatabase() {
		map = new HashMap<>();
	}
	
	public void addStudent(String accountName, Student student) {
		map.put(accountName, student);
	}

	public int getStudentCount() {
		return map.size();
	}

	public String lookupFullName(String accountName) {
		if (map.get(accountName) != null)
		{
			return map.get(accountName).getFullName();
		}
		else 
		{
			return null;
		}
	}

	public double getTotalBearBucks() {
		double bearBucks = 0;
		for (String name : map.keySet())
		{
			bearBucks = bearBucks + map.get(name).getBearBucksBalance();
		}
		return bearBucks;
	}
}
