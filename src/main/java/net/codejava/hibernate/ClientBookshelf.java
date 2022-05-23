package net.codejava.hibernate;

import java.util.Scanner;

public class ClientBookshelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BookManager manager = new BookManager();
		

		System.out.println("Wybierz operację: 1. Dodanie pozycji, 2. Usunięcie pozycji");
		Scanner input = new Scanner(System.in);
		int menuChoice;
		
        do{

            System.out.println("Please select an option!\n");

            System.out.println("1: Create new book");
            System.out.println("2: Find book by Title");//more sense than id
            System.out.println("3: Read all book from bookshelf.");
            System.out.println("4: Delete book by id");
            System.out.println("5: Quit\n");

           menuChoice = input.nextInt();
           long id;
           

            switch(menuChoice){

                case 1: 
                	System.out.println("Podaj tytul: ");
                	Scanner inc = new Scanner(System.in);
                	String t = " ";
                	t+=inc.nextLine();
                	System.out.println("Podaj autora: ");
                	String a = " ";
                	a+=inc.nextLine();
                	System.out.println("Podaj cene: ");
                	String price = inc.next();
                	float p = Float.parseFloat(price);
                	
                	manager.setup();
                	manager.create(a,t,p);
                	manager.exit();
                        break;
                        
                case 2:
                	System.out.println("Podaj identyikator pozycji: ");
                	Scanner var = new Scanner(System.in);
        			String id1=var.next();
        			id = Long.parseLong(id1);
        			manager.setup();
        			manager.readByName(id);
        			manager.exit();
                	break;
                	
                case 3:
                	manager.read();
                	break;
                	
                case 4: 
                	System.out.println("Podaj identyfijtor pozycji do usuniecia: ");
                	Scanner var1 = new Scanner(System.in);
        			String id2=var1.next();
        			id = Long.parseLong(id2);
        			manager.setup();
        			manager.delete(id);
        			manager.exit();
                        break;
                case 5:
                	System.out.println("Goodbye");
                	
                	break;

                default: System.out.println("ENTER A VALID INPUT");
            }

        }while(menuChoice != 5);

        input.close();
        
        
        System.exit(0);

    }

	
	
	}

