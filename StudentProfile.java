package tuckerproject;
//author Arya Bhargava , Tucker HS
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StudentProfile {
	public static void main(String[] args) throws IOException {

		int bool = 1;
		do {
		System.out.println("");
		System.out.println("Do you want to add, view, or update a Student Profile (usage : add/get/update/exit) ");
		BufferedReader reader0 = 
				new BufferedReader(new InputStreamReader(System.in));
		String function = reader0.readLine();
		String operation = "";
		if (function.equals("add")) {
			operation = "add";
		}
		else if (function.equals("get")) {
			operation = "get";
		}
		else if (function.equals("update")) {
			operation = "update";
		}
		else if (function.equals("exit")) {
			System.out.println("Thanks for letting me demo my program!");
			break;
		}
		else {
			operation = "invalid";
		}
		switch (operation) {
		
			case "add": 
					
					System.out.println("What is your unique ID?: ");
					BufferedReader reader = 
							new BufferedReader(new InputStreamReader(System.in));
					String ID = reader.readLine();
					Student student = new Student();
					student.SetID(ID);
					System.out.println("Your Name: ");
					String name = reader.readLine();
					student.SetName(name);
					System.out.println("Your Age: ");
					String age = reader.readLine();
					student.SetAge(age);
					System.out.println("Your Birthday: ");
					String birthday = reader.readLine();
					student.SetBirthday(birthday);
					System.out.println("Your Address: ");
					String address = reader.readLine();
					student.SetAddress(address);
					System.out.println("Your School: ");
					String school = reader.readLine();
					student.SetSchool(school);
					System.out.println("Your activity #1: ");
					String activity1 = reader.readLine();
					student.SetActivity1(activity1);
					System.out.println("Your activity #2: ");
					String activity2 = reader.readLine();
					student.SetActivity2(activity2);
					saveStudentToAFile(student);
					break;
					
			case "get": 
					System.out.println("What is your unique ID?: ");
					BufferedReader reader1 = 
							new BufferedReader(new InputStreamReader(System.in));
					String id = reader1.readLine();
				    Object obj = getStudent(id);
				    if (obj != null)
				    {
				    	Student stdObj = (Student)obj;
				    	System.out.println("Name: " + stdObj.getName());
				    	System.out.println("Age: " + stdObj.getAge());
				    	System.out.println("Birthday: " + stdObj.getBirthday());
				    	System.out.println("Address: " + stdObj.getAddress());
				    	System.out.println("School: " + stdObj.getSchool());
				    	System.out.println("Activity #1: " + stdObj.getActivity1());
				    	System.out.println("Activity #2: " + stdObj.getActivity2());
				    }
				    	break;
				    	
			case "update":
				System.out.println("What is your unique ID?: ");
				BufferedReader reader2 = 
						new BufferedReader(new InputStreamReader(System.in));
				String id2 = reader2.readLine();
			    Object obj2 = getStudent(id2);
			    if (obj2 != null)
			    {
			    	Student stdObj = (Student)obj2;
			    	System.out.println("Do you want to change name?");
			    	String decision = reader2.readLine();
			    	if (decision.equals("yes")) {
			    		System.out.println("Your Name: ");
						String newName = reader2.readLine();
						stdObj.SetName(newName);
						System.out.println("Name Changed to " + stdObj.getName());
			    	}
					
			    	System.out.println("Do you want to change Age?");
			        decision = reader2.readLine();
			    	if (decision.equals("yes")) {
			    		System.out.println("Your Age: ");
						String newAge= reader2.readLine();
						stdObj.SetAge(newAge);
						System.out.println("Age Changed to " + stdObj.getAge());
			    	}
			    	
			    	System.out.println("Do you want to change Birthday?");
			        decision = reader2.readLine();
			    	if (decision.equals("yes")) {
			    		System.out.println("Your Birthday: ");
						String newBirthday= reader2.readLine();
						stdObj.SetBirthday(newBirthday);
						System.out.println("Birthday Changed to " + stdObj.getBirthday());
			    	}
			    	
			    	System.out.println("Do you want to change Address?");
			        decision = reader2.readLine();
			    	if (decision.equals("yes")) {
			    		System.out.println("Your Address: ");
						String newAddress= reader2.readLine();
						stdObj.SetAddress(newAddress);
						System.out.println("Address Changed to " + stdObj.getAddress());
			    	}
			    	
			    	System.out.println("Do you want to change School?");
			        decision = reader2.readLine();
			    	if (decision.equals("yes")) {
			    		System.out.println("Your School: ");
						String newSchool= reader2.readLine();
						stdObj.SetSchool(newSchool);
						System.out.println("School Changed to " + stdObj.getSchool());
			    	}
			    	
			    	System.out.println("Do you want to change Activity #1?");
			        decision = reader2.readLine();
			    	if (decision.equals("yes")) {
			    		System.out.println("Your Activity #1: ");
						String newActivity1= reader2.readLine();
						stdObj.SetActivity1(newActivity1);
						System.out.println("Age Changed to " + stdObj.getActivity1());
			    	}
			    	
			    	System.out.println("Do you want to change Activity #2?");
			        decision = reader2.readLine();
			    	if (decision.equals("yes")) {
			    		System.out.println("Your Activity #2: ");
						String newActivity2= reader2.readLine();
						stdObj.SetActivity2(newActivity2);
						System.out.println("Age Changed to " + stdObj.getActivity2());
			    	}
			    	
			    	 saveStudentToAFile(stdObj);
			    }
			           
						break;
					
			case "invalid":
					System.out.println("Invalid input ...exiting");
					break;
		}
	}while (bool > 0);
	 
	}
			
	public static Object getStudent(String id)
	{
        try { 
        	FileInputStream fileIn = new FileInputStream(id+".txt");
        	ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        	Object obj = objectIn.readObject();
        	System.out.println("The file has been read \n");
        	objectIn.close();
        	return obj;
	        } 
        catch (Exception ex) {
			            //ex.printStackTrace();
			            System.out.println("File Not Found ");
			            return null;
			}

	}
	
	public static void saveStudentToAFile(Student student)
	{
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try {

			fout = new FileOutputStream(student.getID()+".txt");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(student);

			System.out.println("Student Data Saved to a file named: " + student.getID()+".txt" );

		} catch (Exception ex) {

			ex.printStackTrace();

		} finally {

			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
}

