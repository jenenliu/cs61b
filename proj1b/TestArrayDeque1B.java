import static org.junit.Assert.*;

import edu.princeton.cs.algs4.*;
import org.junit.Assert;
import org.junit.Test;

public class TestArrayDeque1B {
    private String generateErrorMessage(Integer expected, Integer actual, String operations) {
        return "Expected " + expected + ", but got " + actual +
                    "\nAll operations: \n" + operations;
    }

    @Test
    public void randomrizedTestStudentArrayDeque() {
        LinkedListDeque<Integer> studentArrayDeque = new LinkedListDeque<>();
        ArrayDequeSolution<Integer> arrayDequeSolution = new ArrayDequeSolution<>();
        OperationSequence fs = new OperationSequence();

        int testRound = 10;
        for (int i = 0; i < testRound; i++) {
            int ran = StdRandom.uniform(100);

            DequeOperation dequeOperation = new DequeOperation("addFirst", ran);
            fs.addOperation(dequeOperation);
            studentArrayDeque.addFirst(ran);
            arrayDequeSolution.addFirst(ran);

            String message = "Expected " + arrayDequeSolution.size() + ", but got " + studentArrayDeque.size() +
                    "\nAll operations: \n" + fs.toString();
            Assert.assertEquals(message, arrayDequeSolution.size(), studentArrayDeque.size());
            message = "Expected " + arrayDequeSolution.get(0) + ", but got " + studentArrayDeque.get(0) +
                    "\nAll operations: \n" + fs.toString();
            Assert.assertEquals(message, arrayDequeSolution.get(0), studentArrayDeque.get(0));
        }

        for (int i = 0; i < testRound / 2; i++) {
            DequeOperation dequeOperation = new DequeOperation("removeLast");
            fs.addOperation(dequeOperation);
            Integer studentLast = studentArrayDeque.removeLast();
            Integer solutionLast = arrayDequeSolution.removeLast();

            String message = "Expected " + solutionLast + ", but got " + studentLast +
                    "\nAll operations: \n" + fs.toString();
            Assert.assertEquals(message, solutionLast, studentLast);

            message = generateErrorMessage(arrayDequeSolution.size(), studentArrayDeque.size(), fs.toString());
            Assert.assertEquals(message, arrayDequeSolution.size(), studentArrayDeque.size());
        }


        for (int i = 0; i < testRound / 2 - 1; i++) {
           DequeOperation dequeOperation = new DequeOperation("removeFirst");
           fs.addOperation(dequeOperation);
           Integer studentFirst = studentArrayDeque.removeFirst();
           Integer solutionFirst = arrayDequeSolution.removeFirst();

           String message = generateErrorMessage(solutionFirst, studentFirst, fs.toString());
           Assert.assertEquals(message, solutionFirst, studentFirst);
        }
    }
}
