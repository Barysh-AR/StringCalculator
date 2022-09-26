import java.util.ArrayList;

public class StringCalculator {
    public static int add(String numbers){
        int all_sum = 0;
        ArrayList<Integer>  negative_numbers = new ArrayList<Integer>();

        if (numbers != ""){
            ArrayList<String> delimiters = new ArrayList<String>();
            delimiters.add(new String("\\n"));

            if (numbers.length() >= 2){
                if (numbers.charAt(0) == '/' & numbers.charAt(1) == '/') {
                    int index = numbers.indexOf("\\n");
                    String delim = numbers.substring(2,index);
                    numbers = numbers.substring(index+2);
                    if (numbers == ""){return 0;}

                    if(delim.length() >= 2){
                        if(delim.charAt(0) == '[' & delim.charAt(delim.length()-1) == ']'){
                            String[] lines = delim.split("]\\[");

                            lines[0] = lines[0].substring(1);
                            int n = 0;
                            for(String i : lines){n++;}
                            lines[n-1] = lines[n-1].substring(0,lines[n-1].length()-1);

                            for(String line : lines) {
                                if (line != "") {delimiters.add(new String(line));}
                            }
                        } else { if (delim != "") {delimiters.add(new String(delim));} }
                    } else { if (delim != "") {delimiters.add(new String(delim));} }

                    sort(delimiters);
                }
            }

            for (int i = 0; i < delimiters.size(); i++) {
                numbers = numbers.replace(delimiters.get(i), ",");
            }

            if (numbers.charAt(numbers.length()-1) == ',') {return -1;}

            String[] lines = numbers.split(",");

            for(String line : lines){
                try{
                    int n = Integer.parseInt(line);
                    if(n < 0){
                        negative_numbers.add(n);
                        n = 0;
                    }
                    if (n > 1000){n = 0;}
                    all_sum += n;
                }catch (NumberFormatException e) {return -1;}
            }
        }
        if (negative_numbers.size() != 0){
            System.out.println("«недозволені від’ємні числа»");
            for (int i = 0; i < negative_numbers.size(); i++){System.out.print(negative_numbers.get(i) + " ");}
            System.out.println();
            return -1;
        }
        return all_sum;
    }

    public static void sort(ArrayList<String> array) {
        boolean s = false;
        while (!s) {
            s = true;
            for (int i = 1; i < array.size(); i++) {
                if (array.get(i - 1).length() < array.get(i).length()) {
                    String t = array.get(i);
                    array.set(i, array.get(i - 1));
                    array.set(i - 1, t);
                    s = false;
                }
            }
        }
    }
}
