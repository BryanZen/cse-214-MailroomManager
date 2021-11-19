/**
 * @Author Bryan Zen 113252725
 * @version 1.0
 * @since 2021-10-05
 */

import java.util.EmptyStackException;
import java.util.Objects;
import java.util.Stack;

/**
 *PackageStack
 *
 * Write a fully-documented class named PackageStack. For this homework
 * assignment, you are allowed to use built-in Java libraries for your
 * stack. You may choose to extend a stack (Stack Package or
 * ArrayList Package or LinkedList Package) or implement your own
 * (using an array or LinkedList). PackageStack must only use stack methods
 * (push, pop, isEmpty, isFull, and peek), with the exception of printing.
 * Note: The isFull method is not typically included in stack methods,
 * but has been added for convenience.
 */
public class PackageStack extends Stack<Package> {
    private static int CAPACITY = 7;
    private int currentPackages = 0;
    private String name = "";

    /**
     * The constructor for the stack object, Extends Stack Package
     * @param name is the name of the package
     */
    public PackageStack(String name){
        super();
        this.name = name;
    }

    /**
     *
     * @param x Pushes x onto the top of the backing data structure.
     * Throws: FullStackException if the stack is at capacity.
     *          If you are extending LinkedList, you may rename this pushPackage
     *          (Package x) if your IDE is complaining about throwing a
     *          FullStackException
     * @return the pushed package.
     */
    public Package push(Package x){
        if (this.isFull()){
            try {
                throw new FullStackException("One more package and it will " +
                        "topple!");
            } catch (FullStackException e) {
                e.printStackTrace();
            }
        } else {
            super.push(x);
            currentPackages++;
        }
        return x;
    }

    /**
     *Removes the topmost package from the stack and returns it.
     * @return the package pooped.
     * @throws EmptyStackException if the stack was empty.
     * If you are extending LinkedList, you may rename this popPackage()
     * if your IDE is complaining about throwing a EmptyStackException
     */
    public Package pop() throws EmptyStackException{
        if (currentPackages == 0){
            throw new EmptyStackException();
        }
        Package x = super.pop();
        currentPackages--;
        return x;
    }

    /**
     * The stack should be unchanged as a result of this method.
     * @return The topmost Package from the stack without removing it.
     * @throws EmptyStackException if the stack was empty
     */
    public Package peek() throws EmptyStackException{
        if (currentPackages == 0){
            throw new EmptyStackException();
        } else {
            return super.peek();
        }
    }

    /**
     * @return True if the stack is full, false otherwise.
     */
    public boolean isEmpty(){
        return super.isEmpty();
    }

    /**
     * If the stack is the floor stack, it returns false
     * @return True if the stack is empty, false otherwise.
     */
    public boolean isFull(){
        if (Objects.equals(this.name, "floor")){
            return false;
        } else return currentPackages == CAPACITY;
    }

    /**
     * @return the toString for the stack
     */
    public String toString(){
        return "";
    }

    /**
     * @return name of the stack
     */
    public String getName() {
        return name;
    }

    /**
     * @param name is the new name of the stack
     */
    public void setName(String name) {
        this.name = name;
    }
}