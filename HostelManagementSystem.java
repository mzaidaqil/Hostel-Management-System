package Group_Project;

import java.util.*;

abstract class Room{

    //This is how we do intialized the variable
    protected int roomNumber;
    protected int occupancy;
    protected int capacity;

    //This is how we do constructor for an object 
    public Room (int roomNumber, int capacity){
        this.roomNumber = roomNumber;
        this.capacity = capacity; //this assign to the instance variable
        this.occupancy = 0;
    }

    //Method 1 
    public boolean isAvailable(){
        return occupancy < capacity;
    }

    //Method 2
    public int getRoomNumber(){
        return roomNumber;
    }

    //Method 3
    public abstract void allocateRoom(String residentName);

    //Method 4 Concrete Method 
    public void displayRoomDetails(){
        System.out.println("Rooom Number : " + roomNumber + ", Capacity : " + capacity + ", Occupancy : " + occupancy);
    }
}

//Subclass : single room

class SingleRoom extends Room {

    //Constructor
    public SingleRoom(int roomNumber){
        super(roomNumber, 1);
    }

    @Override
    public void allocateRoom(String residentName){
        if (isAvailable()){
            occupancy = 1;
            System.out.println("Single room : " + roomNumber + " allocated successfully!");
        } else {
            System.out.println("Single room : " + roomNumber + " is fully occupied, sorry :(");
        }
    }
}
class SharedRoom extends Room{
    private List<String> occupants;
    
    //Constructor 
    public SharedRoom (int roomNumber, int capacity){
        super(roomNumber, 4);
        occupants = new ArrayList<>();
    }

    @Override
    public void allocateRoom(String residentName){
        if (isAvailable()){
            occupants.add(residentName);
            occupancy++;
            System.out.println("Shared room : " + roomNumber + "allocated to" + residentName + " successfully!");
        }else{
            System.out.println("Shared room : " + roomNumber + " is fully occupied, sorry :(");
        }
    }

    @Override 
    public void displayRoomDetails(){
        super.displayRoomDetails();
        System.out.print("Occupants :");
    
    for (String name : occupants){
        System.out.println(name + " ");
    }
    System.out.println();
    }
}

class Resident {
    private String name;
    private String studentId;
    private int roomNumber;

    //Constructor
    public Resident (String name, String studentId, int roomNumber){
        this.name=name;
        this.studentId=studentId;
        this.roomNumber=roomNumber;
    }

    public String getName(){
        return name;
    }

    public int getRoomNumber(){
        return roomNumber;
    }

    public void displayResidentDetails(){
        System.out.println("Name : " + name + ", Student ID :  " + studentId + ", Room Number : " + roomNumber);
    }
}

public class HostelManagementSystem{
        //Create object 

        private static List<Room> rooms = new ArrayList<>();
        private static List<Resident> residents = new ArrayList<>();
        private static Scanner scanner = new Scanner(System.in);

        public static void main (String[] args){
            rooms.add(new SingleRoom (101));
            rooms.add(new SharedRoom(102,4));
            rooms.add(new SharedRoom(103, 2));

            while (true){
                System.out.println("\n---Welcome to UNITEN Hostel Management System---");
                System.out.println("1. Admin Login");
                System.out.println("2. Resident Login");
                System.out.println("3. Exit");

                System.out.println("Choose an option : ");

                int choice = scanner.nextInt();

                swith (choice){
                    case 1: 
                        adminMenu();
                        break;

                    case 2: 
                        residentMenu();
                        break;
                    case 3:
                        System.out.println("Exiting the program, thanks!");
                        return;
                    default:
                        System.out.println ("Invalid choice. Try again");
                }
            }
        }

        private static void adminMenu(){
            
        }

    
}