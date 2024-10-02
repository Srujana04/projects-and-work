package minorproject;
import java.util.Scanner;

class Address {
	
	int flatno; String apartment; String area; String city; int pincode;
	
	public void inputAddress() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter flat no, apartment name, area, city, pincode: ");
		flatno=sc.nextInt(); apartment=sc.next(); area=sc.next(); city=sc.next(); pincode=sc.nextInt();
	}

	void displayAddress() {
		System.out.println(flatno+", "+apartment+", "+area+", "+city+"- "+pincode);
	}
	
}

class Date extends Address {
	
int date; int month; int year;
	
	void inputDate() {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter date, month, year (DD/MM/YYYY): ");
		date=sc.nextInt(); month=sc.nextInt(); year=sc.nextInt();
	}
	
	void displayDate() {
		System.out.print(date+"/"+month+"/"+year);
	}
	
}

class Employee extends Date {
	
String name; int empID; double salary; tareekh hireDate; String jobPosition; String contactNumber; pataa address;
	
	Employee(String n, int id, double s, String jp, String cn) {
		this.name=n; this.empID=id; this.salary=s; this.jobPosition=jp; this.contactNumber=cn;
	}	
	
	void displayInfo() {
		System.out.print(name+"\t\t"+empID+"\t"+salary+"\t"); super.displayDate(); 
		System.out.print("\t"+jobPosition+"\t\t"+contactNumber+"\t"); super.displayAddress();
	}
	
}

public class Test {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Employee [] emp = new Employee [500];
		String name; int empID; double salary; String jobPosition; String contactNumber;
		
		for (int i=0; i<emp.length; i++) {
			System.out.println("For employee "+(i+1)+":- ");
			System.out.print("Enter name, ID, Salary, JobPosition, ContactNumber: ");
			name=sc.next(); empID=sc.nextInt(); salary=sc.nextDouble(); jobPosition=sc.next(); contactNumber=sc.next();
			emp[i]=new Employee(name, empID, salary, jobPosition, contactNumber);
			emp[i].inputAddress(); emp[i].inputDate(); 
		}
		
		Date d1=new Date(); d1.date=01; d1.month=04; d1.year=2022;
		Date d2=new Date(); d2.date=31; d2.month=03; d2.year=2023;
		
		System.out.println();
		arrangeEmployeeBySalary(emp); System.out.println();
		getEmployeesByJobPosition(emp,"manager"); System.out.println();
		getEmployeesByHireDate(emp, d1, d2); System.out.println();
		System.out.println("Number of foreign employees: "+foreignEmployeeCount(emp)+"\n");
		getEmployeesBySalary(emp, 150000, 300000);	
		
	}
	
	public static void arrangeEmployeeBySalary(Employee e[]) {
		for (int i=0; i<e.length-1; i++) {
			for (int j=0; j<e.length-i-1; j++) {
				if (e[j].salary>e[j+1].salary) {
					Employee temp=e[j];
					e[j]=e[j+1];
					e[j+1]=temp;
				}
			}
		}
		System.out.println("EMPLOYESS ARRANGED ACCORDING TO SALARY:-");
		System.out.println("NAME\t\tEMPID\tSALARY\t\tHIREDATE\tJOBPOSITION\tCONTACTNUMBER\tADDRESS");
		for(int k=e.length-1; k>=0; k--) {
			e[k].displayInfo();
		}
	}
	
	public static void getEmployeesByJobPosition(Employee e[], String jp) {
		System.out.println("EMPLOYEES WHO ARE MANAGERS:-");
		System.out.println("NAME\t\tEMPID\tSALARY\t\tHIREDATE\tJOBPOSITION\tCONTACTNUMBER\tADDRESS");
		for (int i=0; i<e.length; i++) {
			if (e[i].jobPosition.equals(jp)) {
				e[i].displayInfo();
			}
		}
	}
	
	public static void getEmployeesByHireDate(Employee e[], Date d1, Date d2) {
		System.out.println("EMPLOYESS WHO WERE HIRED BETWEEN THE GIVEN DATES:-");
		System.out.println("NAME\t\tEMPID\tSALARY\t\tHIREDATE\tJOBPOSITION\tCONTACTNUMBER\tADDRESS");
		for(int i=0;i<e.length;i++){
            if(e[i].date>=d1.date && e[i].date<=d2.date){
                if(e[i].year==d1.year){
                    if(e[i].month>=4 && e[i].month<=12){
                        e[i].displayInfo();
                    }
                }
                else if(e[i].year==d2.year) {
                    if(e[i].month>=1 && e[i].month<=3) {
                        e[i].displayInfo();
                    }
                }
            }
        }
	}
	
	public static int foreignEmployeeCount(Employee e[]) {
		int count=0;
		String [] cn=new String [e.length]; String [] code=new String[e.length];
		for (int i=0; i<e.length; i++) {
			cn[i]=e[i].contactNumber;
			code[i]=cn[i].substring(0,2);
			if (code[i].equals("91")) {
				count++;
			}
		}
		return e.length-count;
	}
	
	public static void getEmployeesBySalary(Employee e[], double s1, double s2) {
		System.out.println("EMPLOYEES WHOSE SALARY IS BETWEEN RS. "+s1+" AND RS. "+s2+":-");
		System.out.println("NAME\t\tEMPID\tSALARY\t\tHIREDATE\tJOBPOSITION\tCONTACTNUMBER\tADDRESS");
		for (int i=0; i<e.length; i++) {
			if (e[i].salary>=s1 && e[i].salary<=s2) {
				e[i].displayInfo();
			}
		}
	}

}
