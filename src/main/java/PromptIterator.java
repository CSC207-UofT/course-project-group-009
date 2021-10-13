import java.io.*;
import java.util.*;

/**
 * Iterates through a list of String prompts
 */
public class PromptIterator implements Iterator<String> {
    private List<String> prompts = new ArrayList<>();
    private int current = 0;

    /**
     * The prompt Strings are read from a file, student_properties.txt,
     * and added to the list of student properties.
     */
    public PromptIterator(File file) {

        //open file and read from it...
        BufferedReader br = null;
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String prompt = myReader.nextLine();
                prompts.add(prompt + ": ");
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(file + " cannot be found.");
            e.printStackTrace();
        }
    }

    /**
     * Checks for subsequent prompts.
     * @return true if there is prompt that has not yet been returned.
     */
    @Override
    public boolean hasNext() {
        return current < prompts.size();
    }

    /**
     * Returns the next prompt to be printed.
     * @return the next prompt.
     */
    @Override
    public String next() {
        String res;

        // List.get(i) throws an IndexOutBoundsException if
        // we call it with i >= properties.size().
        // But Iterator's next() needs to throw a
        // NoSuchElementException if there are no more elements.
        try {
            res = prompts.get(current);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
        current += 1;
        return res;
    }

    /**
     * Removes the prompt just returned. Unsupported.
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported."); 
    }


}