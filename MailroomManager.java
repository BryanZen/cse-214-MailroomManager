/**
 * @Author Bryan Zen 113252725
 * @version 1.0
 * @since 2021-10-05
 */

import java.util.Objects;
import java.util.Scanner;

/**
 * Write a fully-documented driver class named MailroomManager which contains
 * 6 package stacks for storing mail. Packages can be added to stacks, removed
 * from stacks, and moved from one stack to another. Mail will be stored
 * according to the following criteria: Packages whose recipient’s name begins
 * with A-G will be stored in the first stack, H-J in second, K-M in the third,
 * N-R in the fourth, and S-Z in the fifth. The sixth stack will serve as the
 * Floor stack, which is used when moving packages of a specific recipient.
 *
 * This Method uses traditional and enhanced for loops, if your java cannot
 * compile it, please upgrade your java.
 */
public class MailroomManager {
    public static void main(String[] args) throws FullStackException,
            EmptyStackException{
        PackageStack[] stacks = new PackageStack[6];

        stacks[0] = new PackageStack("ag");
        stacks[1] = new PackageStack("hj");
        stacks[2] = new PackageStack("km");
        stacks[3] = new PackageStack("nr");
        stacks[4] = new PackageStack("sz");
        stacks[5] = new PackageStack("floor");
        PackageStack tempStack = new PackageStack("temp");
        int currentDay = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Irving Mailroom Manager. You can " +
                "try to make it better, but the odds are stacked against " +
                "you. It is day 0.");
        System.out.println("""
                Menu:

                     D) Deliver a package

                     G) Get someone's package

                     T) Make it tomorrow

                     P) Print the stacks

                     M) Move a package from one stack to another

                     F) Find packages in the wrong stack and move to floor

                     L) List all packages awaiting a user

                     E) Empty the floor.

                     Q) Quit""");
        boolean x = true;
        while (x){
            System.out.println("\n" + "Please select an option: ");
            char choice = sc.next().charAt(0);
            try{
                if (choice >= '0' && choice <= '9'){
                    throw new Exception("Bad input! ");
                }
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
            choice = Character.toUpperCase(choice);
            switch (choice) {
                case 'D' -> {
                    boolean wrongStack = false;
                    int fullStack = -1;
                    int freeStack = -1;
                    double weightD = -1;
                    System.out.println("Please enter the recipient name: ");
                    sc.nextLine();
                    String nameD = sc.nextLine();
                    try{
                        char nameChar = nameD.charAt(0);
                    } catch (Exception e){
                        System.out.println("Bad input!");
                        break;
                    }
                    try{
                        char ch = nameD.charAt(0);
                        if (ch >= '0' && ch <= '9'){
                            throw new Exception("Bad input! ");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                    System.out.println("Please enter the weight (lbs): ");
                    weightD = sc.nextDouble();

                    try{
                        if (weightD < 0){
                            throw new Exception("Bad input! ");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                    Package newPackageD = new Package(nameD, currentDay,
                            weightD);
                    char nameChar = nameD.charAt(0);
                    nameChar = Character.toUpperCase(nameChar);
                    switch (nameChar) {
                        case 'A', 'B', 'C', 'D', 'E', 'F', 'G' -> {
                            if (stacks[0].isFull()){
                                if (stacks[1].isFull()){
                                    if (stacks[2].isFull()){
                                        if (stacks[3].isFull()){
                                            if (stacks[4].isFull()){
                                                stacks[5].push(newPackageD);
                                                fullStack = 1;
                                                freeStack = 6;
                                            } else{
                                                stacks[4].push(newPackageD);
                                                fullStack = 1;
                                                freeStack = 5;
                                            }
                                        } else{
                                            stacks[3].push(newPackageD);
                                            fullStack = 1;
                                            freeStack = 4;
                                        }
                                    } else{
                                        stacks[2].push(newPackageD);
                                        fullStack = 1;
                                        freeStack = 3;
                                    }
                                } else{
                                    stacks[1].push(newPackageD);
                                    fullStack = 1;
                                    freeStack = 2;
                                }
                                wrongStack = true;
                            } else{
                                stacks[0].push(newPackageD);
                            }
                        }
                        case 'H', 'I', 'J' -> {
                            if (stacks[1].isFull()){
                                if (stacks[0].isFull()){
                                    if (stacks[2].isFull()){
                                        if (stacks[3].isFull()){
                                            if (stacks[4].isFull()){
                                                stacks[5].push(newPackageD);
                                                fullStack = 2;
                                                freeStack = 6;
                                            } else{
                                                stacks[4].push(newPackageD);
                                                fullStack = 2;
                                                freeStack = 5;
                                            }
                                        } else{
                                            stacks[3].push(newPackageD);
                                            fullStack = 2;
                                            freeStack = 4;
                                        }
                                    } else{
                                        stacks[2].push(newPackageD);
                                        fullStack = 2;
                                        freeStack = 3;
                                    }
                                } else{
                                    stacks[0].push(newPackageD);
                                    fullStack = 2;
                                    freeStack = 1;
                                }
                                wrongStack = true;
                            } else{
                                stacks[1].push(newPackageD);
                            }
                        }
                        case 'K', 'L', 'M' -> {
                            if (stacks[2].isFull()){
                                if (stacks[1].isFull()){
                                    if (stacks[3].isFull()){
                                        if (stacks[0].isFull()){
                                            if (stacks[4].isFull()){
                                                stacks[5].push(newPackageD);
                                                fullStack = 3;
                                                freeStack = 6;
                                            } else{
                                                stacks[4].push(newPackageD);
                                                fullStack = 3;
                                                freeStack = 5;
                                            }
                                        } else{
                                            stacks[0].push(newPackageD);
                                            fullStack = 3;
                                            freeStack = 1;
                                        }
                                    } else{
                                        stacks[3].push(newPackageD);
                                        fullStack = 3;
                                        freeStack = 4;
                                    }
                                } else{
                                    stacks[1].push(newPackageD);
                                    fullStack = 3;
                                    freeStack = 2;
                                }
                                wrongStack = true;
                            } else{
                                stacks[2].push(newPackageD);
                            }
                        }
                        case 'N', 'O', 'P', 'Q', 'R' -> {
                            if (stacks[3].isFull()){
                                if (stacks[2].isFull()){
                                    if (stacks[4].isFull()){
                                        if (stacks[1].isFull()){
                                            if (stacks[0].isFull()){
                                                stacks[5].push(newPackageD);
                                                fullStack = 4;
                                                freeStack = 6;
                                            } else{
                                                stacks[0].push(newPackageD);
                                                fullStack = 4;
                                                freeStack = 1;
                                            }
                                        } else{
                                            stacks[1].push(newPackageD);
                                            fullStack = 4;
                                            freeStack = 2;
                                        }
                                    } else{
                                        stacks[4].push(newPackageD);
                                        fullStack = 4;
                                        freeStack = 5;
                                    }
                                } else{
                                    stacks[2].push(newPackageD);
                                    fullStack = 4;
                                    freeStack = 3;
                                }
                                wrongStack = true;
                            } else{
                                stacks[3].push(newPackageD);
                            }
                        }
                        case 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' -> {
                            if (stacks[4].isFull()){
                                if (stacks[3].isFull()){
                                    if (stacks[2].isFull()){
                                        if (stacks[1].isFull()){
                                            if (stacks[0].isFull()){
                                                stacks[5].push(newPackageD);
                                                fullStack = 5;
                                                freeStack = 6;
                                            } else{
                                                stacks[0].push(newPackageD);
                                                fullStack = 5;
                                                freeStack = 1;
                                            }
                                        } else{
                                            stacks[1].push(newPackageD);
                                            fullStack = 5;
                                            freeStack = 2;
                                        }
                                    } else{
                                        stacks[2].push(newPackageD);
                                        fullStack = 5;
                                        freeStack = 3;
                                    }
                                } else{
                                    stacks[3].push(newPackageD);
                                    fullStack = 5;
                                    freeStack = 4;
                                }
                                wrongStack = true;
                            } else{
                                stacks[4].push(newPackageD);
                            }
                        }
                    }
                    if (weightD % 1 == 0){
                        int weightDI = (int) weightD;
                        System.out.printf("A %d lb package is awaiting " +
                                "pickup by %s. ", weightDI, nameD);
                    } else{
                        System.out.printf("A %.1f lb package is awaiting " +
                                "pickup by %s. ", weightD, nameD);
                    }
                    if (wrongStack){
                        if (freeStack == 6){
                            System.out.printf("As stack %d was full, it was " +
                                    "placed on the floor.", fullStack);
                        } else{
                            System.out.printf("As stack %d was full, it was " +
                                    "placed in stack %d.", fullStack, freeStack);
                        }
                    }
                }
                case 'G' -> {
                    System.out.println("Please enter the recipient name: ");
                    sc.nextLine();
                    String nameG = sc.nextLine();
                    try{
                        char nameChar = nameG.charAt(0);
                    } catch (Exception e){
                        System.out.println("Bad input!");
                        break;
                    }
                    try{
                        char ch = nameG.charAt(0);
                        if (ch >= '0' && ch <= '9'){
                            throw new Exception("Bad input! ");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                    double weightG = 0;
                    int arrivalDayG = 0;
                    int toFloor = 0;
                    int foundStack = 0;
                    boolean found = false;
                    while (!found){
                        for (int i = 0; i < 5; i++){
                            int stackSize = stacks[i].size();
                            for (int j = 0; j < stackSize; j++){
                                int lastPackage = stackSize - 1;
                                if (Objects.equals(stacks[i].peek()
                                        .getRecipient(), nameG) && !found){
                                    weightG = stacks[i].peek().getWeight();
                                    arrivalDayG = stacks[i].peek()
                                            .getArrivalDate();
                                    foundStack = i;
                                    found = true;
                                } else if (j != lastPackage && !found){
                                    Package popped = stacks[i].pop();
                                    stacks[5].push(popped);
                                    toFloor++;
                                }
                                if (j == lastPackage && !found){
                                    int moved = toFloor;
                                    for (int k = 0; k < moved; k++){
                                        Package popped = stacks[5].pop();
                                        stacks[i].push(popped);
                                        toFloor--;
                                    }
                                }
                            }
                        }
                    }
                    System.out.printf("Move %d packages from Stack %d " +
                            "to floor. \n", toFloor, foundStack + 1);
                    System.out.println("""
                            Current Packages:
                            --------------------------------""");
                    for (PackageStack stack: stacks){
                        if (stack == stacks[0]){
                            System.out.print("Stack 1 (A-G):|");
                        }
                        else if (stack == stacks[1]){
                            System.out.print("Stack 2 (H-J):|");
                        }
                        else if (stack == stacks[2]){
                            System.out.print("Stack 3 (K-M):|");
                        }
                        else if (stack == stacks[3]){
                            System.out.print("Stack 4 (N-R):|");
                        }
                        else if (stack == stacks[4]){
                            System.out.print("Stack 5 (S-Z):|");
                        }
                        else if (stack == stacks[5]){
                            System.out.print("Floor: |");
                        }
                        if (stack.isEmpty()){
                            System.out.print("empty.");
                        }
                        for (Package index: stack){
                            System.out.print(index);
                        }
                        System.out.println();
                    }
                    if (weightG % 1 == 0) {
                        int weightGI = (int) weightG;
                        System.out.printf("Give %s %d lb package delivered " +
                                "on day %d. \n", nameG, weightGI, arrivalDayG);
                    } else{
                        System.out.printf("Give %s %.1f lb package delivered " +
                                "on day %d. \n", nameG, weightG, arrivalDayG);
                    }
                    stacks[foundStack].pop();
                    System.out.printf("Return %d packages to Stack %d from " +
                            "floor. \n", toFloor, foundStack + 1 );
                    int moved = toFloor;
                    for (int k = 0; k < moved; k++){
                        Package popped = stacks[5].pop();
                        stacks[foundStack].push(popped);
                    }
                    System.out.println("""
                            Current Packages:
                            --------------------------------""");
                    for (PackageStack stack: stacks){
                        if (stack == stacks[0]){
                            System.out.print("Stack 1 (A-G):|");
                        }
                        else if (stack == stacks[1]){
                            System.out.print("Stack 2 (H-J):|");
                        }
                        else if (stack == stacks[2]){
                            System.out.print("Stack 3 (K-M):|");
                        }
                        else if (stack == stacks[3]){
                            System.out.print("Stack 4 (N-R):|");
                        }
                        else if (stack == stacks[4]){
                            System.out.print("Stack 5 (S-Z):|");
                        }
                        else if (stack == stacks[5]){
                            System.out.print("Floor: |");
                        }
                        if (stack.isEmpty()){
                            System.out.print("empty.");
                        }
                        for (Package index: stack){
                            System.out.print(index);
                        }
                        System.out.println();
                    }
                }
                case 'T' -> {
                    currentDay++;
                    int numRemoved = 0;
                    for (int i = 0; i < 5; i++){
                        int stackSize = stacks[i].size();
                        for (int j = 0; j < stackSize; j++){
                            Package temp = stacks[i].peek();
                            int dayNum = temp.getArrivalDate();
                            if (currentDay - dayNum == 5) {
                                stacks[i].pop();
                                numRemoved++;
                            } else if (j != stackSize - 1){
                                Package popped = stacks[i].pop();
                                tempStack.push(popped);
                            }
                            if ((j == stackSize - 1)){
                                int tempStackSize = tempStack.size();
                                for (int k = 0; k < tempStackSize; k++){
                                    Package temppop = tempStack.pop();
                                    stacks[i].push(temppop);
                                }
                            }
                        }
                    }
                    if (numRemoved == 0){
                        System.out.printf("It is now day %d.", currentDay);
                    } else{
                        System.out.printf("It is now day %d. %d packages " +
                                "have been returned to sender.", currentDay,
                                numRemoved);
                    }
                }
                case 'P' -> {
                    System.out.println("""
                            Current Packages:
                            --------------------------------""");
                    for (PackageStack stack: stacks){
                        if (stack == stacks[0]){
                            System.out.print("Stack 1 (A-G):|");
                        }
                        else if (stack == stacks[1]){
                            System.out.print("Stack 2 (H-J):|");
                        }
                        else if (stack == stacks[2]){
                            System.out.print("Stack 3 (K-M):|");
                        }
                        else if (stack == stacks[3]){
                            System.out.print("Stack 4 (N-R):|");
                        }
                        else if (stack == stacks[4]){
                            System.out.print("Stack 5 (S-Z):|");
                        }
                        else if (stack == stacks[5]){
                            System.out.print("Floor: |");
                        }
                        if (stack.isEmpty()){
                            System.out.print("empty.");
                        }
                        for (Package index: stack){
                            System.out.print(index);
                        }
                        System.out.println();
                    }
                }
                case 'M' -> {
                    int source = -1;
                    int dest = -1;
                    System.out.println("Please enter the source stack " +
                            "(enter 0 for floor): ");
                    source = sc.nextInt();
                    try{
                        if (source < 0 || source > 5){
                            throw new Exception("Source stack does" +
                                    " not exist! ");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                    System.out.println("Please enter the destination stack: ");
                    dest = sc.nextInt();
                    try{
                        if (dest < 0 || dest > 5){
                            throw new Exception("Destination stack does" +
                                    "not exist! ");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                    try{
                        if (stacks[source - 1].isEmpty()){
                            throw new EmptyStackException("Source stack " +
                                    "is empty! ");
                        }
                        if (stacks[dest - 1].isFull()){
                            throw new FullStackException("Destination stack " +
                                    "is empty! ");
                        }
                    } catch (EmptyStackException e) {
                        e.printStackTrace();
                    }
                    Package move = stacks[source - 1].pop();
                    stacks[dest - 1].push(move);
                }
                case 'F' -> {
                    int packages = 0;
                    for (int i = 0; i < 5; i++){
                        int stackSize = stacks[i].size();
                        for (int j = 0; j < stackSize; j++){
                            int lastPackage = stackSize - 1;
                            if (stacks[i].peek().correctStack() != i){
                                Package popped = stacks[i].pop();
                                stacks[5].push(popped);
                                packages++;
                            } else if (j != lastPackage){
                                Package popped = stacks[i].pop();
                                tempStack.push(popped);
                            }
                            if (j == lastPackage){
                                int tempStackSize = tempStack.size();
                                for (int k = 0; k < tempStackSize; k++){
                                    Package temppop = tempStack.pop();
                                    stacks[i].push(temppop);
                                }
                            }
                        }
                    }
                    if (packages == 0){
                        System.out.println("All packages are in the " +
                                "correct stack.");
                    } else{
                        System.out.println("Misplaced packages " +
                                "moved to floor. ");
                    }
                }
                case 'L' -> {
                    int packages = 0;
                    System.out.println("Please enter the recipient name: ");
                    sc.nextLine();
                    String recipient = sc.nextLine();
                    try{
                        char nameChar = recipient.charAt(0);
                    } catch (Exception e){
                        System.out.println("Bad input!");
                        break;
                    }
                    try{
                        char ch = recipient.charAt(0);
                        if (ch >= '0' && ch <= '9'){
                            throw new Exception("Bad input! ");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                    int numPack = 0;
                    int stackNum = 0;
                    StringBuilder listPack = new StringBuilder();
                    for (PackageStack stack: stacks){
                        if (stack == stacks[0]){
                            stackNum = 1;
                        }
                        if (stack == stacks[1]){
                            stackNum = 2;
                        }
                        if (stack == stacks[2]){
                            stackNum = 3;
                        }
                        if (stack == stacks[3]){
                            stackNum = 4;
                        }
                        if (stack == stacks[4]){
                            stackNum = 5;
                        }
                        if (stack == stacks[5]){
                            stackNum = 0;
                        }
                        for (Package index: stack){
                            if (Objects.equals(index.getRecipient(),
                                    recipient)){
                                numPack++;
                                double weightL = index.getWeight();
                                if (weightL % 1 == 0){
                                    int weightLI = (int) weightL;
                                    String addPack = String.format
                                            ("Package %d is in Stack %s, " +
                                                            "it was " +
                                                            "delivered on " +
                                                            "day %d, and it " +
                                                            "weighs %d lbs. \n",
                                            numPack, stackNum,
                                            index.getArrivalDate(),
                                            weightLI);
                                    packages++;
                                    listPack.append(addPack);
                                } else{
                                    String addPack = String.format("Package " +
                                                    "%d is in Stack %s, it " +
                                                    "was delivered on day " +
                                                    "%d, and it weighs %.1f " +
                                                    "lbs. \n",
                                            numPack, stackNum,
                                            index.getArrivalDate(),
                                            weightL);
                                    packages++;
                                    listPack.append(addPack);
                                }
                            }
                        }
                    }
                    if (packages == 0){
                        System.out.printf("%s has no packages. ", recipient);
                    } else{
                        System.out.printf("%s has %d packages total. \n",
                                recipient, numPack);
                        System.out.print(listPack);
                    }
                }
                case 'E' -> {
                    int floorSize = stacks[5].size();
                    for (int i = 0; i < floorSize; i++){
                        stacks[5].pop();
                    }
                    System.out.println("The floor has been emptied. " +
                            "Mr. Trash Can is no longer hungry.");
                }
                case 'Q' -> {
                    System.out.println("Use Amazon Locker next time. ");
                    x = false;
                }
            }
        }
    }
}
