package org.example;
import java.util.Collections;
import java.util.*;

public class lecture {
    public static void main(String[] args) {

        System.out.println("####################");
        System.out.println("       LISTS");
        System.out.println("####################");

        List<String> names = new ArrayList<String>();
        names.add("Frodo");
        names.add("Sam");
        names.add("Pippin");
        names.add("Merry");
        names.add("Gandalf");
        names.add("Aragorn");
        names.add("Boromir");
        names.add("Gimli");
        names.add("Legolas");
        names.add("Sauron");



        System.out.println("####################");
        System.out.println("Lists are ordered");
        System.out.println("####################");

        //the elements will be returned in the same order they were added
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }



        //ANOTHER WAY OF CREATING LIST AND INITIALIZING AT SAME TIME
        // Declare and initialize an immutable List using List.of()
        System.out.println();
        System.out.println("List.of()");
        List<String> myList = List.of("Frodo", "Sam", "Gollum");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
        System.out.println();
        //myList.add("Neo"); //This will fail as the List.of method creates an immutable List.
        //Can use a for-each if i is not needed.
        for(String name : myList){
            System.out.println(name);
        }




        System.out.println("####################");
        System.out.println("Lists allow duplicates");
        System.out.println("####################");

        names.add("Sam");

        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

        System.out.println("####################");
        System.out.println("Lists allow elements to be inserted in the middle");
        System.out.println("####################");

        names.add(2, "Bilbo");

        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

        System.out.println("####################");
        System.out.println("Lists allow elements to be removed by index");
        System.out.println("####################");

        names.remove(2);

        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

        System.out.println("####################");
        System.out.println("Find out if something is already in the List");
        System.out.println("####################");

        boolean inList = names.contains("Samwise");
        System.out.println("Samwise is in the list of names: " + inList);

        System.out.println("####################");
        System.out.println("Find index of item in List");
        System.out.println("####################");

        int indexOfGandalf = names.indexOf("Gandalf");
        System.out.println("Gandalf is located at index: " + indexOfGandalf);



        System.out.println("####################");
        System.out.println("Lists can be turned into an array");
        System.out.println("####################");

        String[] namesArray = names.toArray(new String[0]);
        for (int i = 0; i < namesArray.length; i++) {
            System.out.println(namesArray[i]);
        }


		/*
		   EXTENDED MATERIAL TURN AN ARRAY INTO A LIST
		 */

        String[] array = {"Tesla", "BMW", "Hyundai"};

        // Using Arrays.asList() to convert to List
        List<String> list = Arrays.asList(array);

        // Creating an ArrayList from the List
        ArrayList<String> arrayList = new ArrayList<>(list);

        // Now, arrayList is an ArrayList containing the elements from the array
        //System.out.println(arrayList);
        System.out.println(list);


        //ALTERNATE WAY
        String[] arrayModels = {"Model 3", "iX", "Ionic5"};

        // Creating an ArrayList and adding array elements
        List<String> arrayListModels = new ArrayList<>();
        for (String element : arrayModels) {
            arrayListModels.add(element);
        }

        // Now, arrayList is an ArrayList containing the elements from the array
        System.out.println(arrayListModels);



        // =======================  END EXTENDED MATERIAL ==============


        System.out.println("####################");
        System.out.println("Lists can be sorted");
        System.out.println("####################");

        Collections.sort(names); //Sort() modifies the original list, doesn't require assignment
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

        System.out.println("####################");
        System.out.println("Lists can be reversed too");
        System.out.println("####################");

        Collections.reverse(names); //Reverse() modifies the original list, doesn't require assignment
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

        System.out.println("####################");
        System.out.println("       FOREACH");
        System.out.println("####################");
        System.out.println();

        // Let's loop through names again, but this time using a for-each loop
        // for each name in names
        for (String name : names) {
            // print the name
            System.out.println(name);
        }


        System.out.println("##########################################");
        System.out.println("  FOR LOOP VS FOREACH - UPDATING ARRAY    ");
        System.out.println("##########################################");
        System.out.println();

