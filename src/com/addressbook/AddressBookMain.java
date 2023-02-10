package com.addressbook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

//Address book program
public class AddressBookMain extends ContactPerson {
    public static void main(String[] args) {
        int flag = 0;
        int choice;
        AddressBookMain newPerson = new AddressBookMain();
        ArrayList<ContactPerson> person = new ArrayList<>();
        System.out.println("Welcome to Address Book Program");
        Scanner scanner = new Scanner(System.in);
        while (flag != 1) {
            System.out.println("Enter 1 to add contact details");
            System.out.println("Enter 2 to edit details");
            System.out.println("Enter 3 to delete contact");
            System.out.println("Enter 4 to exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                //Add person address
                System.out.println("Enter first name");
                newPerson.setFirstName(scanner.nextLine());
                System.out.println("Enter last name");
                newPerson.setLastName(scanner.nextLine());
                System.out.println("Enter address");
                newPerson.setAddress(scanner.nextLine());
                System.out.println("Enter city");
                newPerson.setCity(scanner.nextLine());
                System.out.println("Enter state");
                newPerson.setState(scanner.nextLine());
                System.out.println("Enter zip code");
                newPerson.setZip(scanner.nextLine());
                System.out.println("Enter phone number");
                newPerson.setPhoneNumber(scanner.nextLine());
                System.out.println("Enter Email");
                newPerson.setEmail(scanner.nextLine());
                ContactPerson contactPerson = new ContactPerson(newPerson.getFirstName(),newPerson.getLastName(), newPerson.getAddress(), newPerson.getCity(), newPerson.getState(), newPerson.getZip(), newPerson.getPhoneNumber(),newPerson.getEmail());
                person.add(contactPerson);
                System.out.println(person);
            } else if (choice == 2) {
                System.out.println("Enter the first name whose contact to be edited");
                String name = scanner.nextLine();
                Iterator<ContactPerson> iterator = person.listIterator();
                while (iterator.hasNext()){
                    ContactPerson contactPerson= iterator.next();
                if (name.equals(contactPerson.getFirstName()))
                {
                    System.out.println("Edit first name");
                    newPerson.setFirstName(scanner.nextLine());
                    System.out.println("Edit last name");
                    newPerson.setLastName(scanner.nextLine());
                    System.out.println("Edit address");
                    newPerson.setAddress(scanner.nextLine());
                    System.out.println("Edit city");
                    newPerson.setCity(scanner.nextLine());
                    System.out.println("Edit state");
                    newPerson.setState(scanner.nextLine());
                    System.out.println("Edit zip code");
                    newPerson.setZip(scanner.nextLine());
                    System.out.println("Edit phone number");
                    newPerson.setPhoneNumber(scanner.nextLine());
                    System.out.println("Edit Email");
                    newPerson.setEmail(scanner.nextLine());
                    ContactPerson person1 = new ContactPerson(newPerson.getFirstName(),newPerson.getLastName(), newPerson.getAddress(), newPerson.getCity(), newPerson.getState(), newPerson.getZip(), newPerson.getPhoneNumber(),newPerson.getEmail());
                    person.add(person1);}
                 else{
                    System.out.println("Provided name doesn't exist");
                }
                }
            } else if (choice==3) {
                System.out.println("Enter the first name of contact to delete");
                String nameDelete;
                nameDelete = scanner.nextLine();
                Iterator<ContactPerson> iterator = person.listIterator();
                while (iterator.hasNext()) {
                    ContactPerson contactPerson= iterator.next();
                    if (nameDelete.equals(contactPerson.getFirstName())) {
                        person.remove(contactPerson);
                    }
                }
                System.out.println(person);
            } else if (choice == 4) {
                flag = 1;
            }
        }
    }
}