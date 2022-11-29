package assignment7;

//TODO: Copy a working Student class from Assignment 7 over this file.
public class Student {
		private String firstName;
		private String lastName;
		private int studentID;
		private int attemptedCredits;
		private int passingCredits;
		private double totalGradeQualityPoints;
		private double bearBucksBalance;
		
		/**
		 * Constructor method that takes in the provided parameters and initializes them to the instance variables
		 * 
		 * @param initFirstName the first name of the created student object
		 * @param initLastName the last name of the created student object
		 * @param initStudentID the student ID of the created student object
		 */
		public Student(String initFirstName, String initLastName, int initStudentID)
		{
			firstName = initFirstName;
			lastName = initLastName;
			studentID = initStudentID;
			attemptedCredits = 0;
			passingCredits = 0;
			totalGradeQualityPoints = 0.0;
			bearBucksBalance = 0.0;
		}
		
		/**
		 * Gets the full name of a Student with a space between them
		 * 
		 * @return the full name of a Student
		 */
		public String getFullName()
		{
			return firstName + " " + lastName;
		}
			
		/**
		 * Gets the studentID number of a Student
		 * 
		 * @return the Student ID of a Student
		 */
		public int getId()
		{
			return studentID;
		}
		
		/**
		 * Takes in a course grade and number of credits for a course and updates the Student's GPA and attempted credits accordingly
		 * From the grades computed in the course, determines the number of credits the Student is passing
		 * 
		 * @param grade the grade as a value between 0 and 4 in a course
		 * @param credits the amount of credits the course is worth
		 */
		public void submitGrade(double grade, int credits)
		{
			attemptedCredits = attemptedCredits + credits;
			if (grade >= 1.7)
			{
				passingCredits = passingCredits + credits;
			}
			double qualityPoints = grade * credits;
			totalGradeQualityPoints = totalGradeQualityPoints + qualityPoints;
		}
		
		/**
		 * Gets the number of credits the Student has attempted
		 * 
		 * @return the number of attempted credits for all submitted grades
		 */
		public int getTotalAttemptedCredits()
		{
			return attemptedCredits;
		}
		
		/**
		 * Gets the number of credits the Student has passed
		 * 
		 * @return the number of passing credits (credits for which a Student has received at least a 1.7 grade)
		 */
		public int getTotalPassingCredits()
		{
			return passingCredits;
		}
		
		/**
		 * Calculates a Student's GPA on a scale of 0 to 4 by dividing the number of grade quality points by the attempted credits
		 * 
		 * @return the Student's GPA
		 */
		public double calculateGradePointAverage()
		{
			return totalGradeQualityPoints / attemptedCredits;
		}
		
		/**
		 * Determines the Student's class standing based on how many credits they have passed
		 * 
		 * @return the Student's class standing 
		 */
		public String getClassStanding()
		{
			if (passingCredits < 30)
			{
				return "First Year";
			}
			else if (passingCredits < 60)
			{
				return "Sophomore";
			}
			else if (passingCredits < 90)
			{
				return "Junior";
			}
			else
			{
				return "Senior";
			}
		}
		
		/**
		 * Determines a Student's eligibility for Phi Beta Kappa
		 * Requirements: must either have a 3.6 GPA and passed 98 credits or a 3.8 GPA and passed 75 credits
		 * 
		 * @return a true or false value of if the Student is eligible
		 */
		public boolean isEligibleForPhiBetaKappa()
		{
			if (passingCredits >= 98 && calculateGradePointAverage() >= 3.6)
			{
				return true;
			}
			else if (passingCredits >= 75 && calculateGradePointAverage() >= 3.8)
			{
				return true;
			}
			else
			{
			return false;
			}
		}
		
		/**
		 * Adds funds to the Student's Bear Bucks balance
		 * 
		 * @param amount the amount of money added to the balance
		 */
		public void depositBearBucks(double amount)
		{
			bearBucksBalance = bearBucksBalance + amount;
		}
		
		/**
		 * Subtracts funds from a Student's Bear Bucks balance
		 * 
		 * @param amount the amount of money taken from the balance
		 */
		public void deductBearBucks(double amount)
		{
			bearBucksBalance = bearBucksBalance - amount;
		}
		
		/**
		 * Gets the amount of money currently in a Student's Bear Bucks balance
		 * 
		 * @return the Student's Bear Bucks balance
		 */
		public double getBearBucksBalance()
		{
			return bearBucksBalance;
		}
		
		/**
		 * Zeroes out the Bear Bucks balance and returns the appropriate amount
		 * Remaining balances are refunded, minus a $10 administrative fee
		 * 
		 * @return the amount of money cashed out
		 */
		public double cashOutBearBucks()
		{
			double amountLeft = getBearBucksBalance();
			bearBucksBalance = 0.0;
			if (amountLeft <= 10.0)
			{
				return 0.0;
			}
			else
			{
				return amountLeft - 10.0;
			}
		}
		
		/**
		 * Creates a Student that is a legacy of two other Students from WashU
		 * Deposits remaining funds from the parent Students into the new Student's Bear Bucks balance
		 * 
		 * @param firstName the new Student's first name
		 * @param other the other parent of the Student object type
		 * @param isHyphenated a boolean value of whether or not the new Student's last name is hyphenated
		 * @param id the new Student's student ID number
		 * @return a new student object with a unique first name and Student ID number and a last name based on the parent Students
		 */
		public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id)
		{
			if (isHyphenated)
			{
				
				Student a = new Student(firstName, this.lastName + "-" + other.lastName, id);
				a.depositBearBucks(this.cashOutBearBucks() + other.cashOutBearBucks());
				return a;
			}
			else 
			{
				Student a = new Student(firstName, this.lastName, id);
				a.depositBearBucks(this.cashOutBearBucks() + other.cashOutBearBucks());
				return a;
			}
		}
		
		/**
		 * Returns the Students full name and studentID
		 */
		public String toString()
		{
			return getFullName() + getId();
		}
		
		/**
		 * Allows a Student's first name to be changed
		 * 
		 * @param newName the new first name for the student
		 */
		public void setFirstName(String newName)
		{
			firstName = newName;
		}
		
		/**
		 * Allows a Student's last name to be changed
		 * 
		 * @param newName the new last name for the student
		 */
		public void setLastName(String newName)
		{
			lastName = newName;
		}
	}

