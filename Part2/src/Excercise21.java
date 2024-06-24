import java.util.ArrayList;
import java.util.List;

public class Excercise21 {
    float avg(int[] nums) throws EmptyArray, NegativeNumbersException {
        int sum = 0;
        List<Integer> negativeIndices = new ArrayList<>();
        List<Integer> negativeValues = new ArrayList<>();
        if (nums == null || nums.length == 0)
            throw new EmptyArray();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negativeIndices.add(i + 1);
                negativeValues.add(nums[i]);
            }
            sum += nums[i];
        }
        if (!negativeIndices.isEmpty()) {
            throw new NegativeNumbersException(negativeIndices, negativeValues);
        }
        return sum / nums.length;
    }

    public static void main(String[] args) {
        Excercise21 test = new Excercise21();
        int[] nums = new int[] { 1, 2 };
        Float result;
        try {
            result = test.avg(nums);
            System.out.println("Result: " + result);
        } catch (EmptyArray e) {
        } catch (NegativeNumbersException e) {
            List<Integer> indices = e.getIndices();
            List<Integer> values = e.getValues();
            for (int i = 0; i < indices.size(); i++) {
                System.out
                        .println("The " + indices.get(i) + "rd number " + values.get(i) + " in your array is invalid");
            }
        }

    }
}

class EmptyArray extends Exception {
}

class NegativeNumbersException extends Exception {
    private List<Integer> indices;
    private List<Integer> values;

    public NegativeNumbersException(List<Integer> indices, List<Integer> values) {
        this.indices = indices;
        this.values = values;
    }

    public List<Integer> getIndices() {
        return indices;
    }

    public List<Integer> getValues() {
        return values;
    }
}