        //example for updating array in traditional for loop
        int[] numbers = {1, 2, 3, 4, 5};

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i] * 2; // Modify array elements
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        //example for unable to update array in foreach loop
		/*
		In a foreach (enhanced for) loop, you cannot directly modify array elements using the loop variable.
		The loop variable is effectively read-only. Attempting to modify it will not change the original array.
		Here's an example:
		 */

        int[] numbers2 = {1, 2, 3, 4, 5};

        for (int num : numbers2) {
            num = num * 2; // This does not modify the original array
            System.out.println(num);
        }
        //check original
        for (int num : numbers2) {
            System.out.println(num);
        }
        //===========================END FOR VS FOREACH =========================


        //---------------------QUEUES-----------------------
        System.out.println("####################");
        System.out.println("       QUEUES");
        System.out.println("####################");
        System.out.println();

        //Queue<String> customers = new LinkedList<>();
        Queue<String> customers = new LinkedList<String>();
        customers.offer("Batman");
        customers.offer("The Joker");
        customers.offer("Robin");
        //checking to see what's next
        String next = customers.peek(); //checking next element - reading it using peek
        System.out.println(next);
        System.out.println(customers.size());


        next = customers.poll(); //taking action on next element - removing it using poll()
        System.out.println(next);
        System.out.println(customers.size());

        next = customers.poll(); //taking action on next element - removing it using poll()
        System.out.println(next);
        System.out.println(customers.size());


        //foreach - can read items but can't modify any of them
        for(String customer : customers){
            System.out.println(customer);
        }

        System.out.println(customers.size());
        //To remove from queue use the while loop
        while (customers.size() > 0){
            String customerName = customers.poll(); //item is removed; returns removed item
            System.out.println(customerName);
        }
        System.out.println(customers.size());





        //---------------------STACKS-----------------------
        System.out.println("####################");
        System.out.println("       STACKS");
        System.out.println("####################");
        System.out.println();

        //Stack<Integer> warehousePallets = new Stack<Integer>();
        Stack<Integer> warehousePallets = new Stack<>();
        warehousePallets.push(1010);
        warehousePallets.push(3020);
        warehousePallets.push(5130);

        Integer pallet = warehousePallets.peek();
        System.out.println(pallet);
        System.out.println(warehousePallets.size());

        //pallet = warehousePallets.pop();
        System.out.println(pallet);
        System.out.println(warehousePallets.size());

        //pallet = warehousePallets.pop();
        System.out.println(pallet);
        System.out.println(warehousePallets.size());


        //foreach - can read items but can't modify any of them
        for(Integer wPallet : warehousePallets){
            System.out.println(wPallet);
        }

        System.out.println(warehousePallets.size());
        //To remove from stack use the while loop
        while (warehousePallets.size() > 0){
            Integer wPallet = warehousePallets.pop(); //item is removed; returns removed item
            System.out.println(wPallet);
        }
        System.out.println(warehousePallets.size());





        System.out.println("####################");
        System.out.println("        MAPS");
        System.out.println("####################");
        System.out.println();

        // Declaring and initializing a Map
        Map<String, String> nameToSector = new HashMap<String, String>();

        // Adding an item to a Map


        nameToSector.put("Neo", "44120C");
        nameToSector.put("Trinity", "44124C");
        nameToSector.put("Morpheus", "44012A");







        // Retrieving an item from a Map
        System.out.println("Neo lives in " + nameToSector.get("Neo"));
        System.out.println("Trinity lives in " + nameToSector.get("Trinity"));
        System.out.println("Morpheus lives in " + nameToSector.get("Morpheus"));
        System.out.println();

        // Retrieving just the keys from a Map
        System.out.println("We can also retrieve a list of keys and iterate over them using a for loop:");

        //*** Note to instructor:
        //*** The return type of `Map<String, String>.keySet()` is a `Set<String>`. Keys are required to be unique
        //*** and sets guarantee uniqueness.
        Set<String> keys = nameToSector.keySet(); // returns a Collection of all of the keys in the Map
        for (String name : keys) {
            System.out.println(name + " lives in sector " + nameToSector.get(name));
        }
        System.out.println();

        // Check to see if a key already exists
        if (nameToSector.containsKey("Neo")) {
            System.out.println("Neo exists");
        }
        System.out.println();

        System.out.println("set 12345J for key Neo");
        nameToSector.put("Neo", "12345J"); // If key already exists, value is updated, otherwise key-value added

        // Iterate through the key-value pairs in the Map
        for (Map.Entry<String, String> nameSector : nameToSector.entrySet()) {
            System.out.println(nameSector.getKey() + " lives in sector " + nameSector.getValue());
        }
        System.out.println();

        // Remove an element from the Map
        nameToSector.remove("Neo");
        System.out.println("removed Neo");
        System.out.println();

        // loop through again to show David was removed
        for (Map.Entry<String, String> nameSector : nameToSector.entrySet()) {
            System.out.println(nameSector.getKey() + " lives in sector " + nameSector.getValue());
        }


        System.out.println("####################");
        System.out.println("        Sets");
        System.out.println("####################");
        System.out.println();

        Set<String> lotrNamesSet = new HashSet<>(); // Unique entries - no dups

        //Add an item to a Set
        lotrNamesSet.add("Neo");
        lotrNamesSet.add("Trinity");
        lotrNamesSet.add("Morpheus");
        lotrNamesSet.add("Apoc");
        lotrNamesSet.add("Morpheus"); //does nothing because Morpheus already exists

        //Remove an item from a Set
        lotrNamesSet.remove("Apoc");

        //Get the size of a Set
        int size = lotrNamesSet.size();

        //Loop through the items in a Set
        for(String name : lotrNamesSet){
            System.out.println(name);
        }

        // To replace an item: Remove the old and add the new.  Sets do not maintain a sequence (index) like a List.

    }
}